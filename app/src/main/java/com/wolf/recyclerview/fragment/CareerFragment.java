package com.wolf.recyclerview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.databinding.ACountryBinding;
import com.wolf.recyclerview.presenter.Visitable;
import com.wolf.recyclerview.utils.HttpParams;
import com.wolf.recyclerview.utils.Task;

import java.util.List;

import rx.Subscriber;

/**
 * Created by nanchaodong on 2017/3/31.
 */

public class CareerFragment extends BaseFragment<ACountryBinding> {
    private HttpParams httpParams;
    private GridLayoutManager manager;
    private CommonAdapter adapter;
    @Override
    protected int setLayout() {
        return R.layout.a_country;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        httpParams = new HttpParams();
        httpParams.setCountry("jp");
        httpParams.setCatId(0);
        httpParams.setPageSize(20);
        httpParams.setStartIndex(0);
        manager = new GridLayoutManager(getActivity(), 1);
        bindView.recyclerView.setLayoutManager(manager);
        adapter = new CommonAdapter(getActivity());
        bindView.recyclerView.setAdapter(adapter);
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
