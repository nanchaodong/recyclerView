package com.wolf.recyclerview.bean;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.wolf.recyclerview.BR;
import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/3/7.
 */

public class News extends BaseObservable implements Visitable {
    private String articleId;
    private String userId;
    private String title;
    private String readCount;
    private String shortContent;
    private String advertUrl;
    private String createTime;
    private String articleUrl;
    private int isActivity;
    private boolean isCollection;
    private int collum = 1;
    private int item_type = TYPE.left_type.ordinal();

    public News(String articleId, String userId, String title, String readCount, String shortContent, String advertUrl, String createTime, String articleUrl, int isActivity, boolean isCollection) {
        this.articleId = articleId;
        this.userId = userId;
        this.title = title;
        this.readCount = readCount;
        this.shortContent = shortContent;
        this.advertUrl = advertUrl;
        this.createTime = createTime;
        this.articleUrl = articleUrl;
        this.isActivity = isActivity;
        this.isCollection = isCollection;
    }

    public News() {

    }

    public int getItem_type() {
        return item_type;
    }

    public void setItem_type(int item_type) {
        this.item_type = item_type;
    }

    public int getCollum() {
        return collum;
    }

    public void setCollum(int collum) {
        this.collum = collum;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    @Bindable
    public String getReadCount() {
        return readCount;
    }


    public void setReadCount(String readCount) {
        this.readCount = readCount;
    }

    public String getShortContent() {
        return shortContent;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public String getAdvertUrl() {
        return advertUrl;
    }

    public void setAdvertUrl(String advertUrl) {
        this.advertUrl = advertUrl;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public void setArticleUrl(String articleUrl) {
        this.articleUrl = articleUrl;
    }

    public int getIsActivity() {
        return isActivity;
    }

    public void setIsActivity(int isActivity) {
        this.isActivity = isActivity;
    }

    public boolean isCollection() {
        return isCollection;
    }

    public void setCollection(boolean collection) {
        isCollection = collection;
    }

    public void addReadCount() {
        int readC = Integer.valueOf(this.readCount);
        readC++;
        this.readCount = readC + "";
        notifyPropertyChanged(BR.readCount);
    }

    @Override
    public int type(TypeFactory typeFactory) {
        return typeFactory.type(this);
    }

    @Override
    public String type() {
        return "News";
    }

    @Override
    public String toString() {
        return "News{" +
                "articleId='" + articleId + '\'' +
                ", userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", readCount='" + readCount + '\'' +
                ", shortContent='" + shortContent + '\'' +
                ", advertUrl='" + advertUrl + '\'' +
                ", createTime='" + createTime + '\'' +
                ", articleUrl='" + articleUrl + '\'' +
                ", isActivity=" + isActivity +
                ", isCollection=" + isCollection +
                '}';
    }

    public enum TYPE {
        left_type, right_type
    }
}
