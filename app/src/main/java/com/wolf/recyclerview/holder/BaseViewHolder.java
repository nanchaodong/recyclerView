package com.wolf.recyclerview.holder;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;

/**
 * Created by nanchaodong on 2017/3/3.
 */

public abstract class BaseViewHolder<T, SV extends ViewDataBinding> extends RecyclerView.ViewHolder {

    protected SV bindingView;
    protected Context context;

    public BaseViewHolder(View itemView) {
        super(itemView);
        bindingView = DataBindingUtil.bind(itemView);
        bindingView.executePendingBindings();
        context = itemView.getContext();
    }

    public abstract void setBean(T model, int position, BaseAdapter adapter);
}
