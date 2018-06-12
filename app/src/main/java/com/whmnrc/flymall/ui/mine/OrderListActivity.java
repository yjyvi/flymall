package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.TableViewPagerAdapter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.ui.LazyLoadFragment;
import com.whmnrc.flymall.utils.evntBusBean.OrderListEvent;
import com.whmnrc.flymall.views.MyViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author yjyvi
 * @data 2018/5/21.
 */

public class OrderListActivity extends BaseActivity {

    /**
     * 订单状态：0：所有 1：待支付；2：待发货；3：待收货；4：超时未付款关闭；5：完成
     */


    List<LazyLoadFragment> fragments = new ArrayList<>();
    String[] titles = new String[]{"UNPAID", "UNSHIPPED", "RECEIPT", "ALL"};
    @BindView(R.id.mid_tab)
    MagicIndicator mMidTab;
    @BindView(R.id.vp_order)
    MyViewPager mVpOrder;
    public int mOrderState;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_order_list;
    }

    @Override
    protected void initViewData() {
        EventBus.getDefault().register(this);
        mOrderState = getIntent().getIntExtra("orderState", 0);
        setTitle("My Order");
        initFragment();
        initTab();
    }


    private void initFragment() {
        for (int i = 0; i < titles.length; i++) {
            switch (i) {
                case 0:
                    fragments.add(OrderFragment.newInstance(1));
                    break;
                case 1:
                    fragments.add(OrderFragment.newInstance(2));
                    break;
                case 2:
                    fragments.add(OrderFragment.newInstance(3));
                    break;
                case 3:
                    fragments.add(OrderFragment.newInstance(0));
                    break;
                default:
                    break;
            }
        }
    }


    private void initTab() {

        mVpOrder.setAdapter(new TableViewPagerAdapter(getSupportFragmentManager(), fragments));
        mVpOrder.setOffscreenPageLimit(4);
        mVpOrder.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                changeTable(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return titles.length;
            }

            @Override
            public IPagerTitleView getTitleView(final Context context, final int index) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.BLACK);
                colorTransitionPagerTitleView.setSelectedColor(ContextCompat.getColor(context, R.color.black));
                colorTransitionPagerTitleView.setTextSize(10);
                colorTransitionPagerTitleView.setText(titles[index]);
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mVpOrder.setCurrentItem(index);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setLineHeight(3);
                indicator.setColors(ContextCompat.getColor(context, R.color.black));
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                return indicator;
            }
        });

        mMidTab.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mMidTab, mVpOrder);

        mVpOrder.setCurrentItem(mOrderState);

    }

    public static void start(Context context, int orderState) {
        Intent starter = new Intent(context, OrderListActivity.class);
        starter.putExtra("orderState", orderState);
        context.startActivity(starter);
    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    private void changeTable(int index) {
        switch (index) {
            case 0:
                EventBus.getDefault().post(new OrderListEvent().setEventType(OrderListEvent.UNPAID));
                break;
            case 1:
                EventBus.getDefault().post(new OrderListEvent().setEventType(OrderListEvent.UNSHIPPED));
                break;
            case 2:
                EventBus.getDefault().post(new OrderListEvent().setEventType(OrderListEvent.RECEIPT));
                break;
            case 3:
                EventBus.getDefault().post(new OrderListEvent().setEventType(OrderListEvent.ALL));
                break;
            default:
                break;
        }
    }

    @Subscribe
    public void orderListEvent(OrderListEvent orderListEvent) {

    }

}
