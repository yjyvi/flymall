package com.whmnrc.flymall.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.UserBean;
import com.whmnrc.flymall.eventbus.HomeTableChangeEvent;
import com.whmnrc.flymall.ui.table.ClassifyFragment;
import com.whmnrc.flymall.ui.table.HomeFragment;
import com.whmnrc.flymall.ui.table.MineFragment;
import com.whmnrc.flymall.ui.table.ShoppingCartFragment;
import com.whmnrc.flymall.utils.evntBusBean.SHopCartEvent;
import com.whmnrc.flymall.views.MyViewPager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @date 2017/10/22
 * 主切换页面
 */
public class HomeTableActivity extends BaseActivity {


    private static final String CHANGE_HOME_TABLE = "change_home_table";
    @BindView(R.id.tv_table_home)
    TextView mTvTableHome;
    @BindView(R.id.tv_table_brands)
    TextView mTvTableBrands;
    @BindView(R.id.tv_table_shop)
    TextView mTvTableShop;
    @BindView(R.id.tv_cart_num)
    TextView mTvCartNum;
    @BindView(R.id.tv_table_mine)
    TextView mTvTableMine;

    @BindView(R.id.tab_pager)
     MyViewPager mTabPager;

    private int mIndex;
    ArrayList<Fragment> mFragments = new ArrayList<>();

    public static void startHomeTableView(Context activity, int tab) {
        Intent intent = new Intent(activity, HomeTableActivity.class);
        intent.putExtra(CHANGE_HOME_TABLE, tab);
        activity.startActivity(intent);
    }

    @Override
    protected void back() {
        exit();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        selectedView(mTvTableHome);
        mTabPager.setCurrentItem(0);
        Log.e("HomeTableActivity", "onNewIntent");
    }

    @Override
    protected void initViewData() {
        mIndex = getIntent().getIntExtra(CHANGE_HOME_TABLE, 0);
        EventBus.getDefault().register(this);

        mFragments.add(HomeFragment.newInstance());
        mFragments.add(ClassifyFragment.newInstance());
        mFragments.add(ShoppingCartFragment.newInstance(false));
        mFragments.add(MineFragment.newInstance());

        UserManager.refresh();

        HelpsViewPagerAdapter helpsViewPagerAdapter = new HelpsViewPagerAdapter(getSupportFragmentManager(), mFragments);
        mTabPager.setNoScroll(true);
        mTabPager.setAdapter(helpsViewPagerAdapter);
        mTabPager.setOffscreenPageLimit(3);
        selectedView(mTvTableHome);
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_table_home;
    }

    public class HelpsViewPagerAdapter extends FragmentPagerAdapter {
        private ArrayList<Fragment> mFragments;

        public HelpsViewPagerAdapter(FragmentManager supportFragmentManager, ArrayList<Fragment> fragments) {
            super(supportFragmentManager);
            this.mFragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void tabChangeEvent(HomeTableChangeEvent homeTableChangeEvent) {
        if (homeTableChangeEvent.getEventType() == HomeTableChangeEvent.CHANGE_TAB) {
            int type = (int) homeTableChangeEvent.getData();
            switch (type) {
                case 0:
                    mTabPager.setCurrentItem(0);
                    selectedView(mTvTableHome);
                    break;
                case 2:
                    if (!UserManager.getIsLogin(this)) {
                        return;
                    }

                    mTabPager.setCurrentItem(2);
                    selectedView(mTvTableShop);
                    break;
                default:
                    break;
            }

        }

    }


    @Subscribe
    public void shoppingCartEvent(SHopCartEvent sHopCartEvent) {
        if (sHopCartEvent.getEventType() == SHopCartEvent.SHOPPING_CARR_NUM) {
            int data = (int) sHopCartEvent.getData();
            showCartNum(data);
        }
    }

    /**
     * 显示购物车数量
     *
     * @param data
     */
    private void showCartNum(int data) {
        if (data == 0) {
            mTvCartNum.setVisibility(View.GONE);
        } else {
            mTvCartNum.setVisibility(View.VISIBLE);
            mTvCartNum.setText(String.valueOf(data));
        }
    }


    @OnClick({R.id.tv_table_home, R.id.tv_table_brands, R.id.tv_table_shop, R.id.tv_table_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_table_home:
                Log.e("HomeTableActivity", "onClick");
                mTabPager.setCurrentItem(0);
                selectedView(mTvTableHome);
                break;
            case R.id.tv_table_brands:
                mTabPager.setCurrentItem(1);
                selectedView(mTvTableBrands);
                break;
            case R.id.tv_table_shop:
                if (!UserManager.getIsLogin(this)) {
                    return;
                }
                mTabPager.setCurrentItem(2);
                selectedView(mTvTableShop);
                break;
            case R.id.tv_table_mine:
                if (!UserManager.getIsLogin(this)) {
                    return;
                }
                mTabPager.setCurrentItem(3);
                selectedView(mTvTableMine);
                break;
            default:
                break;
        }

        if (UserManager.getUser() != null) {
            UserBean.ResultdataBean user = UserManager.getUser();
            showCartNum(user.getShoppingCartNum());
        }
    }


    private View lastView;

    private void selectedView(View view) {
        if (lastView != null) {
            lastView.setSelected(false);
        }
        if (!view.isSelected()) {
            view.setSelected(true);
            lastView = view;
        } else {
            view.setSelected(false);
        }

    }
}
