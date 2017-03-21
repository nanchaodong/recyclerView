package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.List;

/**
 * Created by nanchaodong on 2017/3/20.
 */

public class TopTag implements Visitable {
    public static final String TYPE = "TopTag";
    private List<NewsTag> topTags;

    public TopTag(List<NewsTag> topTags) {
        this.topTags = topTags;
    }

    public TopTag() {
    }

    public List<NewsTag> getTopTags() {
        return topTags;
    }

    public void setTopTags(List<NewsTag> topTags) {
        this.topTags = topTags;
    }

    @Override
    public String toString() {
        return "TopTag{" +
                "topTags=" + topTags +
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
