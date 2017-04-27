package com.wolf.recyclerview.holder;

import android.view.View;
import android.widget.Toast;

import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.WeiBoPicture;
import com.wolf.recyclerview.databinding.WeiboPictureItemBinding;
import com.wolf.recyclerview.presenter.PresenterClick;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/4/26.
 */

public class WeiboPictureItemHolder extends BaseViewHolder<WeiBoPicture, WeiboPictureItemBinding> {


    public WeiboPictureItemHolder(View itemView) {
        super(itemView);


    }

    @Override
    public void setBean(WeiBoPicture model, int position, BaseAdapter adapter) {
        bindingView.setWeiboPicture(model);
        bindingView.setPresenter(click);


    }

    private PresenterClick click = new PresenterClick() {
        @Override
        public void click(View view, Visitable visitable) {

        }

    };
}
