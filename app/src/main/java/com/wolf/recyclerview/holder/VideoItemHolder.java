package com.wolf.recyclerview.holder;

import android.view.View;

import com.bumptech.glide.Glide;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.Video;
import com.wolf.recyclerview.databinding.VideoItemBinding;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by nanchaodong on 2017/3/21.
 */

public class VideoItemHolder extends BaseViewHolder<Video, VideoItemBinding> {
    public VideoItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(Video model, int position, BaseAdapter adapter) {
        if (bindingView.playerListVideo != null) {
            bindingView.playerListVideo.release();
        }
        boolean setUp = bindingView.playerListVideo.setUp(model.getVideoUrl(), JCVideoPlayer.SCREEN_LAYOUT_LIST, "");
        if (setUp) {
            Glide.with(context).load("http://a4.att.hudong.com/05/71/01300000057455120185716259013.jpg").into(bindingView.playerListVideo.thumbImageView);
        }
    }
}
