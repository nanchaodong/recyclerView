package com.wolf.recyclerview.bean;

/**
 * Created by nanchaodong on 2017/3/24.
 */

public class Preface {
    private String small;
    private String big;
    private String fixw;
    private String raw;

    public Preface(String small, String big, String fixw, String raw) {
        this.small = small;
        this.big = big;
        this.fixw = fixw;
        this.raw = raw;
    }

    public Preface() {
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getBig() {
        return big;
    }

    public void setBig(String big) {
        this.big = big;
    }

    public String getFixw() {
        return fixw;
    }

    public void setFixw(String fixw) {
        this.fixw = fixw;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Override
    public String toString() {
        return "Preface{" +
                "small='" + small + '\'' +
                ", big='" + big + '\'' +
                ", fixw='" + fixw + '\'' +
                ", raw='" + raw + '\'' +
                '}';
    }
}
