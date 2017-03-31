package com.wolf.recyclerview.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.databinding.ABaseBinding;

/**
 * Created by nanchaodong on 2017/3/20.
 */

public abstract class BaseActivity<SV extends ViewDataBinding> extends AppCompatActivity {
    protected ABaseBinding aBaseBinding;
    protected SV bindView;
    private RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        aBaseBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.a_base, null, false);
        bindView = DataBindingUtil.inflate(getLayoutInflater(), layoutResID, null, false);
        aBaseBinding.aContainer.addView(bindView.getRoot(), lp);
        getWindow().setContentView(aBaseBinding.getRoot());

    }
}
