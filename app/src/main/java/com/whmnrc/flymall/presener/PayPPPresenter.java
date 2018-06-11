package com.whmnrc.flymall.presener;

import com.whmnrc.flymall.beans.BaseBean;
import com.whmnrc.flymall.network.CommonCallBack;
import com.whmnrc.flymall.network.OKHttpManager;
import com.whmnrc.flymall.ui.PresenterBase;

import java.util.HashMap;

/**
 * @author yjyvi
 * @data 2018/6/4.
 */

public class PayPPPresenter  extends PresenterBase{

    private  PayPPListener mPayPPListener;

    public PayPPPresenter(PayPPListener payPPListener){
        this.mPayPPListener = payPPListener;

    }

    public void getPayPPToken(){
        OKHttpManager.get("http://192.168.0.113:8064/Api/PayPal/GetToken", new HashMap<String, String>(), new CommonCallBack<BaseBean>() {
            @Override
            protected void onSuccess(BaseBean data) {
                if (data.getType()==1) {
                    String  resultdata = (String) data.getResultdata();
                    mPayPPListener.getPPTokenSuccess(resultdata);
                }
            }
        });
    }


    public interface PayPPListener{
        void getPPTokenSuccess(String toke);
    }

}
