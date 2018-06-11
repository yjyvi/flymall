package com.whmnrc.flymall.ui.shop;

import android.content.Context;
import android.content.Intent;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.eventbus.HomeTableChangeEvent;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.ui.HomeTableActivity;
import com.whmnrc.flymall.ui.table.ShoppingCartFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * @author yjyvi
 * @data 2018/5/25.
 */

public class ShoppingCartActivity extends BaseActivity {

    @Override
    protected void initViewData() {
        EventBus.getDefault().register(this);
        ShoppingCartFragment shoppingCartFragment = ShoppingCartFragment.newInstance(true);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_content, shoppingCartFragment).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_shopping_cart;
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, ShoppingCartActivity.class);
        context.startActivity(starter);
    }

    @Subscribe
    public void tabChangeEvent(HomeTableChangeEvent homeTableChangeEvent) {
        if (homeTableChangeEvent.getEventType() == HomeTableChangeEvent.GO_TO_HOME) {
            finish();
            HomeTableActivity.startHomeTableView(this, 0);
        }
    }
}
