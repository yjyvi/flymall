package com.whmnrc.flymall.ui.table;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.whmnrc.flymall.CommonConstant;
import com.whmnrc.flymall.MyApplication;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.ClassifyLeftAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.MultiItemTypeAdapter;
import com.whmnrc.flymall.beans.OneBrandsBean;
import com.whmnrc.flymall.presener.OneBrandListPresenter;
import com.whmnrc.flymall.ui.LazyLoadFragment;
import com.whmnrc.flymall.ui.classify.TwoClassifyFragment;
import com.whmnrc.flymall.utils.SPUtils;
import com.whmnrc.flymall.views.LoadingDialog;
import com.whmnrc.flymall.views.SmoothScrollLayoutManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author yjyvi
 * @date 2018/1/30
 * 分类界面
 */

public class ClassifyFragment extends LazyLoadFragment implements OneBrandListPresenter.OneBrandListListener, OnRefreshListener {

    @BindView(R.id.rv_left)
    RecyclerView rv_left;

    @BindView(R.id.rl_right)
    RelativeLayout rl_right;

    @BindView(R.id.refresh)
    SmartRefreshLayout mRefresh;

    private OneBrandListPresenter mClassifyP;
    private ClassifyLeftAdapter mClassifyLeftAdapter;
    private List<OneBrandsBean.ResultdataBean> mClassifyData;
    //可见列表项的数量
    private int visibleCount = 0;
    //上次点击的位置
    private int lastPosition = 0;
    private int ce = 0;
    //实际列表是否超出屏幕
    private boolean isOut = true;
    private View lastLineView;
    private int mCurrentySex = 0;
    private LoadingDialog mLoadingDialog;
    private int mLastPosition = 0;

    @Override
    protected int contentViewLayoutID() {
        return R.layout.fragment_classify;
    }

    @Override
    protected void initViewData() {
        setTitle("Classification");
        mLoadingDialog = new LoadingDialog(getActivity());
        mLoadingDialog.show();
        mClassifyP = new OneBrandListPresenter(this, mLoadingDialog);
        mClassifyP.getOneBrans();

        mRefresh.setOnRefreshListener(this);
        mRefresh.setEnableLoadMore(false);


        //左侧列表
        SmoothScrollLayoutManager layout = new SmoothScrollLayoutManager(getActivity());
        layout.setAutoMeasureEnabled(true);
        rv_left.setLayoutManager(layout);
        mClassifyLeftAdapter = new ClassifyLeftAdapter(getActivity(), R.layout.item_classify_left);
        rv_left.setAdapter(mClassifyLeftAdapter);

        mClassifyLeftAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                scroll(position, mClassifyLeftAdapter, view);
                mLastPosition = position;
                initRightData(mClassifyLeftAdapter.getDatas().get(position).getSubCategories());
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });

        String classifyData = SPUtils.getString(MyApplication.applicationContext, CommonConstant.Common.CLASSIFY_DATA);
        if (!TextUtils.isEmpty(classifyData)) {
            List<OneBrandsBean.ResultdataBean> resultdataBeans = JSONObject.parseArray(classifyData, OneBrandsBean.ResultdataBean.class);
            initClassifyData(resultdataBeans);
        }

    }


    /**
     * 初始化右则数据
     *
     * @param oneBrandsId
     */
    private void initRightData(List<OneBrandsBean.ResultdataBean.SubCategoriesBeanX> oneBrandsId) {
        //获取右侧品牌宽度
        RecyclerView viewById = (RecyclerView) findViewById(R.id.rv_left);
        ViewGroup.LayoutParams layoutParams = viewById.getLayoutParams();
        int width = layoutParams.width;
        int widthPixels = getResources().getDisplayMetrics().widthPixels;
        width = widthPixels - width - getResources().getDimensionPixelSize(R.dimen.dm_10);

        //模拟右侧标签页
        TwoClassifyFragment fragment = TwoClassifyFragment.newInstance((ArrayList<OneBrandsBean.ResultdataBean.SubCategoriesBeanX>) oneBrandsId, width, mCurrentySex);
        FragmentManager fm = getFragmentManager();
        if (fm != null) {
            FragmentTransaction ft = fm.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.ll_right_main, fragment, "c0").commit();
            }
        }

    }

    /**
     * 将选择的目录滑动到中间
     *
     * @param position
     * @param view
     */
    private void scroll(int position, CommonAdapter adapter1, View view) {
        if (view == null) {
            return;
        }

        //改变选中状态
        if (!view.isSelected()) {
            //去除上一次控件的状态
            if (lastLineView != null) {
                lastLineView.setSelected(false);
            }
            lastLineView = view;

            view.setSelected(true);
        }


        if (visibleCount == 0) {
            visibleCount = rv_left.getChildCount();
            if (visibleCount == mClassifyData.size()) {
                isOut = false;
            } else {
                ce = visibleCount / 2;
            }
        }

        RecyclerView.LayoutManager layoutManager = rv_left.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
            //上移
            if (position <= (linearManager.findFirstVisibleItemPosition() + ce)) {
                rv_left.smoothScrollToPosition(position - ce);
            } else {
                //下移
                if ((linearManager.findLastVisibleItemPosition() + ce + 1) <= adapter1.getItemCount()) {
                    rv_left.smoothScrollToPosition(position + ce);
                } else {
                    rv_left.smoothScrollToPosition(adapter1.getItemCount() - 1);
                }
            }
            lastPosition = position;
        }

    }


    /**
     * 初始化实例
     *
     * @return
     */
    public static ClassifyFragment newInstance() {
        Bundle bundle = new Bundle();
        ClassifyFragment classifyFragment = new ClassifyFragment();
        classifyFragment.setArguments(bundle);
        return classifyFragment;
    }

    @Override
    public void getOneBrandListDataSuccess(List<OneBrandsBean.ResultdataBean> dataBean) {
        SPUtils.put(MyApplication.applicationContext, CommonConstant.Common.CLASSIFY_DATA, JSON.toJSONString(dataBean));
        initClassifyData(dataBean);
    }

    private void initClassifyData(List<OneBrandsBean.ResultdataBean> dataBean) {
        mClassifyLeftAdapter.setDataArray(dataBean);
        mClassifyData = dataBean;
        //默认显示第一个分类的数据
        if (dataBean != null && dataBean.size() > 0) {
            initRightData(dataBean.get(mLastPosition).getSubCategories());
            scroll(mLastPosition, mClassifyLeftAdapter, rv_left.getLayoutManager().getChildAt(mLastPosition));
        }

        mClassifyLeftAdapter.notifyDataSetChanged();
        mLoadingDialog.dismiss();
    }




    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        refreshLayout.finishRefresh();
        mClassifyP.getOneBrans();
    }
}
