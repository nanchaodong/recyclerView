package com.wolf.recyclerview.utils;

import com.google.gson.Gson;
import com.wolf.recyclerview.constant.Urls;
import com.wolf.recyclerview.presenter.RetrofitHttpClient;

import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.HTTP;

/**
 * Created by nanchaodong on 2017/3/16.
 */

public class HttpUtils {

    private static HttpUtils instance;
    private Gson gson;
    private Retrofit retrofit;
    private RetrofitHttpClient retrofitHttpClientService;

    private HttpUtils() {
        OkHttpClient.Builder okBuilder = new OkHttpClient.Builder();
        okBuilder.readTimeout(20, TimeUnit.SECONDS);
        okBuilder.writeTimeout(20, TimeUnit.SECONDS);
        okBuilder.connectTimeout(10, TimeUnit.SECONDS);

        OkHttpClient client = okBuilder.build();
        retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(Urls.URL_BASE)
                .build();
        retrofitHttpClientService = retrofit.create(RetrofitHttpClient.class);
    }

    public static HttpUtils getInstance() {
        if (instance == null) {
            synchronized (HttpUtils.class) {
                if (instance == null) {
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    public RetrofitHttpClient getRetrofitHttpClientService() {
        return retrofitHttpClientService;
    }


    public Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }
}
