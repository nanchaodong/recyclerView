package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.List;

/**
 * Created by nanchaodong on 2017/3/16.
 */

public class Advert implements Visitable {
    public static final String TYPE = "Advert";
    private List<Banner> topAdvs;

    public Advert(List<Banner> topAdvs) {
        this.topAdvs = topAdvs;
    }

    public Advert() {
    }

    public List<Banner> getTopAdvs() {
        return topAdvs;
    }

    public void setTopAdvs(List<Banner> topAdvs) {
        this.topAdvs = topAdvs;
    }

    @Override
    public String toString() {
        return "Advert{" +
                "topAdvs=" + topAdvs +
                '}';
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
