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
    private boolean mIsSelect;

    public AddressManagerAdapter(Context context, int layoutId, boolean isSelect) {
        super(context, layoutId);
        this.mIsSelect = isSelect;
    }

    @Override
    public void convert(ViewHolder holder, final AddressBean.ResultdataBean resultdataBean, int position) {
        holder.setText(R.id.tv_address_name, String.format("Receiver：%s %s", resultdataBean.getShipTo(), resultdataBean.getAddress_LastName()));
        holder.setText(R.id.tv_address_tel, resultdataBean.getPhone());
        holder.setText(R.id.tv_address_desc, resultdataBean.getAddress());
        holder.setOnClickListener(R.id.iv_address_edit, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddAddressActivity.start(v.getContext(), JSON.toJSONString(resultdataBean), 1);
            }
        });


        if (resultdataBean.getAddress_IsDefault() == 1) {
            holder.setVisible(R.id.v_isDefault, true);
        } else {
            holder.setVisible(R.id.v_isDefault, false);
        }

        if (mIsSelect) {
            holder.setVisible(R.id.iv_selected, true);
            holder.setSelected(R.id.iv_selected, resultdataBean.isSelect());
        } else {
            holder.setVisible(R.id.iv_selected, false);
        }
    }
}
