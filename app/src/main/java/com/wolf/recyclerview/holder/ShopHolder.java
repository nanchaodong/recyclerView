package com.wolf.recyclerview.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.ClassInfo;
import com.wolf.recyclerview.bean.Shop;
import com.wolf.recyclerview.databinding.ShopItemBinding;
import com.wolf.recyclerview.presenter.PresenterClick;
import com.wolf.recyclerview.utils.JumperManager;

/**
 * Created by nanchaodong on 2017/3/27.
 */

public class ShopHolder extends BaseViewHolder<Shop, ShopItemBinding> {
    private static final String TAG = "ShopHolder";


    public ShopHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setBean(Shop model, int position, BaseAdapter adapter) {
        bindingView.setShop(model);
        bindingView.setPresenter(click);

    }
    private PresenterClick click = new PresenterClick(){
        @Override
        public void clickToWeb(String url) {
            String path = url.replace("[VER]","4.6");
            JumperManager.showWebActivity(context, path);

        }
    };
}
