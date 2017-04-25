package com.wolf.recyclerview.holder;

import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.WeiboSearch;
import com.wolf.recyclerview.databinding.WeiboSearchItemBinding;

/**
 * Created by nanchaodong on 2017/4/25.
 */

public class WeiboSearchHolder extends BaseViewHolder<WeiboSearch, WeiboSearchItemBinding> {

    public WeiboSearchHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(WeiboSearch model, int position, BaseAdapter adapter) {
        bindingView.setWeiboSearch(model);

    }
}
