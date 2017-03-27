package com.wolf.recyclerview.bean;

import java.util.List;

/**
 * Created by nanchaodong on 2017/3/27.
 */

public class ShopList {
    private List<Shop> list;

    public ShopList(List<Shop> list) {
        this.list = list;
    }

    public ShopList() {
    }

    public List<Shop> getList() {
        return list;
    }

    public void setList(List<Shop> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "ShopList{" +
                "list=" + list +
                '}';
    }
}
