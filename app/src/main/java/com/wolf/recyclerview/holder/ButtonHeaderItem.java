package com.wolf.recyclerview.holder;

import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.Btn;
import com.wolf.recyclerview.databinding.ButtonHeaderItemBinding;

/**
 * Created by nanchaodong on 2017/3/21.
 */

public class ButtonHeaderItem extends BaseViewHolder<Btn, ButtonHeaderItemBinding> {
    public ButtonHeaderItem(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(Btn model, int position, BaseAdapter adapter) {
        bindingView.setBtn(model);

    }
}
