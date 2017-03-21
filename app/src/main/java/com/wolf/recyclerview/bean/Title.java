package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/3/7.
 */

public class Title implements Visitable {
    public static final String TYPE = "Title";
    private int groupId;
    private String groupName;
    private int refresh;
    private String refreshText;
    private String refreshUrl;
    private int catId;
    private int drawableId;

    public Title(int groupId, String groupName, int refresh, String refreshText, String refreshUrl, int catId) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.refresh = refresh;
        this.refreshText = refreshText;
        this.refreshUrl = refreshUrl;
        this.catId = catId;
    }

    public Title() {
    }

    public int getDrawableId() {
        return drawableId;
    }

    public void setDrawableId(int drawableId) {
        this.drawableId = drawableId;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getRefresh() {
        return refresh;
    }

    public void setRefresh(int refresh) {
        this.refresh = refresh;
    }

    public String getRefreshText() {
        return refreshText;
    }

    public void setRefreshText(String refreshText) {
        this.refreshText = refreshText;
    }

    public String getRefreshUrl() {
        return refreshUrl;
    }

    public void setRefreshUrl(String refreshUrl) {
        this.refreshUrl = refreshUrl;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    @Override
    public String toString() {
        return "Title{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", refresh=" + refresh +
                ", refreshText='" + refreshText + '\'' +
                ", refreshUrl='" + refreshUrl + '\'' +
                ", catId=" + catId +
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
