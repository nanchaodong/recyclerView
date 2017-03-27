package com.wolf.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.controller.ShopListRecy;
import com.wolf.recyclerview.databinding.ASqBinding;
import com.wolf.recyclerview.presenter.ListRecy;

/**
 * Created by nanchaodong on 2017/3/24.
 */

public class SqActivity extends BaseActivity<ASqBinding> {
    private static final String TAG = "SqActivity";
    private CommonAdapter adapter;
    private StaggeredGridLayoutManager manager;
    private ListRecy listRecy;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_sq);
        adapter = new CommonAdapter(this);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        bindView.recyclerView.setLayoutManager(manager);
        listRecy = new ShopListRecy(bindView.recyclerView, bindView.swipe, adapter, true);
        listRecy.down();

    }


}
