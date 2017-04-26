package com.wolf.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.databinding.AScaleBinding;

/**
 * Created by nanchaodong on 2017/4/25.
 */

public class ScaleActivity extends BaseActivity<AScaleBinding> {
    private String path = "http://img02.tooopen.com/images/20140504/sy_60294738471.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_scale);
        bindView.setPath(path);
        bindView.bigBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                big();
            }
        });
        bindView.smallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                small();
            }
        });
    }

    private void small() {
        ScaleAnimation animation = new ScaleAnimation(1.0f, 1.0f, 1.0f, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        bindView.imageView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bindView.imageView.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public void big(){
        ScaleAnimation animation = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        bindView.imageView.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
