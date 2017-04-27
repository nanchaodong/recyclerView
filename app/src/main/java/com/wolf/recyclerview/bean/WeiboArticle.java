package com.wolf.recyclerview.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wolf.recyclerview.BR;
import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.List;

/**
 * Created by nanchaodong on 2017/4/26.
 */

public class WeiboArticle extends BaseObservable implements Visitable {
    private static final String TYPE = "WeiboArticle";
    private String headUrl;
    private String userName;
    private String content;
    private String transpondCount;
    private String replyCount;
    private String praiseCount;
    private boolean isPraise;
    private List<WeiBoPicture> pictures;
    private String tagName;

    public WeiboArticle() {
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getTranspondCount() {
        return transpondCount;
    }

    public void setTranspondCount(String transpondCount) {
        this.transpondCount = transpondCount;
    }

    public String getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(String replyCount) {
        this.replyCount = replyCount;
    }

    public String getPraiseCount() {
        return praiseCount;
    }

    public void setPraiseCount(String praiseCount) {
        this.praiseCount = praiseCount;
    }

    @Bindable
    public boolean isPraise() {
        return isPraise;
    }

    public void setPraise(boolean praise) {
        isPraise = praise;
        notifyPropertyChanged(BR.praise);
    }

    public List<WeiBoPicture> getPictures() {
        return pictures;
    }

    public void setPictures(List<WeiBoPicture> pictures) {
        this.pictures = pictures;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
