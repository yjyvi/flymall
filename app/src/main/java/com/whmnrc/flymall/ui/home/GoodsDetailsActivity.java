package com.whmnrc.flymall.ui.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.TableViewPagerAdapter;
import com.whmnrc.flymall.beans.ConfirmBean;
import com.whmnrc.flymall.beans.GoodsDetailsBean;
import com.whmnrc.flymall.beans.GoodsSpecificationsBean;
import com.whmnrc.flymall.eventbus.HomeTableChangeEvent;
import com.whmnrc.flymall.presener.AddOrDelCollectionGoodsPresenter;
import com.whmnrc.flymall.presener.AddShoppingCartPresenter;
import com.whmnrc.flymall.presener.GoodsDetailsPresenter;
import com.whmnrc.flymall.presener.GoodsSpecificationsPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.ui.LazyLoadFragment;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.ui.home.gooddetailsfragment.GoodsDetailsFragment;
import com.whmnrc.flymall.ui.home.gooddetailsfragment.GoodsEvaluationFragment;
import com.whmnrc.flymall.ui.mine.ConfirmOrderActivity;
import com.whmnrc.flymall.ui.shop.ShoppingCartActivity;
import com.whmnrc.flymall.utils.PlaceholderUtils;
import com.whmnrc.flymall.utils.evntBusBean.SHopCartEvent;
import com.whmnrc.flymall.views.GoodSpecificationsPop;
import com.whmnrc.flymall.views.LoadingDialog;
import com.whmnrc.flymall.views.MyScrollView;
import com.whmnrc.flymall.views.MyViewPager;
import com.whmnrc.flymall.views.PullUpToLoadMore;
import com.whmnrc.flymall.views.RatingBarView;
import com.youth.banner.Banner;

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
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class GoodsDetailsActivity extends BaseActivity implements GoodsDetailsPresenter.GoodsDetailsListener,  AddOrDelCollectionGoodsPresenter.AddOrDelCollectionGoodsListener, GoodSpecificationsPop.PopListener, AddShoppingCartPresenter.AddShoppingCartListListener {


    @BindView(R.id.ptlm_specialist_tour_detail)
    PullUpToLoadMore mPtlmSpecialistTourDetail;


    @BindView(R.id.mid_tab)
    MagicIndicator mMidTab;
    @BindView(R.id.ve_goods_details_evaluation)
    MyViewPager mVpOrder;
    @BindView(R.id.rb_star)
    RatingBarView mRbStar;

    List<LazyLoadFragment> fragments = new ArrayList<>();
    String[] titles = new String[]{"Details", "Evaluation"};
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tv_price)
    TextView mTvPrice;
    @BindView(R.id.tv_old_price)
    TextView mTvOldPrice;
    @BindView(R.id.tv_comment_num)
    TextView mTvCommentNum;
    @BindView(R.id.tv_current_page)
    TextView mTvCurrentPage;
    @BindView(R.id.tv_total_page)
    TextView mTvTotalPage;
    @BindView(R.id.ll_banner_position)
    LinearLayout mLlBannerPosition;
    @BindView(R.id.tv_sold)
    TextView mTvSold;
    @BindView(R.id.mscl_1)
    MyScrollView mMscl1;
    @BindView(R.id.mscl_2)
    MyScrollView mMscl2;
    @BindView(R.id.iv_like)
    ImageView mIvLike;
    @BindView(R.id.banner)
    Banner mBanner;


    private int type;
    public String mGoodsId;
    public GoodsDetailsPresenter mGoodsDetailsPresenter;
    private List<GoodsSpecificationsBean.ResultdataBean> mGoodsSpecificationBean;
    public GoodsSpecificationsPresenter mGoodsSpecificationsPresenter;
    private String mGoodsImg;
    public GoodSpecificationsPop mGoodSpecificationsPop;
    private LoadingDialog mLoadingDialog;
    public AddOrDelCollectionGoodsPresenter mAddOrDelCollectionGoodsPresenter;
    private GoodsDetailsBean.ResultdataBean mGoodsBean;
    private boolean isAddCart;
    public AddShoppingCartPresenter mAddShoppingCartPresenter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_goods_details;
    }

    @Override
    protected void initViewData() {

        EventBus.getDefault().register(this);
        mLoadingDialog = new LoadingDialog(this);
        mLoadingDialog.show();
        mGoodsDetailsPresenter = new GoodsDetailsPresenter(this);
        mAddOrDelCollectionGoodsPresenter = new AddOrDelCollectionGoodsPresenter(this);

        mAddShoppingCartPresenter = new AddShoppingCartPresenter(this);
        mGoodsId = getIntent().getStringExtra("goodsId");

        mAddOrDelCollectionGoodsPresenter.addCollection(mGoodsId, 2);

        mGoodsDetailsPresenter.getGoodsDetial(mGoodsId);


        mRbStar.setClickable(false);


    }

//    private void initBanner(List<GoodsDetailsBean.ResultdataBean.ImgBean> img) {
//        if (img == null || img.size() <= 0) {
//            mLlBannerPosition.setVisibility(View.GONE);
//            return;
//        }
//        mLlBannerPosition.setVisibility(View.VISIBLE);
//        mTvCurrentPage.setText("1");
//        mTvTotalPage.setText(String.format("/%s", img.size()));
//        mBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                mTvCurrentPage.setText(String.valueOf(position + 1));
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        mBanner.isAutoPlay(false).setImages(img).setImageLoader(new ImageLoader() {
//            @Override
//            public void displayImage(Context context, Object path, ImageView imageView) {
//
//                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//                GoodsDetailsBean.ResultdataBean.ImgBean imgBeans = (GoodsDetailsBean.ResultdataBean.ImgBean) path;
//                UIUtils.loadCommentImg(imageView, imgBeans.getImg_Path());
//
//                //轮播图跳转
//                imageView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//                    }
//                });
//            }
//        }).start();
//    }


    private void initTab(String goodsContent, GoodsDetailsBean.ResultdataBean evaluate, String goodsId) {
        fragments.add(GoodsDetailsFragment.newInstance(goodsContent, JSON.toJSONString(evaluate)));
        fragments.add(GoodsEvaluationFragment.newInstance(goodsId));
        mVpOrder.setNoScroll(true);
        mVpOrder.setAdapter(new TableViewPagerAdapter(getSupportFragmentManager(), fragments));

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
                colorTransitionPagerTitleView.setTextSize(18);
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
                indicator.setLineHeight(4);
                indicator.setColors(ContextCompat.getColor(context, R.color.black));
                indicator.setMode(LinePagerIndicator.MODE_WRAP_CONTENT);
                return indicator;
            }
        });

        mMidTab.setNavigator(commonNavigator);
        ViewPagerHelper.bind(mMidTab, mVpOrder);

        mVpOrder.setCurrentItem(0);


    }


    public static void start(Context context, String goodsId) {
        Intent starter = new Intent(context, GoodsDetailsActivity.class);
        starter.putExtra("goodsId", goodsId);
        context.startActivity(starter);
    }


    @OnClick({R.id.iv_like,
            R.id.iv_shopping_cart,
            R.id.tv_add_cart, R.id.tv_buy, R.id.iv_back, R.id.iv_back2
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_like:
                if (!UserManager.getIsLogin(this)) {
                    return;
                }
                //添加收藏
                if (!mIvLike.isSelected()) {
                    isCollection(true, true);
                } else {
                    isCollection(false, true);
                }
                break;
            case R.id.iv_shopping_cart:
                if (!UserManager.getIsLogin(this)) {
                    return;
                }
                ShoppingCartActivity.start(view.getContext());
                break;
            case R.id.tv_add_cart:

                isAddCart = true;
                if (mGoodSpecificationsPop != null) {
                    mGoodSpecificationsPop.show();
                }
                break;
            case R.id.tv_buy:

                isAddCart = false;
                if (mGoodSpecificationsPop != null) {
                    mGoodSpecificationsPop.show();
                }
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_back2:
                mPtlmSpecialistTourDetail.scrollToTop();
                if (mVpOrder != null) {
                    mVpOrder.setCurrentItem(0);
                }
                break;

            default:
                break;
        }
    }

    private void isCollection(boolean isSelect, boolean isRequestApi) {
        if (isSelect) {
            mIvLike.setSelected(true);
            mIvLike.setImageResource(R.mipmap.icon_like_true);
            if (isRequestApi) {
                mAddOrDelCollectionGoodsPresenter.addCollection(mGoodsId, 1);
            }
        } else {
            mIvLike.setImageResource(R.mipmap.icon_like_false);
            mIvLike.setSelected(false);
            if (isRequestApi) {
                mAddOrDelCollectionGoodsPresenter.delCollection(mGoodsId);
            }
        }
    }


    @Override
    public void getGoodsDetailsSuccess(GoodsDetailsBean.ResultdataBean goodsDetailsBean) {
        mLoadingDialog.dismiss();
        mGoodsBean = goodsDetailsBean;

        if (goodsDetailsBean != null) {
            GoodsDetailsBean.ResultdataBean.ProductBean product = goodsDetailsBean.getProduct();
            mGoodsImg = product.getImagePath();
            mTvTitle.setFocusableInTouchMode(true);
            mTvTitle.setText(product.getProductName());
            mTvPrice.setText(PlaceholderUtils.pricePlaceholder(product.getMinSalePrice()));
            mTvOldPrice.setText(PlaceholderUtils.pricePlaceholder(product.getMarketPrice()));
            mTvOldPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            mRbStar.setStar(product.getAuditStatus(), true);
            mTvCommentNum.setText(String.valueOf(product.getSaleCounts()));
            mTvSold.setText(String.format("Sold：%s", product.getSaleCounts()));
//            initBanner(goodsDetailsBean.getImg());

            //是否收藏
//            if (TextUtils.equals(goodsDetailsBean.getCollection(), "1")) {
//                isCollection(true, false);
//            } else {
//                isCollection(false, false);
//            }

            initTab(goodsDetailsBean.getProductDescription(), goodsDetailsBean, String.valueOf(goodsDetailsBean.getProduct().getId()));

            mGoodSpecificationsPop = new GoodSpecificationsPop(this, goodsDetailsBean, mGoodsImg);
            mGoodSpecificationsPop.setPopListener(this);
        }
    }

    @Override
    public void addCollectionSuccess() {

    }

    @Override
    public void delCollectionSuccess() {

    }



    @Override
    public void onEntryClick(int oneId, int twoId, int number, String priceId) {
        if (!UserManager.getIsLogin(this)) {
            return;
        }
        if (isAddCart) {
            mAddShoppingCartPresenter.addShoppingCartList(mGoodsId, priceId, String.valueOf(number));
        } else {
            ArrayList<ConfirmBean> confirmBeans = new ArrayList<>();
            ConfirmBean confirmBean = new ConfirmBean();
            confirmBean.setGoods_Describe(mGoodsBean.getProduct().getShortDescription());
            confirmBean.setGoods_ImaPath(mGoodsImg);
            confirmBean.setGoods_Name(mGoodsBean.getProduct().getProductName());
            confirmBean.setGoodsNUm(number);
            if (mGoodsSpecificationBean != null) {
//                confirmBean.setGoods_spec(mGoodsSpecificationBean.get(oneId).getGoodsPrice_AttrName() + mGoodsSpecificationBean.get(oneId).getContent().get(twoId).getGoodsPrice_Attribute());
            }
            confirmBean.setPriceIds(priceId);
            confirmBean.setGoods_SourcePrice(mGoodsBean.getProduct().getMarketPrice());
            confirmBean.setGoodsPrice_Price(mGoodsBean.getProduct().getMinSalePrice());
            confirmBeans.add(confirmBean);

            ConfirmOrderActivity.start(this, confirmBeans);

            if (mGoodSpecificationsPop != null && mGoodSpecificationsPop.isShow()) {
                mGoodSpecificationsPop.dissmiss();
            }
        }
    }

    @Override
    public void addCartSuccess() {
        EventBus.getDefault().post(new SHopCartEvent().setEventType(SHopCartEvent.ADD_SHOPPING_CART_SUCCESS));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void shoppingCartEvent(SHopCartEvent sHopCartEvent) {

    }

    @Subscribe
    public void tabChangeEvent(HomeTableChangeEvent homeTableChangeEvent) {
        if (homeTableChangeEvent.getEventType() == HomeTableChangeEvent.GO_TO_HOME) {
            finish();
        }
    }
}
