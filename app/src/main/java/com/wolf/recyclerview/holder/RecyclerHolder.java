package com.wolf.recyclerview.holder;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.bean.Nurse;
import com.wolf.recyclerview.bean.Result;
import com.wolf.recyclerview.databinding.ACountryBinding;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/3/29.
 */

public class RecyclerHolder extends BaseViewHolder<Result<List<Nurse>>, ACountryBinding> {
    private GridLayoutManager manager;
    private CommonAdapter adapter;
    private List<String> list;

    public RecyclerHolder(View itemView) {
        super(itemView);
        manager = new GridLayoutManager(context, 4);
        bindingView.recyclerView.setLayoutManager(manager);
        adapter = new CommonAdapter(context);
        bindingView.recyclerView.setAdapter(adapter);
        list = new ArrayList<String>();
        list.add("每日护理");
        list.add("每周护理");
    }

    @Override
    public void setBean(Result<List<Nurse>> model, int position, BaseAdapter adapter) {
        List<Visitable> list = new ArrayList<Visitable>();
        list.addAll(model.getData());
        this.adapter.addData(list, false);
        bindingView.setText(this.list.get(position));

    }
}
