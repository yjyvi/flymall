package com.whmnrc.flymall.ui.login;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.UserBean;
import com.whmnrc.flymall.presener.LoginPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.ui.CommonH5WebView;
import com.whmnrc.flymall.ui.HomeTableActivity;
import com.whmnrc.flymall.ui.UserManager;
import com.whmnrc.flymall.utils.PhoneUtils;
import com.whmnrc.flymall.utils.SPUtils;
import com.whmnrc.flymall.utils.TextColorChangeUtils;
import com.whmnrc.flymall.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * <pre>
 *     author : Think
 *     e-mail : 1007687534@qq.com
 *     time   : 2018/01/31
 *     desc   : 邮箱登录
 *     version: 1.0
 * </pre>
 *
 * @author yjyvi
 */
public class LoginActivity extends BaseActivity implements LoginPresenter.LoginListener {


    @BindView(R.id.et_mail)
    EditText mEtMail;
    @BindView(R.id.et_pwd)
    EditText mEtPwd;
    @BindView(R.id.tv_agreement)
    TextView mTvAgreement;

    private boolean mIsShow;
    public LoginPresenter mEmailLoginPresenter;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    protected void initViewData() {
        setTitle(getResources().getString(R.string.login));
        String agreement = mTvAgreement.getText().toString().trim();
        TextColorChangeUtils.changeTextColor(mTvAgreement, agreement, 34, agreement.length() - 1, ContextCompat.getColor(this, R.color.normal_red));
        mEmailLoginPresenter = new LoginPresenter(this);

        mEtMail.setText("androidlk@aliyun.com");
        mEtPwd.setText("123456");
    }


    @OnClick({R.id.tv_login, R.id.tv_agreement})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                if (inputVerification()) {
                    mEmailLoginPresenter.emailLogin(mEtMail.getText().toString().trim(), mEtPwd.getText().toString().trim(), "1", "", "", "");
                }
                break;
            case R.id.tv_agreement:
                //用户协议
                CommonH5WebView.startCommonH5WebView(view.getContext(),CommonConstant.Common.AGREEMENT,"User Agreement");
                break;

            default:
                break;
        }
    }

    /**
     * 输入提示
     *
     * @return
     */
    private boolean inputVerification() {

        if (TextUtils.isEmpty(mEtMail.getText().toString().trim())) {
            ToastUtils.showToast(getResources().getString(R.string.input_tel));
            return false;
        }

        if (TextUtils.isEmpty(mEtPwd.getText().toString().trim())) {
            ToastUtils.showToast(getResources().getString(R.string.input_password));
            return false;
        }

        if (!PhoneUtils.isEmail(mEtMail.getText().toString().trim())) {
            ToastUtils.showToast(getResources().getString(R.string.input_email));
            return false;
        }
        return true;
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    @Override
    public void loginSuccess(UserBean.ResultdataBean userBean) {
        SPUtils.put(this, CommonConstant.Common.LAST_LOGIN_ID, userBean.getId());
        UserManager.saveUser(userBean);
        HomeTableActivity.startHomeTableView(LoginActivity.this, 0);
        finish();
    }
}
