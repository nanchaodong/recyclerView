package com.wolf.recyclerview.utils;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.wolf.recyclerview.adapter.CommonAdapter;

/**
 * Created by nanchaodong on 2017/3/27.
 */

public class ListRecy {
    private static final String TAG = "ListRecy";
    private RecyclerView recyclerView;
    private CommonAdapter adapter;


    public ListRecy(RecyclerView r, CommonAdapter a, boolean hasFooter) {
        this.recyclerView = r;
        this.adapter = a;
        if (hasFooter){
            this.adapter.ShowFooter(0);
        }
        addScrollListener();

    }

    private void addScrollListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastPosition = -1;
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof GridLayoutManager) {
                    GridLayoutManager manager = (GridLayoutManager) layoutManager;
                    lastPosition = manager.findLastVisibleItemPosition();
                }
                if (layoutManager instanceof LinearLayoutManager) {
                    LinearLayoutManager manager = (LinearLayoutManager) layoutManager;
                    lastPosition = manager.findLastVisibleItemPosition();
                }
                if (layoutManager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager) layoutManager;
                    int[] lastPositions = new int[manager.getSpanCount()];
                    manager.findLastVisibleItemPositions(lastPositions);
                    lastPosition = findMax(lastPositions);
                }
                if (dy > 0 && lastPosition == layoutManager.getItemCount() - 2) {
                    Log.i(TAG, "onScrolled: " + lastPosition);
                }
            }
        });
    }

    private int findMax(int[] lastPositions) {

        int max = lastPositions[0];
        for (int lastPosition : lastPositions) {
            if (lastPosition > max) {
                max = lastPosition;
            }
        }
        return max;
    }

}
