package com.wolf.recyclerview.holder;

import android.content.Intent;
import android.view.View;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.ClassInfo;
import com.wolf.recyclerview.databinding.ClassItemBinding;
import com.wolf.recyclerview.presenter.PresenterClick;

/**
 * Created by nanchaodong on 2017/3/21.
 */

public class ClassItemHolder extends BaseViewHolder<ClassInfo, ClassItemBinding> {
    public ClassItemHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(ClassInfo model, int position, BaseAdapter adapter) {
        bindingView.setClassInfo(model);
        bindingView.setPresenter(click);
    }

    private PresenterClick click = new PresenterClick() {
        @Override
        public void clickClass(ClassInfo classInfo) {
            Intent intent = new Intent(context, classInfo.getaClass());
            context.startActivity(intent);
        }
    };
}
