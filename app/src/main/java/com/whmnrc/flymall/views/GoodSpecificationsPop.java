package com.whmnrc.flymall.views;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.MultiItemTypeAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.GoodsDetailsBean;
import com.whmnrc.flymall.beans.GoodsSpecificationsBean;
import com.whmnrc.flymall.presener.GoodsSpecificationsPresenter;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.mylibrary.utils.GlideUtils;

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
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
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
    private CommonAdapter<GoodsDetailsBean.ResultdataBean.ColorBean> adapter2;
    private CommonAdapter<GoodsDetailsBean.ResultdataBean.SizeBean> adapter1;
    private Activity activity;
    private PopListener popListener;
    List<GoodsDetailsBean.ResultdataBean.SizeBean> oneList = new ArrayList<>();
    List<GoodsDetailsBean.ResultdataBean.ColorBean> twoList = new ArrayList<>();
    public PopupWindow mPopupWindow;
    private int selectOneListPosition = -1;
    private int selectTwoListPosition = -1;
    private int mTotalNumber;
    private String mProductAttrIds = "";
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

                if (oneList.size() != 0) {
                    if (twoList.size() == 0 && selectOneListPosition == -1) {
                        ToastUtils.showToast("Please select specifications");
                        return;
                    }
                    if (twoList.size() > 0 && selectTwoListPosition == -1) {
                        ToastUtils.showToast("Please select specifications");
                        return;
                    }
                    if (twoList.size() > 0 && selectOneListPosition == -1) {
                        ToastUtils.showToast("Please select specifications");
                        return;
                    }
                }

                if (mSpecificationBean == null) {
                    skuId = mGoodsId + "_" + mColorSkuId + "_" + mSizeSkuId + "_" + versionSkuId;
                    skuAttr = "";
                } else {
                    skuId = mSpecificationBean.getId();
                    skuAttr = mSpecificationBean.getColor() + mSpecificationBean.getSize() + mSpecificationBean.getVersion();
                }

                if (oneList.size() != 0 && TextUtils.isEmpty(skuAttr)) {
                    ToastUtils.showToast("Please select specifications");
                    return;
                }
                if (twoList.size() != 0 && TextUtils.isEmpty(skuAttr)) {
                    ToastUtils.showToast("Please select specifications");
                    return;
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
                currentNumber++;
                editNum.setText(String.valueOf(currentNumber));
            }
        });

    }

    public void show() {

        // 设置PopupWindow以外部分的背景颜色  有一种变暗的效果
        // 0.0 完全不透明,1.0完全透明
        if (!TextUtils.isEmpty(mGoodsImg)) {
            if (!mGoodsImg.endsWith(".png") || !mGoodsImg.endsWith(".jpg")) {
                mGoodsImg += "/1.png";
                GlideUtils.LoadImage(activity, mGoodsImg, ivImg);
            }
        }
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

    private View adapter1View;
    private View adapter2View;

    /**
     * 选择重置
     */
    private void selectedFalse(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        for (int i = 0; i < childCount; i++) {
            layoutManager.getChildAt(i).setSelected(false);
        }
    }

    private void initRv() {

        if (oneList.size() > 0) {
            tvName1.setVisibility(View.VISIBLE);
            recyclerView1.setVisibility(View.VISIBLE);
            recyclerView1.setLayoutManager(new GridLayoutManager(activity, 3));

            adapter1 = new CommonAdapter<GoodsDetailsBean.ResultdataBean.SizeBean>(activity, R.layout.item_speciflcations_select2) {
                @Override
                public void convert(ViewHolder holder, GoodsDetailsBean.ResultdataBean.SizeBean sizeBean, int position) {
                    holder.setText(R.id.tv_name, sizeBean.getValue());
                }
            };
            adapter1.setDataArray(oneList);
            recyclerView1.setAdapter(adapter1);
            recyclerView1.setNestedScrollingEnabled(false);
            selectOneListPosition = 0;

            adapter1.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                    selectedFalse(recyclerView1);

                    String colorName = " ";
                    if (selectTwoListPosition != -1) {
                        colorName = mGoodsSpecificationBean.getColor().get(selectTwoListPosition).getValue();
                    }


                    if (selectOneListPosition != position) {
                        view.setSelected(true);
                        mSizeSkuId = String.valueOf(oneList.get(position).getSKUId());
                        selectOneListPosition = position;
                        tvSelectTag.setText(String.format("Chosen %s %s ", mGoodsSpecificationBean.getSize().get(position).getValue(), colorName));
                        if (twoList.size() > 0 && !TextUtils.equals(mColorSkuId, "0") || twoList.size() == 0) {
                            mGoodsSpecificationsPresenter.getSpecificationsList(String.valueOf(mGoodsId), mColorSkuId, mSizeSkuId, versionSkuId);
                        }
                    } else {
                        view.setSelected(false);
                        mSizeSkuId = "0";
                        tvSelectTag.setText(String.format("Chosen %s %s ", "", colorName));
                        selectOneListPosition = -1;
                    }
                }

                @Override
                public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                    return false;
                }
            });


        } else {
            tvName1.setVisibility(View.GONE);
            recyclerView1.setVisibility(View.GONE);
        }


        if (twoList.size() > 0) {
            tvName2.setVisibility(View.VISIBLE);
            recyclerView2.setVisibility(View.VISIBLE);
            recyclerView2.setNestedScrollingEnabled(false);
            recyclerView2.setLayoutManager(new GridLayoutManager(activity, 3));
            adapter2 = new CommonAdapter<GoodsDetailsBean.ResultdataBean.ColorBean>(activity, R.layout.item_speciflcations_select2) {
                @Override
                public void convert(ViewHolder holder, GoodsDetailsBean.ResultdataBean.ColorBean colorBean, int position) {
                    holder.setText(R.id.tv_name, colorBean.getValue());
                }
            };
            adapter2.setDataArray(twoList);
            recyclerView2.setAdapter(adapter2);

            adapter2.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                    selectedFalse(recyclerView2);

                    String sizeName = " ";
                    if (selectOneListPosition != -1) {
                        sizeName = mGoodsSpecificationBean.getSize().get(selectOneListPosition).getValue();
                    }


                    if (selectTwoListPosition != position) {
                        view.setSelected(true);
                        tvSelectTag.setText(String.format("Chosen %s %s ", sizeName, mGoodsSpecificationBean.getColor().get(position).getValue()));
                        selectTwoListPosition = position;
                        mColorSkuId = String.valueOf(twoList.get(position).getSKUId());
                        if (oneList.size() == 0 || oneList.size() > 0 && !TextUtils.equals("0", mSizeSkuId)) {
                            mGoodsSpecificationsPresenter.getSpecificationsList(String.valueOf(mGoodsId), mColorSkuId, mSizeSkuId, versionSkuId);
                        }
                    } else {
                        view.setSelected(false);
                        tvSelectTag.setText(String.format("Chosen %s %s ", sizeName, " "));
                        selectTwoListPosition = -1;
                        mColorSkuId = "0";
                    }
                }

                @Override
                public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                    return false;
                }
            });
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
        tvSelectTag.setText(String.format("Chosen %s %s ", resultdataBean.getSize(), resultdataBean.getColor()));
    }

    //
    public interface PopListener {
        void onEntryClick(int oneId, int twoId, int number, String productAttrIds, String goodsAttr);
    }

}
