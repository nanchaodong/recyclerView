package com.wolf.recyclerview.bean;

import java.util.List;

/**
 * Created by nanchaodong on 2017/3/16.
 */

public class Information {
    private List<Banner> topAdvs;
    private List<Nation> nation;
    private List<NewGroup> newsGroup;
    private List<NewsTag> topTags;
    private List<NewsTag> hotTags;
    private List<News> records;
    private List<Btn> buttons;

    public Information() {
    }

    public Information(List<Banner> topAdvs, List<Nation> nation, List<NewGroup> newsGroup, List<NewsTag> topTags, List<NewsTag> hotTags, List<News> records, List<Btn> buttons) {
        this.topAdvs = topAdvs;
        this.nation = nation;
        this.newsGroup = newsGroup;
        this.topTags = topTags;
        this.hotTags = hotTags;
        this.records = records;
        this.buttons = buttons;
    }

    public List<NewsTag> getHotTags() {
        return hotTags;
    }

    public void setHotTags(List<NewsTag> hotTags) {
        this.hotTags = hotTags;
    }

    public List<Btn> getButtons() {
        return buttons;
    }

    public void setButtons(List<Btn> buttons) {
        this.buttons = buttons;
    }

    public List<NewsTag> getTopTags() {
        return topTags;
    }

    public void setTopTags(List<NewsTag> topTags) {
        this.topTags = topTags;
    }


    public List<News> getRecords() {
        return records;
    }

    public void setRecords(List<News> records) {
        this.records = records;
    }

    public List<Banner> getTopAdvs() {
        return topAdvs;
    }

    public void setTopAdvs(List<Banner> topAdvs) {
        this.topAdvs = topAdvs;
    }

    public List<Nation> getNation() {
        return nation;
    }

    public void setNation(List<Nation> nation) {
        this.nation = nation;
    }

    public List<NewGroup> getNewsGroup() {
        return newsGroup;
    }

    public void setNewsGroup(List<NewGroup> newsGroup) {
        this.newsGroup = newsGroup;
    }

}
