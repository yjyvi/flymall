package com.whmnrc.flymall.ui;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.whmnrc.flymall.R;

import butterknife.BindView;


/**
 * @author yjyvi
 * @date 2017/10/8
 * 公用H5页面
 */


public class CommonH5WebView extends BaseActivity {

    @BindView(R.id.wb_content)
    WebView wb_content;

    @BindView(R.id.pb_loading)
    ProgressBar pb_loading;

    public String mTitle;
    public String mH5Url;


    @Override
    protected void back() {
        if (wb_content.canGoBack()) {
            wb_content.goBack();
        } else {
            finish();
        }
    }

    public static void startCommonH5WebView(Context activity, String h5Url, String title) {
        Intent intent = new Intent(activity, CommonH5WebView.class);
        intent.putExtra("h5Url", h5Url);
        intent.putExtra("title", title);
        activity.startActivity(intent);
    }

    @Override
    public int setLayoutId() {
        return R.layout.activity_my_binbei;
    }

    @Override
    public void initViewData() {

        mTitle = getIntent().getStringExtra("title");
        mH5Url = getIntent().getStringExtra("h5Url");

        setTitle(mTitle);

        WebSettings settings = wb_content.getSettings();
        settings.setSupportZoom(false);

        settings.setJavaScriptEnabled(false);
//        wb_content.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
//        wb_content.setWebViewClient(new WebViewClient() {
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//
//        });

//        wb_content.setOnKeyListener(new View.OnKeyListener() {
//            @Override
//            public boolean onKey(View v, int keyCode, KeyEvent event) {
//                if (event.getAction() == KeyEvent.ACTION_DOWN) {
//                    //表示按返回键
//                    if (keyCode == KeyEvent.KEYCODE_BACK && wb_content.canGoBack()) {
//                        wb_content.goBack();
//                        return true;
//                    }
//                }
//                return false;
//            }
//        });
//        settings.setDefaultTextEncodingName("utf-8");
//        wb_content.setWebChromeClient(new WebChromeClient() {
//
//            @Override
//            public void onProgressChanged(WebView view, int newProgress) {
//                super.onProgressChanged(view, newProgress);
//
//                if (newProgress == 100) {
//                    //加载完网页进度条消失
//                    pb_loading.setVisibility(View.GONE);
//                } else {
//                    //开始加载网页时显示进度条
//                    pb_loading.setVisibility(View.VISIBLE);
//                    //设置进度值
//                    pb_loading.setProgress(newProgress);
//                }
//            }
//        });


//        if (!mH5Url.startsWith("http")&&mH5Url.startsWith("https")) {
//            mH5Url = "http://".concat(mH5Url);
//        }
        wb_content.loadUrl(mH5Url);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (wb_content.canGoBack()) {
                wb_content.goBack();
            } else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
