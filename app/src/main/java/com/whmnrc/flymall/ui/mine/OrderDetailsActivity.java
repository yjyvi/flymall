package com.whmnrc.flymall.ui.mine;

import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.ConfirmOrderGoodListAdapter;
import com.whmnrc.flymall.beans.AddressBean;
import com.whmnrc.flymall.beans.OrderListBean;
import com.whmnrc.flymall.presener.OrderDetailsPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.ui.home.OderCommentListActivity;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.views.AlertDialog;
import com.whmnrc.flymall.views.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/22.
 */

public class OrderDetailsActivity extends BaseActivity implements OrderDetailsPresenter.OrderDetailsListener {

    @BindView(R.id.rv_goods_list)
    RecyclerView rvGoodsList;
    @BindView(R.id.tv_address_name)
    TextView mTvAddressName;
    @BindView(R.id.tv_address_tel)
    TextView mTvAddressTel;
    @BindView(R.id.tv_address_desc)
    TextView mTvAddressDesc;
    @BindView(R.id.tv_order_number)
    TextView mTvOrderNumber;
    @BindView(R.id.tv_order_time)
    TextView mTvOrderTime;
    @BindView(R.id.tv_order_type)
    TextView mTvOrderType;
    @BindView(R.id.tv_order_total_price)
    TextView mTvOrderTotalPrice;
    @BindView(R.id.tv_order_freight)
    TextView mTvOrderFreight;
    @BindView(R.id.tv_order_pay_price)
    TextView mTvOrderPayPrice;
    @BindView(R.id.tv_skype)
    TextView mTvSkype;
    @BindView(R.id.tv_cancel_order)
    TextView mTvCancelOrder;
    @BindView(R.id.tv_pay_order)
    TextView mTvPayOrder;
    @BindView(R.id.ll_bottom)
    LinearLayout ll_bottom;
    private LoadingDialog mLoadingDialog;
    public OrderDetailsPresenter mOrderDetailsPresenter;
    public String mOrderId;
    public ConfirmOrderGoodListAdapter mMOrderListAdapter;
    private OrderListBean.ResultdataBean orderBean;

    @Override
    protected void initViewData() {
        setTitle("Line item");
        mLoadingDialog = new LoadingDialog(this);
        rvGoodsList.setNestedScrollingEnabled(false);

        mOrderId = getIntent().getStringExtra("orderId");
        mOrderDetailsPresenter = new OrderDetailsPresenter(this);
        mOrderDetailsPresenter.getOrderDetails(mOrderId);

        rvGoodsList.setLayoutManager(new LinearLayoutManager(this));
        rvGoodsList.addItemDecoration(new RecyclerView.ItemDecoration() {

            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                c.drawColor(ContextCompat.getColor(parent.getContext(), R.color.common_line));
            }

            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.bottom = 1;
            }
        });
        mMOrderListAdapter = new ConfirmOrderGoodListAdapter(this, R.layout.item_goods_list_vertical, true);

        rvGoodsList.setAdapter(mMOrderListAdapter);

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_order_details;
    }

    public static void start(Context context, String orderId) {
        Intent starter = new Intent(context, OrderDetailsActivity.class);
        starter.putExtra("orderId", orderId);
        context.startActivity(starter);
    }

    @Override
    public void getOrderDetailsSuccess(List<OrderListBean.ResultdataBean> resultdataBeans) {

        OrderListBean.ResultdataBean resultdataBean = resultdataBeans.get(0);
        orderBean = resultdataBean;
        mTvAddressName.setText(String.format("Receiver:%s", resultdataBean.getOrder().getAddress_Name()));
        mTvAddressTel.setText(resultdataBean.getOrder().getAddress_Mobile());
        mTvAddressDesc.setText(resultdataBean.getOrder().getAddress_Detail());
        mTvOrderNumber.setText(String.format("Order number:%s", resultdataBean.getOrder().getOrder_No()));
        mTvOrderTime.setText(String.format("Order time:%s", resultdataBean.getOrder().getOrder_CreateTime()));
        mTvOrderType.setText(String.format("Mode of payment:%s", resultdataBean.getOrder().getOrder_PayType()));
        mTvOrderFreight.setText(String.format("Freight:%s", resultdataBean.getOrder().getORder_Freight()));
        mTvOrderTotalPrice.setText(String.format("Total Purchases:%s", resultdataBean.getOrder().getOrder_Money()));
        mTvOrderPayPrice.setText(String.format("Has to pay the amount:%s", resultdataBean.getOrder().getOrder_Money()));
        mTvSkype.setText(String.format("skype us:%s", resultdataBean.getOrder().getOrder_Seed()));


        switch (resultdataBean.getOrder().getOrder_State()) {
            case 0:
                ll_bottom.setVisibility(View.VISIBLE);
                mTvCancelOrder.setText("Cancel");
                mTvPayOrder.setText("Pay now");
                break;
            case 1:
                mTvCancelOrder.setVisibility(View.GONE);
                mTvPayOrder.setVisibility(View.GONE);
                ll_bottom.setVisibility(View.GONE);
                break;
            case 2:
                mTvCancelOrder.setVisibility(View.GONE);
                mTvPayOrder.setVisibility(View.GONE);
                ll_bottom.setVisibility(View.GONE);
                break;
            case 3:
                ll_bottom.setVisibility(View.VISIBLE);
                mTvCancelOrder.setVisibility(View.GONE);
                mTvPayOrder.setText("evaluated");

                break;
            case 4:
                mTvCancelOrder.setVisibility(View.GONE);
                mTvPayOrder.setVisibility(View.GONE);
                ll_bottom.setVisibility(View.GONE);
                break;
            case 5:
                mTvCancelOrder.setVisibility(View.GONE);
                mTvPayOrder.setVisibility(View.GONE);
                ll_bottom.setVisibility(View.GONE);
                break;
            case 7:
                ll_bottom.setVisibility(View.VISIBLE);
                mTvCancelOrder.setVisibility(View.GONE);
                mTvPayOrder.setText("Confirm receipt");
                break;
            default:
                mTvCancelOrder.setVisibility(View.GONE);
                mTvPayOrder.setVisibility(View.GONE);
                ll_bottom.setVisibility(View.GONE);
                break;
        }


        mMOrderListAdapter.setDataArray(resultdataBean.getOrderItem());
        mMOrderListAdapter.notifyDataSetChanged();
    }


    @OnClick({R.id.tv_order_number_copy, R.id.tv_skype, R.id.tv_cancel_order, R.id.tv_pay_order})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_order_number_copy:
                // 将文本内容放到系统剪贴板里。
                if (mTvOrderNumber != null) {
                    ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    String orderNumber = mTvOrderNumber.getText().toString().trim();
                    String copyOrderNumber = orderNumber.split(":")[1];
                    cm.setText(copyOrderNumber);
                    ToastUtils.showToast("复制成功" + copyOrderNumber);
                }

                break;
            case R.id.tv_skype:
                Intent intent = new Intent();

                //设置要传递的内容。
//                intent.setData(Uri.parse(guanzhu_URL));

                intent.setPackage("com.tencent.mm");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                break;
            case R.id.tv_cancel_order:
                if (orderBean.getOrder().getOrder_State() == 0) {
                    receipOrCancelOrder(view, "Are you sure you want to Cancel the order?", true);
                }
                break;
            case R.id.tv_pay_order:
                switch (orderBean.getOrder().getOrder_State()) {
                    case 0:
                        AddressBean.ResultdataBean addressBean = new AddressBean.ResultdataBean();
                        addressBean.setAddress_Detail(orderBean.getOrder().getAddress_Detail());
                        addressBean.setAddress_Mobile(orderBean.getOrder().getAddress_Mobile());
                        addressBean.setAddress_Name(orderBean.getOrder().getAddress_Name());
                        ConfirmPaymentActivity.start(OrderDetailsActivity.this, orderBean.getOrder().getOrder_No(), String.valueOf(orderBean.getOrder().getOrder_Money()), JSON.toJSONString(addressBean));
                        break;
                    case 3:
                        OderCommentListActivity.start(view.getContext(), (ArrayList<OrderListBean.ResultdataBean.OrderItemBean>) orderBean.getOrderItem());
                        break;
                    case 7:
                        receipOrCancelOrder(view, "Do you want to confirm receipt?", false);
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    private void receipOrCancelOrder(View view, String hinText, final boolean isCancel) {
        new AlertDialog(view.getContext()).builder().setTitle("Warning!")
                .setMsg(hinText)
                .setCancelable(true)
                .setPositiveButton("agree", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (isCancel) {
                            ToastUtils.showToast("取消成功");
                        } else {
                            ToastUtils.showToast("确认成功");
                        }
                    }
                })
                .setNegativeButton("cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                }).show();
    }


}
