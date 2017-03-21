package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/3/21.
 */

public class ClassInfo implements Visitable {
    public static final String TYPE = "ClassInfo";
    private String className;
    private Class aClass;

    public ClassInfo(String className, Class aClass) {
        this.className = className;
        this.aClass = aClass;
    }

    public ClassInfo() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "className='" + className + '\'' +
                ", aClass=" + aClass +
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
