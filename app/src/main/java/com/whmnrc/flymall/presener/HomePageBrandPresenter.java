//package com.whmnrc.flymall.presener;
//
//import com.whmnrc.flymall.R;
//import com.whmnrc.flymall.beans.HomeBrandBean;
//import com.whmnrc.flymall.network.CommonCallBack;
//import com.whmnrc.flymall.network.OKHttpManager;
//import com.whmnrc.flymall.ui.PresenterBase;
//import com.whmnrc.flymall.utils.ToastUtils;
//
//import java.util.HashMap;
//import java.util.List;
//
///**
// * @author yjyvi
// * @data 2018/5/29.
// */
//
//public class HomePageBrandPresenter extends PresenterBase {
//
//    private HomePageBrandListener mHomePageBrandListener;
//
//    public HomePageBrandPresenter(HomePageBrandListener homePageBannerListener ) {
//        this.mHomePageBrandListener = homePageBannerListener;
//
//    }
//
//    public void getHomePageBrand(int page,int rows) {
//        HashMap<String, String> params = new HashMap<>(2);
//        params.put("Page", String.valueOf(page));
//        params.put("Rows", String.valueOf(rows));
//
//        OKHttpManager.get(getUrl(R.string.GetHomePageBrand), params, new CommonCallBack<HomeBrandBean>() {
//            @Override
//            protected void onSuccess(HomeBrandBean data) {
//                if (data.getType() == 1) {
//                    mHomePageBrandListener.loadBrandSuccess(data.getResultdata());
//                } else {
//                    ToastUtils.showToast(data.getMessage());
//                }
//            }
//        });
//    }
//
//
//    public interface HomePageBrandListener {
//        void loadBrandSuccess(List<HomeBrandBean.ResultdataBean> allVideoBean);
//    }
//
//}
