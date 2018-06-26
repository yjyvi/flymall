package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.GoodsEvaluateListBean;
import com.whmnrc.flymall.beans.MediaBean;
import com.whmnrc.flymall.utils.TimeUtils;
import com.whmnrc.flymall.views.MyVideoPlayGoods;
import com.whmnrc.flymall.views.RatingBarView;
import com.whmnrc.mylibrary.utils.GlideUtils;
import com.whmnrc.mylibrary.widget.photobigview.PhotoViewActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class GoodsCommentAdapter extends CommonAdapter<GoodsEvaluateListBean.ResultdataBean.ModelsBean> {
    public GoodsCommentAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, GoodsEvaluateListBean.ResultdataBean.ModelsBean bean, int position) {

        holder.setIsRecyclable(false);
        RatingBarView view = holder.getView(R.id.rb_star);
        view.setClickable(false);
        view.setStar(bean.getStars(), false);
        GlideUtils.LoadCircleImage(mContext, bean.getPhoto(), (ImageView) holder.getView(R.id.iv_user_img));
        holder.setText(R.id.tv_goods_comment_content, bean.getCommentContent());
        holder.setText(R.id.tv_user_name, bean.getNick());
        String spec = bean.getColor() + bean.getSize() + bean.getVersion();
        if (!TextUtils.isEmpty(spec)) {
            holder.setText(R.id.tv_goods_spec, spec);
        } else {
            holder.setVisible(R.id.tv_goods_spec, false);
        }
        TimeUtils.setTime((TextView) holder.getView(R.id.tv_comment_time), bean.getCreateDate());

        RecyclerView rvGoodsCommentImg = holder.getView(R.id.rv_goods_comment_img);


        final List<MediaBean> mediaBeanList = new ArrayList<>();
        //视频
        MediaBean mediaBean;
        if (!TextUtils.isEmpty(bean.getVideoUrl())) {
            mediaBean = new MediaBean();
            mediaBean.setNetimgPath(bean.getThumImg());
            mediaBean.setNetVideoPath(bean.getVideoUrl());
            mediaBean.setType(1);
            mediaBeanList.add(mediaBean);
        }

        if (!TextUtils.isEmpty(bean.getImages())) {
            String images = bean.getImages();
            String[] split = images.split(",");
            for (int i = 0; i < split.length; i++) {
                if (!split[i].equals(bean.getThumImg())) {
                    mediaBean = new MediaBean();
                    mediaBean.setNetimgPath(split[i]);
                    mediaBean.setType(0);
                    mediaBeanList.add(mediaBean);
                }
            }
        } else {
            rvGoodsCommentImg.setVisibility(View.GONE);
        }

        if (mediaBeanList.size() > 0) {
            rvGoodsCommentImg.setLayoutManager(new GridLayoutManager(mContext, 3));
            EvaluateImgVideoAdapter evaluateImgVideoAdapter = new EvaluateImgVideoAdapter(mContext, R.layout.item_goods_comment_img);

            evaluateImgVideoAdapter.setDataArray(mediaBeanList);
            rvGoodsCommentImg.setAdapter(evaluateImgVideoAdapter);

            evaluateImgVideoAdapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                    if (mediaBeanList.get(position).getType() == 0) {
                        int selectPosition = position;
                        if (mediaBeanList.get(0).getType() == 1) {
                            selectPosition -=1;
                        }
                        toPIc(mediaBeanList, selectPosition);
                    } else {
                        String netVideoPath = mediaBeanList.get(position).getNetVideoPath();
                        if (!TextUtils.isEmpty(netVideoPath)) {
                            if (!netVideoPath.startsWith("http")) {
                                netVideoPath = mContext.getResources().getString(R.string.service_host_image) + netVideoPath;
                            }
                        }

                        MyVideoPlayGoods.start(mContext, netVideoPath);
                    }
                }

                @Override
                public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                    return false;
                }
            });
        }

    }


    /**
     * 查看图片
     *
     * @param mData
     */
    private void toPIc(List<MediaBean> mData, int position) {
        ArrayList<String> images = new ArrayList<>();

        for (MediaBean mDatum : mData) {
            if (mDatum.getType() == 0) {
                images.add(mDatum.getNetimgPath());
            }
        }

        PhotoViewActivity.start(mContext, images, position);
    }
}
