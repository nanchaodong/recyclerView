package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.Visitable;

import java.util.List;

/**
 * Created by nanchaodong on 2017/3/20.
 */

public class Transfer<T> {
    private List<Visitable> visitables;
    private T t;

    public Transfer(List<Visitable> visitables, T t) {
        this.visitables = visitables;
        this.t = t;
    }

    public Transfer() {
    }

    public List<Visitable> getVisitables() {
        return visitables;
    }

    public void setVisitables(List<Visitable> visitables) {
        this.visitables = visitables;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "visitables=" + visitables +
                ", t=" + t +
                '}';
    }
}
