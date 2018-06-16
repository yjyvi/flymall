package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.HomeDataBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;

/**
 * @author yjyvi
 * @data 2018/5/29.
 */

public class HomePageDataPresenter extends PresenterBase {

    private HomePageBannerListener mHomePageDataListener;

    public HomePageDataPresenter(HomePageBannerListener homePageBannerListener ) {
        this.mHomePageDataListener = homePageBannerListener;

    }

    public void getHomePageBanner() {
        HashMap<String, String> params = new HashMap<>(1);
        OKHttpManager.get(getUrl(R.string.InitHomePage), params, new CommonCallBack<HomeDataBean>() {
            @Override
            protected void onSuccess(HomeDataBean data) {
                if (data.getType() == 1) {
                    mHomePageDataListener.loadHomeData(data);
                } else {
                    mHomePageDataListener.laodHomeDataField();
                    ToastUtils.showToast(data.getMessage());
                }
            }

            @Override
            protected void onError(String msg) {
                super.onError(msg);
                mHomePageDataListener.laodHomeDataField();
            }
        });


    }


    public interface HomePageBannerListener {
        void loadHomeData(HomeDataBean homeBannerBean);
        void laodHomeDataField();
    }

}
