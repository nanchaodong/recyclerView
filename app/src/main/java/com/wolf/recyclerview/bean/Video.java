package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.presenter.TypeFactory;
import com.wolf.recyclerview.presenter.Visitable;

/**
 * Created by nanchaodong on 2017/3/21.
 */

public class Video implements Visitable{
    public static final String TYPE = "Video";
    private String videoUrl;
    private String imageUrl;

    public Video(String videoUrl, String imageUrl) {
        this.videoUrl = videoUrl;
        this.imageUrl = imageUrl;
    }

    public Video() {
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Video{" +
                "videoUrl='" + videoUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
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
