package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/3/24.
 */

public class Shop implements Visitable {
    public static final String TYPE = "Shop";
    private String id;
    private String url;
    private String name;
    private String is_rec;
    private Preface preface;
    private int jf;
    private int price;
    private int orig_price;
    private int sku;
    private int sold_cc;
    private int sold_cc_2;
    private int order_idx;

    public Shop(String id, String url, String name, String is_rec, Preface preface, int jf, int price, int orig_price, int sku, int sold_cc, int sold_cc_2, int order_idx) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.is_rec = is_rec;
        this.preface = preface;
        this.jf = jf;
        this.price = price;
        this.orig_price = orig_price;
        this.sku = sku;
        this.sold_cc = sold_cc;
        this.sold_cc_2 = sold_cc_2;
        this.order_idx = order_idx;
    }

    public Shop() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIs_rec() {
        return is_rec;
    }

    public void setIs_rec(String is_rec) {
        this.is_rec = is_rec;
    }

    public Preface getPreface() {
        return preface;
    }

    public void setPreface(Preface preface) {
        this.preface = preface;
    }

    public int getJf() {
        return jf;
    }

    public void setJf(int jf) {
        this.jf = jf;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrig_price() {
        return orig_price;
    }

    public void setOrig_price(int orig_price) {
        this.orig_price = orig_price;
    }

    public int getSku() {
        return sku;
    }

    public void setSku(int sku) {
        this.sku = sku;
    }

    public int getSold_cc() {
        return sold_cc;
    }

    public void setSold_cc(int sold_cc) {
        this.sold_cc = sold_cc;
    }

    public int getSold_cc_2() {
        return sold_cc_2;
    }

    public void setSold_cc_2(int sold_cc_2) {
        this.sold_cc_2 = sold_cc_2;
    }

    public int getOrder_idx() {
        return order_idx;
    }

    public void setOrder_idx(int order_idx) {
        this.order_idx = order_idx;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", is_rec='" + is_rec + '\'' +
                ", preface=" + preface +
                ", jf=" + jf +
                ", price=" + price +
                ", orig_price=" + orig_price +
                ", sku=" + sku +
                ", sold_cc=" + sold_cc +
                ", sold_cc_2=" + sold_cc_2 +
                ", order_idx=" + order_idx +
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
