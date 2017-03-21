package com.wolf.recyclerview.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.bean.Advert;
import com.wolf.recyclerview.bean.News;
import com.wolf.recyclerview.bean.Title;
import com.wolf.recyclerview.databinding.ActivityMainBinding;
import com.wolf.recyclerview.presenter.Visitable;
import com.wolf.recyclerview.utils.Task;

import java.util.List;

import rx.Subscriber;

public class MainActivity extends BaseActivity<ActivityMainBinding> {
    private GridLayoutManager manager;
    private CommonAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = new GridLayoutManager(this, 4);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (adapter.getType(position).equals(Advert.TYPE)){
                    return manager.getSpanCount();
                }else if (adapter.getType(position).equals(Title.TYPE)){
                    return manager.getSpanCount();
                }else if (adapter.getType(position).equals("News")){
                    News news = (News) adapter.getBean(position);
                    if (news.getCollum() == 1){
                        return manager.getSpanCount();
                    }else {
                        return 2;
                    }
                }
                else {
                    return 1;
                }
            }
        });
        adapter = new CommonAdapter(this);
        bindView.recyclerView.setLayoutManager(manager);
        bindView.recyclerView.setAdapter(adapter);
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
