package com.wolf.recyclerview.activity;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;

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
        anim();
        bindView.appbarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int distance = appBarLayout.getTotalScrollRange();
                if (Math.abs(verticalOffset) == distance&& distance != 0) {
                    Log.i(TAG, "onOffsetChanged: " + "最顶");
                    bindView.imageBack.setVisibility(View.VISIBLE);
                    changeStatus(true);
                    final AppBarLayout.LayoutParams lp = (AppBarLayout.LayoutParams) bindView.recyclerView.getLayoutParams();
                    bindView.recyclerView.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            lp.setScrollFlags(0);
                            bindView.recyclerView.setLayoutParams(lp);
                            bindView.recyclerView.setVisibility(View.GONE);
                        }
                    }, 100);
                    
                }


            }
        });
        bindView.imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              AppBarLayout.LayoutParams lp = (AppBarLayout.LayoutParams) bindView.recyclerView.getLayoutParams();
                lp.setScrollFlags(AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
                bindView.recyclerView.setLayoutParams(lp);
                bindView.recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        anim();
                        bindView.recyclerView.setVisibility(View.VISIBLE);
                        bindView.imageBack.setVisibility(View.GONE);
                        changeStatus(false);
                    }
                },300);

            }
        });


    }
    private void anim(){
        LayoutTransition mTransition = new LayoutTransition();
/** * 添加View时过渡动画效果 */
        ObjectAnimator addAnimator = ObjectAnimator.ofFloat(null, "translationY", 0, 1.f).setDuration(mTransition.getDuration(LayoutTransition.APPEARING));
        mTransition.setAnimator(LayoutTransition.APPEARING, addAnimator);
        bindView.appbarlayout.setLayoutTransition(mTransition);

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
        bindView.viewpager.setOffscreenPageLimit(3);

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
