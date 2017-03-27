package com.wolf.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.bean.Result;
import com.wolf.recyclerview.bean.ShopList;
import com.wolf.recyclerview.databinding.ASqBinding;
import com.wolf.recyclerview.presenter.Visitable;
import com.wolf.recyclerview.utils.ListRecy;
import com.wolf.recyclerview.utils.Task;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;

/**
 * Created by nanchaodong on 2017/3/24.
 */

public class SqActivity extends BaseActivity<ASqBinding> {
    private static final String TAG = "SqActivity";
    private CommonAdapter adapter;
    private StaggeredGridLayoutManager manager;
    private ListRecy listRecy;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_sq);
        adapter = new CommonAdapter(this);
        bindView.recyclerView.setBackgroundResource(R.color.common_color);
        manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        bindView.recyclerView.setAdapter(adapter);
        bindView.recyclerView.setLayoutManager(manager);
        listRecy = new ListRecy(bindView.recyclerView, adapter, true);

    }


    @Override
    protected void onResume() {
        super.onResume();
        Task.getInstance().getShop(new Subscriber<Result<ShopList>>() {
            @Override
            public void onCompleted() {
                System.out.print("");
            }

            @Override
            public void onError(Throwable e) {
                System.out.print("");

            }

            @Override
            public void onNext(Result<ShopList> shopListResult) {
                System.out.print("");
                List<Visitable> list = new ArrayList<Visitable>();
                list.addAll(shopListResult.getData().getList());
                adapter.addData(list, false);

            }
        });
    }
}
