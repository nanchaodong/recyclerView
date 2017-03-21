package com.wolf.recyclerview.holder;

import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.TopTag;
import com.wolf.recyclerview.databinding.NewsTagItenBinding;

/**
 * Created by nanchaodong on 2017/3/21.
 */

public class NewsTagHolder extends BaseViewHolder<TopTag, NewsTagItenBinding> {
    public NewsTagHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(TopTag model, int position, BaseAdapter adapter) {
        bindingView.setTopTag(model);
    }
}
