package com.wolf.recyclerview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.RecyclerData;
import com.wolf.recyclerview.bean.WeiBoChildTag;
import com.wolf.recyclerview.bean.WeiBoPicture;
import com.wolf.recyclerview.bean.WeiboArticle;
import com.wolf.recyclerview.databinding.FWeiboFindBinding;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/4/25.
 */

public class WeiBoFindFragment extends BaseFragment<FWeiboFindBinding> {
    private BaseAdapter adapter;
    private GridLayoutManager manager;
    private List<WeiBoChildTag> tags;


    @Override
    protected int setLayout() {
        return R.layout.f_weibo_find;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BaseAdapter(getActivity());
        manager = new GridLayoutManager(getActivity(), 1);
        bindView.recyclerView.setAdapter(adapter);
        bindView.recyclerView.setLayoutManager(manager);

        createTag();

    }

    private void createTag() {
        List<Visitable> list = new ArrayList<>();
        tags = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            WeiBoChildTag weiBoChildTag = new WeiBoChildTag("热点", false);
            tags.add(weiBoChildTag);
        }
        RecyclerData<WeiBoChildTag> data = new RecyclerData<>();
        data.setData(tags);
        list.add(data);
        for (int i = 0; i < 20; i++) {
            WeiboArticle article = new WeiboArticle();
            article.setTranspondCount("1335");
            article.setReplyCount("5656");
            article.setPraiseCount("7890");
            article.setHeadUrl("http://imgtu.5011.net/uploads/content/20170406/4698681491456593.jpg");
            article.setUserName("南朝东" + i);
            if (i % 2 == 0) {
                article.setContent("enterAlways的附加值。这里涉及到Child View的高度和最小高度，向下滚动时，Child View先向下滚动最小高度值，然后Scrolling View开始滚动，到达边界时，Child View再向下滚动，直至显示完全");
            } else {
                article.setContent("这里也涉及到最小高度。发生向上滚动事件时，Child View向上滚动退出直至最小高度，然后Scrolling View开始滚动。也就是，Child View不会完全退出屏幕。");
            }
            List<WeiBoPicture> pictures = new ArrayList<>();
            if (i % 7 == 0) {//9张图
                for (int j = 0; j < 9; j++) {
                    WeiBoPicture weiBoPicture = new WeiBoPicture("http://imgtu.5011.net/uploads/content/20170406/8949921491450978.jpg");
                    pictures.add(weiBoPicture);
                }
                article.setPictures(pictures);
                article.setTagName("情感");

            } else if (i % 7 == 1) {//4张
                for (int j = 0; j < 4; j++) {
                    WeiBoPicture weiBoPicture = new WeiBoPicture("http://pic17.nipic.com/20111122/6759425_152002413138_2.jpg");
                    pictures.add(weiBoPicture);
                }
                article.setPictures(pictures);

            } else if (i % 7 == 2) {//1张
                WeiBoPicture weiBoPicture = new WeiBoPicture("http://scimg.jb51.net/allimg/151228/14-15122Q60431W4.jpg");
                pictures.add(weiBoPicture);
                article.setPictures(pictures);
                article.setTagName("时事");

            }else if (i%7 ==3){//2张
                for (int j = 0; j < 2; j++) {
                    WeiBoPicture weiBoPicture = new WeiBoPicture("http://pic.58pic.com/58pic/15/17/38/02w58PICuYi_1024.jpg");
                    pictures.add(weiBoPicture);
                }
                article.setPictures(pictures);
            }else if (i% 7 ==4){//3张
                for (int j = 0; j < 3; j++) {
                    WeiBoPicture weiBoPicture = new WeiBoPicture("http://img.taopic.com/uploads/allimg/121124/235013-12112419214432.jpg");
                    pictures.add(weiBoPicture);
                }
                article.setPictures(pictures);
            }else if (i % 7 == 5){//5张

                for (int j = 0; j < 5; j++) {
                    WeiBoPicture weiBoPicture = new WeiBoPicture("http://pic.58pic.com/58pic/14/15/82/29S58PICTPg_1024.jpg");
                    pictures.add(weiBoPicture);
                }
                article.setPictures(pictures);
                article.setTagName("生活");

            }
            list.add(article);

        }
        adapter.addData(list, false);

    }

    public void changeVisible(boolean flag) {

        if (tags != null && tags.size() > 0) {
            for (WeiBoChildTag tag : tags) {
                tag.setShow(flag);
            }
        }
        if (!flag){
            bindView.recyclerView.scrollToPosition(0);
        }


    }
}
