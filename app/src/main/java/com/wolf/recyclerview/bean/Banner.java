package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

import org.w3c.dom.ProcessingInstruction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/3/7.
 */

public class Banner implements Visitable {
    private int advertId;
    private int articleId;
    private String articleTitle;
    private String imageurl;
    private String linkurl;
    private int type;

    public Banner(int advertId, int articleId, String articleTitle, String imageurl, String linkurl, int type) {
        this.advertId = advertId;
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.imageurl = imageurl;
        this.linkurl = linkurl;
        this.type = type;
    }

    public Banner() {
    }

    public int getAdvertId() {
        return advertId;
    }

    public void setAdvertId(int advertId) {
        this.advertId = advertId;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getLinkurl() {
        return linkurl;
    }

    public void setLinkurl(String linkurl) {
        this.linkurl = linkurl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String type() {
        return "Banner";
    }

    @Override
    public String toString() {
        return "Banner{" +
                "advertId=" + advertId +
                ", articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", linkurl='" + linkurl + '\'' +
                ", type=" + type +
                '}';
    }
}
