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

public class ShoppingCartAdapter extends CommonAdapter<ShoppingCartListBean.ResultdataBean.ProductsBean> {
    public ShoppingCartAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    private OperationShoppingCartListener mOperationShoppingCartListener;

    public void setOperationShoppingCartListener(OperationShoppingCartListener operationShoppingCartListener) {
        mOperationShoppingCartListener = operationShoppingCartListener;
    }

    @Override
    public void convert(ViewHolder holder, final ShoppingCartListBean.ResultdataBean.ProductsBean resultdataBean, final int position) {
        holder.setIsRecyclable(false);
        GlideUtils.LoadImage(mContext, resultdataBean.getImgUrl(), (ImageView) holder.getView(R.id.iv_goods_img));
        holder.setText(R.id.tv_goods_name, resultdataBean.getName());
        holder.setText(R.id.tv_goods_spec, resultdataBean.getColor() + resultdataBean.getSize() + resultdataBean.getVersion());
        holder.setText(R.id.edit_num, String.valueOf(resultdataBean.getCount()));
        holder.setText(R.id.tv_goods_price, PlaceholderUtils.pricePlaceholder(resultdataBean.getPrice()));

        final ImageView view = holder.getView(R.id.iv_selected);
        selectedView(view, position, resultdataBean);

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
                GoodsDetailsActivity.start(v.getContext(), String.valueOf(resultdataBean.getId()));
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
                resultdataBean.setCount(buyCarNum);
                goodsNum.setText(String.valueOf(buyCarNum));
                if (resultdataBean.isSelect()) {
                    mOperationShoppingCartListener.selectToPrice(position, resultdataBean.getPrice(), true, String.valueOf(resultdataBean.getSkuId()), String.valueOf(resultdataBean.getCartItemId()));
                }
                mOperationShoppingCartListener.addOrMinus(resultdataBean.getSkuId(), String.valueOf(buyCarNum));

            }
        });

        holder.setOnClickListener(R.id.iv_minus, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num = Integer.parseInt(goodsNum.getText().toString().trim());
                if (num >= 2) {
                    int buyCarNum = --num;
                    goodsNum.setText(String.valueOf(buyCarNum));
                    resultdataBean.setCount(buyCarNum);
                    if (resultdataBean.isSelect()) {
                        mOperationShoppingCartListener.selectToPrice(position, resultdataBean.getPrice(), false, String.valueOf(resultdataBean.getSkuId()), String.valueOf(resultdataBean.getCartItemId()));
                    }

                    mOperationShoppingCartListener.addOrMinus(resultdataBean.getSkuId(), String.valueOf(buyCarNum));
                }
            }
        });

    }

    public interface OperationShoppingCartListener {
        void delItem(int position);

        void selectToPrice(int position, double goodsPrice, boolean isAdd, String cartId, String cartItemId);

        void addOrMinus(String skuId, String count);
    }


    private void selectedView(View view, int position, ShoppingCartListBean.ResultdataBean.ProductsBean resultdataBean) {
        if (resultdataBean.isSelect()) {
            view.setSelected(false);
            resultdataBean.setSelect(false);
            mOperationShoppingCartListener.selectToPrice(position, resultdataBean.getPrice() * resultdataBean.getCount(), false, String.valueOf(resultdataBean.getSkuId()), String.valueOf(resultdataBean.getCartItemId()));
        } else {
            view.setSelected(true);
            resultdataBean.setSelect(true);
            mOperationShoppingCartListener.selectToPrice(position, resultdataBean.getPrice() * resultdataBean.getCount(), true, String.valueOf(resultdataBean.getSkuId()), String.valueOf(resultdataBean.getCartItemId()));
        }
    }

}
