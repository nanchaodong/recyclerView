package com.wolf.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.controller.SchoolListRecy;
import com.wolf.recyclerview.databinding.CommonRecyLayoutBinding;

/**
 * Created by nanchaodong on 2017/3/27.
 */

public class SchoolActivity extends BaseActivity<CommonRecyLayoutBinding> {
    private GridLayoutManager manager;
    private CommonAdapter adapter;
    private SchoolListRecy schoolListRecy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_recy_layout);
        adapter = new CommonAdapter(this);
        bindView.recyclerView.setAdapter(adapter);
        manager = new GridLayoutManager(this, 1);
        bindView.recyclerView.setLayoutManager(manager);
        schoolListRecy = new SchoolListRecy(bindView.recyclerView, bindView.swipe, adapter, true);
        schoolListRecy.down();

    }
}
