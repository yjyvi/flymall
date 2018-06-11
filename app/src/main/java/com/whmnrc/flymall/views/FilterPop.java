package com.whmnrc.flymall.views;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.whmnrc.flymall.R;
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

    public interface MixinPopListener {
        void addGroups();

        void newFriend();

        void scanFriend();

    }

    private MixinPopListener mMixinPopListener;

    public void setMixinPopListener(MixinPopListener mixinPopListener) {
        mMixinPopListener = mixinPopListener;
    }

    private void initData() {
        dataList.add("Cotton");
        dataList.add("Seven sleeves");
        dataList.add("Polyester");
        dataList.add("Seven sleeves");
        dataList.add("Wool");
        dataList.add("Seven sleeves");
        dataList.add("Wool");
        dataList.add("Seven sleeves");
        dataList.add("Wool");
        dataList.add("Polyester");

    }

    // 存放popupwindow的布局；
    private View conentView;

    public void imPopWindow(final Activity context) {
        initData();

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        conentView = inflater.inflate(R.layout.item_pop_goods_filter, null);

        TagFlowLayout tagFlowLayout1 = conentView.findViewById(R.id.tag_flow_layout1);
        TagFlowLayout tagFlowLayout2 = conentView.findViewById(R.id.tag_flow_layout2);

        tagFlowLayout1.setAdapter(new TagAdapter<String>(dataList) {
            @Override
            public View getView(FlowLayout parent, int position, String content) {
                TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speciflcations_select, null);
                textView.setText(content);
                return textView;
            }
        });

        tagFlowLayout2.setAdapter(new TagAdapter<String>(dataList) {
            @Override
            public View getView(FlowLayout parent, int position, String content) {
                TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_speciflcations_select, null);
                textView.setText(content);
                return textView;
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
}
