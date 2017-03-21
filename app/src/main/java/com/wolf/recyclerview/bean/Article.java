package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/3/3.
 */

public class Article implements Visitable {

    private String name;
    private String url;

    public Article(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Article() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public int type(TypeFactory typeFactory) {

        return typeFactory.type(this);
    }

    @Override
    public String type() {
        return "Article";
    }


}
