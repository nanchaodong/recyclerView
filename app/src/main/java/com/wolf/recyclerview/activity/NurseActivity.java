package com.wolf.recyclerview.activity;

import android.graphics.Paint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.bean.Nurse;
import com.wolf.recyclerview.bean.Result;
import com.wolf.recyclerview.databinding.ACountryBinding;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/3/29.
 */

public class NurseActivity extends BaseActivity<ACountryBinding> {
    String json1 = "{data:[{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"}]}";
    String json2 = "{data:[{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"},{url:\"http://static.jiemodou.net//proc//News//Wap//images//app-icon-jp@2x.png\",name:\"宝宝体温\"}]}";
    private GridLayoutManager manager;
    private CommonAdapter adapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_country);
        Gson gson = new Gson();
        Result<List<Nurse>> result1 = gson.fromJson(json1, new TypeToken<Result<List<Nurse>>>() {
        }.getType());
        Result<List<Nurse>> result2 = gson.fromJson(json2, new TypeToken<Result<List<Nurse>>>() {
        }.getType());
        List<Visitable> list = new ArrayList<Visitable>();
        list.add(result1);
        list.add(result2);
        manager = new GridLayoutManager(this, 1);
        bindView.recyclerView.setLayoutManager(manager);
        adapter = new CommonAdapter(this);
        bindView.recyclerView.setAdapter(adapter);
        adapter.addData(list, false);

    }
}
