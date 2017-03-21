package com.wolf.recyclerview.adapter;

import android.content.Context;

import com.wolf.recyclerview.presenter.Visitable;

import java.security.Policy;
import java.util.List;

/**
 * Created by nanchaodong on 2017/3/7.
 */

public class CommonAdapter extends BaseAdapter {
    public CommonAdapter(Context context) {
        super(context);
    }

    @Override
    public void addData(List<Visitable> list, boolean flag) {
        if (flag) {
            this.list.addAll(list);
        } else {
            this.list = list;
        }
        notifyDataSetChanged();
    }
    public String getType(int postion){
        return list.get(postion).type();
    }
    public Visitable getBean(int position){
        return list.get(position);
    }

}
