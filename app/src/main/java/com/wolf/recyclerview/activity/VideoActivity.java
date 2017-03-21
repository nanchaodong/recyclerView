package com.wolf.recyclerview.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.AbsListView;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.bean.Video;
import com.wolf.recyclerview.databinding.ActivityMainBinding;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.ArrayList;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

/**
 * Created by nanchaodong on 2017/3/21.
 */

public class VideoActivity extends BaseActivity<ActivityMainBinding> {
    private List<Visitable> list = new ArrayList<Visitable>();
    private CommonAdapter adapter;
    private GridLayoutManager manager;
    private JCVideoPlayerStandard currPlayer;
    private int firstVisible;//当前第一个可见的item
    private int visibleCount;//当前可见的item个数

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 20; i++) {
            list.add(new Video("http://gslb.miaopai.com/stream/ed5HCfnhovu3tyIQAiv60Q__.mp4", "http://a4.att.hudong.com/05/71/01300000057455120185716259013.jpg"));
        }
        adapter = new CommonAdapter(this);
        bindView.recyclerView.setAdapter(adapter);
        manager = new GridLayoutManager(this,1);
        bindView.recyclerView.setLayoutManager(manager);
        adapter.addData(list,false);
        bindView.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {

                switch (newState) {
                    case AbsListView.OnScrollListener.SCROLL_STATE_FLING:
                        break;

                    case AbsListView.OnScrollListener.SCROLL_STATE_IDLE:
                        //滑动停止自动播放视频
                        autoPlayVideo(recyclerView);
                        break;

                    case AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL:
                        break;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                firstVisible = manager.findFirstCompletelyVisibleItemPosition();
                visibleCount =manager.findLastVisibleItemPosition() - firstVisible;
            }
        });

    }
    private void autoPlayVideo(ViewGroup view) {

        for (int i = 0; i < visibleCount; i++) {
            if (view != null && view.getChildAt(i) != null && view.getChildAt(i).findViewById(R.id.player_list_video) != null) {
                currPlayer = (JCVideoPlayerStandard) view.getChildAt(i).findViewById(R.id.player_list_video);
                Rect rect = new Rect();
                //获取当前view 的 位置
                currPlayer.getLocalVisibleRect(rect);
                int videoheight = currPlayer.getHeight();
                if (rect.top == 0 && rect.bottom == videoheight) {
                    if (currPlayer.currentState == JCVideoPlayer.CURRENT_STATE_NORMAL
                            || currPlayer.currentState == JCVideoPlayer.CURRENT_STATE_ERROR) {
                        currPlayer.startButton.performClick();
                    }
                    return;
                }
            }
        }
        //释放其他视频资源
        JCVideoPlayer.releaseAllVideos();
    }
    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
