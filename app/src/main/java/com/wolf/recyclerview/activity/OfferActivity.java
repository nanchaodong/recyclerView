package com.wolf.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.OfferPagerAdapter;
import com.wolf.recyclerview.bean.OfferTitle;
import com.wolf.recyclerview.databinding.AOfferBinding;
import com.wolf.recyclerview.fragment.BriefFragment;
import com.wolf.recyclerview.fragment.CareerFragment;
import com.wolf.recyclerview.fragment.OfferFragment;
import com.wolf.recyclerview.fragment.RequestFragment;

import java.util.ArrayList;
import java.util.List;

import retrofit2.http.PartMap;

/**
 * Created by nanchaodong on 2017/3/31.
 */

public class OfferActivity extends BaseActivity<AOfferBinding> {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private OfferPagerAdapter pagerAdapter;
    private List<OfferTitle> list;
    private static final String TAG = "OfferActivity";
    private int imageHeight = 0;
    private int blankHeight = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_offer);
        aBaseBinding.setShow(true);
        aBaseBinding.title.setText("Offer库详情");
        aBaseBinding.titleLayout.setAlpha(1);
        tabLayout = bindView.tablayout;
        viewPager = bindView.viewpager;
        pagerAdapter = new OfferPagerAdapter(getSupportFragmentManager());
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        createData();
        pagerAdapter.addData(list);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(pagerAdapter);
        bindView.setImagePath("http://img02.tooopen.com/images/20140504/sy_60294738471.jpg");
        blankHeight = this.getResources().getDimensionPixelSize(R.dimen.d46);
        bindView.appbarlayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                int a = Math.abs(verticalOffset);
                int total = appBarLayout.getTotalScrollRange();
                float b = a / (total * 1.0f);
                Log.i(TAG, "onOffsetChanged: " + imageHeight);
                Log.i(TAG, "onOffsetChanged: " + b);
                aBaseBinding.titleLayout.setAlpha(b);








            }
        });
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) bindView.appbarlayout.getLayoutParams();
        CoordinatorLayout.Behavior behavior = layoutParams.getBehavior();


    }

    public void createData() {
        list = new ArrayList<OfferTitle>();
        OfferTitle title = new OfferTitle("要求", new RequestFragment());
        OfferTitle title1 = new OfferTitle("简介", new BriefFragment());
        OfferTitle title2 = new OfferTitle("专业", new CareerFragment());
        OfferTitle title3 = new OfferTitle("Offer", new OfferFragment());
        list.add(title);
        list.add(title1);
        list.add(title2);
        list.add(title3);
    }
}