package com.whmnrc.flymall.network;

import android.content.Context;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.BuildConfig;
import com.whmnrc.flymall.MyApplication;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.utils.NetworkUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.util.Map;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import anet.channel.request.Request;
import okhttp3.Call;
import okhttp3.MediaType;

/**
 *
 * @author yjyvi
 * @date 2018/1/30
 */

public class OKHttpManager {


    private Request.Builder mOkHttpClient;

    public void setCertificates(Context context, InputStream... certificates)
    {
        try
        {
            CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null);
            int index = 0;
            for (InputStream certificate : certificates)
            {
                String certificateAlias = Integer.toString(index++);
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate));

                try
                {
                    if (certificate != null)
                        certificate.close();
                } catch (IOException e)
                {
                }
            }

            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.
                    getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);

            //初始化keystore
            KeyStore clientKeyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            clientKeyStore.load(context.getAssets().open("zhy_client.jks"), "123456".toCharArray());

            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            keyManagerFactory.init(clientKeyStore, "123456".toCharArray());

            mOkHttpClient = new Request.Builder();
            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
            mOkHttpClient.setSslSocketFactory(sslContext.getSocketFactory());


        } catch (Exception e)
        {
            e.printStackTrace();
        }

    }


    public static void post(String url, Map<String, String> params, final CommonCallBack callback) {


        if (getIsConnected()) return;
        if (BuildConfig.DEBUG) {
            Log.e("请求参数=", url + JSON.toJSONString(params));
        }

        OkHttpUtils.post().url(url).params(params).build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                callback.onFailure(id, e.toString());
            }

            @Override
            public void onResponse(String response, int id) {
                callback.onSuccess(response);
            }
        });


    }

    /**
     * 是否有网络
     * @return
     */
    public static boolean getIsConnected() {
        if (!NetworkUtils.isConnected()) {
            ToastUtils.showToast(MyApplication.applicationContext.getResources().getString(R.string.app_name).concat("：网络异常，请检查网络设置"));
            return true;
        }
        return false;
    }


    public static void get(String url, Map<String, String> paramters,
                           final CommonCallBack callback) {

        if (getIsConnected()) return;

        try {
            if (BuildConfig.DEBUG) {
                Log.e("请求参数=", url + JSON.toJSONString(paramters));
            }
            OkHttpUtils
                    .get()
                    .url(url)
                    .params(paramters)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {
                            callback.onFailure(id, e.toString());
                        }

                        @Override
                        public void onResponse(String responseString, int id) {
                            if (BuildConfig.DEBUG) {
                                Log.e("返回结果=", responseString);
                            }
                            if (callback != null) {
                                callback.onSuccess(responseString);
                            }
                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }






    //上传文件
    public static void uploadFile(Map<String, String> params, final StringCallback callback) {

        if (getIsConnected()) return;

        String url = MyApplication.applicationContext.getString(R.string.service_host_address).concat("/api/Order/UploadFile");

        postString(url, JSON.toJSONString(params), new ObjectCallback() {
            @Override
            public void onSuccess(String st) {
                callback.onResponse(st, 0);
            }

            @Override
            public void onFailure(int code, String errorMsg) {

            }
        });
    }

    public static void postString(String url, String gsonString, final ObjectCallback objectCallback) {

        if (getIsConnected()) return;
        if (BuildConfig.DEBUG) {
            Log.e("OkhttpUtil", url + gsonString);
        }
        OkHttpUtils.postString().content(gsonString)
                .url(url)
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .build().execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                objectCallback.onFailure(id, e.getLocalizedMessage());
            }

            @Override
            public void onResponse(String response, int id) {
                if (BuildConfig.DEBUG) {
                    Log.e("返回结果=", response);
                }
                objectCallback.onSuccess(response);
            }
        });
    }




    public interface ObjectCallback {
        void onSuccess(String st);

        void onFailure(int code, String errorMsg);

    }
}
