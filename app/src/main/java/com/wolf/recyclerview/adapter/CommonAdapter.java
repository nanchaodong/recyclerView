package com.wolf.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;

import com.wolf.recyclerview.bean.Footer;
import com.wolf.recyclerview.holder.BaseViewHolder;
import com.wolf.recyclerview.presenter.Visitable;

import java.security.Policy;
import java.util.List;

/**
 * Created by nanchaodong on 2017/3/7.
 */

public class CommonAdapter extends BaseAdapter {
    private Footer footer;

    public CommonAdapter(Context context) {
        super(context);
        footer = new Footer();
    }

    @Override
    public void addData(List<Visitable> list, boolean flag) {
        this.list.remove(footer);
        if (flag) {
            this.list.addAll(list);
        } else {
            this.list = list;
        }
        this.list.add(footer);
        notifyDataSetChanged();
    }



    public void ShowFooter(int id) {
        footer.setId(id);
    }

    public String getType(int postion) {
        return list.get(postion).type();
    }

    public Visitable getBean(int position) {
        return list.get(position);
    }

    @Override
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp != null && lp instanceof StaggeredGridLayoutManager.LayoutParams) {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            int position = holder.getLayoutPosition();
            String type = getType(position);
            if (type.equals("Footer")) {
                p.setFullSpan(true);
            }


        }
    }
}
