package com.wolf.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wolf.recyclerview.holder.BaseViewHolder;
import com.wolf.recyclerview.presenter.TypeFactoryList;
import com.wolf.recyclerview.presenter.Visitable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/3/3.
 */

public  class BaseAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final String TAG = "BaseAdapter222";
    protected List<Visitable> list;
    private Context mCtx;
    private TypeFactoryList typeFactoryList;
    private LayoutInflater inflater;

    public BaseAdapter(Context context) {
        this.mCtx = context;
        list = new ArrayList<Visitable>();
        typeFactoryList = new TypeFactoryList();
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public boolean isFooter(int position) {
        if (position == list.size() - 1) {
            return true;
        }
        return false;
    }
    public Context getmCtx(){
        return mCtx;
    }

    public void addData(List<Visitable> list, boolean flag) {
        if (flag) {
            this.list.remove(this.list.size() - 1);
            this.list.addAll(list);
        } else {
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = inflater.inflate(viewType, null, false);

        return typeFactoryList.createViewHolder(viewType, itemView);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {

        holder.setBean(list.get(position), position, this);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).type(typeFactoryList);
    }
}
