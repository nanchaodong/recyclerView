package com.wolf.recyclerview.holder;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.wolf.recyclerview.activity.CountryActivity;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.Nation;
import com.wolf.recyclerview.databinding.ButtonItemBinding;
import com.wolf.recyclerview.presenter.PresenterClick;
import com.wolf.recyclerview.utils.JumperManager;

/**
 * Created by nanchaodong on 2017/3/7.
 */

public class ButtonHolder extends BaseViewHolder<Nation, ButtonItemBinding> {
    public ButtonHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(Nation model, int position, BaseAdapter adapter) {
        bindingView.setNation(model);
        bindingView.setPresenter(click);

    }

    private PresenterClick click = new PresenterClick() {
        @Override
        public void clickNationButton(View view, Nation nation) {
            Intent intent = new Intent(context, CountryActivity.class);
            context.startActivity(intent);
        }
    };
}
