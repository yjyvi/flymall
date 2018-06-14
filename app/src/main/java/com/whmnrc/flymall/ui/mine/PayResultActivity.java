package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.ui.BaseActivity;

import butterknife.BindView;

/**
 * Created by yong hao zeng on 2018/1/11.
 */

public class PayResultActivity extends BaseActivity {

    public boolean mIsField;
    @BindView(R.id.iv_img)
    ImageView mIvImg;
    @BindView(R.id.tv_text)
    TextView mTvText;
    @BindView(R.id.tv_click)
    TextView mTvClick;
    private String mOrderId;
    private String[] orderIds;

    @Override
    public int setLayoutId() {
        return R.layout.activity_pay_result;
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        toActivity();
    }

    @Override
    public void initViewData() {

       setTitle("Payment results");
        mOrderId = getIntent().getStringExtra("orderId");
        if (!TextUtils.isEmpty(mOrderId)) {
            orderIds = mOrderId.split(",");
        }
        mIsField = getIntent().getBooleanExtra("isField", false);

        if (mIsField) {
            mIvImg.setImageResource(R.mipmap.icon_order_pay_field);
            mTvText.setText("Payment failed");
        }

        mTvClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toActivity();
            }
        });
    }

    private void toActivity() {
        if (orderIds != null && orderIds.length > 1) {
            OrderListActivity.start(this, mIsField ? 0 : 1);
        } else if (!TextUtils.isEmpty(mOrderId)) {
            OrderDetailsActivity.start(this, mOrderId);
        }
        finish();
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, PayResultActivity.class);
        context.startActivity(starter);
    }

    public static void start(Context context, String orderId) {
        Intent starter = new Intent(context, PayResultActivity.class);
        starter.putExtra("orderId", orderId);
        context.startActivity(starter);
    }

    public static void start(Context context, String orderId, boolean isField) {
        Intent starter = new Intent(context, PayResultActivity.class);
        starter.putExtra("orderId", orderId);
        starter.putExtra("isField", isField);
        context.startActivity(starter);
    }
}
