package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/3/27.
 */

public class School implements Visitable {
    public static final String TYPE = "School";
    private String id;
    private Preface preface;
    private int price;
    private String end_at;
    private String score;
    private String reg_cc;
    private String zhuxuejin;
    private String subject;
    private String is_reg;

    public School(String id, Preface preface, int price, String end_at, String score, String reg_cc, String zhuxuejin, String subject, String is_reg) {
        this.id = id;
        this.preface = preface;
        this.price = price;
        this.end_at = end_at;
        this.score = score;
        this.reg_cc = reg_cc;
        this.zhuxuejin = zhuxuejin;
        this.subject = subject;
        this.is_reg = is_reg;
    }

    public School() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Preface getPreface() {
        return preface;
    }

    public void setPreface(Preface preface) {
        this.preface = preface;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getEnd_at() {
        return end_at;
    }

    public void setEnd_at(String end_at) {
        this.end_at = end_at;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getReg_cc() {
        return reg_cc;
    }

    public void setReg_cc(String reg_cc) {
        this.reg_cc = reg_cc;
    }

    public String getZhuxuejin() {
        return zhuxuejin;
    }

    public void setZhuxuejin(String zhuxuejin) {
        this.zhuxuejin = zhuxuejin;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getIs_reg() {
        return is_reg;
    }

    public void setIs_reg(String is_reg) {
        this.is_reg = is_reg;
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
        return "School{" +
                "id='" + id + '\'' +
                ", preface=" + preface +
                ", price=" + price +
                ", end_at='" + end_at + '\'' +
                ", score='" + score + '\'' +
                ", reg_cc='" + reg_cc + '\'' +
                ", zhuxuejin='" + zhuxuejin + '\'' +
                ", subject='" + subject + '\'' +
                ", is_reg='" + is_reg + '\'' +
                '}';
    }
}
