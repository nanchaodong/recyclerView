package com.wolf.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.databinding.ATextBinding;

/**
 * Created by nanchaodong on 2017/4/21.
 */

public class TestActivity extends BaseActivity<ATextBinding> {
    private String url = "http://pic6.huitu.com/res/20130116/84481_20130116142820494200_1.jpg";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_text);
    }
}
