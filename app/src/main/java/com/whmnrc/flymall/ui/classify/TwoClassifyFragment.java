package com.whmnrc.flymall.ui.classify;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewStub;

import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.ClassifyRightAdapter;
import com.whmnrc.flymall.beans.OneBrandsBean;
import com.whmnrc.flymall.ui.LazyLoadFragment;
import com.whmnrc.flymall.utils.EmptyListUtils;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * @author yjyvi
 * @date 2018/2/1
 * 右侧二级分类界面
 */

public class TwoClassifyFragment extends LazyLoadFragment {

    @BindView(R.id.rv_category)
    RecyclerView rv_category;
    @BindView(R.id.vs_empty)
    ViewStub mVsEmpty;


    public ClassifyRightAdapter mGoodsListAdapter;
    public ArrayList<OneBrandsBean.ResultdataBean.SubCategoriesBeanX> oneBrands;
    private int page = 1;
    private int rows = 10;
    private int mWidth;
    public int mCurrentySex;


    @Override
    protected int contentViewLayoutID() {
        return R.layout.fragment_two_type_list;
    }


    @Override
    protected void initViewData() {


        oneBrands = getArguments().getParcelableArrayList("oneBrands");
        mWidth = getArguments().getInt("width");
        mCurrentySex = getArguments().getInt("mCurrentySex");


        if (oneBrands != null) {
            LinearLayoutManager layout = new LinearLayoutManager(getActivity());
            layout.setAutoMeasureEnabled(true);
            rv_category.setLayoutManager(layout);
            mGoodsListAdapter = new ClassifyRightAdapter(getActivity(), R.layout.item_brands, mWidth);
            rv_category.setAdapter(mGoodsListAdapter);
            mGoodsListAdapter.setDataArray(oneBrands);
            showEmpty();
        }

    }

    public void showEmpty() {
        if (mGoodsListAdapter != null && mGoodsListAdapter.getDatas().size() == 0) {
            EmptyListUtils.loadEmpty(true, mVsEmpty);
        } else {
            if (mVsEmpty != null) {
                mVsEmpty.setVisibility(View.GONE);
            }
        }
    }

    /**
     * 初始化实例
     *
     * @return
     */
    public static TwoClassifyFragment newInstance(ArrayList<OneBrandsBean.ResultdataBean.SubCategoriesBeanX> subCategoriesBeanXXES, int width, int currentySex) {
        Bundle bundle = new Bundle();
        TwoClassifyFragment twoClassifyFragment = new TwoClassifyFragment();
        bundle.putParcelableArrayList("oneBrands", subCategoriesBeanXXES);
        bundle.putInt("width", width);
        bundle.putInt("mCurrentySex", currentySex);
        twoClassifyFragment.setArguments(bundle);
        return twoClassifyFragment;
    }


}
