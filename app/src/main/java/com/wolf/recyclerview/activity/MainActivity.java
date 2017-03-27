package com.wolf.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.bean.Advert;
import com.wolf.recyclerview.bean.News;
import com.wolf.recyclerview.bean.Title;
import com.wolf.recyclerview.databinding.ActivityMainBinding;
import com.wolf.recyclerview.presenter.Visitable;
import com.wolf.recyclerview.utils.Task;

import java.util.List;

import lib.homhomlib.design.SlidingLayout;
import rx.Subscriber;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private static final String TAG = "MainActivitysss";
    private GridLayoutManager manager;
    private CommonAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate: ");
        manager = new GridLayoutManager(this, 4);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (adapter.getType(position).equals(Advert.TYPE)) {
                    return manager.getSpanCount();
                } else if (adapter.getType(position).equals(Title.TYPE)) {
                    return manager.getSpanCount();
                } else if (adapter.getType(position).equals("News")) {
                    News news = (News) adapter.getBean(position);
                    if (news.getCollum() == 1) {
                        return manager.getSpanCount();
                    } else {
                        return 2;
                    }
                } else {
                    return 1;
                }
            }
        });
        adapter = new CommonAdapter(this);
        bindView.recyclerView.setLayoutManager(manager);
        bindView.recyclerView.setAdapter(adapter);
        bindView.slidingLayout.setSlidingListener(new SlidingLayout.SlidingListener() {
            @Override
            public void onSlidingOffset(View view, float delta) {
                Log.i(TAG, "onSlidingOffset: " + delta);
            }

            @Override
            public void onSlidingStateChange(View view, int state) {
            }

            @Override
            public void onSlidingChangePointer(View view, int pointerId) {
                Log.i(TAG, "onSlidingChangePointer: " + pointerId);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Task.getInstance().getNewsHome(new Subscriber<List<Visitable>>() {
            @Override
            public void onCompleted() {
                System.out.print("");

            }

            @Override
            public void onError(Throwable e) {
                System.out.print("");

            }

            @Override
            public void onNext(List<Visitable> visitables) {
                adapter.addData(visitables, false);
            }
        });
    }
}
