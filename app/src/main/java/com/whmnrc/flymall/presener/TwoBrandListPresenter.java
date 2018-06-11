//package com.whmnrc.flymall.presener;
//
//import com.whmnrc.flymall.R;
//import com.whmnrc.flymall.beans.TwoBrandsBean;
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
// * @date 2018/2/3
// * 获取分类
// */
//
//public class TwoBrandListPresenter extends PresenterBase {
//    private TwoBrandListListener mTwoBrandListListener;
//
//    public TwoBrandListPresenter(TwoBrandListListener twoBrandListListener) {
//        this.mTwoBrandListListener = twoBrandListListener;
//    }
//
//
//    public void getTwoBrans(String oneBransId, int sex, int page, int rows) {
//        HashMap<String, String> paramters = new HashMap<>(3);
//
//
//
//        paramters.put("Brand_Classification", oneBransId);
//        paramters.put("Page", String.valueOf(page));
//        paramters.put("Rows", String.valueOf(rows));
//        paramters.put("Sex", String.valueOf(sex));
//
//        OKHttpManager.get(getUrl(R.string.GetAllBrand), paramters, new CommonCallBack<TwoBrandsBean>() {
//            @Override
//            protected void onSuccess(TwoBrandsBean data) {
//                if (data.getType() == 1) {
//                    mTwoBrandListListener.getTwoBrandListDataSuccess(data.getResultdata());
//                } else {
//                    ToastUtils.showToast(data.getMessage());
//                }
//            }
//        });
//    }
//
//
//    public interface TwoBrandListListener {
//        void getTwoBrandListDataSuccess(List<TwoBrandsBean.ResultdataBean> dataBean);
//    }
//
//}
