package com.wolf.recyclerview.presenter;

import com.wolf.recyclerview.bean.BabyList;
import com.wolf.recyclerview.bean.Information;
import com.wolf.recyclerview.bean.Result;
import com.wolf.recyclerview.bean.School;
import com.wolf.recyclerview.bean.Shop;
import com.wolf.recyclerview.constant.Urls;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Url;
import rx.Observable;

/**
 * Created by nanchaodong on 2017/3/16.
 */
public interface RetrofitHttpClient {
    @GET(Urls.HOME_UIRL)
    Observable<Result<Information>> getHomeNews();

    @Multipart
    @POST(Urls.Country_url)
    Observable<Result<Information>> getCountryNews(@PartMap() Map<String, RequestBody> maps);

    @Multipart
    @POST
    Observable<Result<BabyList<Shop>>> getshop(@Url String url, @PartMap() Map<String, RequestBody> maps);

    @Multipart
    @POST
    Observable<Result<BabyList<School>>> getSchool(@Url String url, @PartMap() Map<String, RequestBody> maps);
}
