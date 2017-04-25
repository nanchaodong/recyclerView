package com.wolf.recyclerview.presenter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.wolf.recyclerview.bean.Advert;
import com.wolf.recyclerview.bean.Article;
import com.wolf.recyclerview.bean.Banner;
import com.wolf.recyclerview.bean.Btn;
import com.wolf.recyclerview.bean.ButtonTitle;
import com.wolf.recyclerview.bean.ClassInfo;
import com.wolf.recyclerview.bean.Footer;
import com.wolf.recyclerview.bean.Nation;
import com.wolf.recyclerview.bean.NewGroup;
import com.wolf.recyclerview.bean.News;
import com.wolf.recyclerview.bean.NewsTag;
import com.wolf.recyclerview.bean.Nurse;
import com.wolf.recyclerview.bean.People;
import com.wolf.recyclerview.bean.RecyclerData;
import com.wolf.recyclerview.bean.Result;
import com.wolf.recyclerview.bean.School;
import com.wolf.recyclerview.bean.SchoolButtonList;
import com.wolf.recyclerview.bean.Shop;
import com.wolf.recyclerview.bean.Test;
import com.wolf.recyclerview.bean.Title;
import com.wolf.recyclerview.bean.TopTag;
import com.wolf.recyclerview.bean.Video;
import com.wolf.recyclerview.bean.WeiBoButton;
import com.wolf.recyclerview.bean.WeiBoChildTag;
import com.wolf.recyclerview.bean.WeiboSearch;
import com.wolf.recyclerview.bean.WeiboTag;
import com.wolf.recyclerview.controller.SchoolListRecy;
import com.wolf.recyclerview.holder.BaseViewHolder;

/**
 * Created by nanchaodong on 2017/3/3.
 */

public interface TypeFactory {

    int type(Article article);

    int type(People people);

    int type(Footer footer);

    int type(Nation nation);

    int type(Banner banner);

    int type(Title title);

    int type(News news);

    int type(NewGroup newGroup);

    int type(Advert advert);

    int type(ButtonTitle buttonTitle);

    int type(Btn btn);

    int type(NewsTag newsTag);

    int type(TopTag topTag);

    int type(Video video);

    int type(ClassInfo classInfo);

    int type(Shop shop);

    int type(School school);

    int type(SchoolButtonList schoolButtonList);

    int type(Nurse nurse);

    int type(Result result);

    int type(Test test);

    int type(RecyclerData recyclerData);

    int type(WeiBoButton weiBoButton);

    int type(WeiboTag weiboTag);

    int type(WeiboSearch weiboSearch);

    int type(WeiBoChildTag weiBoChildTag);

    BaseViewHolder createViewHolder(int type, View itemView);
}
