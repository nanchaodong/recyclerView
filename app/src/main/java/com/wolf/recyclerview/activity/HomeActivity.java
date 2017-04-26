package com.wolf.recyclerview.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.bean.ClassInfo;
import com.wolf.recyclerview.controller.SchoolListRecy;
import com.wolf.recyclerview.databinding.ActivityMainBinding;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by nanchaodong on 2017/3/21.
 */

public class HomeActivity extends BaseActivity<ActivityMainBinding> {
    private CommonAdapter adapter;
    private GridLayoutManager manager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Visitable> list = new ArrayList<Visitable>();
        list.add(new ClassInfo("多样化recyclerView列表", MainActivity.class));
        list.add(new ClassInfo("视屏列表", VideoActivity.class));
        list.add(new ClassInfo("流失布局", FlowActivity.class));
        list.add(new ClassInfo("瀑布流", SqActivity.class));
        list.add(new ClassInfo("web", WebActivity.class));
        list.add(new ClassInfo("学科", SchoolActivity.class));
        list.add(new ClassInfo("输入验证码", CodeActivity.class));
        list.add(new ClassInfo("列表嵌套列表", NurseActivity.class));
        list.add(new ClassInfo("offer", OfferActivity.class));
        list.add(new ClassInfo("scroll", ScroolActivity.class));
        list.add(new ClassInfo("text", TestActivity.class));
        list.add(new ClassInfo("WeiBoFindActivity", WeiBoFindActivity.class));
        list.add(new ClassInfo("ScaleActivity", ScaleActivity.class));
        adapter = new CommonAdapter(this);
        bindView.recyclerView.setAdapter(adapter);
        manager = new GridLayoutManager(this, 1);
        bindView.recyclerView.setLayoutManager(manager);
        adapter.addData(list, false);
        


    }
}
