package com.wolf.recyclerview.holder;

import android.databinding.DataBindingUtil;
import android.view.View;

import com.wolf.recyclerview.bean.People;
import com.wolf.recyclerview.databinding.PeopleItemBinding;

/**
 * Created by nanchaodong on 2017/3/3.
 */

public class PeopleHolder extends BaseViewHolder<People, PeopleItemBinding> {
    public PeopleHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(People model, int position, com.wolf.recyclerview.adapter.BaseAdapter adapter) {
        bindingView.setPeople(model);
    }


}
