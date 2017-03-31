package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/3/29.
 */

public class Nurse implements Visitable {
    private final String TYPE = "Nurse";

    private String url;
    private String name;

    public Nurse(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Nurse() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String type() {
        return TYPE;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "TYPE='" + TYPE + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
