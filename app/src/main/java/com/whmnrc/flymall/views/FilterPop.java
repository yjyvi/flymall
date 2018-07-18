package com.whmnrc.flymall.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.beans.SearchResultBean;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * 点击更多按钮弹出PopupWindow
 *
 * @author MrLiu
 * @style 测试
 * @date 2015/12/08
 */

public class FilterPop extends PopupWindow {

    private List<String> dataList = new ArrayList<>();
    private List<SearchResultBean.ResultdataBean.CategoryBean> mCategoryList;
    private String cid = "";
    private OnConfirmClickListener mOnConfirmClickListener;

    public void setOnConfirmClickListener(OnConfirmClickListener onConfirmClickListener) {
        this.mOnConfirmClickListener = onConfirmClickListener;
    }

    // 存放popupwindow的布局；
    private View conentView;

    public void imPopWindow(final Activity context, List<SearchResultBean.ResultdataBean.CategoryBean> mCategoryList) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.item_pop_goods_filter, null);
        LinearLayout llAllTabFlow = conentView.findViewById(R.id.ll_all_flow_layout);

        final List<SearchResultBean.ResultdataBean.CategoryBean.SubCategoryBean> num = new ArrayList<>();

        //动态适配分类
        for (int i = 0; i < mCategoryList.size(); i++) {
            final SearchResultBean.ResultdataBean.CategoryBean categoryBean = mCategoryList.get(i);
            View view = inflater.inflate(R.layout.tab_flow_item, null);
            TagFlowLayout tagFlowLayout = view.findViewById(R.id.tag_flow_layout);
            TextView tvTitleFlow = view.findViewById(R.id.tv_flow_title);
            tvTitleFlow.setText(categoryBean.getName());
            List<String> list = new ArrayList<>();
            for (SearchResultBean.ResultdataBean.CategoryBean.SubCategoryBean subCategoryBean : categoryBean.getSubCategory()) {
                list.add(subCategoryBean.getName());
            }
            tagFlowLayout.setAdapter(new TagAdapter<String>(list) {
                @Override
                public View getView(FlowLayout parent, int position, String content) {
                    TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speciflcations_select, null);
                    textView.setText(content);
                    return textView;
                }
            });
            final int finalI = i;
            tagFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                @Override
                public boolean onTagClick(View view, int position, FlowLayout parent) {
                    num.clear();
                    num.add(categoryBean.getSubCategory().get(position));
                    return false;
                }
            });
            llAllTabFlow.addView(view);
        }

        TextView tvConfirm = conentView.findViewById(R.id.tv_confirm);

        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                if (TextUtils.isEmpty(cid)) {
                    if (mOnConfirmClickListener != null) {
                        List<SearchResultBean.ResultdataBean.CategoryBean.SubCategoryBean> noNullCid = new ArrayList<>();
                        //去Null值
                        for (int i = 0; i < num.size(); i++) {
                            if (num.get(i) != null) {
                                noNullCid.add(num.get(i));
                            }

                        }
                        for (int i = 0; i < noNullCid.size(); i++) {
                            if (i == noNullCid.size() || noNullCid.size() == 1) {
                                cid += noNullCid.get(i).getId();
                            } else {
                                cid += noNullCid.get(i).getId() + ",";
                            }
                        }

                        if (noNullCid.size() >= 2) {
                            cid = cid.substring(0, cid.length() - 1);
                        }
                        mOnConfirmClickListener.onConfirm(cid, noNullCid);
                    }
                }
            }
        });

        // 获取context窗口的宽高；
        int h = context.getWindowManager().getDefaultDisplay().getHeight();
        int w = context.getWindowManager().getDefaultDisplay().getWidth();

        // 设置SelectPicPopupWindow的View
        this.setContentView(conentView);

        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(LayoutParams.MATCH_PARENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(LayoutParams.WRAP_CONTENT);


        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        // 当前窗体外围可触摸，加这个貌似没什么效果，这里可以不加；
        this.setOutsideTouchable(true);

        // 刷新状态，家或者不加并没有什么影响。
        this.update();

        conentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(ContextCompat.getColor(context, R.color.translate));
        // 点back键和其他地方使其消失,设置了这个才能触发OnDismisslistener ，设置其他控件变化等操作
        this.setBackgroundDrawable(dw);

    }

    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 出现在父控件正左下方，x、y方向有偏移；
            this.showAsDropDown(parent);
        } else {
            this.dismiss();
        }
    }

    public interface OnConfirmClickListener {
        void onConfirm(String cid, List<SearchResultBean.ResultdataBean.CategoryBean.SubCategoryBean> noNullCid);
    }
}
