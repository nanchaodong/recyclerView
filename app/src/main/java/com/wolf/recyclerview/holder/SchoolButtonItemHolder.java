package com.wolf.recyclerview.holder;

import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.SchoolButtonList;
import com.wolf.recyclerview.databinding.SchoolButtonItemBinding;

/**
 * Created by nanchaodong on 2017/3/27.
 */

public class SchoolButtonItemHolder extends BaseViewHolder<SchoolButtonList, SchoolButtonItemBinding> {
    public SchoolButtonItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(SchoolButtonList model, int position, BaseAdapter adapter) {
        bindingView.setSchoolButtonList(model);
    }
}
