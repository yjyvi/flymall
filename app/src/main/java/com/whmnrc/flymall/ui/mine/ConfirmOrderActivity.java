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
import com.whmnrc.flymall.beans.AddressBean;
import com.whmnrc.flymall.beans.ConfirmBean;
import com.whmnrc.flymall.beans.CouponBean;
import com.whmnrc.flymall.beans.OrderDeitalsBean;
import com.whmnrc.flymall.beans.ShopCartCreateOrderBean;
import com.whmnrc.flymall.presener.AddressListPresenter;
import com.whmnrc.flymall.presener.CreateOrderPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.ui.home.VerticalGoodsListActivity;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.evntBusBean.AddressEvent;
import com.whmnrc.flymall.utils.evntBusBean.CouponsEvent;
import com.whmnrc.flymall.utils.evntBusBean.SHopCartEvent;
import com.whmnrc.flymall.views.LoadingDialog;
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
    public StringBuffer mSkuIds = new StringBuffer();
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
    public boolean mIsGoodsDetails;
    private LoadingDialog mLoadingDialog;

    @Override
    protected void initViewData() {
        setTitle("Confirm Order");

        EventBus.getDefault().register(this);


        mLoadingDialog = new LoadingDialog(this);

        mGoodsBean = getIntent().getParcelableArrayListExtra("goodsBean");
        mIsGoodsDetails = getIntent().getBooleanExtra("isGoodsDetails", false);

        mCreateOrderPresenter = new CreateOrderPresenter(this);

        mAddressListPresenter = new AddressListPresenter(this);
        mAddressListPresenter.getAddressList();

        if (mGoodsBean != null) {
            double sourcePrice = 0;
            double currentPrice = 0;

            for (ConfirmBean confirmBean : mGoodsBean) {
                sourcePrice += confirmBean.getGoods_SourcePrice() * confirmBean.getGoodsNUm();
                currentPrice += confirmBean.getGoodsPrice_Price() * confirmBean.getGoodsNUm();
                mGoodsNum += confirmBean.getGoodsNUm();
                if (mGoodsBean.size() == 1) {
                    mSkuIds.append(confirmBean.getPriceIds());
                } else {
                    mSkuIds.append(confirmBean.getPriceIds()).append(",");
                }
            }


            sourcePrice = sourcePrice * mGoodsNum;

            mTvOrderPrice.setText(PlaceholderUtils.pricePlaceholder(currentPrice));
            mTvOrderDiscountPrice.setText("-" + PlaceholderUtils.pricePlaceholder(0));
            mTvOrderFreight.setText("0");
            mMoney = currentPrice;
            mTvOrderTotalPrice.setText(PlaceholderUtils.pricePlaceholder(mMoney));
            mTvSumPrices.setText(PlaceholderUtils.pricePlaceholder(currentPrice));
            initSaleList();
        }
    }

    /**
     * SaleList
     */
    private void initSaleList() {
        mFlGoodsImg.removeAllViews();
        int goodsNum = 0;
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
                imageView.setLayoutParams(new LinearLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.dm_75), getResources().getDimensionPixelOffset(R.dimen.dm_75)));
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setBackgroundResource(R.color.normal_gray);
                GlideUtils.LoadImage(this, R.mipmap.icon_order_normal, imageView);
                mFlGoodsImg.addView(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        VerticalGoodsListActivity.start(view.getContext(), mGoodsBean);
                    }
                });
            }
            goodsNum += mGoodsBean.get(i).getGoodsNUm();
        }
        mTvGoodsNum.setText(String.format("%s items", goodsNum));
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_confirm_order;
    }


    public static void start(Context context, ArrayList<ConfirmBean> goodsBean, boolean isGoodsDetails) {
        Intent starter = new Intent(context, ConfirmOrderActivity.class);
        starter.putParcelableArrayListExtra("goodsBean", goodsBean);
        starter.putExtra("isGoodsDetails", isGoodsDetails);
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
                AddressManagerActivity.start(view.getContext(), true, mAddressId);
                break;
            case R.id.ll_tv_select_coupon:
                SelectCouponsActivity.start(view.getContext(), String.valueOf(mMoney));
                break;
            case R.id.tv_entry:
                if (TextUtils.isEmpty(mAddressId)) {
                    ToastUtils.showToast("Please select the shipping address");
                    return;
                }

                String productAttrIds = mSkuIds.toString();

                if (mIsGoodsDetails) {
                    mCreateOrderPresenter.goodsDetailsCreateOrder(productAttrIds, mAddressId, mCouponId, String.valueOf(mGoodsNum), mGoodsBean.get(0).getGoods_Name(), mEtRemark.getText().toString().trim());
                } else {
                    if (productAttrIds.split(",").length > 1) {
                        productAttrIds = productAttrIds.substring(0, productAttrIds.length() - 1);
                    }
                    mCreateOrderPresenter.shopCartCreateOrder(productAttrIds, mAddressId, mCouponId, mEtRemark.getText().toString().trim());
                }
                mLoadingDialog.show();
                break;
            case R.id.ll_to_order_img:
                VerticalGoodsListActivity.start(view.getContext(), mGoodsBean);
                break;
            default:
                break;
        }
    }

    @Override
    public void createOneOrderSuccess(OrderDeitalsBean.ResultdataBean resultdataBean) {
        createSuccess(String.valueOf(resultdataBean.getId()), resultdataBean.getProductTotalAmount() - mCouponFullQuota);
    }

    @Override
    public void createOrderField() {
        mLoadingDialog.show();
    }


    @Override
    public void createMutOrderSuccess(ShopCartCreateOrderBean.ResultdataBean resultdataBean) {
        createSuccess(String.valueOf(resultdataBean.getId()), resultdataBean.getProductTotalAmount() - mCouponFullQuota);
    }


    /**
     * 创建成功跳转
     *
     * @param orderId
     * @param price
     */
    private void createSuccess(String orderId, double price) {
        mLoadingDialog.dismiss();
        //刷新购物车
        EventBus.getDefault().post(new SHopCartEvent().setEventType(SHopCartEvent.ADD_SHOPPING_CART_SUCCESS));
        ConfirmPaymentActivity.start(this, orderId, price, JSON.toJSONString(addressEventData));
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
            for (AddressBean.ResultdataBean resultdataBean : resultdataBeans) {
                if (resultdataBean.getAddress_IsDefault() == 1) {
                    addressEventData = resultdataBean;
                    mRlAddAddress.setVisibility(View.GONE);
                    mRlSelectAddress.setVisibility(View.VISIBLE);
                    mRlSelectAddress.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AddressManagerActivity.start(v.getContext(), true, mAddressId);
                        }
                    });
                    mAddressId = String.valueOf(resultdataBean.getId());
                    mTvAddressDesc.setText(resultdataBean.getAddress());
                    mTvAddressName.setText(String.format("Receiver：%s %s", resultdataBean.getShipTo(), resultdataBean.getAddress_LastName()));
                    mTvAddressTel.setText(resultdataBean.getPhone());
                    break;
                } else {
                    mRlAddAddress.setVisibility(View.VISIBLE);
                    mRlSelectAddress.setVisibility(View.GONE);
                    mRlAddAddress.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AddressManagerActivity.start(v.getContext(), true, mAddressId);
                        }
                    });
                }

            }

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
                mRlAddAddress.setVisibility(View.GONE);
                mRlSelectAddress.setVisibility(View.VISIBLE);
                mAddressId = String.valueOf(addressEventData.getId());
                mTvAddressTel.setText(addressEventData.getPhone());
                mTvAddressDesc.setText(addressEventData.getAddress());
                mTvAddressName.setText(String.format("Receiver：%s %s", addressEventData.getShipTo(), addressEventData.getAddress_LastName()));
            }
        } else if (addressEvent.getEventType() == AddressEvent.ADD_ADDRESS_SUCCESS) {
            mAddressListPresenter.getAddressList();
        }
    }


    @Subscribe
    public void selectCouponsEvent(CouponsEvent couponsEvent) {
        if (couponsEvent.getEventType() == CouponsEvent.SELECT_COUPONS) {
            CouponBean.ResultdataBean data = (CouponBean.ResultdataBean) couponsEvent.getData();
            mCouponId = String.valueOf(data.getCouponId());
            mTvOrderCoupon.setText(data.getCouponName());
            mCouponFullQuota = data.getPrice();
            mTvOrderDiscountPrice.setText("-" + PlaceholderUtils.pricePlaceholder(mCouponFullQuota));
            mTvSumPrices.setText(PlaceholderUtils.pricePlaceholder(mMoney - mCouponFullQuota));
        }
    }


}
