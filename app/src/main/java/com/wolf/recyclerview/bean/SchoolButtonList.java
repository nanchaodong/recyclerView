package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.List;

/**
 * Created by nanchaodong on 2017/3/27.
 */

public class SchoolButtonList implements Visitable{
    public static final String TYPE = "SchoolButtonList";
    private List<SchoolButton> schoolButtonList;

    public SchoolButtonList(List<SchoolButton> schoolButtonList) {
        this.schoolButtonList = schoolButtonList;
    }

    public SchoolButtonList() {
    }

    public List<SchoolButton> getSchoolButtonList() {
        return schoolButtonList;
    }

    public void setSchoolButtonList(List<SchoolButton> schoolButtonList) {
        this.schoolButtonList = schoolButtonList;
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
