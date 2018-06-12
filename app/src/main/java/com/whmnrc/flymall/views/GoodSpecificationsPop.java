package com.whmnrc.flymall.views;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.GoodsDetailsBean;
import com.whmnrc.flymall.beans.GoodsSpecificationsBean;
import com.whmnrc.flymall.presener.GoodsSpecificationsPresenter;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.mylibrary.utils.GlideUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by yong hao zeng on 2018/3/4.
 */

public class GoodSpecificationsPop implements GoodsSpecificationsPresenter.GoodsSpecificationsListener {

    private String mGoodsImg;
    private GoodsDetailsBean.ResultdataBean mGoodsSpecificationBean;
    private View mShowView;
    TextView tvPrice;
    ImageView ivImg;
    TagFlowLayout recyclerView1;
    TagFlowLayout recyclerView2;
    ImageView ivMinus;
    TextView editNum;
    ImageView ivAdd;
    ImageView ivClose;
    TextView tvName1;
    TextView tvName2;
    TextView tvSelectTag;
    TextView tvEntry;
    View llbootom;
    /**
     * //购买 购物车都显示  1 加入购物车 2：立即购买
     */
    private int type = 0;
    private int currentNumber = 1;
    private TagAdapter<GoodsDetailsBean.ResultdataBean.ColorBean> adapter2;
    private TagAdapter<GoodsDetailsBean.ResultdataBean.SizeBean> adapter1;
    private Activity activity;
    private PopListener popListener;
    List<GoodsDetailsBean.ResultdataBean.SizeBean> oneList = new ArrayList<>();
    List<GoodsDetailsBean.ResultdataBean.ColorBean> twoList = new ArrayList<>();
    public PopupWindow mPopupWindow;
    private int selectOneListPosition = -1;
    private int selectTwoListPosition = 0;
    private int mTotalNumber;
    private String mProductAttrIds = "";
    public TagFlowLayout.OnTagClickListener mOnTagClickListener;
    public TagFlowLayout.OnTagClickListener mOnTagClickListener2;
    private GoodsSpecificationsPresenter mGoodsSpecificationsPresenter;
    public int mGoodsId;
    private String versionSkuId = "0";
    public String mColorSkuId = "0";
    public String mSizeSkuId = "0";
    private GoodsSpecificationsBean.ResultdataBean mSpecificationBean;

    public void setPopListener(PopListener popListener) {
        this.popListener = popListener;
    }

    public GoodSpecificationsPop(Activity activity, GoodsDetailsBean.ResultdataBean goodsSpecificationBean, String goodsImg) {
        this.activity = activity;
        this.mGoodsSpecificationBean = goodsSpecificationBean;
        this.mGoodsImg = goodsImg;
        initPayTypePop();
    }


    public boolean isShow() {
        return mPopupWindow.isShowing();
    }


    private void initPayTypePop() {


        mPopupWindow = new PopupWindow(activity);
        View view = activity.getLayoutInflater().inflate(R.layout.activity_buy_dialog, null);
        mPopupWindow.setContentView(view);

        mPopupWindow.setWidth(LinearLayout.LayoutParams.MATCH_PARENT);
        mPopupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);

        tvPrice = view.findViewById(R.id.tv_price);
        ivImg = view.findViewById(R.id.iv_img);
        recyclerView1 = view.findViewById(R.id.recyclerView1);
        recyclerView2 = view.findViewById(R.id.recyclerView2);
        ivMinus = view.findViewById(R.id.iv_minus);
        editNum = view.findViewById(R.id.edit_num);
        ivAdd = view.findViewById(R.id.iv_add);
        ivClose = view.findViewById(R.id.tv_close);
        tvName1 = view.findViewById(R.id.tv_name1);
        tvName2 = view.findViewById(R.id.tv_name2);
        tvSelectTag = view.findViewById(R.id.tv_select_tag);
        tvEntry = view.findViewById(R.id.tv_entry);


        initData();

        initRv();


        ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dissmiss();
            }
        });


        tvEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String skuId;
                String skuAttr;
                if (mSpecificationBean == null) {
                    skuId = mGoodsId + "_" + mColorSkuId + "_" + mSizeSkuId + "_" + versionSkuId;
                    skuAttr = "";
                } else {
                    skuId = mSpecificationBean.getId();
                    skuAttr = mSpecificationBean.getColor() + mSpecificationBean.getColor() + mSpecificationBean.getVersion();
                }
                popListener.onEntryClick(selectOneListPosition, selectTwoListPosition, currentNumber, skuId, skuAttr);
            }
        });

    }

    private void initData() {

        mGoodsSpecificationsPresenter = new GoodsSpecificationsPresenter(this);
        if (mGoodsSpecificationBean == null) {
            return;
        }

        oneList = mGoodsSpecificationBean.getSize();
        twoList = mGoodsSpecificationBean.getColor();
        tvPrice.setText(PlaceholderUtils.pricePlaceholder(mGoodsSpecificationBean.getProduct().getMinSalePrice()));
        mGoodsId = mGoodsSpecificationBean.getProduct().getId();

        mOnTagClickListener = new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                mSizeSkuId = String.valueOf(oneList.get(position).getSKUId());
                selectOneListPosition = position;
                if (!TextUtils.equals(mColorSkuId, "0")) {
                    mGoodsSpecificationsPresenter.getSpecificationsList(String.valueOf(mGoodsId), mColorSkuId, mSizeSkuId, versionSkuId);
                }
                return true;
            }
        };
        recyclerView1.setOnTagClickListener(mOnTagClickListener);

        mOnTagClickListener2 = new TagFlowLayout.OnTagClickListener() {
            @Override
            public boolean onTagClick(View view, int position, FlowLayout parent) {
                selectTwoListPosition = position;

                mColorSkuId = String.valueOf(twoList.get(position).getSKUId());

                if (mGoodsSpecificationBean.getColor() != null && mGoodsSpecificationBean.getColor().size() > 0 &&
                        TextUtils.equals(mColorSkuId, "0")) {
                    ToastUtils.showToast("请选择颜色");
                    return false;
                }

                if (mGoodsSpecificationBean.getSize() != null && mGoodsSpecificationBean.getSize().size() > 0 &&
                        TextUtils.equals(mSizeSkuId, "0")) {
                    ToastUtils.showToast("请选择尺寸");
                    return false;
                }
                if (mGoodsSpecificationBean.getVersion() != null && mGoodsSpecificationBean.getVersion().size() > 0 &&
                        TextUtils.equals(versionSkuId, "0")) {
                    ToastUtils.showToast("请选择型号");
                    return false;
                }
                mGoodsSpecificationsPresenter.getSpecificationsList(String.valueOf(mGoodsId), mColorSkuId, mSizeSkuId, versionSkuId);
                return true;
            }
        };
        recyclerView2.setOnTagClickListener(mOnTagClickListener2);


        ivMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentNumber <= 1)
                    return;
                currentNumber--;
                editNum.setText(String.valueOf(currentNumber));
            }
        });

        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (currentNumber >= mTotalNumber) {
//                    ToastUtils.showToast("库存不足了");
//                    return;
//                }
                currentNumber++;
                editNum.setText(String.valueOf(currentNumber));
            }
        });

    }

    public void show() {
        // 设置PopupWindow以外部分的背景颜色  有一种变暗的效果
        // 0.0 完全不透明,1.0完全透明
        GlideUtils.LoadImage(activity, mGoodsImg, ivImg);
        PopUtils.setBackgroundAlpha(activity, 0.5f);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(false);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        // 设置弹出位置
        mPopupWindow.showAtLocation(activity.getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
        mPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                PopUtils.setBackgroundAlpha(activity, 1);
            }
        });
    }

    public void dissmiss() {
        mPopupWindow.dismiss();
    }

    private void initRv() {

        if (oneList.size() > 0) {
            tvName1.setVisibility(View.VISIBLE);
            recyclerView1.setVisibility(View.VISIBLE);
            adapter1 = new TagAdapter<GoodsDetailsBean.ResultdataBean.SizeBean>(oneList) {
                @Override
                public View getView(FlowLayout parent, int position, GoodsDetailsBean.ResultdataBean.SizeBean o) {
                    TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speciflcations_select2, null);
                    textView.setText(o.getValue());
                    return textView;
                }
            };
            recyclerView1.setAdapter(adapter1);
            selectOneListPosition = 0;
        } else {
            tvName1.setVisibility(View.GONE);
            recyclerView1.setVisibility(View.GONE);
        }


        if (twoList.size() > 0) {
            tvName2.setVisibility(View.VISIBLE);
            recyclerView2.setVisibility(View.VISIBLE);
            adapter2 = new TagAdapter<GoodsDetailsBean.ResultdataBean.ColorBean>(twoList) {
                @Override
                public View getView(FlowLayout parent, int position, GoodsDetailsBean.ResultdataBean.ColorBean contentBean) {
                    TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speciflcations_select2, null);
                    textView.setText(contentBean.getValue());
                    return textView;
                }
            };
            recyclerView2.setAdapter(adapter2);
        } else {
            tvName2.setVisibility(View.GONE);
            recyclerView2.setVisibility(View.GONE);
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void getGoodsSpecificationsSuccess(GoodsSpecificationsBean.ResultdataBean resultdataBean) {
        this.mSpecificationBean = resultdataBean;
        mTotalNumber = resultdataBean.getStock();
        tvPrice.setText(PlaceholderUtils.pricePlaceholder(resultdataBean.getSalePrice()));
        tvSelectTag.setText(String.format("Chosen“%s”“%s”", resultdataBean.getSize(), resultdataBean.getColor()));

    }

    //
    public interface PopListener {
        void onEntryClick(int oneId, int twoId, int number, String productAttrIds, String goodsAttr);

//        void onSelectClick(String sizeSku, String colorSku);
//
//        void onBuyClick(String oneId, String twoId, int number);
//
//        void addShopCar(String oneId, String twoId, int number);
    }

}
