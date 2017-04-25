package com.wolf.recyclerview.holder;

import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.WeiBoChildTag;
import com.wolf.recyclerview.databinding.WeiboChildTagItemBinding;

/**
 * Created by nanchaodong on 2017/4/25.
 */

public class WeiBoChilTagItemHolder extends BaseViewHolder<WeiBoChildTag, WeiboChildTagItemBinding> {
    public WeiBoChilTagItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(WeiBoChildTag model, int position, BaseAdapter adapter) {
        bindingView.setWeiBoChildTag(model);

    }


}
