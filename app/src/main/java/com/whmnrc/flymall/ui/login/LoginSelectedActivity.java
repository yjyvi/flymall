package com.whmnrc.flymall.ui.login;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareConfig;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.UserBean;
import com.whmnrc.flymall.presener.LoginPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.ui.CommonH5WebView;
import com.whmnrc.flymall.ui.HomeTableActivity;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.utils.SPUtils;
import com.whmnrc.flymall.utils.TextColorChangeUtils;
import com.whmnrc.flymall.utils.ToastUtils;

import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *     author : Think
 *     e-mail : 1007687534@qq.com
 *     time   : 2018/01/31
 *     desc   : 登录选择界面
 *     version: 1.0
 * </pre>
 *
 * @author yjyvi
 */
public class LoginSelectedActivity extends BaseActivity implements LoginPresenter.LoginListener {

    @BindView(R.id.iv_close)
    ImageView mIvClose;
    @BindView(R.id.ll_mail_login)
    LinearLayout mLlMailLogin;
    @BindView(R.id.ll_facebook_login)
    LinearLayout mLlFacebookLogin;
    @BindView(R.id.ll_twitter_login)
    LinearLayout mLlTwitterLogin;
    @BindView(R.id.ll_wechat_login)
    LinearLayout mLlWechatLogin;
    @BindView(R.id.tv_agreement)
    TextView mTvAgreement;
    private UMShareAPI mShareAPI;
    public LoginPresenter mLoginPresenter;

    @Override
    protected void back() {
        HomeTableActivity.startHomeTableView(this, 0);
        finish();
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login_selected;
    }


    @Override
    protected void initViewData() {

        mLoginPresenter = new LoginPresenter(this);
        String agreement = mTvAgreement.getText().toString().trim();
        TextColorChangeUtils.changeTextColor(mTvAgreement, agreement, 34, agreement.length() - 1, ContextCompat.getColor(this, R.color.normal_red));
        setTitle(getResources().getString(R.string.login));
    }


    public static void start(Context context) {
        Intent starter = new Intent(context, LoginSelectedActivity.class);
        context.startActivity(starter);
    }


    @OnClick({R.id.iv_close, R.id.ll_mail_login, R.id.ll_facebook_login, R.id.ll_twitter_login, R.id.ll_wechat_login, R.id.tv_agreement})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_close:
                back();
                break;
            case R.id.ll_mail_login:
                selectedView(mLlMailLogin);
                LoginActivity.start(view.getContext());
                finish();
                break;
            case R.id.ll_facebook_login:
                selectedView(mLlFacebookLogin);
                quickLogin(SHARE_MEDIA.FACEBOOK);
                break;
            case R.id.ll_twitter_login:
                quickLogin(SHARE_MEDIA.TWITTER);
                selectedView(mLlTwitterLogin);
                break;
            case R.id.ll_wechat_login:
                quickLogin(SHARE_MEDIA.WEIXIN);
                selectedView(mLlWechatLogin);
                break;
            case R.id.tv_agreement:
                CommonH5WebView.startCommonH5WebView(view.getContext(),CommonConstant.Common.AGREEMENT,"User Agreement");
                break;
            default:
                break;
        }
    }

    private View lastView;

    private void selectedView(View view) {
        if (lastView != null) {
            lastView.setSelected(false);
        }
        if (!view.isSelected()) {
            view.setSelected(true);
            lastView = view;
        } else {
            view.setSelected(false);
        }
    }


    String unionid;//微信id
    String nikeName;//昵称
    String sex;//性别   1男2女
    String headIcon;//头像
    String originate;//1微信2qq3微博


    public void quickLogin(SHARE_MEDIA shareMedia) {
        UMShareConfig config = new UMShareConfig();
        config.isNeedAuthOnGetUserInfo(true);
        UMShareAPI.get(LoginSelectedActivity.this).setShareConfig(config);

        mShareAPI = UMShareAPI.get(LoginSelectedActivity.this);
        mShareAPI.getPlatformInfo(LoginSelectedActivity.this, shareMedia, umAuthListener);
    }

    private UMAuthListener umAuthListener = new UMAuthListener() {
        private String name;

        @Override
        public void onStart(SHARE_MEDIA share_media) {

        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            switch (platform) {
                case FACEBOOK:
                    unionid = data.get("uid");
                    headIcon = data.get("iconurl");
                    nikeName = data.get("name");
                    sex = data.get("gender").equals("男") ? "1" : "2";
                    originate = "2";
                    break;
                case WEIXIN://微信授权回调
                    unionid = data.get("unionid");
                    headIcon = data.get("profile_image_url");
                    nikeName = data.get("screen_name");
                    sex = data.get("gender").equals("男") ? "1" : "2";
                    originate = "0";

                    break;
                case TWITTER:
                    unionid = data.get("uid");
                    headIcon = data.get("iconurl");
                    nikeName = data.get("name");
                    sex = data.get("gender").equals("男") ? "1" : "2";
                    originate = "3";
                    break;
                default:
                    break;

            }
            //第三方登录的请求
            if (nikeName.length() > 6) {
                name = nikeName.substring(0, 5);
                nikeName = name;
            }
//            if (TextUtils.isEmpty(headIcon)) {
//                headIcon = getResources().getString(R.string.service_host_address_photo) + "img/user.jpg";
//            }
            ToastUtils.showToast("授权成功");
            mLoginPresenter.emailLogin(unionid, "", originate, headIcon, sex, nikeName);
        }


        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            ToastUtils.showToast("授权失败");
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void loginSuccess(UserBean.ResultdataBean userBean) {
        SPUtils.put(this, CommonConstant.Common.LAST_LOGIN_ID, userBean.getId());
        UserManager.saveUser(userBean);
        HomeTableActivity.startHomeTableView(LoginSelectedActivity.this, 0);
        finish();
    }
}
