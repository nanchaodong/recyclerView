package com.wolf.recyclerview.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.databinding.FBaseBinding;

/**
 * Created by nanchaodong on 2017/3/20.
 */

public abstract class BaseFragment<SV extends ViewDataBinding> extends Fragment {
    private FBaseBinding fBaseBinding;
    protected SV bindView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fBaseBinding = DataBindingUtil.inflate(inflater, R.layout.f_base, null, false);
        bindView = DataBindingUtil.inflate(inflater, setLayout(), null, false);
        fBaseBinding.fContainer.addView(bindView.getRoot());
        return fBaseBinding.getRoot();
    }

    protected abstract int setLayout();
}
