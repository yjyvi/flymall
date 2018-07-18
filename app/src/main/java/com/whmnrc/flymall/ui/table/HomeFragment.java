package com.whmnrc.flymall.ui.table;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.MyApplication;
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
import com.whmnrc.flymall.ui.home.ActivityGoodsListActivity;
import com.whmnrc.flymall.ui.home.GoodsDetailsActivity;
import com.whmnrc.flymall.ui.home.GoodsListActivity;
import com.whmnrc.flymall.ui.home.homebrands.HomeBrandsFragment;
import com.whmnrc.flymall.utils.EmptyListUtils;
import com.whmnrc.flymall.utils.SPUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.UIUtils;
import com.whmnrc.flymall.utils.evntBusBean.GoodsCommentEvent;
import com.whmnrc.flymall.views.LoadingDialog;
import com.whmnrc.flymall.views.MyVideoPlayGoods;
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
    @BindView(R.id.nsv_layout)
    NestedScrollView mNestedScrollView;

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
    private String mCurrencyCode;
    /**
     * 品牌的一页显示的最大数据
     */
    private int pageMax = 10;

    @Override
    protected int contentViewLayoutID() {
        return R.layout.fragment_home;
    }


    @Override
    protected void initViewData() {

        EventBus.getDefault().register(this);

        mLoadingDialog = new LoadingDialog(getActivity());
        mLoadingDialog.show();

        mRefresh.setOnRefreshLoadMoreListener(this);

//        requestNoTouch();
        initVideoList();
        initSaleList();

        showCahceData();

        mGetAllCurrencyPresenter = new GetAllCurrencyPresenter(this);
        mUpdateDefaultCurrencyPresenter = new UpdateDefaultCurrencyPresenter(this);
        mHomePageActivityGoodsPresenter = new HomePageActivityGoodsPresenter(this);

        mHomePageActivityGoodsPresenter.getHomePageActivityGoods();

        mTvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoodsListActivity.start(v.getContext(), "0");
            }
        });

        if (!SPUtils.getBoolean(MyApplication.applicationContext, CommonConstant.Common.FIRST_SETTING_CURRENCY)) {
            mGetAllCurrencyPresenter.getAllCurrency();
        }

        initData();

    }


    /**
     * 取消子类的滑动焦点
     */
    private void requestNoTouch() {
        mRvSaleList.setNestedScrollingEnabled(false);
        mRvVideoList.setNestedScrollingEnabled(false);

        mRvSaleList.setFocusableInTouchMode(false);
        mRvVideoList.setFocusableInTouchMode(false);
        mLlPoint.setFocusableInTouchMode(false);
        mVpBrands.setFocusableInTouchMode(false);

        mRvSaleList.requestFocus();
        mRvVideoList.requestFocus();
        mLlPoint.requestFocus();
        mVpBrands.requestFocus();
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
                HomeDataBean.ResultdataBean.VideosBean videosBean = mAdapter.getDatas().get(position);
                String videoUrl;
                if (!videosBean.getVideoUrl().startsWith("http")) {
                    videoUrl = getResources().getString(R.string.service_host_image) + videosBean.getVideoUrl();
                } else {
                    videoUrl = videosBean.getVideoUrl();
                }
                MyVideoPlayGoods.start(view.getContext(), videoUrl, videosBean.getDescription(), String.valueOf(videosBean.getProductId()));
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

    /**
     * 请求轮播图、视频、品牌数据
     */
    private void initData() {
        mHomePageBannerPresenter = new HomePageDataPresenter(this);
        mHomePageBannerPresenter.getHomePageBanner();


    }

    /**
     * 显示缓存数据
     */
    private void showCahceData() {

        String homeData1 = SPUtils.getString(MyApplication.applicationContext, CommonConstant.Common.HOME_CACHE_DATA1);
        if (!TextUtils.isEmpty(homeData1)) {
            initHomeData(JSON.parseObject(homeData1, HomeDataBean.class));
        }

        String homeData2 = SPUtils.getString(MyApplication.applicationContext, CommonConstant.Common.HOME_CACHE_DATA2);
        if (!TextUtils.isEmpty(homeData2)) {
            List<HomeActivityGoodsBean.ResultdataBean> resultdataBean = JSON.parseArray(homeData2, HomeActivityGoodsBean.ResultdataBean.class);
            initHomeActivityData(resultdataBean);
        }

        String homeData3 = SPUtils.getString(MyApplication.applicationContext, CommonConstant.Common.HOME_CACHE_DATA3);
        if (!TextUtils.isEmpty(homeData3)) {
            List<HomeSaleGoodsBean.ResultdataBean> resultdataBean = JSON.parseArray(homeData3, HomeSaleGoodsBean.ResultdataBean.class);
            initSaleGoodsList(resultdataBean);
        }

    }

    /**
     * 创建点
     */
    private void addPoint(int brandsPage) {
        mLlPoint.removeAllViews();
        for (int i = 0; i < brandsPage; i++) {
            View imageView = new View(getActivity());
            if (i == 0) {
                createView(imageView, getResources().getDimensionPixelOffset(R.dimen.dm_30), R.drawable.rect_home_brands_true);
            } else {
                createView(imageView, getResources().getDimensionPixelOffset(R.dimen.dm_8), R.drawable.rect_home_brands_false);

            }
            mLlPoint.addView(imageView);
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
        }

        lastView = childAt;
        createView(childAt, getResources().getDimensionPixelOffset(R.dimen.dm_30), R.drawable.rect_home_brands_true);
    }

    /**
     * 创建品牌页面点
     *
     * @param childAt
     * @param width
     * @param resid
     */
    private void createView(View childAt, int width, int resid) {
        childAt.setBackgroundResource(resid);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                width, getResources().getDimensionPixelOffset(R.dimen.dm_4)
        );
        layoutParams.setMargins(0, 0, 10, 0);
        childAt.setLayoutParams(layoutParams);
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
        SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.HOME_CACHE_DATA1, JSON.toJSONString(homeDataBean));
        initHomeData(homeDataBean);
    }

    @Override
    public void laodHomeDataField() {

    }

    @Override
    public void loadActivityGoodsSuccess(final List<HomeActivityGoodsBean.ResultdataBean> resultdataBean) {
        SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.HOME_CACHE_DATA2, JSON.toJSONString(resultdataBean));
        initHomeActivityData(resultdataBean);
    }

    @Override
    public void loadHomeSaleGoodsSuccess(List<HomeSaleGoodsBean.ResultdataBean> resultdataBean) {
        SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.HOME_CACHE_DATA3, JSON.toJSONString(resultdataBean));
        initSaleGoodsList(resultdataBean);
    }

    @Override
    public void laodHomeSaleField() {

    }


    /**
     * 显示首页轮播图、视频、品眚数据
     *
     * @param homeDataBean
     */
    private void initHomeData(HomeDataBean homeDataBean) {
        if (mAdapter.getDatas() != null) {
            mAdapter.getDatas().clear();
        }

        if (mAdapter.getDatas() != null) {
            mAdapter.getDatas().clear();
        }
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
                        String url = resultdataBean.getUrl();
                        if (!TextUtils.isEmpty(url)) {
                            String[] content = url.split("=");
                            if (content.length >= 3) {
                                String goodsId = content[2];
                                GoodsDetailsActivity.start(view.getContext(), goodsId);
                            }
                        }

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
        int brandsPage;
        //获得余数
        int sizeResult = size % pageMax;
        if (sizeResult == 0) {
            brandsPage = size / pageMax;
        } else {
            brandsPage = size / pageMax + 1;
        }


        ArrayList<ArrayList<HomeDataBean.ResultdataBean.BrandsBean>> onPageVideoLists = new ArrayList<>();
        ArrayList<HomeDataBean.ResultdataBean.BrandsBean> onPageVideoList;
        for (int i = 0; i < brandsPage; i++) {
            onPageVideoList = new ArrayList<>();
            int maxNum = 0;
            int initI = i * pageMax;
            if (i + 1 == brandsPage) {
                maxNum += initI + pageMax;
            } else {
                maxNum = initI + pageMax;
            }
            for (int j = initI; j < maxNum; j++) {
                if (brands.size() > j) {
                    onPageVideoList.add(brands.get(j));
                }
            }
            onPageVideoLists.add(onPageVideoList);
        }

        mFragments.clear();
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


    /**
     * 显示首页活动数据
     *
     * @param resultdataBean
     */
    private void initHomeActivityData(final List<HomeActivityGoodsBean.ResultdataBean> resultdataBean) {
        if (resultdataBean == null) {
            return;
        }
        if (resultdataBean.size() > 0) {
            GlideUtils.LoadImage(getActivity(), resultdataBean.get(0).getImageUrl(), mIvActivity1);
            mIvActivity1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityGoodsListActivity.start(v.getContext(), String.valueOf(resultdataBean.get(0).getId()));
                }
            });
        }
        if (resultdataBean.size() > 1) {
            GlideUtils.LoadImage(getActivity(), resultdataBean.get(1).getImageUrl(), mIvActivity2);
            mIvActivity2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityGoodsListActivity.start(v.getContext(), String.valueOf(resultdataBean.get(1).getId()));
                }
            });
        }

        if (resultdataBean.size() > 2) {
            GlideUtils.LoadImage(getActivity(), resultdataBean.get(2).getImageUrl(), mIvActivity3);
            mIvActivity3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityGoodsListActivity.start(v.getContext(), String.valueOf(resultdataBean.get(2).getId()));
                }
            });
        }

        if (resultdataBean.size() > 3) {
            GlideUtils.LoadImage(getActivity(), resultdataBean.get(3).getImageUrl(), mIvActivity4);
            mIvActivity4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityGoodsListActivity.start(v.getContext(), String.valueOf(resultdataBean.get(3).getId()));
                }
            });
        }

        if (resultdataBean.size() > 4) {
            GlideUtils.LoadImage(getActivity(), resultdataBean.get(4).getImageUrl(), mIvActivity5);
            mIvActivity5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ActivityGoodsListActivity.start(v.getContext(), String.valueOf(resultdataBean.get(4).getId()));
                }
            });
        }
    }


    /**
     * 显示底部商品列表
     *
     * @param resultdataBean
     */
    private void initSaleGoodsList(List<HomeSaleGoodsBean.ResultdataBean> resultdataBean) {
        if (mGoodListAdapter.getDatas() != null) {
            mGoodListAdapter.getDatas().clear();
        }
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

        mLoadingDialog.dismiss();
    }

    @Override
    public void loadSuccess(List<AllCurrencyBean.ResultdataBean.ModelsBean> resultdataBean) {
        mPopCurrenty = new PopCurrency(getActivity(), resultdataBean);
        mPopCurrenty.show();
        mPopCurrenty.setListener(new PopCurrency.CurrencyClickListener() {
            @Override
            public void onClick(String currencyId, double currencyPrice, String code) {

                if (TextUtils.isEmpty(currencyId)) {
                    ToastUtils.showToast("Please Select Currency");
                    return;
                }
                mCurrencyPrice = currencyPrice;
                mCurrencyCode = code;
                mPopCurrenty.dismiss();
                SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.CURRENT_CURRENCY, mCurrencyPrice);
                SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.CURRENT_CURRENCY_CODE, mCurrencyCode);
                SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.FIRST_SETTING_CURRENCY, true);
                EventBus.getDefault().post(new GoodsCommentEvent().setEventType(GoodsCommentEvent.CHANGE_CURRENCY));
            }

            @Override
            public void dissmisPop() {
                SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.FIRST_SETTING_CURRENCY, true);
            }
        });
    }


    @Override
    public void updateSuccess(String msg) {
        SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.CURRENT_CURRENCY, mCurrencyPrice);
        SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.CURRENT_CURRENCY_CODE, mCurrencyCode);
        EventBus.getDefault().post(new GoodsCommentEvent().setEventType(GoodsCommentEvent.CHANGE_CURRENCY));
    }


    /**
     * 修改货币显示
     *
     * @param goodsCommentEvent
     */
    @Subscribe
    public void changePrice(GoodsCommentEvent goodsCommentEvent) {
        if (goodsCommentEvent.getEventType() == GoodsCommentEvent.CHANGE_CURRENCY) {
            mGoodListAdapter.notifyDataSetChanged();
        }
    }
}
