package com.wolf.recyclerview.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.databinding.ABaseBinding;

/**
 * Created by nanchaodong on 2017/3/20.
 */

public abstract class BaseActivity<SV extends ViewDataBinding> extends Activity {
    protected ABaseBinding aBaseBinding;
    protected SV bindView;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        aBaseBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.a_base, null, false);
        bindView = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);
        aBaseBinding.aContainer.addView(bindView.getRoot());
        getWindow().setContentView(aBaseBinding.getRoot());

    }
}
