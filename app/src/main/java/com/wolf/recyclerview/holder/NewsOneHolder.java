package com.wolf.recyclerview.holder;

import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.News;
import com.wolf.recyclerview.databinding.NewsItemOneBinding;
import com.wolf.recyclerview.presenter.PresenterClick;

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
        bindingView.setPresenter(click);
    }

    private PresenterClick click = new PresenterClick() {
        @Override
        public void clickNews(News news) {
            news.addReadCount();
        }
    };
}
