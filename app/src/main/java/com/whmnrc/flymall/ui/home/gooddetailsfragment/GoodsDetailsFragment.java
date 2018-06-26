package com.whmnrc.flymall.ui.home.gooddetailsfragment;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.whmnrc.flymall.R;
import com.whmnrc.flymall.adapter.GoodsCommentAdapter2;
import com.whmnrc.flymall.beans.GoodsDetailsBean;
import com.whmnrc.flymall.ui.LazyLoadFragment;
import com.whmnrc.flymall.utils.evntBusBean.GoodsCommentEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;

/**
 * @author yjyvi
 * @data 2018/5/21.
 */

public class GoodsDetailsFragment extends LazyLoadFragment {

    @BindView(R.id.rv_goods_comment)
    RecyclerView mRvGoodsComment;
    @BindView(R.id.tv_more_comment)
    TextView mTvMoreComment;
    @BindView(R.id.web)
    WebView web;
    @BindView(R.id.nsv_layout)
    NestedScrollView mNestedScrollView;
    private GoodsCommentAdapter2 mGoodsCommentAdapter;
    public GoodsDetailsBean.ResultdataBean.ProductCommentInfo mEvaluateBean;
    private int mSrollY = 0;

    @Override
    protected int contentViewLayoutID() {
        return R.layout.fragment_goods_details;
    }

    @Override
    protected void initViewData() {

        EventBus.getDefault().register(this);

        String evaluate = getArguments().getString("evaluate");
        mEvaluateBean = JSON.parseObject(evaluate, GoodsDetailsBean.ResultdataBean.ProductCommentInfo.class);

        String goodsContent = getArguments().getString("goodsContent");

        mRvGoodsComment.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvGoodsComment.setNestedScrollingEnabled(false);
        mGoodsCommentAdapter = new GoodsCommentAdapter2(getActivity(), R.layout.item_goods_comment);
        mRvGoodsComment.setAdapter(mGoodsCommentAdapter);
        mGoodsCommentAdapter.setDataArray(mEvaluateBean.getModels());
        initWeb(goodsContent);

        mTvMoreComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new GoodsCommentEvent().setEventType(GoodsCommentEvent.CHANGE_TO_COMMENT));
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mNestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
                @Override
                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    mSrollY = scrollY;
                }
            });

            mNestedScrollView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_UP:
                            if (mSrollY ==0) {
                                EventBus.getDefault().post(new GoodsCommentEvent().setEventType(GoodsCommentEvent.CHANGE_TO_TOP));
                            }
                            break;
                        default:
                            break;
                    }
                    return false;
                }
            });
        }

    }


    private void initWeb(final String contUrl) {
        web.post(new Runnable() {
            @Override
            public void run() {
                String htmlData = getHtmlData(contUrl);
                web.loadData(htmlData, "text/html; charset=UTF-8", null);
                //去除WebView的焦点事件
                web.setFocusableInTouchMode(false);
                WebSettings settings = web.getSettings();
                settings.setSupportZoom(false);
                settings.setJavaScriptEnabled(false);
                settings.setDefaultTextEncodingName("utf-8");
            }
        });


    }

    /**
     * 添加HTML标签样式
     *
     * @param bodyHTML
     * @return
     */
    public static String getHtmlData(String bodyHTML) {
        String head = "<head><style>*{margin: 0;padding: 0;}img {width: 100%;}</style></head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }


    public static GoodsDetailsFragment newInstance(String goodsContent, String evaluate) {
        Bundle args = new Bundle();
        GoodsDetailsFragment fragment = new GoodsDetailsFragment();
        args.putString("goodsContent", goodsContent);
        args.putString("evaluate", evaluate);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Subscribe
    public void changeToComment(GoodsCommentEvent goodsCommentEvent) {

    }
}
