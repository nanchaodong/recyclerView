package com.wolf.recyclerview.holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.Shop;
import com.wolf.recyclerview.databinding.ShopItemBinding;

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
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        int top = context.getResources().getDimensionPixelSize(R.dimen.d20);
        int left = position % 2 == 0 ? context.getResources().getDimensionPixelSize(R.dimen.d20) : context.getResources().getDimensionPixelSize(R.dimen.d5);
        int right = position % 2 == 0 ? context.getResources().getDimensionPixelSize(R.dimen.d5) : context.getResources().getDimensionPixelSize(R.dimen.d20);
        int bottom = 0;
        lp.setMargins(left, top, right, bottom);
        bindingView.itemContainer.setLayoutParams(lp);

    }
}
