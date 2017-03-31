package com.wolf.recyclerview.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.wolf.recyclerview.bean.OfferTitle;
import com.wolf.recyclerview.fragment.BaseFragment;

import java.util.List;

/**
 * Created by nanchaodong on 2017/3/31.
 */

public class OfferPagerAdapter extends FragmentPagerAdapter {
    private List<OfferTitle> list;

    public OfferPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addData(List<OfferTitle> list) {
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
