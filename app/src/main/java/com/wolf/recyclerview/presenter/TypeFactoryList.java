package com.wolf.recyclerview.presenter;

import android.drm.DrmStore;
import android.view.View;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.bean.Advert;
import com.wolf.recyclerview.bean.Article;
import com.wolf.recyclerview.bean.Banner;
import com.wolf.recyclerview.bean.Btn;
import com.wolf.recyclerview.bean.ButtonTitle;
import com.wolf.recyclerview.bean.ClassInfo;
import com.wolf.recyclerview.bean.Nation;
import com.wolf.recyclerview.bean.Footer;
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
import com.wolf.recyclerview.holder.ArticleHolder;
import com.wolf.recyclerview.holder.BannerHolder;
import com.wolf.recyclerview.holder.BaseViewHolder;
import com.wolf.recyclerview.holder.ButtonHeaderHolder;
import com.wolf.recyclerview.holder.ButtonHeaderItem;
import com.wolf.recyclerview.holder.ButtonHolder;
import com.wolf.recyclerview.holder.ClassItemHolder;
import com.wolf.recyclerview.holder.FooterHolder;

import com.wolf.recyclerview.holder.NewsOneHolder;
import com.wolf.recyclerview.holder.NewsTagHolder;
import com.wolf.recyclerview.holder.NewsTwoHolder;
import com.wolf.recyclerview.holder.NurseHolder;
import com.wolf.recyclerview.holder.PeopleHolder;
import com.wolf.recyclerview.holder.RecyHolder;
import com.wolf.recyclerview.holder.RecyclerHolder;
import com.wolf.recyclerview.holder.SchoolButtonItemHolder;
import com.wolf.recyclerview.holder.SchoolHolder;
import com.wolf.recyclerview.holder.ShopHolder;
import com.wolf.recyclerview.holder.TestItemHolder;
import com.wolf.recyclerview.holder.TitleHolder;
import com.wolf.recyclerview.holder.VideoItemHolder;
import com.wolf.recyclerview.holder.WeiBoChilTagItemHolder;
import com.wolf.recyclerview.holder.WeiboButtonHolder;
import com.wolf.recyclerview.holder.WeiboSearchHolder;
import com.wolf.recyclerview.holder.WeiboTagItemHolder;

import java.util.List;

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
    private final int class_item = R.layout.class_item;
    private final int video_item = R.layout.video_item;
    private final int shop_item = R.layout.shop_item;
    private final int school_subject_item = R.layout.school_subject_item;
    private final int school_button_item = R.layout.school_button_item;
    private final int reycler_item = R.layout.a_country;
    private final int nurse_item = R.layout.nurse_item;
    private final int test_item = R.layout.test_item;
    private final int recycler_layout_item = R.layout.recycler_layout;
    private final int weibo_button_item = R.layout.weibo_button_item;
    private final int weibo_tag_item = R.layout.weibo_tag_item;
    private final int weibo_search_item = R.layout.weibo_search_item;
    private final int weibo_child_tag_item = R.layout.weibo_child_tag_item;

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
    public int type(Video video) {
        return video_item;
    }

    @Override
    public int type(ClassInfo classInfo) {
        return class_item;
    }

    @Override
    public int type(Shop shop) {
        return shop_item;
    }

    @Override
    public int type(School school) {
        return school_subject_item;
    }

    @Override
    public int type(SchoolButtonList schoolButtonList) {
        return school_button_item;
    }

    @Override
    public int type(Nurse nurse) {
        return nurse_item;
    }

    @Override
    public int type(Result result) {
        if (result.getData() instanceof List) {
            List list = (List) result.getData();
            if (list.get(0) instanceof Nurse) {
                return reycler_item;

            }
        }
        return -1;
    }

    @Override
    public int type(Test test) {
        return test_item;
    }

    @Override
    public int type(RecyclerData recyclerData) {
        return recycler_layout_item;
    }

    @Override
    public int type(WeiBoButton weiBoButton) {
        return weibo_button_item;
    }

    @Override
    public int type(WeiboTag weiboTag) {
        return weibo_tag_item;
    }

    @Override
    public int type(WeiboSearch weiboSearch) {
        return weibo_search_item;
    }

    @Override
    public int type(WeiBoChildTag weiBoChildTag) {
        return weibo_child_tag_item;
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
            case class_item:
                return new ClassItemHolder(itemView);
            case video_item:
                return new VideoItemHolder(itemView);
            case shop_item:
                return new ShopHolder(itemView);
            case school_subject_item:
                return new SchoolHolder(itemView);
            case school_button_item:
                return new SchoolButtonItemHolder(itemView);
            case reycler_item:
                return new RecyclerHolder(itemView);
            case nurse_item:
                return new NurseHolder(itemView);
            case test_item:
                return new TestItemHolder(itemView);
            case weibo_button_item:
                return new WeiboButtonHolder(itemView);
            case recycler_layout_item:
                return new RecyHolder(itemView);
            case weibo_tag_item:
                return new WeiboTagItemHolder(itemView);
            case weibo_search_item:
                return new WeiboSearchHolder(itemView);
            case weibo_child_tag_item:
                return new WeiBoChilTagItemHolder(itemView);
            default:
                return null;
        }
    }


}
