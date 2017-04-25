package com.wolf.recyclerview.holder;

import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.Test;
import com.wolf.recyclerview.databinding.TestItemBinding;

/**
 * Created by nanchaodong on 2017/4/24.
 */

public class TestItemHolder extends BaseViewHolder<Test,TestItemBinding> {
    public TestItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(Test model, int position, BaseAdapter adapter) {

    }


}
