package com.wolf.recyclerview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.RecyclerData;
import com.wolf.recyclerview.bean.WeiBoChildTag;
import com.wolf.recyclerview.databinding.FWeiboFindBinding;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/4/25.
 */

public class WeiBoFindFragment extends BaseFragment<FWeiboFindBinding> {
    private BaseAdapter adapter;
    private GridLayoutManager manager;
    private List<WeiBoChildTag> tags;


    @Override
    protected int setLayout() {
        return R.layout.f_weibo_find;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new BaseAdapter(getActivity());
        manager = new GridLayoutManager(getActivity(), 1);
        bindView.recyclerView.setAdapter(adapter);
        bindView.recyclerView.setLayoutManager(manager);

        createTag();

    }

    private void createTag() {
        List<Visitable> list = new ArrayList<>();
        tags = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            WeiBoChildTag weiBoChildTag = new WeiBoChildTag("热点", false);
            tags.add(weiBoChildTag);
        }
        RecyclerData<WeiBoChildTag> data = new RecyclerData<>();
        data.setData(tags);
        list.add(data);
        adapter.addData(list, false);

    }

    public void changeVisible(boolean flag) {

        if (tags != null && tags.size() > 0){
            for (WeiBoChildTag tag : tags) {
                tag.setShow(flag);
            }
        }


    }
}
