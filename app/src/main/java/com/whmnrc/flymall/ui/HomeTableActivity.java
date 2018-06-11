package com.whmnrc.flymall.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.eventbus.HomeTableChangeEvent;
import com.whmnrc.flymall.ui.table.ClassifyFragment;
import com.whmnrc.flymall.ui.table.HomeFragment;
import com.whmnrc.flymall.ui.table.MineFragment;
import com.whmnrc.flymall.ui.table.ShoppingCartFragment;
import com.whmnrc.flymall.utils.evntBusBean.SHopCartEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.OnClick;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;
import static android.content.Intent.FLAG_ACTIVITY_SINGLE_TOP;

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

    private int mIndex;


    public static void startHomeTableView(Context activity, int tab) {
        Intent intent = new Intent(activity, HomeTableActivity.class);
        intent.putExtra(CHANGE_HOME_TABLE, tab);
        intent.addFlags(FLAG_ACTIVITY_CLEAR_TOP | FLAG_ACTIVITY_SINGLE_TOP);
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
        setContentFragment(0);

    }

    @Override
    protected void initViewData() {
        EventBus.getDefault().register(this);
        selectedView(mTvTableHome);
        setContentFragment(0);
        UserManager.refresh();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_table_home;
    }


    /**
     * TABLE页面切换
     *
     * @param position
     */
    public void setContentFragment(int position) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Fragment currentFragment = getSupportFragmentManager().findFragmentByTag(String.valueOf(mIndex));

        if (currentFragment != null) {
            ft.hide(currentFragment);
        }
        Fragment foundFragment = getSupportFragmentManager().findFragmentByTag(String.valueOf(position));

        if (foundFragment == null) {
            switch (position) {
                case 0:
                    foundFragment = HomeFragment.newInstance();
                    break;
                case 1:
                    foundFragment = ClassifyFragment.newInstance();
                    break;
                case 2:
                    foundFragment = ShoppingCartFragment.newInstance(false);
                    break;
                case 3:
                    foundFragment = MineFragment.newInstance();
                    break;
                default:
                    foundFragment = HomeFragment.newInstance();
                    break;

            }
        }

        if (foundFragment.isAdded()) {
            ft.show(foundFragment);
        } else {
            ft.add(R.id.fragment_content, foundFragment, String.valueOf(position));
        }
        ft.commit();
        mIndex = position;


        mTvCartNum.setText(String.valueOf(UserManager.getUser().getShoppingCartNum()));
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
                    selectedView(mTvTableHome);
                    setContentFragment(0);
                    break;
                case 1:

                    break;
                case 2:
                    if (!UserManager.getIsLogin(this)) {
                        return;
                    }
                    selectedView(mTvTableShop);
                    setContentFragment(2);
                    break;
                case 3:

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
            mTvCartNum.setText(String.valueOf(data));
        }
    }


    @OnClick({R.id.tv_table_home, R.id.tv_table_brands, R.id.tv_table_shop, R.id.tv_table_mine})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_table_home:
                selectedView(mTvTableHome);
                setContentFragment(0);
                break;
            case R.id.tv_table_brands:
                selectedView(mTvTableBrands);
                setContentFragment(1);
                break;
            case R.id.tv_table_shop:
                if (!UserManager.getIsLogin(this)) {
                    return;
                }
                selectedView(mTvTableShop);
                setContentFragment(2);
                break;
            case R.id.tv_table_mine:
                if (!UserManager.getIsLogin(this)) {
                    return;
                }
                selectedView(mTvTableMine);
                setContentFragment(3);
                break;
            default:
                break;
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
