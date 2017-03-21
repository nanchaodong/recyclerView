package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/3/20.
 */

public class NewsTag implements Visitable{
    public static final String TYPE = "NewsTag";
    private String tagName;
    private int catId;
    private int tagId;
    private String country;
    private String name;

    public NewsTag(String tagName, int catId, int tagId, String country, String name) {
        this.tagName = tagName;
        this.catId = catId;
        this.tagId = tagId;
        this.country = country;
        this.name = name;
    }

    public NewsTag() {
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NewsTag{" +
                "tagName='" + tagName + '\'' +
                ", catId=" + catId +
                ", tagId=" + tagId +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
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
