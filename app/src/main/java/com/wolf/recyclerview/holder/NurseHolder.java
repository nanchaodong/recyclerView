package com.wolf.recyclerview.holder;

import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.Nurse;
import com.wolf.recyclerview.databinding.NurseItemBinding;

/**
 * Created by nanchaodong on 2017/3/29.
 */

public class NurseHolder extends BaseViewHolder<Nurse, NurseItemBinding> {
    public NurseHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(Nurse model, int position, BaseAdapter adapter) {
        bindingView.setNurse(model);
    }
}
