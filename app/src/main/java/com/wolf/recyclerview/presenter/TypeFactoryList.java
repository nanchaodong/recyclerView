package com.wolf.recyclerview.presenter;

import android.view.View;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.bean.Advert;
import com.wolf.recyclerview.bean.Article;
import com.wolf.recyclerview.bean.Banner;
import com.wolf.recyclerview.bean.Btn;
import com.wolf.recyclerview.bean.ButtonTitle;
import com.wolf.recyclerview.bean.Nation;
import com.wolf.recyclerview.bean.Footer;
import com.wolf.recyclerview.bean.NewGroup;
import com.wolf.recyclerview.bean.News;
import com.wolf.recyclerview.bean.NewsTag;
import com.wolf.recyclerview.bean.People;
import com.wolf.recyclerview.bean.Title;
import com.wolf.recyclerview.bean.TopTag;
import com.wolf.recyclerview.holder.ArticleHolder;
import com.wolf.recyclerview.holder.BannerHolder;
import com.wolf.recyclerview.holder.BaseViewHolder;
import com.wolf.recyclerview.holder.ButtonHeaderHolder;
import com.wolf.recyclerview.holder.ButtonHeaderItem;
import com.wolf.recyclerview.holder.ButtonHolder;
import com.wolf.recyclerview.holder.FooterHolder;

import com.wolf.recyclerview.holder.NewsOneHolder;
import com.wolf.recyclerview.holder.NewsTagHolder;
import com.wolf.recyclerview.holder.NewsTwoHolder;
import com.wolf.recyclerview.holder.PeopleHolder;
import com.wolf.recyclerview.holder.TitleHolder;

/**
 * Created by nanchaodong on 2017/3/3.
 */

public class TypeFactoryList implements TypeFactory {
    private final int article_item = R.layout.article_item;
    private final int people_item = R.layout.people_item;
    private final int footer_item = R.layout.footer_item;

    private final int banner_item = R.layout.banner_item;
    private final int button_item = R.layout.button_item;
    private final int title_item = R.layout.title_item;
    private final int news_item_one = R.layout.news_item_one;
    private final int news_item_two = R.layout.new_item_two;
    private final int button_header = R.layout.button_header;
    private final int button_header_item = R.layout.button_header_item;
    private final int new_top_item = R.layout.news_tag_iten;

    @Override

    public int type(Article article) {
        return article_item;
    }

    @Override
    public int type(People people) {
        return people_item;
    }

    @Override
    public int type(Footer footer) {
        return footer_item;
    }


    @Override
    public int type(Nation nation) {
        return button_item;
    }

    @Override
    public int type(Banner banner) {
        return banner_item;
    }

    @Override
    public int type(Title title) {
        return title_item;
    }

    @Override
    public int type(News news) {
        if (news.getCollum() == 1) {
            return news_item_one;
        } else {
            return news_item_two;
        }
    }


    @Override
    public int type(NewGroup newGroup) {
        return 0;
    }

    @Override
    public int type(Advert advert) {
        return banner_item;
    }

    @Override
    public int type(ButtonTitle buttonTitle) {
        return button_header;
    }

    @Override
    public int type(Btn btn) {
        return button_header_item;
    }

    @Override
    public int type(NewsTag newsTag) {
        return 0;
    }

    @Override
    public int type(TopTag topTag) {
        return new_top_item;
    }

    @Override
    public BaseViewHolder createViewHolder(int type, View itemView) {
        switch (type) {
            case article_item:
                return new ArticleHolder(itemView);
            case people_item:
                return new PeopleHolder(itemView);
            case footer_item:
                return new FooterHolder(itemView);
            case button_item:
                return new ButtonHolder(itemView);
            case banner_item:
                return new BannerHolder(itemView);
            case title_item:
                return new TitleHolder(itemView);
            case news_item_one:
                return new NewsOneHolder(itemView);
            case news_item_two:
                return new NewsTwoHolder(itemView);
            case button_header:
                return new ButtonHeaderHolder(itemView);
            case new_top_item:
                return new NewsTagHolder(itemView);
            case button_header_item:
                return new ButtonHeaderItem(itemView);
            default:
                return null;
        }
    }


}
