package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.CollectionListBean;
import com.whmnrc.flymall.ui.home.GoodsDetailsActivity;
import com.whmnrc.mylibrary.utils.GlideUtils;

/**
 * @author yjyvi
 * @data 2018/5/23.
 */

public class CollectionAdapter extends CommonAdapter<CollectionListBean.ResultdataBean> {
    CollectionOpertionListener mCollectionOpertionListener;

    public void setCollectionOpertionListener(CollectionOpertionListener collectionOpertionListener) {
        mCollectionOpertionListener = collectionOpertionListener;
    }

    public CollectionAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, final CollectionListBean.ResultdataBean resultdataBean, final int position) {

        holder.setText(R.id.tv_goods_name, resultdataBean.getGoods_Name());
        GlideUtils.LoadImage(mContext, resultdataBean.getGoods_ImaPath(), (ImageView) holder.getView(R.id.iv_goods_img));
        holder.setOnClickListener(R.id.iv_del_collection, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCollectionOpertionListener != null) {
                    mCollectionOpertionListener.delCollection(resultdataBean);
                }
            }
        });

        holder.setOnClickListener(R.id.iv_selected, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedView(view, position, resultdataBean);
            }
        });

        holder.getView(R.id.right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCollectionOpertionListener != null) {
                    mCollectionOpertionListener.delCollection(resultdataBean);
                }
            }
        });


        holder.setOnClickListener(R.id.iv_goods_img, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsDetailsActivity.start(v.getContext(), resultdataBean.getGoods_ID());
            }
        });
    }


    public interface CollectionOpertionListener {
        void delCollection(CollectionListBean.ResultdataBean good);

        void selectCollection(int position, boolean isSelect, String collectionId);
    }


    private void selectedView(View view, int position, CollectionListBean.ResultdataBean resultdataBean) {
        if (!resultdataBean.isSelect()) {
            view.setSelected(true);
            resultdataBean.setSelect(true);
            mCollectionOpertionListener.selectCollection(position, true, resultdataBean.getId());
        } else {
            view.setSelected(false);
            resultdataBean.setSelect(false);
            mCollectionOpertionListener.selectCollection(position, false, resultdataBean.getId());
        }


    }
}
