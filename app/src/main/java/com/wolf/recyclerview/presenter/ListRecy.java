package com.wolf.recyclerview.presenter;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.wolf.recyclerview.adapter.CommonAdapter;
import com.wolf.recyclerview.presenter.Refresh;

/**
 * Created by nanchaodong on 2017/3/27.
 */

public abstract class ListRecy implements Refresh {
    private static final String TAG = "ListRecy";
    protected RecyclerView recyclerView;
    protected CommonAdapter adapter;
    protected SwipeRefreshLayout refreshLayout;
    protected boolean isLoading;
    protected int offset = 0;

    public ListRecy(RecyclerView r, SwipeRefreshLayout rs, CommonAdapter a, boolean hasFooter) {
        this.recyclerView = r;
        this.refreshLayout = rs;
        this.adapter = a;
        this.recyclerView.setAdapter(adapter);
        if (hasFooter) {
            this.adapter.ShowFooter(0);
        }
        addScrollListener();
        addRefresh();
    }

    private void addRefresh() {
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                isLoading = false;
                chageFooterState(0);
                down();
            }
        });
    }

    protected void chageLoadingState() {
        isLoading = false;
    }

    protected void chageFooterState(int id) {
        adapter.ShowFooter(id);
    }

    private void addScrollListener() {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager instanceof StaggeredGridLayoutManager) {
                    StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager) layoutManager;
                    manager.invalidateSpanAssignments();


                    int [] positions = manager.findFirstVisibleItemPositions(null);
                    int firstPostion = findMin(positions);
                    if (firstPostion == 0 || firstPostion == 1){
                        Log.i(TAG, "onScrollStateChanged: " + firstPostion);
//                        recyclerView.invalidateItemDecorations();
                    }

                }

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
                    int[] firstPositions = new int[manager.getSpanCount()];
                    manager.findLastVisibleItemPositions(lastPositions);

                    lastPosition = findMax(lastPositions);


                }

                if (dy > 0 && lastPosition == layoutManager.getItemCount() - 2) {
                    if (!isLoading) {
                        isLoading = true;
                        up();
                    }

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
    private int findMin(int [] positions){
        int min = positions[0];
        for (int position : positions) {
            if (min > position){
                min = position;
            }
        }
        return min;
    }
}
