package com.wolf.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.Toast;

import com.nineoldandroids.animation.PropertyValuesHolder;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.adapter.WeiboPagerAdapter;
import com.wolf.recyclerview.bean.Advert;
import com.wolf.recyclerview.bean.Banner;
import com.wolf.recyclerview.bean.RecyclerData;
import com.wolf.recyclerview.bean.WeiBoButton;
import com.wolf.recyclerview.bean.WeiBoTab;
import com.wolf.recyclerview.bean.WeiboSearch;
import com.wolf.recyclerview.bean.WeiboTag;
import com.wolf.recyclerview.databinding.AWeiboFindBinding;
import com.wolf.recyclerview.fragment.WeiBoFindFragment;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/4/24.
 */

public class WeiBoFindActivity extends BaseActivity<AWeiboFindBinding> {
    private static final String TAG = "WeiBoFindActivity";
    private BaseAdapter headAdapter;
    private GridLayoutManager headManager;
    private WeiboPagerAdapter pagerAdapter;
    private List<WeiBoTab> weiBoTabs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_weibo_find);
        pagerAdapter = new WeiboPagerAdapter(getSupportFragmentManager());
        headAdapter = new BaseAdapter(this);
        headManager = new GridLayoutManager(this, 1);
        bindView.recyclerView.setAdapter(headAdapter);
        bindView.recyclerView.setLayoutManager(headManager);
        bindView.recyclerView.setPadding(0, 0, 0, this.getResources().getDimensionPixelSize(R.dimen.d10));
        createTitle();
        create();
        bindView.appbarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int distance = appBarLayout.getTotalScrollRange();
                if (Math.abs(verticalOffset) == distance) {
                    bindView.imageBack.setVisibility(View.VISIBLE);
                    changeStatus(true);
                    bindView.recyclerView.setVisibility(View.GONE);

                }
                if (Math.abs(verticalOffset) == 0){
                    if (bindView.recyclerView.getVisibility() == View.GONE){
                        bindView.imageBack.setVisibility(View.VISIBLE);
                        changeStatus(true);
                    }else {
                        bindView.imageBack.setVisibility(View.GONE);
                        changeStatus(false);
                    }

                }
                Log.i(TAG, "onOffsetChanged: " + verticalOffset);

            }
        });
        bindView.imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bindView.recyclerView.setVisibility(View.VISIBLE);


            }
        });


    }

    private void changeStatus(boolean flag) {
        if (weiBoTabs != null && weiBoTabs.size() > 0) {
            for (int i = 0; i < weiBoTabs.size(); i++) {
                if (pagerAdapter.getItem(i) != null) {
                    ((WeiBoFindFragment) pagerAdapter.getItem(i)).changeVisible(flag);
                }

            }

        }

    }

    private void createTitle() {
        WeiBoTab weiBoTab = new WeiBoTab("热们");
        WeiBoTab weiBoTab1 = new WeiBoTab("榜单");
        WeiBoTab weiBoTab2 = new WeiBoTab("视频");
        WeiBoTab weiBoTab3 = new WeiBoTab("头条");
        weiBoTabs = new ArrayList<WeiBoTab>();
        weiBoTabs.add(weiBoTab);
        weiBoTabs.add(weiBoTab1);
        weiBoTabs.add(weiBoTab2);
        weiBoTabs.add(weiBoTab3);
        pagerAdapter.addData(weiBoTabs);
        bindView.tablayout.setupWithViewPager(bindView.viewpager);
        bindView.viewpager.setAdapter(pagerAdapter);

    }

    private void create() {
        List<Visitable> visitables = new ArrayList<Visitable>();
        WeiboSearch weiboSearch = new WeiboSearch(R.mipmap.ame, "地方华商报返回键：第八回房间不会手机");
        visitables.add(weiboSearch);
        Advert advert = new Advert();
        List<Banner> banners = new ArrayList<Banner>();
        for (int i = 0; i < 4; i++) {
            Banner banner = new Banner();
            banner.setImageurl("http://d.5857.com/xgs_150428/desk_005.jpg");
            banners.add(banner);
        }
        advert.setTopAdvs(banners);
        visitables.add(advert);
        RecyclerData<WeiBoButton> recyclerData = new RecyclerData<WeiBoButton>();
        List<WeiBoButton> weiBoButtons = new ArrayList<WeiBoButton>();
        for (int i = 0; i < 10; i++) {
            WeiBoButton weiBoButton = new WeiBoButton(R.mipmap.ame, "招人" + i);
            if (i == 9) {
                weiBoButton.setLoadType(1);
                weiBoButton.setShowMore(true);
            }
            weiBoButton.setId(i);
            weiBoButtons.add(weiBoButton);

        }
        recyclerData.setData(weiBoButtons);
        visitables.add(recyclerData);
        RecyclerData<WeiboTag> recyclerData1 = new RecyclerData<>();
        List<WeiboTag> weiboTags = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            WeiboTag weiboTag = new WeiboTag(R.mipmap.ame, "afhusahfjbhsj" + i);
            weiboTags.add(weiboTag);
        }
        recyclerData1.setData(weiboTags);
        visitables.add(recyclerData1);
        headAdapter.addData(visitables, false);
    }


}
