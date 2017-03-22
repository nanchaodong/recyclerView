package com.wolf.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.databinding.AFlowBinding;

/**
 * Created by nanchaodong on 2017/3/22.
 */

public class FlowActivity extends BaseActivity<AFlowBinding> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_flow);
    }
}
