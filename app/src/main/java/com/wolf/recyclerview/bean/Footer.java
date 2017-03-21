package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/3/6.
 */

public class Footer implements Visitable {
    private int id;//0 加载中。。。 1 加载失败 2没有更多数据
    private String msg;

    public Footer() {
        this(0);
    }

    public Footer(int id) {
        this.id = id;
        switch (id) {
            case 0:
                msg = "加载中...";
                break;
            case 1:
                msg = "加载失败";
                break;
            case 2:
                msg = "没有更多数据";
                break;
        }

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String type() {
        return "Footer";
    }


}
