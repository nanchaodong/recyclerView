package com.wolf.recyclerview.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.bean.NewsTag;
import com.wolf.recyclerview.bean.Transfer;
import com.wolf.recyclerview.databinding.ACountryBinding;
import com.wolf.recyclerview.presenter.Visitable;
import com.wolf.recyclerview.utils.HttpParams;
import com.wolf.recyclerview.utils.Task;

import java.util.List;

import rx.Subscriber;

/**
 * Created by nanchaodong on 2017/3/20.
 */

public class CountryActivity extends BaseActivity<ACountryBinding> {
    private HttpParams httpParams;
    private GridLayoutManager manager;
    private CommonAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_country);
        httpParams = new HttpParams();
        httpParams.setCountry("jp");
        httpParams.setCatId(0);
        httpParams.setPageSize(20);
        httpParams.setStartIndex(0);
        manager = new GridLayoutManager(this, 1);
        bindView.recyclerView.setLayoutManager(manager);
        adapter = new CommonAdapter(this);
        bindView.recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();
        Task.getInstance().getCountry(new Subscriber<List<Visitable>>() {
                                          @Override
                                          public void onCompleted() {

                                          }

                                          @Override
                                          public void onError(Throwable e) {

                                          }

                                          @Override
                                          public void onNext(List<Visitable> list) {
                                              adapter.addData(list, false);

                                          }
                                      }
                , httpParams.getBodyMap());
    }
}
