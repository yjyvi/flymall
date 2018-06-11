package com.whmnrc.flymall.ui.mine;


import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.GoodListAdapter;
import com.whmnrc.flymall.beans.AddressBean;
import com.whmnrc.flymall.beans.ConfirmBean;
import com.whmnrc.flymall.beans.CouponBean;
import com.whmnrc.flymall.presener.AddressListPresenter;
import com.whmnrc.flymall.presener.CreateOrderPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.ui.home.VerticalGoodsListActivity;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.evntBusBean.AddressEvent;
import com.whmnrc.flymall.utils.evntBusBean.CouponsEvent;
import com.whmnrc.mylibrary.utils.GlideUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class ConfirmOrderActivity extends BaseActivity implements CreateOrderPresenter.CreateOrderListener, AddressListPresenter.AddressListListener {
    @BindView(R.id.fl_goods_img)
    LinearLayout mFlGoodsImg;
    @BindView(R.id.tv_total)
    TextView mTvTotal;
    @BindView(R.id.ll_to_order_img)
    LinearLayout mLlToOrderImg;
    @BindView(R.id.tv_order_coupon)
    TextView mTvOrderCoupon;
    @BindView(R.id.tv_order_price)
    TextView mTvOrderPrice;
    @BindView(R.id.tv_order_discount_price)
    TextView mTvOrderDiscountPrice;
    @BindView(R.id.tv_order_freight)
    TextView mTvOrderFreight;
    @BindView(R.id.tv_order_total_price)
    TextView mTvOrderTotalPrice;
    @BindView(R.id.tv_sum_prices)
    TextView mTvSumPrices;
    @BindView(R.id.rl_add_address)
    RelativeLayout mRlAddAddress;
    @BindView(R.id.rl_select_address)
    RelativeLayout mRlSelectAddress;
    @BindView(R.id.tv_address_name)
    TextView mTvAddressName;
    @BindView(R.id.tv_address_tel)
    TextView mTvAddressTel;
    @BindView(R.id.tv_address_desc)
    TextView mTvAddressDesc;
    @BindView(R.id.tv_goods_num)
    TextView mTvGoodsNum;
    @BindView(R.id.et_remark)
    EditText mEtRemark;
    private GoodListAdapter mGoodListAdapter;
    public StringBuffer mPriceIds = new StringBuffer();
    public CreateOrderPresenter mCreateOrderPresenter;
    public AddressListPresenter mAddressListPresenter;
    private String mAddressId;
    private String mCouponId = "";
    public ArrayList<ConfirmBean> mGoodsBean;
    private int mGoodsNum = 0;
    public AddressBean.ResultdataBean addressEventData;
    public double mMoney;
    /**
     * 优惠券的金额
     */
    public double mCouponFullQuota;

    @Override
    protected void initViewData() {
        setTitle("Confirm Order");

        EventBus.getDefault().register(this);


        mGoodsBean = getIntent().getParcelableArrayListExtra("goodsBean");

        mCreateOrderPresenter = new CreateOrderPresenter(this);

        mAddressListPresenter = new AddressListPresenter(this);
        mAddressListPresenter.getAddressList();

        if (mGoodsBean != null) {
            double sourcePrice = 0;
            double currentPrice = 0;

            for (ConfirmBean confirmBean : mGoodsBean) {
                sourcePrice += confirmBean.getGoods_SourcePrice();
                currentPrice += confirmBean.getGoodsPrice_Price();
                mGoodsNum += confirmBean.getGoodsNUm();
                if (mGoodsBean.size() == 1) {
                    mPriceIds.append(confirmBean.getPriceIds());
                } else {
                    mPriceIds.append(confirmBean.getPriceIds()).append("|");
                }
            }


            mTvOrderPrice.setText(PlaceholderUtils.pricePlaceholder(sourcePrice));
            mTvOrderDiscountPrice.setText(PlaceholderUtils.pricePlaceholder(currentPrice));
            mTvOrderFreight.setText("0");
            mMoney = sourcePrice - currentPrice;
            mTvOrderTotalPrice.setText(PlaceholderUtils.pricePlaceholder(mMoney));
            mTvSumPrices.setText(PlaceholderUtils.pricePlaceholder(mMoney));
            initSaleList();
        }
    }

    /**
     * SaleList
     */
    private void initSaleList() {
        mFlGoodsImg.removeAllViews();
        for (int i = 0; i < mGoodsBean.size(); i++) {
            if (i <= 1) {
                ImageView imageView = new ImageView(this);
                imageView.setPadding(0, 0, getResources().getDimensionPixelOffset(R.dimen.dm_5), 0);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.dm_75), getResources().getDimensionPixelOffset(R.dimen.dm_75)));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                GlideUtils.LoadImage(this, mGoodsBean.get(i).getGoods_ImaPath(), imageView);
                mFlGoodsImg.addView(imageView);
            } else if (i == 2) {
                ImageView imageView = new ImageView(this);
                imageView.setPadding(0, 0, getResources().getDimensionPixelOffset(R.dimen.dm_5), 0);
                imageView.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.dm_75), getResources().getDimensionPixelOffset(R.dimen.dm_75)));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setBackgroundResource(R.color.normal_gray);
                GlideUtils.LoadImage(this, R.mipmap.icon_order_normal, imageView);
                mFlGoodsImg.addView(imageView);
            }
        }
        mTvGoodsNum.setText(String.format("%s items", mGoodsBean.size()));
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_confirm_order;
    }


    public static void start(Context context, ArrayList<ConfirmBean> goodsBean) {
        Intent starter = new Intent(context, ConfirmOrderActivity.class);
        starter.putParcelableArrayListExtra("goodsBean", goodsBean);
        context.startActivity(starter);
    }


    @OnClick({R.id.iv_address_edit, R.id.rl_select_address,
            R.id.ll_tv_select_coupon, R.id.tv_entry,
            R.id.ll_to_order_img
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_address_edit:
                AddressManagerActivity.start(view.getContext());
                break;
            case R.id.rl_select_address:
                AddressManagerActivity.start(view.getContext());
                break;
            case R.id.ll_tv_select_coupon:
                SelectCouponsActivity.start(view.getContext(), String.valueOf(mMoney));
                break;
            case R.id.tv_entry:
                if (TextUtils.isEmpty(mAddressId)) {
                    ToastUtils.showToast("地址不能为空");
                    return;
                }

                if (TextUtils.isEmpty(mAddressId)) {
                    ToastUtils.showToast("地址不能为空");
                    return;
                }

                mCreateOrderPresenter.createOrder(mPriceIds.toString(), mAddressId, mCouponId, mEtRemark.getText().toString().trim());
                break;
            case R.id.ll_to_order_img:
                VerticalGoodsListActivity.start(view.getContext(), mGoodsBean);
                break;
            default:
                break;
        }
    }

    @Override
    public void createOrderSuccess(String orderId) {
        ConfirmPaymentActivity.start(this, orderId, PlaceholderUtils.pricePlaceholder(mMoney), JSON.toJSONString(addressEventData));
        finish();
    }

    @Override
    public void getListSuccess(List<AddressBean.ResultdataBean> resultdataBeans) {
        if (resultdataBeans.size() == 0) {
            mRlAddAddress.setVisibility(View.VISIBLE);
            mRlSelectAddress.setVisibility(View.GONE);
            mRlAddAddress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AddressManagerActivity.start(v.getContext(), true);
                }
            });
        } else {
            addressEventData = resultdataBeans.get(0);
            mRlAddAddress.setVisibility(View.GONE);
            mRlSelectAddress.setVisibility(View.VISIBLE);
            mRlSelectAddress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AddressManagerActivity.start(v.getContext(), true);
                }
            });
            mAddressId = String.valueOf(resultdataBeans.get(0).getId());
            mTvAddressDesc.setText(resultdataBeans.get(0).getAddress());
            mTvAddressName.setText(String.format("Receiver：%s", resultdataBeans.get(0).getRegionFullName()));
            mTvAddressTel.setText(resultdataBeans.get(0).getPhone());
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @org.greenrobot.eventbus.Subscribe
    public void addressEvent(AddressEvent addressEvent) {
        if (addressEvent.getEventType() == AddressEvent.ORDER_SELECT_ADDRESS) {
            addressEventData = (AddressBean.ResultdataBean) addressEvent.getData();
            if (addressEventData != null) {
                mAddressId = String.valueOf(addressEventData.getId());
                mTvAddressTel.setText(addressEventData.getPhone());
                mTvAddressDesc.setText(addressEventData.getAddress());
                mTvAddressName.setText(String.format("Receiver：%s", addressEventData.getRegionFullName()));
            }
        }
    }

    @Subscribe
    public void selectCouponsEvent(CouponsEvent couponsEvent) {
        if (couponsEvent.getEventType() == CouponsEvent.SELECT_COUPONS) {
            CouponBean.ResultdataBean data = (CouponBean.ResultdataBean) couponsEvent.getData();
            mCouponId = data.getCoupon_ID();
            mTvOrderCoupon.setText(data.getCoupon_Name());
            mCouponFullQuota = data.getCoupon_FullQuota();
            mTvOrderDiscountPrice.setText(PlaceholderUtils.pricePlaceholder(mCouponFullQuota));
            mTvSumPrices.setText(PlaceholderUtils.pricePlaceholder(mMoney - mCouponFullQuota));
        }
    }


}
