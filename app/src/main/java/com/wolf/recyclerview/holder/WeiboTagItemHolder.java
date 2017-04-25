package com.wolf.recyclerview.holder;

import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.WeiboTag;
import com.wolf.recyclerview.databinding.WeiboTagItemBinding;

/**
 * Created by nanchaodong on 2017/4/25.
 */

public class WeiboTagItemHolder extends BaseViewHolder<WeiboTag, WeiboTagItemBinding> {
    public WeiboTagItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(WeiboTag model, int position, BaseAdapter adapter) {
        bindingView.setWeiboTag(model);
        bindingView.setPosition(position);

    }
}
