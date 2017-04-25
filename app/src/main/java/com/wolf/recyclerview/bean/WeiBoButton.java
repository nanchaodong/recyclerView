package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/4/24.
 */

public class WeiBoButton implements Visitable {
    private static final String TYPE = "WeiBoButton";
    private int mipmapId;
    private String name;
    private int type;
    private boolean showMore;
    private int id;

    public WeiBoButton(int mipmapId, String name) {
        this.mipmapId = mipmapId;
        this.name = name;
    }

    public WeiBoButton() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLoadType(int type){
        this.type = type;
    }
    public int getLoadType(){
        return type;
    }

    public boolean isShowMore() {
        return showMore;
    }

    public void setShowMore(boolean showMore) {
        this.showMore = showMore;
    }

    public int getMipmapId() {
        return mipmapId;
    }

    public void setMipmapId(int mipmapId) {
        this.mipmapId = mipmapId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String type() {
        return TYPE;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj){
//            return true;
//        }
//        if (obj == null || getClass() != obj.getClass()){
//            return false;
//        }
//        WeiBoButton weiBoButton = (WeiBoButton) obj;
//        return id != -1 ? id == weiBoButton.id : weiBoButton.id == -1;
//
//    }
}
