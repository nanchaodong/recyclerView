package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.List;

/**
 * Created by nanchaodong on 2017/3/21.
 */

public class ButtonTitle implements Visitable {
    public static final String TYPE = "ButtonTitle";
    private List<Btn> btns;

    public ButtonTitle(List<Btn> btns) {
        this.btns = btns;
    }

    public ButtonTitle() {
    }

    public List<Btn> getBtns() {
        return btns;
    }

    public void setBtns(List<Btn> btns) {
        this.btns = btns;
    }

    @Override
    public String toString() {
        return "ButtonTitle{" +
                "btns=" + btns +
                '}';
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String type() {
        return null;
    }
}
