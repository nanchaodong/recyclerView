package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/3/7.
 */

public class Nation implements Visitable {
    private String name;
    private String nationPName;
    private String nationUrl;
    private String circleImageUrl;

    public Nation(String name, String nationPName, String nationUrl, String circleImageUrl) {
        this.name = name;
        this.nationPName = nationPName;
        this.nationUrl = nationUrl;
        this.circleImageUrl = circleImageUrl;
    }

    public Nation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationPName() {
        return nationPName;
    }

    public void setNationPName(String nationPName) {
        this.nationPName = nationPName;
    }

    public String getNationUrl() {
        return nationUrl;
    }

    public void setNationUrl(String nationUrl) {
        this.nationUrl = nationUrl;
    }

    public String getCircleImageUrl() {
        return circleImageUrl;
    }

    public void setCircleImageUrl(String circleImageUrl) {
        this.circleImageUrl = circleImageUrl;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String type() {
        return "Nation";
    }


}
