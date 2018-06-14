package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.AllVideoBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.HashMap;

/**
 * @author yjyvi
 * @data 2018/5/29.
 */

public class AllVideoPresenter extends PresenterBase {

    private AllVideoListener mAllVideoListener;

    public AllVideoPresenter(AllVideoListener allVideoListener) {
        this.mAllVideoListener = allVideoListener;

    }

    public void getAllVideo(int page, int rows) {
        HashMap<String, String> params = new HashMap<>(3);
//        params.put("Page", String.valueOf(page));
//        params.put("Rows", String.valueOf(rows));
                OKHttpManager.get(getUrl(R.string.GetAllVideo), params, new CommonCallBack<AllVideoBean>() {
            @Override
            protected void onSuccess(AllVideoBean data) {
                if (data.getType() == 1) {
                    mAllVideoListener.loadSuccess(data);
                } else {
                    ToastUtils.showToast(data.getMessage());
                }
            }
        });
    }


    public interface AllVideoListener {
        void loadSuccess(AllVideoBean allVideoBean);
    }

}
