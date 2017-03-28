package com.wolf.recyclerview.holder;

import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.School;
import com.wolf.recyclerview.databinding.SchoolSubjectItemBinding;

/**
 * Created by nanchaodong on 2017/3/27.
 */

public class SchoolHolder extends BaseViewHolder<School,SchoolSubjectItemBinding> {
    public SchoolHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(School model, int position, BaseAdapter adapter) {
        bindingView.setSchool(model);
    }
}
