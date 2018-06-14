package com.whmnrc.flymall.ui.home.gooddetailsfragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    private GoodsCommentAdapter2 mGoodsCommentAdapter;
    public GoodsDetailsBean.ResultdataBean.ProductCommentInfo mEvaluateBean;

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

    }


    private void initWeb(final String contUrl) {
        web.post(new Runnable() {
            @Override
            public void run() {
                web.loadData(getHtmlData(contUrl), "text/html; charset=UTF-8", null);
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
        String head = "<head><style>* {\n" +
                "        margin: 0;\n" +
                "        padding: 0;\n" +
                "    }\n" +
                "\n" +
                "    img {\n" +
                "        width: 100%;\n" +
                "    }\n" + "</style></head>";
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
    public void changeToComment(GoodsCommentEvent goodsCommentEvent){

    }
}
