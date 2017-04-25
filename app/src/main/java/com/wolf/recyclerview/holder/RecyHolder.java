package com.wolf.recyclerview.holder;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.RecyclerData;
import com.wolf.recyclerview.bean.WeiBoButton;
import com.wolf.recyclerview.bean.WeiBoChildTag;
import com.wolf.recyclerview.bean.WeiboTag;
import com.wolf.recyclerview.databinding.RecyclerLayoutBinding;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.List;

/**
 * Created by nanchaodong on 2017/4/24.
 */

public class RecyHolder extends BaseViewHolder<RecyclerData, RecyclerLayoutBinding> {
    private GridLayoutManager manager;
    private BaseAdapter mAdapter;
    private int padding = 0;

    public RecyHolder(View itemView) {
        super(itemView);
        mAdapter = new BaseAdapter(context);
        padding = context.getResources().getDimensionPixelSize(R.dimen.d10);
    }

    @Override
    public void setBean(RecyclerData model, int position, BaseAdapter adapter) {
        bindingView.recyclerView.setNestedScrollingEnabled(false);
        if (model.getData() != null && model.getData().get(0) instanceof WeiBoButton) {
            manager = new GridLayoutManager(context, 5);
            bindingView.recyclerView.setPadding(0,0,0,padding);
        }
        if (model.getData() != null && model.getData().get(0) instanceof WeiboTag){
            manager = new GridLayoutManager(context, 2);
            bindingView.recyclerView.setPadding(padding, 0, padding, 0);
        }
        if (model.getData() != null && model.getData().get(0) instanceof WeiBoChildTag){
            manager = new GridLayoutManager(context, 1, LinearLayoutManager.HORIZONTAL, false);
        }
        bindingView.recyclerView.setLayoutManager(manager);
        bindingView.recyclerView.setAdapter(mAdapter);
        List<Visitable> list = model.getData();
        mAdapter.addData(list, false);

    }
}
