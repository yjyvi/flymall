package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.ShoppingCartListBean;
import com.whmnrc.flymall.ui.home.GoodsDetailsActivity;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.mylibrary.utils.GlideUtils;

/**
 * @author yjyvi
 * @data 2018/5/18.
 */

public class ShoppingCartAdapter extends CommonAdapter<ShoppingCartListBean.ResultdataBean> {
    public ShoppingCartAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    private OperationShoppingCartListener mOperationShoppingCartListener;

    public void setOperationShoppingCartListener(OperationShoppingCartListener operationShoppingCartListener) {
        mOperationShoppingCartListener = operationShoppingCartListener;
    }

    @Override
    public void convert(ViewHolder holder, final ShoppingCartListBean.ResultdataBean resultdataBean, final int position) {

        GlideUtils.LoadImage(mContext, resultdataBean.getGoods_ImaPath(), (ImageView) holder.getView(R.id.iv_goods_img));
        holder.setText(R.id.tv_goods_name, resultdataBean.getGoods_Name());
        holder.setText(R.id.tv_goods_spec, resultdataBean.getGoodsPrice_AttrName());
        holder.setText(R.id.edit_num, String.valueOf(resultdataBean.getBuyCar_Num()));
        holder.setText(R.id.tv_goods_price, PlaceholderUtils.pricePlaceholder(resultdataBean.getGoodsPrice_Price()));

        final ImageView view = holder.getView(R.id.iv_selected);
        holder.setOnClickListener(R.id.iv_selected, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedView(view, position, resultdataBean);
            }
        });

        final TextView goodsNum = holder.getView(R.id.edit_num);


        holder.getView(R.id.iv_goods_img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsDetailsActivity.start(v.getContext(), "");
            }
        });

        holder.getView(R.id.right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOperationShoppingCartListener != null) {
                    mOperationShoppingCartListener.delItem(position);
                }
            }
        });

        holder.setOnClickListener(R.id.iv_add, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(goodsNum.getText().toString().trim());
                int buyCarNum = ++num;
                resultdataBean.setBuyCar_Num(buyCarNum);
                goodsNum.setText(String.valueOf(buyCarNum));
                if (resultdataBean.isSelect()) {
                    mOperationShoppingCartListener.selectToPrice(position, resultdataBean.getGoodsPrice_Price() , true, resultdataBean.getBuyCar_ID());
                }
            }
        });

        holder.setOnClickListener(R.id.iv_minus, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(goodsNum.getText().toString().trim());
                if (num >= 2) {
                    int buyCarNum = --num;
                    goodsNum.setText(String.valueOf(buyCarNum));
                    resultdataBean.setBuyCar_Num(buyCarNum);
                    if (resultdataBean.isSelect()) {
                        mOperationShoppingCartListener.selectToPrice(position, resultdataBean.getGoodsPrice_Price() , false, resultdataBean.getBuyCar_ID());
                    }
                }
            }
        });

    }

    public interface OperationShoppingCartListener {
        void delItem(int position);

        void selectToPrice(int position, double goodsPrice, boolean isAdd, String cartId);
    }


    private void selectedView(View view, int position, ShoppingCartListBean.ResultdataBean resultdataBean) {
        if (!resultdataBean.isSelect()) {
            view.setSelected(true);
            resultdataBean.setSelect(true);
            mOperationShoppingCartListener.selectToPrice(position, resultdataBean.getGoodsPrice_Price() * resultdataBean.getBuyCar_Num(), true, resultdataBean.getBuyCar_ID());
        } else {
            view.setSelected(false);
            resultdataBean.setSelect(false);
            mOperationShoppingCartListener.selectToPrice(position, resultdataBean.getGoodsPrice_Price() * resultdataBean.getBuyCar_Num(), false, resultdataBean.getBuyCar_ID());
        }

    }

}
