package com.wolf.recyclerview.holder;

import android.view.View;

import com.wolf.recyclerview.bean.Article;
import com.wolf.recyclerview.databinding.ArticleItemBinding;

/**
 * Created by nanchaodong on 2017/3/3.
 */

public class ArticleHolder extends BaseViewHolder<Article, ArticleItemBinding> {
    public ArticleHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void setBean(Article model, int position, com.wolf.recyclerview.adapter.BaseAdapter adapter) {
        bindingView.setArticle(model);

    }

}
