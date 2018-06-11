package com.whmnrc.flymall.adapter;

import android.content.Context;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.ViewHolder;
import com.whmnrc.flymall.beans.AddressBean;
import com.whmnrc.flymall.ui.mine.AddAddressActivity;

/**
 * @author yjyvi
 * @data 2018/5/19.
 */

public class AddressManagerAdapter extends CommonAdapter<AddressBean.ResultdataBean> {
    public AddressManagerAdapter(Context context, int layoutId) {
        super(context, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, final AddressBean.ResultdataBean resultdataBean, int position) {
        holder.setText(R.id.tv_address_name, String.format("Receiver：%s", resultdataBean.getAddress_Name()));
        holder.setText(R.id.tv_address_tel, resultdataBean.getAddress_Mobile());
        holder.setText(R.id.tv_address_desc, resultdataBean.getAddress_Detail());
        holder.setOnClickListener(R.id.iv_address_edit, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddAddressActivity.start(v.getContext(), JSON.toJSONString(resultdataBean));
            }
        });

        if (resultdataBean.getAddress_IsDefault() == 1) {
            holder.setVisible(R.id.v_isDefault, true);
        } else {
            holder.setVisible(R.id.v_isDefault, false);
        }
    }


}
