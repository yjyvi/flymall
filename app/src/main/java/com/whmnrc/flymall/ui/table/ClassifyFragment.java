package com.whmnrc.flymall.ui.table;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.ClassifyLeftAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.CommonAdapter;
import com.whmnrc.flymall.adapter.recycleViewBaseAdapter.MultiItemTypeAdapter;
import com.whmnrc.flymall.beans.OneBrandsBean;
import com.whmnrc.flymall.presener.OneBrandListPresenter;
import com.whmnrc.flymall.ui.LazyLoadFragment;
import com.whmnrc.flymall.ui.classify.TwoClassifyFragment;
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

public class ClassifyFragment extends LazyLoadFragment implements OneBrandListPresenter.OneBrandListListener {

    @BindView(R.id.rv_left)
    RecyclerView rv_left;

//    @BindView(R.id.iv_men)
//    ImageView mIvMen;
//    @BindView(R.id.iv_women)
//    ImageView mIvWomen;

    @BindView(R.id.rl_right)
    RelativeLayout rl_right;

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
                initRightData(mClassifyLeftAdapter.getDatas().get(position).getSubCategories());
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });


//        selectedView(mIvMen);
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
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.ll_right_main, fragment, "c0").commit();

    }

    /**
     * 将选择的目录滑动到中间
     *
     * @param position
     * @param view
     */
    private void scroll(int position, CommonAdapter adapter1, View view) {


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

        mClassifyLeftAdapter.setDataArray(dataBean);
        mClassifyData = dataBean;
        //默认显示第一个分类的数据
        if (dataBean != null && dataBean.size() > 0) {
            initRightData(dataBean.get(0).getSubCategories());
        }

        mClassifyLeftAdapter.notifyDataSetChanged();
    }


//    @OnClick({
//            R.id.iv_men, R.id.iv_women
//    })
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.iv_men:
//                selectedView(mIvMen);
//                mCurrentySex = 0;
//                break;
//            case R.id.iv_women:
//                mCurrentySex = 1;
//                selectedView(mIvWomen);
//                break;
//            default:
//                break;
//        }
//
//    }


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
        mClassifyP.getOneBrans();
    }

}
