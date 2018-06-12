package com.whmnrc.flymall.network;

import android.text.TextUtils;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.BuildConfig;
import com.whmnrc.flymall.utils.ToastUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * <pre>
 *     author : Think
 *     e-mail : 1007687534@qq.com
 *     time   : 2018/02/05
 *     desc   :
 *     version: 1.0
 * </pre>
 *
 * @author yjyvi
 */
public abstract class CommonCallBack<T> implements OKHttpManager.ObjectCallback {

    @Override
    public void onFailure(int call, String e) {
        if (BuildConfig.DEBUG) {
            if (!TextUtils.isEmpty(e)) {
                Log.e("CommonCallBack==", e);
            }
        }
        ToastUtils.showToast("Network request error! Please try again");
        onError("Network request error! Please try again");
    }

    @Override
    public void onSuccess(String result) {
        Type genType = this.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        T data = JSON.parseObject(result, params[0]);
        onSuccess(data);
    }

    protected abstract void onSuccess(T data);

    protected void onError(String msg) {
        ToastUtils.showToast(msg);
    }

}
