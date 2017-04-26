package com.wolf.recyclerview.holder;

import android.media.Image;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.WeiBoButton;
import com.wolf.recyclerview.databinding.WeiboButtonItemBinding;
import com.wolf.recyclerview.presenter.PresenterClick;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/4/24.
 */

public class WeiboButtonHolder extends BaseViewHolder<WeiBoButton, WeiboButtonItemBinding> {
    private BaseAdapter mAdapter;
    private List<WeiBoButton> weiBoButtons = new ArrayList<WeiBoButton>();


    public WeiboButtonHolder(View itemView) {
        super(itemView);
        for (int i = 10; i < 14; i++) {
            WeiBoButton weiBoButton = new WeiBoButton(R.mipmap.ame, "招人" + i);
            weiBoButton.setId(i);
            weiBoButtons.add(weiBoButton);
        }
    }

    @Override
    public void setBean(WeiBoButton model, int position, BaseAdapter adapter) {
        mAdapter = adapter;
        bindingView.setWeiboButton(model);
        bindingView.setPresenter(click);


    }

    private PresenterClick click = new PresenterClick() {
        @Override
        public void click(View view, Visitable visitable) {
            WeiBoButton weiBoButton = (WeiBoButton) visitable;
            if (weiBoButton.getLoadType() == 1) {
                ImageView imageView = (ImageView) view.findViewById(R.id.image);
                boolean flag = weiBoButton.isShowMore();
                if (flag) {
                    mAdapter.addItems(weiBoButtons);
                    ViewHelper.setPivotX(imageView, imageView.getWidth() /2);
                    ViewHelper.setPivotY(imageView, imageView.getHeight() /2);
                    ViewPropertyAnimator.animate(imageView).rotation(180f)
                            .setDuration(350).start();


                } else {
                    mAdapter.removeItems(weiBoButtons);
                    ViewHelper.setPivotX(imageView, imageView.getWidth() /2);
                    ViewHelper.setPivotY(imageView, imageView.getHeight() /2);
                    ViewPropertyAnimator.animate(imageView).rotation(360f).setDuration(350).start();
                }
                weiBoButton.setShowMore(!flag);

            }

        }
    };
}
