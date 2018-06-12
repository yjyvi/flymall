package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.presener.PayPPPresenter;
import com.whmnrc.flymall.presener.UpdateHeadImgPresenter;
import com.whmnrc.flymall.presener.UpdateUserInfoPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.UIUtils;
import com.whmnrc.flymall.utils.evntBusBean.UserInfoEvent;
import com.whmnrc.flymall.views.ActionSheetDialog;
import com.whmnrc.mylibrary.utils.EncodeTask;
import com.whmnrc.mylibrary.utils.GlideUtils;
import com.whmnrc.mylibrary.utils.ImgVideoPickerUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/21.
 */

public class PersonalInformationActivity extends BaseActivity implements UpdateHeadImgPresenter.UpdateHeadImgListener, UpdateUserInfoPresenter.UpdateUserInfoListener {
    @BindView(R.id.tv_user_header_img)
    ImageView mTvUserHeaderImg;
    @BindView(R.id.tv_user_name)
    EditText mTvUserName;
    @BindView(R.id.tv_user_gender)
    TextView mTvUserGender;
    private File headFile;
    public UpdateHeadImgPresenter mUpdateHeadImgPresenter;
    private String mResultImgUrl = "";
    public UpdateUserInfoPresenter mUpdateUserInfoPresenter;
    public PayPPPresenter mPayPPPresenter;

    @Override
    protected void initViewData() {
        EventBus.getDefault().register(this);
        mUpdateHeadImgPresenter = new UpdateHeadImgPresenter(this);
        mUpdateUserInfoPresenter = new UpdateUserInfoPresenter(this);

        setTitle("Personal information");

        GlideUtils.LoadCircleImage(this, UserManager.getUser().getPhoto(), mTvUserHeaderImg);

        mTvUserGender.setText(UserManager.getUser().getPoints() == 0 ? "Male" : "Female");
        mTvUserName.setText(UserManager.getUser().getNick());
        mTvUserName.setSelection(mTvUserName.getText().toString().length());


    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_personal_information;
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, PersonalInformationActivity.class);
        context.startActivity(starter);
    }


    @OnClick({R.id.ll_header_img, R.id.ll_gender, R.id.tv_save})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_header_img:
                new ActionSheetDialog(PersonalInformationActivity.this)
                        .builder()
                        .setTitle("Modify avatar")
                        .setCancelable(false)
                        .setCanceledOnTouchOutside(false)
                        .addSheetItem("Gallery", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                ImgVideoPickerUtils.openSinglePhoto(PersonalInformationActivity.this);

                            }
                        })
                        .addSheetItem("Camera", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                ImgVideoPickerUtils.openCamera(PersonalInformationActivity.this);

                            }
                        }).show();

                break;

            case R.id.ll_gender:
                new ActionSheetDialog(this)
                        .builder()
                        .setTitle("Select gender")
                        .setCancelable(false)
                        .setCanceledOnTouchOutside(false)
                        .addSheetItem("Male", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                mTvUserGender.setText("Male");
                            }
                        })

                        .addSheetItem("Female", ActionSheetDialog.SheetItemColor.Blue, new ActionSheetDialog.OnSheetItemClickListener() {
                            @Override
                            public void onClick(int which) {
                                mTvUserGender.setText("Female");

                            }
                        }).show();
                break;
            case R.id.tv_save:
                String nickName = mTvUserName.getText().toString().trim();
                if (TextUtils.isEmpty(nickName)) {
                    ToastUtils.showToast("昵称不能为空");
                    return;
                }

                if (TextUtils.isEmpty(mTvUserGender.getText().toString().trim())) {
                    ToastUtils.showToast("性别不能为空");
                    return;
                }
                mUpdateUserInfoPresenter.updateUserInfo(mResultImgUrl, nickName, mTvUserGender.getText().toString().trim());
                break;
            default:
                break;
        }
    }

    //图片选择 拍照回调
    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK) {
            List<LocalMedia> mediaList = PictureSelector.obtainMultipleResult(data);
            if (!mediaList.isEmpty())
                headFile = new File(mediaList.get(0).getCompressPath());
            else {
                return;
            }
            UIUtils.loadCircleImg(mTvUserHeaderImg, headFile);
            //异步转化为base64
            EncodeTask encodeTask = new EncodeTask(new EncodeTask.onResponse() {
                @Override
                public void onResult(String base64) {
                    if (!TextUtils.isEmpty(base64)) {
                        mUpdateHeadImgPresenter.updateHeadImg(base64,"123123");
                    }
                }
            });
            encodeTask.execute(headFile.getPath());
        }
    }

    @Override
    public void loadSuccess(String resultImgUrl) {
        this.mResultImgUrl = resultImgUrl;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void uploadUserInfoSuccess(String resultMsg) {
        ToastUtils.showToast(resultMsg);
        UserManager.refresh();
        EventBus.getDefault().post(new UserInfoEvent().setEventType(UserInfoEvent.UPDATE_USER_INFO));
        finish();
    }

    @Subscribe
    public void userUpdateEvent(UserInfoEvent userInfoEvent) {

    }


}
