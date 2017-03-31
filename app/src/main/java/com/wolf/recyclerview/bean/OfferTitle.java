package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.fragment.BaseFragment;

/**
 * Created by nanchaodong on 2017/3/31.
 */

public class OfferTitle {
    private String title;
    private BaseFragment fragment;

    public OfferTitle(String title, BaseFragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public OfferTitle() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BaseFragment getFragment() {
        return fragment;
    }

    public void setFragment(BaseFragment fragment) {
        this.fragment = fragment;
    }

    @Override
    public String toString() {
        return "OfferTitle{" +
                "title='" + title + '\'' +
                ", fragment=" + fragment +
                '}';
    }
}
