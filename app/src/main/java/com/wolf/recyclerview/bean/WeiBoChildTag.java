package com.wolf.recyclerview.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wolf.recyclerview.BR;
import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/4/25.
 */

public class WeiBoChildTag extends BaseObservable implements Visitable {
    private static final String TYPE = "WeiBoChildTag";
    private String name;
    private boolean show;

    public WeiBoChildTag(String name, boolean show) {
        this.name = name;
        this.show = show;
    }

    public WeiBoChildTag() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Bindable
    public boolean isShow() {
        return show;
    }


    public void setShow(boolean show) {
        this.show = show;
        notifyPropertyChanged(BR.show);
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String type() {
        return TYPE;
    }
}
