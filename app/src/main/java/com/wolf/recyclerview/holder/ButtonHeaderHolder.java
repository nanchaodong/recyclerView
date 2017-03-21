package com.wolf.recyclerview.holder;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.bean.ButtonTitle;
import com.wolf.recyclerview.databinding.ButtonHeaderBinding;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/3/21.
 */

public class ButtonHeaderHolder extends BaseViewHolder<ButtonTitle, ButtonHeaderBinding> {
    private CommonAdapter mAdapter;
    private GridLayoutManager manager;

    public ButtonHeaderHolder(View itemView) {
        super(itemView);
        mAdapter = new CommonAdapter(context);
        manager = new GridLayoutManager(context, 1, LinearLayoutManager.HORIZONTAL, false);
        bindingView.recyclerView.setAdapter(mAdapter);
        bindingView.recyclerView.setLayoutManager(manager);
    }

    @Override
    public void setBean(ButtonTitle model, int position, BaseAdapter adapter) {
        List<Visitable> list = new ArrayList<Visitable>();
        list.addAll(model.getBtns());
        mAdapter.addData(list, false);
    }


}
