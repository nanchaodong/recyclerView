package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.List;

/**
 * Created by nanchaodong on 2017/4/24.
 */

public class RecyclerData<T> implements Visitable {
    private static final String TYPE = "RecyclerData";
    private List<T> data;

    public RecyclerData(List<T> data) {
        this.data = data;
    }

    public RecyclerData() {
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
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
