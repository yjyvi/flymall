package com.whmnrc.flymall.ui.mine;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.AddressBean;
import com.whmnrc.flymall.beans.SelectAddressBean;
import com.whmnrc.flymall.presener.AddressAddOrUpdatePresenter;
import com.whmnrc.flymall.presener.GetAddressCityPresenter;
import com.whmnrc.flymall.ui.BaseActivity;
import com.whmnrc.flymall.utils.PhoneUtils;
import com.whmnrc.flymall.utils.TextColorChangeUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.evntBusBean.AddressEvent;
import com.whmnrc.flymall.views.CityPop;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author yjyvi
 * @data 2018/5/22.
 */

public class AddAddressActivity extends BaseActivity implements AddressAddOrUpdatePresenter.AddressAddOrUpdateListener, GetAddressCityPresenter.SelectAddressListener, CityPop.CityListener {

    @BindView(R.id.tv_is_default)
    TextView mTvIsDefault;
    @BindView(R.id.et_first_name)
    EditText mEtFirstName;
    @BindView(R.id.et_last_name)
    EditText mEtLastName;
    @BindView(R.id.et_address)
    EditText mEtAddress;
    @BindView(R.id.et_address_continued)
    EditText mEtAddressContinued;
    @BindView(R.id.et_city)
    EditText mEtCity;
    @BindView(R.id.et_postal_code)
    EditText mEtPostalCode;
    @BindView(R.id.et_tel)
    EditText mEtTel;
    @BindView(R.id.tv_indicates)
    TextView mTvIndicates;
    @BindView(R.id.tv_first_name)
    TextView mTvFirstName;
    @BindView(R.id.tv_last_name)
    TextView mTvLastName;
    @BindView(R.id.tv_shipping_address)
    TextView mTvShippingAddress;
    @BindView(R.id.tv_city)
    TextView mTvCity;
    @BindView(R.id.tv_destination_country)
    TextView mTvDestinationCountry;
    @BindView(R.id.tv_country)
    TextView mTvCountry;
    @BindView(R.id.tv_state_province_region)
    TextView mTvStateProvinceRegion;
    @BindView(R.id.tv_province)
    TextView mTvProvince;
    @BindView(R.id.tv_zip_postal_code)
    TextView mTvZipPostalCode;
    @BindView(R.id.tv_phone_number)
    TextView mTvPhoneNumber;
    @BindView(R.id.tv_tel)
    TextView mTvTel;
    public AddressBean.ResultdataBean mResultdataBean;
    public AddressAddOrUpdatePresenter mAddressAddOrUpdatePresenter;
    public GetAddressCityPresenter mGetAddressCityPresenter;
    public CityPop mCityPop;
    private String mParentId;
    private String mCityAreaId;
    private String mProvinceAreaId;

    @Override
    protected void initViewData() {

        EventBus.getDefault().register(this);
        mGetAddressCityPresenter = new GetAddressCityPresenter(this);
        mCityPop = new CityPop(this, this, mEtFirstName);
        setTitle("New address");

        mAddressAddOrUpdatePresenter = new AddressAddOrUpdatePresenter(this);

        String resultdataBeanJson = getIntent().getStringExtra("resultdataBeanJson");
        if (!TextUtils.isEmpty(resultdataBeanJson)) {
            mResultdataBean = JSON.parseObject(resultdataBeanJson, AddressBean.ResultdataBean.class);
            setTitle("Edit address");
        }

        if (mResultdataBean != null) {
            mEtFirstName.setText(mResultdataBean.getAddress_Name());
            mEtLastName.setText(mResultdataBean.getAddress_Name());
            mEtAddress.setText(mResultdataBean.getAddress_Name());
            mEtTel.setText(mResultdataBean.getAddress_Mobile());
            mEtCity.setText(mResultdataBean.getAddress_City());
            mEtAddressContinued.setText(mResultdataBean.getAddress_Region());
            if (mResultdataBean.getAddress_IsDefault() == 1) {
                mTvIsDefault.setSelected(true);
            } else {
                mTvIsDefault.setSelected(false);
            }
        }

        redTextColor(mTvIndicates);
        redTextColor(mTvPhoneNumber);
        redTextColor(mTvZipPostalCode);
        redTextColor(mTvDestinationCountry);
        redTextColor(mTvStateProvinceRegion);
        redTextColor(mTvCity);
        redTextColor(mTvShippingAddress);
        redTextColor(mTvLastName);
        redTextColor(mTvFirstName);
        redTextColor(mTvIndicates);


    }

    private void redTextColor(TextView textView) {
        TextColorChangeUtils.changeTextColor(textView, textView.getText().toString(), 0, 1, ContextCompat.getColor(this, R.color.normal_red));
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_add_address;
    }

    public static void start(Context context, String resultdataBeanJson) {
        Intent starter = new Intent(context, AddAddressActivity.class);
        starter.putExtra("resultdataBeanJson", resultdataBeanJson);
        context.startActivity(starter);
    }


    @OnClick({R.id.tv_country, R.id.tv_province, R.id.tv_save, R.id.tv_is_default})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_country:
                mGetAddressCityPresenter.getTheAddress("0", true);
                break;
            case R.id.tv_province:
                if (!TextUtils.isEmpty(mParentId)) {
                    mGetAddressCityPresenter.getTheAddress(mParentId, false);
                } else {
                    ToastUtils.showToast("Select Country");
                }
                break;
            case R.id.tv_save:
                if (inputVerification()) {
                    if (mResultdataBean != null) {
                        addOrUpdateAddress(false);
                    } else {
                        addOrUpdateAddress(true);
                    }
                }

                break;
            case R.id.tv_is_default:
                if (!view.isSelected()) {
                    view.setSelected(true);
                } else {
                    view.setSelected(false);
                }
                break;
            default:
                break;
        }
    }

    private void addOrUpdateAddress(boolean isAdd) {
        mAddressAddOrUpdatePresenter.addOrUpdateAddress(isAdd,
                mEtTel.getText().toString().trim(),
                mEtFirstName.getText().toString().trim(),
                mEtLastName.getText().toString().trim(),
                mEtAddress.getText().toString().trim(),
                mCityAreaId,
                mProvinceAreaId,
                mEtCity.getText().toString().trim(),
                mEtAddress.getText().toString().trim(),
                mEtAddressContinued.getText().toString().trim(),
                mTvIsDefault.isSelected() ? 1 : 0
        );
    }


    /**
     * 输入提示
     *
     * @return
     */
    private boolean inputVerification() {

        if (TextUtils.isEmpty(mEtFirstName.getText().toString().trim())) {
            ToastUtils.showToast("Please enter First Name");
            return false;
        }

        if (TextUtils.isEmpty(mEtLastName.getText().toString().trim())) {
            ToastUtils.showToast("Please enter Last Name");
            return false;
        }

        if (TextUtils.isEmpty(mEtAddress.getText().toString().trim())) {
            ToastUtils.showToast("Please enter Address");
            return false;
        }
        if (TextUtils.isEmpty(mEtAddressContinued.getText().toString().trim())) {
            ToastUtils.showToast("Please enter Address Continued");
            return false;
        }
        if (TextUtils.isEmpty(mEtCity.getText().toString().trim())) {
            ToastUtils.showToast("Please enter City");
            return false;
        }
        if (TextUtils.isEmpty(mTvDestinationCountry.getText().toString().trim())) {
            ToastUtils.showToast("Please selectToPrice Destination Country");
            return false;
        }
        if (TextUtils.isEmpty(mTvStateProvinceRegion.getText().toString().trim())) {
            ToastUtils.showToast("Please selectToPrice State Province Region");
            return false;
        }
        if (TextUtils.isEmpty(mEtPostalCode.getText().toString().trim())) {
            ToastUtils.showToast("Please enter Postal Code");
            return false;
        }
        if (TextUtils.isEmpty(mEtTel.getText().toString().trim())) {
            ToastUtils.showToast("Please enter phone number");
            return false;
        }
        if (!PhoneUtils.isMobileNO(mEtTel.getText().toString().trim())) {
            ToastUtils.showToast("please enter a valid phone number");
            return false;
        }
        return true;
    }


    @Override
    public void addSuccess() {
        EventBus.getDefault().post(new AddressEvent().setEventType(AddressEvent.ADD_ADDRESS_SUCCESS));
        finish();
    }

    @Override
    public void upadteSuccess() {

    }

    @Override
    public void getTheAddressSuccess(List<SelectAddressBean.ResultdataBean> resultdataBeans, boolean isCountry) {
        mCityPop.setOneList(resultdataBeans);
        mCityPop.show(isCountry);
    }


    @Override
    public void onSelect(String parentId, String cityName, String telAre, String areaId, boolean isCountry) {
        if (isCountry) {
            this.mParentId = parentId;
            this.mCityAreaId = areaId;
            mTvCountry.setText(cityName);
            mTvTel.setText(telAre);
        } else {
            this.mProvinceAreaId = areaId;
            mTvProvince.setText(cityName);
        }

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @org.greenrobot.eventbus.Subscribe
    public void addressEvent(AddressEvent addressEvent) {

    }
}
