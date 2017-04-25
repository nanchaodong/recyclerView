package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/4/25.
 */

public class WeiboSearch implements Visitable {
    private static final String TYPE = "WeiboSearch";
    private int mipmapId;
    private String title;

    public WeiboSearch(int mipmapId, String title) {
        this.mipmapId = mipmapId;
        this.title = title;
    }

    public WeiboSearch() {
    }

    public int getMipmapId() {
        return mipmapId;
    }

    public void setMipmapId(int mipmapId) {
        this.mipmapId = mipmapId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
