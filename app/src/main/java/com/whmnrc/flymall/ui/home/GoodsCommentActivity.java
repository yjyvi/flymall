package com.whmnrc.flymall.ui.home;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.alibaba.fastjson.JSON;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.permissions.RxPermissions;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.publish.PublishImgArrayAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.MultiItemTypeAdapter;
import com.whmnrc.flymall.beans.BaseBean;
import com.whmnrc.flymall.beans.MediaBean;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.presener.AddEvaluatePresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.utils.FileUtils;
import com.whmnrc.flymall.utils.MediaUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.views.RatingBarView;
import com.whmnrc.mylibrary.utils.EncodeTask;
import com.whmnrc.mylibrary.utils.ImgVideoPickerUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class GoodsCommentActivity extends BaseActivity implements AddEvaluatePresenter.AddEvaluateListener {

    @BindView(R.id.rv_photo)
    RecyclerView rvPhoto;
    @BindView(R.id.rb_star)
    RatingBarView mRbStar;
    @BindView(R.id.et_content)
    EditText mEtContent;

    private ProgressDialog progressDialog;
    private Map<LocalMedia, MediaBean> mediaMap = new HashMap<>();
    private List<LocalMedia> localMediaDatas = new ArrayList<>();
    private MultiItemTypeAdapter<LocalMedia> localMediaMultiItemTypeAdapter;
    private static final int MAX_PICTURE = 9;
    public AddEvaluatePresenter mAddEvaluatePresenter;
    private String videos = "";
    public String mOrderId;
    public String mGoodsId;

    @Override
    protected void initViewData() {
        setTitle("Evaluation");
        mOrderId = getIntent().getStringExtra("orderId");
        mGoodsId = getIntent().getStringExtra("goodsId");
        mAddEvaluatePresenter = new AddEvaluatePresenter(this);
        initRv();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_goods_comment;
    }

    public static void start(Context context, String orderId, String goodsId) {
        Intent starter = new Intent(context, GoodsCommentActivity.class);
        starter.putExtra("orderId", orderId);
        starter.putExtra("goodsId", goodsId);
        context.startActivity(starter);
    }


    private void initRv() {

        selectPremissions();
        rvPhoto.setLayoutManager(new GridLayoutManager(this, 3));
        localMediaMultiItemTypeAdapter = new MultiItemTypeAdapter<>(this);
        localMediaMultiItemTypeAdapter.addItemViewDelegate(new PublishImgArrayAdapter(new PublishImgArrayAdapter.OnClick() {
            @Override
            public void onCancelClick(View view, int position) {
                LocalMedia remove = localMediaDatas.remove(position);
                try {
                    mediaMap.remove(remove);
                } catch (Exception e) {

                }
                localMediaMultiItemTypeAdapter.notifyDataSetChanged();
            }
        }));


        localMediaMultiItemTypeAdapter.setDataArray(localMediaDatas);

        rvPhoto.setAdapter(localMediaMultiItemTypeAdapter);

    }

    private void selectPremissions() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
        ).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (aBoolean) {

                }
            }
        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            List<LocalMedia> mediaList = PictureSelector.obtainMultipleResult(data);
            if (mediaList.size() > 0) {

                if (mediaList.get(0).getMimeType() == PictureConfig.TYPE_VIDEO) {
                    localMediaDatas.addAll(0, mediaList);
                } else {
                    localMediaDatas.addAll(localMediaDatas.size(), mediaList);
                }


                localMediaMultiItemTypeAdapter.notifyDataSetChanged();
                if (mediaList.get(0).getMimeType() == PictureConfig.TYPE_VIDEO) {
                    upLoadVideo(mediaList);
                } else {
                    uploadImg(mediaList, 0);
                }
            }
        }

    }


    private boolean isUpload = false;

    public void upLoadVideo(final List<LocalMedia> mediaData) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.setMessage("Uploading");
            progressDialog.setTitle("提示");
            progressDialog.setMax(100);
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(true);
            progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialogInterface) {
                    if (!isUpload) {
                        ToastUtils.showToast("Cancel Upload！");
                    }
                }
            });
        }
        //视频
        if (!progressDialog.isShowing()) {
            isUpload = false;
            progressDialog.show();
        }


        Observable.create(new ObservableOnSubscribe<Map<String, File>>() {
            @Override
            public void subscribe(ObservableEmitter<Map<String, File>> e) throws Exception {
                Bitmap videoThumb = MediaUtils.getVideoThumb(mediaData.get(0).getPath());
                String imgCache = FileUtils.bitmap2File(videoThumb, "img_cache");


                Map<String, File> fileMap = new HashMap<>();
                fileMap.put("image", new File(imgCache));
                fileMap.put("file", new File(mediaData.get(0).getPath()));
                e.onNext(fileMap);
                videoThumb.recycle();
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Map<String, File>>() {
                    Disposable disposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable = d;
                    }

                    @Override
                    public void onNext(Map<String, File> file) {
                        //开始网络请求 上传图片
                        if (OKHttpManager.getIsConnected()) {
                            return;
                        }
                        OkHttpUtils.post().addFile("image", file.get("image").getName(), file.get("image"))
                                .addFile("file", file.get("file").getName(), file.get("file")).url(getString(R.string.service_host_address).concat(getResources().getString(R.string.UploadMp4File)))
                                .build().execute(new StringCallback() {
                            @Override
                            public void onError(Call call, Exception e, int id) {
                                isUpload = true;
                                progressDialog.dismiss();
                                ToastUtils.showToast("上传失败，请重新上传");
                            }

                            @Override
                            public void onResponse(String response, int id) {
                                isUpload = true;
                                ToastUtils.showToast("Uploaded successfully");
                                BaseBean<String> netBaseBean = JSON.parseObject(response, BaseBean.class);
                                if (netBaseBean.getType() == 1) {
                                    String videoImgPath = netBaseBean.getMessage();
                                    String videoPath = netBaseBean.getResultdata();
                                    MediaBean mediaBean = new MediaBean();
                                    videos = videoImgPath + "," + videoPath;
                                    mediaBean.setType(PictureConfig.TYPE_VIDEO);
                                    mediaBean.setNetimgPath(videoImgPath);
                                    mediaBean.setNetVideoPath(videoPath);
                                    mediaMap.put(mediaData.get(0), mediaBean);
                                }
                                disposable.dispose();
                                progressDialog.dismiss();
                            }

                            @Override
                            public void inProgress(float progress, long total, int id) {
                                super.inProgress(progress, total, id);
                                progressDialog.setProgress((int) progress * 100);
                            }
                        });
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


    public void uploadImg(final List<LocalMedia> datas, final int position) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setMessage("上传中");
            progressDialog.setTitle("提示");
            progressDialog.setMax(100);
            progressDialog.setIndeterminate(false);
            progressDialog.setCancelable(true);
//            progressDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
//                @Override
//                public void onDismiss(DialogInterface dialog) {
//                    if (!isUpload) {
//                        ToastUtils.showToast("Cancel Upload！");
//                    }
//                }
//            });
        }
        //视频
        if (!progressDialog.isShowing()) {
            progressDialog.show();
        }

        EncodeTask encodeTask = new EncodeTask(new EncodeTask.onResponse() {
            @Override
            public void onResult(String base64) {
                Map<String, String> params = new HashMap<>();
                params.put("Type", "1");
                params.put("FileData", base64);

                OKHttpManager.uploadFile(params, new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onResponse(String response, int id) {
                        BaseBean<String> netBaseBean = JSON.parseObject(response, BaseBean.class);
                        if (netBaseBean.getType() == 1) {
                            String resultdata = netBaseBean.getResultdata();
                            MediaBean mediaBean = new MediaBean();
                            mediaBean.setType(PictureConfig.TYPE_IMAGE);
                            mediaBean.setNetimgPath(resultdata);
                            mediaBean.setSort(position);
                            mediaMap.put(datas.get(position), mediaBean);
                            uploadImg(datas, position + 1);
                        }
                    }

                    @Override
                    public void inProgress(float progress, long total, int id) {
                        super.inProgress(progress, total, id);
                        progressDialog.setProgress((int) progress * 100);
                    }
                });
            }
        });

        if (position >= datas.size()) {
            progressDialog.dismiss();
            return;
        }
        encodeTask.execute(datas.get(position).getCompressPath());

    }


    @OnClick({R.id.iv_img, R.id.iv_video, R.id.tv_submit})
    public void onClick(View view) {
        if (localMediaDatas.size() >= MAX_PICTURE) {
            ToastUtils.showToast("Comment photos and videos cannot be greater than 9");
            return;
        }
        switch (view.getId()) {
            case R.id.iv_img:

                ImgVideoPickerUtils.openPhoto(GoodsCommentActivity.this, MAX_PICTURE - localMediaDatas.size());
                break;
            case R.id.iv_video:
                for (LocalMedia localMediaData : localMediaDatas) {
                    if (localMediaData.getMimeType() == PictureConfig.TYPE_VIDEO) {
                        ToastUtils.showToast("Can only upload one video");
                        return;
                    }
                }
                ImgVideoPickerUtils.openVideo(GoodsCommentActivity.this);
                break;
            case R.id.tv_submit:

                int starCount = mRbStar.getStarCount();
                if (starCount == 0) {
                    ToastUtils.showToast("请选择评价星级");
                    return;
                }

                String content = mEtContent.getText().toString().trim();

                if (TextUtils.isEmpty(content)) {
                    ToastUtils.showToast("请输入评论内容");
                    return;
                }


                StringBuilder imgs = new StringBuilder();
                if (mediaMap.size() > 0) {
                    for (LocalMedia localMedia : mediaMap.keySet()) {
                        MediaBean mediaBean = mediaMap.get(localMedia);
                        imgs.append(mediaBean.getNetimgPath()).append(",");
                    }
                }

                String imgsChange =   imgs.toString().substring(0,imgs.toString().length());

                mAddEvaluatePresenter.addEvaluate(starCount, content, imgsChange, videos, mOrderId, mGoodsId);

                break;
            default:
                break;
        }
    }

    @Override
    public void addEvaluateSuccess() {
        finish();
    }
}
