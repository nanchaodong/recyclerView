package com.wolf.recyclerview.holder;

import android.view.View;

import com.bumptech.glide.Glide;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.News;
import com.wolf.recyclerview.databinding.NewsItemOneBinding;

/**
 * Created by nanchaodong on 2017/3/7.
 */

public class NewsOneHolder extends BaseViewHolder<News, NewsItemOneBinding> {
    public NewsOneHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(News model, int position, BaseAdapter adapter) {
        bindingView.setNews(model);
    }
}
