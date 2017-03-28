package com.wolf.recyclerview.bean;

/**
 * Created by nanchaodong on 2017/3/27.
 */

public class SchoolButton {
    private int drawbleId;
    private String text;

    public SchoolButton(int drawbleId, String text) {
        this.drawbleId = drawbleId;
        this.text = text;
    }

    public int getDrawbleId() {
        return drawbleId;
    }

    public void setDrawbleId(int drawbleId) {
        this.drawbleId = drawbleId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "SchoolButton{" +
                "drawbleId=" + drawbleId +
                ", text='" + text + '\'' +
                '}';
    }
}
