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
import com.whmnrc.flymall.utils.TextColorChangeUtils;
import com.whmnrc.flymall.utils.ToastUtils;
import com.whmnrc.flymall.utils.evntBusBean.AddressEvent;
import com.whmnrc.flymall.views.CityPop;
import com.whmnrc.flymall.views.LoadingDialog;

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
    private boolean mIsInit;
    private String addressId = "0";
    public String mCityName;
    public String mTelAre;
    public String mProName;
    private String mStringName;
    public String mAddressStateProvince;
    private LoadingDialog mLoadingDialog;

    @Override
    protected void initViewData() {
        mLoadingDialog = new LoadingDialog(this);

        setTitle("New address");
        EventBus.getDefault().register(this);
        mGetAddressCityPresenter = new GetAddressCityPresenter(this);
        mCityPop = new CityPop(this, this, mEtFirstName);

        mAddressAddOrUpdatePresenter = new AddressAddOrUpdatePresenter(this);

        String resultdataBeanJson = getIntent().getStringExtra("resultdataBeanJson");
        int size = getIntent().getIntExtra("size", 0);
        if (!TextUtils.isEmpty(resultdataBeanJson)) {
            mResultdataBean = JSON.parseObject(resultdataBeanJson, AddressBean.ResultdataBean.class);
            setTitle("Edit address");
        }

        if (mResultdataBean != null) {
            mIsInit = true;
            addressId = String.valueOf(mResultdataBean.getId());
            mEtFirstName.setText(mResultdataBean.getShipTo());
            mEtLastName.setText(mResultdataBean.getAddress_LastName());
            mEtAddress.setText(mResultdataBean.getAddress());
            mEtTel.setText(mResultdataBean.getPhone());
            mEtCity.setText(mResultdataBean.getAddress_City());
            mEtAddressContinued.setText(mResultdataBean.getAddress_Address2());
            mEtPostalCode.setText(mResultdataBean.getAddress_ZipCode());
            mParentId = mResultdataBean.getAddress_Provice();
            mAddressStateProvince = mResultdataBean.getAddress_StateProvince();
            mStringName = mAddressStateProvince;

            if (!TextUtils.isEmpty(mAddressStateProvince)) {
                String[] split = mAddressStateProvince.split(",");
                mCityName = split[0];
                mTvCountry.setText(mCityName);
                if (split.length > 1) {
                    mProName = split[1];
                    mTvProvince.setText(mProName);
                }
                if (split.length > 2) {
                    mTelAre = split[2];
                    mTvTel.setText(mTelAre);
                }
            }

            if (mResultdataBean.getAddress_IsDefault() == 1) {
                mTvIsDefault.setSelected(true);
            } else {
                mTvIsDefault.setSelected(false);
            }
        }else {
            if (size ==0) {
                mTvIsDefault.setSelected(true);
            }
        }

        redTextColor(mTvIndicates);
        redTextColor(mTvPhoneNumber);
        redTextColor(mTvZipPostalCode);
        redTextColor(mTvDestinationCountry);
        redTextColor(mTvStateProvinceRegion);
        redTextColor(mTvCity);
        redTextColor(mTvShippingAddress);
        redTextColor(mTvIndicates);


    }

    private void redTextColor(TextView textView) {
        TextColorChangeUtils.changeTextColor(textView, textView.getText().toString(), 0, 1, ContextCompat.getColor(this, R.color.normal_red));
    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_add_address;
    }

    public static void start(Context context, String resultdataBeanJson,int size) {
        Intent starter = new Intent(context, AddAddressActivity.class);
        starter.putExtra("resultdataBeanJson", resultdataBeanJson);
        starter.putExtra("size", size);
        context.startActivity(starter);
    }


    @OnClick({R.id.tv_country, R.id.tv_province, R.id.tv_save, R.id.tv_is_default})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_country:
                mIsInit = false;
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
                    mLoadingDialog.show();
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
        mStringName = mCityName + "," + mProName + "," + mTelAre;
        mAddressAddOrUpdatePresenter.addOrUpdateAddress(isAdd, addressId,
                mEtTel.getText().toString().trim(),
                mEtFirstName.getText().toString().trim(),
                mEtLastName.getText().toString().trim(),
                mEtAddress.getText().toString().trim(),
                mEtCity.getText().toString().trim(),
                mParentId,
                mCityAreaId,
                mEtAddressContinued.getText().toString().trim(),
                mEtPostalCode.getText().toString().trim(),
                mTvIsDefault.isSelected() ? 1 : 0, mStringName
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
        if (TextUtils.isEmpty(mEtCity.getText().toString().trim())) {
            ToastUtils.showToast("Please enter City");
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
        return true;
    }


    @Override
    public void addSuccess() {
        mLoadingDialog.dismiss();
        EventBus.getDefault().post(new AddressEvent().setEventType(AddressEvent.ADD_ADDRESS_SUCCESS));
        finish();
    }

    @Override
    public void upadteSuccess() {
        mLoadingDialog.dismiss();
        EventBus.getDefault().post(new AddressEvent().setEventType(AddressEvent.ADD_ADDRESS_SUCCESS));
        finish();
    }

    @Override
    public void addField() {
        mLoadingDialog.dismiss();
    }

    @Override
    public void getTheAddressSuccess(List<SelectAddressBean.ResultdataBean> resultdataBeans, boolean isCountry) {
        if (!mIsInit) {
            mCityPop.setOneList(resultdataBeans);
            mCityPop.show(isCountry);
        }
    }


    @Override
    public void onSelect(String parentId, String cityName, String telAre, String areaId, boolean isCountry) {
        if (isCountry) {
            this.mParentId = parentId;
            this.mCityAreaId = areaId;
            mCityName = cityName;
            mTvCountry.setText(mCityName);
            mTelAre = telAre;
            mTvTel.setText(mTelAre);
        } else {
            mProName = cityName;
            mTvProvince.setText(mProName);
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
