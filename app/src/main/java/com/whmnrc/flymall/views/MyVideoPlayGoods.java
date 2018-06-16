package com.whmnrc.flymall.views;

import android.content.Context;
import android.content.Intent;

import com.luck.picture.lib.PictureVideoPlayActivity;
import com.whmnrc.flymall.ui.home.GoodsDetailsActivity;

/**
 * @author yjyvi
 * @data 2018/6/14.
 */

public class MyVideoPlayGoods extends PictureVideoPlayActivity {

    @Override
    public void goToGoodsDetials(String goodsId) {
        finish();
        String goodsId1 = getIntent().getStringExtra("goodsId");
        GoodsDetailsActivity.start(this, goodsId1);
    }
    
    public static void start(Context context, String videoPath, String goodsDescription, String goodsId) {
        Intent starter = new Intent(context, MyVideoPlayGoods.class);
        starter.putExtra("video_path", videoPath);
        starter.putExtra("goodsDescription", goodsDescription);
        starter.putExtra("goodsId", goodsId);
        context.startActivity(starter);
    }
}
