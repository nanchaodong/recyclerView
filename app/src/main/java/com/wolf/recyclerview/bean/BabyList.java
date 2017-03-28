package com.wolf.recyclerview.bean;

import java.util.List;

/**
 * Created by nanchaodong on 2017/3/27.
 */

public class BabyList<T> {
    private List<T> list;

    public BabyList(List<T> list) {
        this.list = list;
    }

    public BabyList() {
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "BabyList{" +
                "list=" + list +
                '}';
    }
}
