package com.whmnrc.flymall.ui.table;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.HomeHeaderGoodsListAdapter;
import com.whmnrc.flymall.adapter.HomeVideoGoodsListAdapter;
import com.whmnrc.flymall.adapter.TableViewPagerAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.MultiItemTypeAdapter;
import com.whmnrc.flymall.beans.AllCurrencyBean;
import com.whmnrc.flymall.beans.HomeActivityGoodsBean;
import com.whmnrc.flymall.beans.HomeDataBean;
import com.whmnrc.flymall.beans.HomeSaleGoodsBean;
import com.whmnrc.flymall.eventbus.HomeTableChangeEvent;
import com.whmnrc.flymall.presener.GetAllCurrencyPresenter;
import com.whmnrc.flymall.presener.HomePageActivityGoodsPresenter;
import com.whmnrc.flymall.presener.HomePageDataPresenter;
import com.whmnrc.flymall.presener.HomePageSaleGoodsPresenter;
import com.whmnrc.flymall.presener.UpdateDefaultCurrencyPresenter;
import com.whmnrc.flymall.ui.LazyLoadFragment;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.ui.home.GoodsDetailsActivity;
import com.whmnrc.flymall.ui.home.GoodsListActivity;
import com.whmnrc.flymall.ui.home.homebrands.HomeBrandsFragment;
import com.whmnrc.flymall.ui.home.ActivityGoodsListActivity;
import com.whmnrc.flymall.utils.EmptyListUtils;
import com.whmnrc.flymall.utils.SPUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.UIUtils;
import com.whmnrc.flymall.views.LoadingDialog;
import com.whmnrc.flymall.views.PopCurrency;
import com.whmnrc.mylibrary.utils.GlideUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @date 2018/1/30
 * 首页
 */

public class HomeFragment extends LazyLoadFragment implements OnRefreshLoadMoreListener, HomePageDataPresenter.HomePageBannerListener, HomePageActivityGoodsPresenter.HomeActivityGoodsListener, HomePageSaleGoodsPresenter.HomeSaleGoodsListener, GetAllCurrencyPresenter.GetAllCurrencyListener, UpdateDefaultCurrencyPresenter.UpdateDefaultCurrencyListener {

    @BindView(R.id.rv_sale_list)
    RecyclerView mRvSaleList;
    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;
    @BindView(R.id.header_layout)
    LinearLayout headerLayout;
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.rv_video_list)
    RecyclerView mRvVideoList;

    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;
    @BindView(R.id.tv_search)
    TextView mTvSearch;

    @BindView(R.id.vp_brands)
    ViewPager mVpBrands;

    @BindView(R.id.ll_point)
    LinearLayout mLlPoint;
    @BindView(R.id.ll_header)
    LinearLayout mLlHeader;
    @BindView(R.id.iv_activity_1)
    ImageView mIvActivity1;
    @BindView(R.id.iv_activity_4)
    ImageView mIvActivity4;
    @BindView(R.id.iv_activity_2)
    ImageView mIvActivity2;
    @BindView(R.id.iv_activity_3)
    ImageView mIvActivity3;
    @BindView(R.id.iv_activity_5)
    ImageView mIvActivity5;

    private HomeHeaderGoodsListAdapter mGoodListAdapter;
    private HomeVideoGoodsListAdapter mAdapter;
    public GetAllCurrencyPresenter mGetAllCurrencyPresenter;
    private UpdateDefaultCurrencyPresenter mUpdateDefaultCurrencyPresenter;
    public PopCurrency mPopCurrenty;
    private double mCurrencyPrice;

    private List<LazyLoadFragment> mFragments = new ArrayList<>();
    private int page = 1;
    private int rows = 10;
    public HomePageDataPresenter mHomePageBannerPresenter;
    public HomePageActivityGoodsPresenter mHomePageActivityGoodsPresenter;
    public HomePageSaleGoodsPresenter mHomePageSaleGoodsPresenter;
    private LoadingDialog mLoadingDialog;

    @Override
    protected int contentViewLayoutID() {
        return R.layout.fragment_home;
    }


    @Override
    protected void initViewData() {

        mLoadingDialog = new LoadingDialog(getActivity());
        mLoadingDialog.show();

        EventBus.getDefault().register(this);

        showEmpty();

        mRefresh.setOnRefreshLoadMoreListener(this);

        mRvSaleList.setNestedScrollingEnabled(false);
        mRvVideoList.setNestedScrollingEnabled(false);


        mRvSaleList.setFocusableInTouchMode(false);
        mRvVideoList.setFocusableInTouchMode(false);
        mVpBrands.setFocusableInTouchMode(false);
        mBanner.setFocusableInTouchMode(false);

        mRvSaleList.requestFocus();
        mRvVideoList.requestFocus();
        mVpBrands.requestFocus();
        mBanner.requestFocus();


        initVideoList();
        initSaleList();

        mGetAllCurrencyPresenter = new GetAllCurrencyPresenter(this);
        mUpdateDefaultCurrencyPresenter = new UpdateDefaultCurrencyPresenter(this);
        mHomePageActivityGoodsPresenter = new HomePageActivityGoodsPresenter(this);
        mHomePageActivityGoodsPresenter.getHomePageActivityGoods();
        mTvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsListActivity.start(v.getContext(), "");
            }
        });


        if (SPUtils.getBoolean(getActivity(), CommonConstant.Common.FIRST_LAUNCHER)) {
            mGetAllCurrencyPresenter.getAllCurrency();
        }

        initData();
    }


    /**
     * VideoList
     */
    private void initVideoList() {
        mRvVideoList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        mRvVideoList.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.right = getResources().getDimensionPixelOffset(R.dimen.dm_9);

            }
        });
        mAdapter = new HomeVideoGoodsListAdapter(mRvVideoList.getContext(), R.layout.item_home_video);

        mAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                GoodsDetailsActivity.start(view.getContext(), String.valueOf(mAdapter.getDatas().get(position).getId()));
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });


    }


    /**
     * SaleList
     */
    private void initSaleList() {
        mHomePageSaleGoodsPresenter = new HomePageSaleGoodsPresenter(this);
        mHomePageSaleGoodsPresenter.getHomePageSaleGoods(page, rows);
        mRvSaleList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mGoodListAdapter = new HomeHeaderGoodsListAdapter(mRvSaleList.getContext(), R.layout.item_home_good_list_header);
        mRvSaleList.setAdapter(mGoodListAdapter);


    }

    private void initData() {
        mHomePageBannerPresenter = new HomePageDataPresenter(this);
        mHomePageBannerPresenter.getHomePageBanner();

    }

    /**
     * 创建点
     */

    private void addPoint(int brandsPage) {
        mLlPoint.removeAllViews();
        for (int i = 0; i < brandsPage; i++) {
            View imageView = new View(getActivity());
            createView(imageView, getResources().getDimensionPixelOffset(R.dimen.dm_8), R.drawable.rect_home_brands_false);
            mLlPoint.addView(imageView);
            scaleView(imageView, 30, 8);
        }
    }

    private View lastView;

    /**
     * 点布局样式更换
     *
     * @param position
     */
    private void pointChange(int position) {
        View childAt = mLlPoint.getChildAt(position);

        if (lastView != null) {
            createView(lastView, getResources().getDimensionPixelOffset(R.dimen.dm_8), R.drawable.rect_home_brands_false);
            scaleView(childAt, 30, 8);
        }

        lastView = childAt;
        createView(childAt, getResources().getDimensionPixelOffset(R.dimen.dm_30), R.drawable.rect_home_brands_true);
        scaleView(childAt, 8, 30);
    }

    private void createView(View childAt, int width, int resid) {


        childAt.setBackgroundResource(resid);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                width, getResources().getDimensionPixelOffset(R.dimen.dm_4)
        );
        layoutParams.setMargins(0, 0, 10, 0);
        childAt.setLayoutParams(layoutParams);
    }

    private void scaleView(View view, int star, int end) {
//        ScaleAnimation scaleAnimation = new ScaleAnimation(star, end, 0, 0);
//        scaleAnimation.setDuration(500);
//        view.setAnimation(scaleAnimation);
//        scaleAnimation.start();
//        scaleAnimation.setFillAfter(true);
    }


    /**
     * 初始化实例
     *
     * @return
     */
    public static HomeFragment newInstance() {
        Bundle bundle = new Bundle();
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }


    public void showEmpty() {
        if (mAdapter != null && mAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, mVsEmpty);
        } else {
            if (mVsEmpty != null) {
                mVsEmpty.setVisibility(View.GONE);
            }
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @OnClick(R.id.iv_cart)
    public void onClick() {
        EventBus.getDefault().post(new HomeTableChangeEvent().setEventType(HomeTableChangeEvent.CHANGE_TAB).setData(2));
    }

    @Subscribe
    public void tabChangeEvent(HomeTableChangeEvent homeTableChangeEvent) {

    }


    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        mRefresh.finishLoadMore(1000);
        page++;
        mHomePageSaleGoodsPresenter.getHomePageSaleGoods(page, rows);
        refreshLayout.finishLoadMore();
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        page = 1;
        mHomePageBannerPresenter.getHomePageBanner();
        mHomePageActivityGoodsPresenter.getHomePageActivityGoods();
        mHomePageSaleGoodsPresenter.getHomePageSaleGoods(page, rows);
        refreshLayout.finishRefresh();
    }

    @Override
    public void loadHomeData(HomeDataBean homeDataBean) {
        mLoadingDialog.dismiss();

        mBanner.setDelayTime(3000).setImages(homeDataBean.getResultdata().getBanners()).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                final HomeDataBean.ResultdataBean.BannersBean resultdataBean = (HomeDataBean.ResultdataBean.BannersBean) path;
                UIUtils.loadCommentImg(imageView, resultdataBean.getImageUrl());

                //轮播图跳转
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        GoodsListActivity.start(view.getContext(), String.valueOf(resultdataBean.getId()));
                    }
                });
            }


        }).start();

        List<HomeDataBean.ResultdataBean.VideosBean> videos = homeDataBean.getResultdata().getVideos();
        mAdapter.setDataArray(videos);
        mRvVideoList.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

        List<HomeDataBean.ResultdataBean.BrandsBean> brands = homeDataBean.getResultdata().getBrands();
        int size = brands.size();
        int brandsPage = (size / pageMax) + 1;

        ArrayList<ArrayList<HomeDataBean.ResultdataBean.BrandsBean>> onPageVideoLists = new ArrayList<>();
        ArrayList<HomeDataBean.ResultdataBean.BrandsBean> onPageVideoList;
        for (int i = 0; i < brandsPage; i++) {
            onPageVideoList = new ArrayList<>();
            int maxNum;
            if (i == brandsPage - 1){
                maxNum = i * pageMax + size % pageMax;
            }else {
                maxNum = i * pageMax + 10;
            }
            for (int j = i * pageMax; j < maxNum; j++) {
                onPageVideoList.add(brands.get(j));
            }
            onPageVideoLists.add(onPageVideoList);
        }

//        for (int i = 0; i < brandsPage; i++) {
//            onPageVideoList = new ArrayList();
//            for (int j = 0; j < brands.size(); j++) {
//                if (j <= pageMax * i) {
//                    onPageVideoList.add(brands.get(j));
//                }
//            }
//            onPageVideoLists.add(onPageVideoList);
//        }


        for (int i = 0; i < brandsPage; i++) {
            mFragments.add(HomeBrandsFragment.newInstance(onPageVideoLists.get(i)));
        }

        addPoint(brandsPage);


        mVpBrands.setAdapter(new TableViewPagerAdapter(getFragmentManager(), mFragments));
        mVpBrands.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pointChange(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        pointChange(0);
    }


    private int pageMax = 10;


    @Override
    public void loadActivityGoodsSuccess(final List<HomeActivityGoodsBean.ResultdataBean> resultdataBean) {
        GlideUtils.LoadImage(getActivity(), resultdataBean.get(0).getImageUrl(), mIvActivity1);
        GlideUtils.LoadImage(getActivity(), resultdataBean.get(1).getImageUrl(), mIvActivity2);
        GlideUtils.LoadImage(getActivity(), resultdataBean.get(2).getImageUrl(), mIvActivity3);
        GlideUtils.LoadImage(getActivity(), resultdataBean.get(3).getImageUrl(), mIvActivity4);
        GlideUtils.LoadImage(getActivity(), resultdataBean.get(4).getImageUrl(), mIvActivity5);


        mIvActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityGoodsListActivity.start(v.getContext(), String.valueOf(resultdataBean.get(0).getId()));
            }
        });
        mIvActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityGoodsListActivity.start(v.getContext(), String.valueOf(resultdataBean.get(1).getId()));
            }
        });
        mIvActivity3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityGoodsListActivity.start(v.getContext(), String.valueOf(resultdataBean.get(2).getId()));
            }
        });
        mIvActivity4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityGoodsListActivity.start(v.getContext(), String.valueOf(resultdataBean.get(3).getId()));
            }
        });
        mIvActivity5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityGoodsListActivity.start(v.getContext(), String.valueOf(resultdataBean.get(4).getId()));
            }
        });
    }

    @Override
    public void loadHomeSaleGoodsSuccess(List<HomeSaleGoodsBean.ResultdataBean> resultdataBean) {

        if (page == 1) {
            mGoodListAdapter.setDataArray(resultdataBean);
        } else {
            List<HomeSaleGoodsBean.ResultdataBean> datas = mGoodListAdapter.getDatas();
            if (datas != null) {
                datas.addAll(resultdataBean);
            }
            mGoodListAdapter.setDataArray(datas);
        }
        mGoodListAdapter.notifyDataSetChanged();
    }


    @Override
    public void loadSuccess(List<AllCurrencyBean.ResultdataBean> resultdataBean) {
        mPopCurrenty = new PopCurrency(getActivity(), resultdataBean);
        mPopCurrenty.show();
        mPopCurrenty.setListener(new PopCurrency.CurrencyClickListener() {
            @Override
            public void onClick(String currencyId, double currencyPrice) {

                if (TextUtils.isEmpty(currencyId)) {
                    ToastUtils.showToast("Please Select Currency");
                    return;
                }

                mUpdateDefaultCurrencyPresenter.updateDefaultCurrency(currencyId, UserManager.getUser().getId());
                mCurrencyPrice = currencyPrice;
                mPopCurrenty.dismiss();
            }
        });
    }


    @Override
    public void updateSuccess(String msg) {
        SPUtils.put(getActivity(), CommonConstant.Common.CURRENT_CURRENCY, mCurrencyPrice);
    }
}
