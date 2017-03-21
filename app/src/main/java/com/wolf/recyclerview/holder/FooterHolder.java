package com.wolf.recyclerview.holder;

import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.Footer;
import com.wolf.recyclerview.databinding.FooterItemBinding;

/**
 * Created by nanchaodong on 2017/3/6.
 */

public class FooterHolder extends BaseViewHolder<Footer, FooterItemBinding> {
    public FooterHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(Footer model, int position, BaseAdapter adapter) {
        bindingView.setFooter(model);

    }
}
