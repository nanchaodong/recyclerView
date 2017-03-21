package com.wolf.recyclerview.holder;

import android.view.View;

import com.bumptech.glide.Glide;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.Title;
import com.wolf.recyclerview.databinding.TitleItemBinding;

/**
 * Created by nanchaodong on 2017/3/7.
 */

public class TitleHolder extends BaseViewHolder<Title, TitleItemBinding> {
    public TitleHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(Title model, int position, BaseAdapter adapter) {

        bindingView.setTitle(model);
    }
}
