package com.wolf.recyclerview.utils;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.bean.Advert;
import com.wolf.recyclerview.bean.Banner;
import com.wolf.recyclerview.bean.Btn;
import com.wolf.recyclerview.bean.ButtonTitle;
import com.wolf.recyclerview.bean.Information;
import com.wolf.recyclerview.bean.Nation;
import com.wolf.recyclerview.bean.NewGroup;
import com.wolf.recyclerview.bean.News;
import com.wolf.recyclerview.bean.NewsTag;
import com.wolf.recyclerview.bean.Result;
import com.wolf.recyclerview.bean.BabyList;
import com.wolf.recyclerview.bean.School;
import com.wolf.recyclerview.bean.Shop;
import com.wolf.recyclerview.bean.Title;
import com.wolf.recyclerview.bean.TopTag;
import com.wolf.recyclerview.presenter.HttpResultFunc;
import com.wolf.recyclerview.presenter.RetrofitHttpClient;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by nanchaodong on 2017/3/16.
 */

public class Task {
    private static Task instance;
    private RetrofitHttpClient retrofitHttpClient;

    private Task() {
        retrofitHttpClient = HttpUtils.getInstance().getRetrofitHttpClientService();
    }

    public static Task getInstance() {
        if (instance == null) {
            synchronized (Task.class) {
                if (instance == null) {
                    instance = new Task();
                }
            }
        }
        return instance;
    }

    private <T> void toSubscribe(Observable<T> o, Subscriber<T> s) {
        o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    public void getShopList(String url, HttpParams httpParams, Subscriber<BabyList<Shop>> subscriber) {
        Observable observable = retrofitHttpClient.getshop(url, httpParams.getOtherMap())
                .map(new Func1<Result<BabyList<Shop>>, BabyList<Shop>>() {

                    @Override
                    public BabyList<Shop> call(Result<BabyList<Shop>> babyListResult) {
                        return babyListResult.getData();
                    }
                });
        toSubscribe(observable, subscriber);
    }

    public void getSchoolList(String url, HttpParams httpParams, Subscriber<List<School>> subscriber) {
        Observable observable = retrofitHttpClient.getSchool(url, httpParams.getOtherMap())
                .map(new Func1<Result<BabyList<School>>, List<School>>() {
                    @Override
                    public List<School> call(Result<BabyList<School>> babyListResult) {
                        return babyListResult.getData().getList();
                    }
                });
        toSubscribe(observable, subscriber);
    }


    public void getCountry(Subscriber<List<Visitable>> subscriber, Map<String, RequestBody> map) {
        Observable observable = retrofitHttpClient.getCountryNews(map)
                .map(new HttpResultFunc<Information>())
                .map(new Func1<Information, List<Visitable>>() {


                         @Override
                         public List<Visitable> call(Information information) {
                             List<Visitable> list = new ArrayList<Visitable>();
                             List<Btn> buttons = information.getButtons();
                             if (buttons != null) {
                                 ButtonTitle buttonTitle = new ButtonTitle(buttons);
                                 list.add(buttonTitle);
                             }
                             List<Banner> banners = information.getTopAdvs();
                             if (banners != null) {
                                 Advert advert = new Advert(banners);
                                 list.add(advert);
                             }
                             List<NewsTag> hotTag = information.getHotTags();
                             if (hotTag != null) {
                                 TopTag topTag = new TopTag(hotTag);
                                 list.add(topTag);
                             }
                             List<News> records = information.getRecords();
                             if (records != null) {
                                 list.addAll(records);
                             }
                             return list;
                         }
                     }

                );
        toSubscribe(observable, subscriber);

    }

    public void getNewsHome(Subscriber<List<Visitable>> subscriber) {
        Observable observable = retrofitHttpClient.getHomeNews()
                .map(new HttpResultFunc<Information>())
                .map(new Func1<Information, List<Visitable>>() {

                    @Override
                    public List<Visitable> call(Information information) {
                        List<Visitable> list = new ArrayList<Visitable>();
                        List<Banner> topAdvs = information.getTopAdvs();
                        if (topAdvs != null) {
                            Advert advert = new Advert(topAdvs);
                            list.add(advert);
                        }
                        List<Nation> nations = information.getNation();
                        if (nations != null) {
                            list.addAll(nations);
                        }
                        List<NewGroup> newGroups = information.getNewsGroup();
                        for (int i = 0; i < newGroups.size(); i++) {
                            Title title = new Title();
                            title.setGroupName(newGroups.get(i).getGroupName());
                            title.setRefreshText(newGroups.get(i).getRefreshText());
                            List<News> news = newGroups.get(i).getRecords();
                            if (newGroups.get(i).getRefresh() == 0) {
                                title.setDrawableId(R.mipmap.right_arrow);
                                list.add(title);
                            } else {
                                title.setDrawableId(R.mipmap.refresh);
                                list.add(title);
                                for (int j = 0; j < news.size(); j++) {
                                    news.get(j).setCollum(2);
                                    if (j % 2 == 1) {
                                        news.get(i).setItem_type(News.TYPE.right_type.ordinal());
                                    }
                                }
                            }
                            list.addAll(news);
                        }

                        return list;
                    }
                });
        toSubscribe(observable, subscriber);
    }
}
