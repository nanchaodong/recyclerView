package com.wolf.recyclerview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wolf.recyclerview.bean.WeiBoTab;
import com.wolf.recyclerview.fragment.BaseFragment;

import java.util.List;

/**
 * Created by nanchaodong on 2017/4/25.
 */

public class WeiboPagerAdapter extends FragmentPagerAdapter {
    private List<WeiBoTab> list;

    public WeiboPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addData(List<WeiBoTab> list) {
        this.list = list;

    }

    @Override
    public BaseFragment getItem(int position) {
        return list.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getTitle();
    }
}
