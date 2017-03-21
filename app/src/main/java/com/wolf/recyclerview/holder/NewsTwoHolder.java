package com.wolf.recyclerview.holder;

import android.view.View;

import com.bumptech.glide.Glide;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.News;
import com.wolf.recyclerview.databinding.NewItemTwoBinding;

/**
 * Created by nanchaodong on 2017/3/7.
 */

public class NewsTwoHolder extends BaseViewHolder<News, NewItemTwoBinding> {
    public NewsTwoHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(News model, int position, BaseAdapter adapter) {
        bindingView.setNews(model);
    }
}
