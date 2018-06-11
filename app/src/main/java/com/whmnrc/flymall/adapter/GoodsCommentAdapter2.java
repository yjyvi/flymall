package com.whmnrc.flymall.adapter;

import android.content.Context;

import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.GoodsDetailsBean;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class GoodsCommentAdapter2 extends CommonAdapter<GoodsDetailsBean.ResultdataBean.EvaluateBean> {
    public GoodsCommentAdapter2(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, GoodsDetailsBean.ResultdataBean.EvaluateBean bean, int position) {
//        holder.setIsRecyclable(false);
//        RatingBarView view = holder.getView(R.id.rb_star);
//        view.setClickable(false);
//        view.setStar(bean.getEvaluate_Star(), false);
//        GlideUtils.LoadCircleImage(mContext, bean.getEvaluate_Img(), (ImageView) holder.getView(R.id.iv_user_img));
//        holder.setText(R.id.tv_user_name, bean.getUserInfo_NickName());
//        holder.setText(R.id.tv_goods_spec, bean.getGoodsPrice_AttrName());
//        holder.setText(R.id.tv_goods_comment_content, bean.getEvaluate_Content());
//        TimeUtils.setTime((TextView) holder.getView(R.id.tv_comment_time), bean.getEvaluate_Time());
//
//
//        RecyclerView rvGoodsCommentImg = holder.getView(R.id.rv_goods_comment_img);
//        rvGoodsCommentImg.setLayoutManager(new GridLayoutManager(mContext, 3));
//
//        EvaluateImgVideoAdapter evaluateImgVideoAdapter = new EvaluateImgVideoAdapter(mContext,R.layout.item_array_img);
//
//        List<MediaBean> mediaBeanList = new ArrayList<>();
//        for (GoodsDetailsBean.ResultdataBean.EvaluateBean.DyEvaluateItemBean dyEvaluateItemBean : bean.getDy_EvaluateItem()) {
//        MediaBean mediaBean = new MediaBean();
//            mediaBean.setNetimgPath(dyEvaluateItemBean.getEvaluateItem_Thumbnail());
//            mediaBean.setNetVideoPath(dyEvaluateItemBean.getEvaluateItem_FileUrl());
//            mediaBean.setType(dyEvaluateItemBean.getEvaluateItem_FileType());
//            mediaBeanList.add(mediaBean);
//        }
//
//        evaluateImgVideoAdapter.setDataArray(mediaBeanList);
//        rvGoodsCommentImg.setAdapter(evaluateImgVideoAdapter);

    }
}
