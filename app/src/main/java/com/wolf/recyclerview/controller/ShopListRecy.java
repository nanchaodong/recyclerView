package com.wolf.recyclerview.controller;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.bean.Result;
import com.wolf.recyclerview.bean.ShopList;
import com.wolf.recyclerview.presenter.ListRecy;
import com.wolf.recyclerview.presenter.Visitable;
import com.wolf.recyclerview.utils.HttpParams;
import com.wolf.recyclerview.utils.Task;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by nanchaodong on 2017/3/27.
 */

public class ShopListRecy extends ListRecy {
    private HttpParams httpParams;
    private int offset = 0;

    public ShopListRecy(RecyclerView r, SwipeRefreshLayout rs, CommonAdapter a, boolean hasFooter) {
        super(r, rs, a, hasFooter);
        httpParams = new HttpParams();
        httpParams.setPlatform("android");
        httpParams.setDevice_token("Asv4x7aECQJWsGxpchPIC6IOb_eX8qJDk2q7P1EWf0pE");
        httpParams.setVersion("4.6.0.0");
        httpParams.setOffset(offset + "");

    }


    @Override
    public void down() {
        offset = 0;
        httpParams.setOffset(offset + "");
        Task.getInstance().getShop(httpParams, new Subscriber<Result<ShopList>>() {
            @Override
            public void onCompleted() {
                refreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Result<ShopList> shopListResult) {
                List<Visitable> list = new ArrayList<Visitable>();
                list.addAll(shopListResult.getData().getList());
                adapter.addData(list, false);

            }
        });


    }

    @Override
    public void up() {
        offset += 10;
        httpParams.setOffset(offset + "");
        Task.getInstance().getShop(httpParams, new Subscriber<Result<ShopList>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                chageFooterState(1);

            }

            @Override
            public void onNext(Result<ShopList> shopListResult) {
                List<Visitable> list = new ArrayList<Visitable>();
                if (shopListResult.getData().getList() != null && shopListResult.getData().getList().size() > 0) {
                    list.addAll(shopListResult.getData().getList());
                    adapter.addData(list, true);
                    chageLoadingState();
                } else {
                    chageFooterState(2);
                    isLoading = true;
                }


            }
        });
    }
}
