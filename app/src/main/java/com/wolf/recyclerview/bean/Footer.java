package com.wolf.recyclerview.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wolf.recyclerview.BR;
import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/3/6.
 */

public class Footer extends BaseObservable implements Visitable {

    private int id;//0 加载中。。。 1 加载失败 2没有更多数据
    private String msg;
    private boolean status;

    public Footer() {
        this(0);
    }

    public Footer(int id) {
        this.id = id;
        switch (id) {
            case 0:
                msg = "加载中...";
                break;
            case 1:
                msg = "加载失败";
                break;
            case 2:
                msg = "没有更多数据";
                break;
        }

    }

    @Bindable
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
        notifyPropertyChanged(BR.status);
    }

    @Bindable
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
        status = true;
        notifyPropertyChanged(BR.status);
        switch (id) {
            case 0:
                msg = "加载中...";
                break;
            case 1:
                msg = "加载失败";
                break;
            case 2:
                msg = "没有更多数据";
                break;
        }
        notifyPropertyChanged(BR.msg);


    }

    @Bindable
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
        notifyPropertyChanged(BR.msg);
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String type() {
        return "Footer";
    }


}
