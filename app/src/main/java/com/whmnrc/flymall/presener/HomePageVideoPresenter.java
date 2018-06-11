//package com.whmnrc.flymall.presener;
//
//import com.whmnrc.flymall.R;
//import com.whmnrc.flymall.beans.AllVideoBean;
//import com.whmnrc.flymall.network.CommonCallBack;
//import com.whmnrc.flymall.network.OKHttpManager;
//import com.whmnrc.flymall.ui.PresenterBase;
//import com.whmnrc.flymall.utils.ToastUtils;
//
//import java.util.HashMap;
//
///**
// * @author yjyvi
// * @data 2018/5/29.
// */
//
//public class HomePageVideoPresenter extends PresenterBase {
//
//    private HomePageVideoListener mHomePageVideoListener;
//
//    public HomePageVideoPresenter(HomePageVideoListener emailLoginListener) {
//        this.mHomePageVideoListener = emailLoginListener;
//
//    }
//
//    public void getHomePageVideo(int page, int rows) {
//        HashMap<String, String> params = new HashMap<>(2);
//        params.put("Page", String.valueOf(page));
//        params.put("Rows", "50");
//        OKHttpManager.get(getUrl(R.string.GetHomePageVideo), params, new CommonCallBack<AllVideoBean>() {
//            @Override
//            protected void onSuccess(AllVideoBean data) {
//                if (data.getType() == 1) {
//                    mHomePageVideoListener.loadVideoSuccess(data);
//                } else {
//                    ToastUtils.showToast(data.getMessage());
//                }
//            }
//        });
//    }
//
//
//    public interface HomePageVideoListener {
//        void loadVideoSuccess(AllVideoBean allVideoBean);
//    }
//
//}
