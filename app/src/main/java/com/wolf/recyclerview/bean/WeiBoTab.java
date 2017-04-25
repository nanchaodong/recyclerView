package com.wolf.recyclerview.bean;

import com.wolf.recyclerview.fragment.BaseFragment;
import com.wolf.recyclerview.fragment.WeiBoFindFragment;

/**
 * Created by nanchaodong on 2017/4/25.
 */

public class WeiBoTab {
    private String title;
    private BaseFragment fragment;

    public WeiBoTab(String title, BaseFragment fragment) {
        this.title = title;
        this.fragment = fragment;
    }

    public WeiBoTab() {
    }

    public WeiBoTab(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BaseFragment getFragment() {
        if (fragment == null) {
            fragment = new WeiBoFindFragment();
        }
        return fragment;
    }

    public void setFragment(BaseFragment fragment) {
        this.fragment = fragment;
    }
}
