package com.wolf.recyclerview.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.List;

/**
 * Created by nanchaodong on 2017/3/20.
 */

@SuppressLint("ValidFragment")
public class NewsFragment extends BaseFragment {
    private List<Visitable> list;

    public NewsFragment(List<Visitable> list) {
        this.list = list;
    }

    @Override
    protected int setLayout() {
        return R.layout.f_news;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
