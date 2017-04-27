package com.wolf.recyclerview.holder;

import android.graphics.Rect;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wolf.recyclerview.R;
import com.wolf.recyclerview.adapter.BaseAdapter;
import com.wolf.recyclerview.bean.ClassInfo;
import com.wolf.recyclerview.bean.WeiBoPicture;
import com.wolf.recyclerview.bean.WeiboArticle;
import com.wolf.recyclerview.databinding.WeiboArticleItemBinding;
import com.wolf.recyclerview.presenter.PresenterClick;
import com.wolf.recyclerview.presenter.Visitable;
import com.wolf.recyclerview.utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/4/26.
 */

public class WeiboArticleItemHolder extends BaseViewHolder<WeiboArticle, WeiboArticleItemBinding> {
    private static final String TAG = "WeiboArticleItemHolder";
    private BaseAdapter mAdapter;
    private GridLayoutManager manager;
    private int imageDistance;
    private int recy3distance;
    private int recy2distance;


    public WeiboArticleItemHolder(View itemView) {
        super(itemView);
        mAdapter = new BaseAdapter(context);
        int screenDistance = ScreenUtils.getScreenWidth(context);
        int recyWidth = screenDistance - 2 * context.getResources().getDimensionPixelSize(R.dimen.d10);
        int recyWithOutPadding = recyWidth - 2 * context.getResources().getDimensionPixelSize(R.dimen.d5);
        imageDistance = recyWithOutPadding / 3;
        recy3distance = recyWidth;
        recy2distance = recy3distance - imageDistance - context.getResources().getDimensionPixelSize(R.dimen.d5);

    }

    @Override
    public void setBean(WeiboArticle model, int position, BaseAdapter adapter) {
        bindingView.setWeiboArticle(model);
        bindingView.setPresenter(click);
        bindingView.recyclerView.setNestedScrollingEnabled(false);
        List<WeiBoPicture> pictures = model.getPictures();
        ViewGroup.LayoutParams layoutParams = bindingView.recyclerView.getLayoutParams();
        if (pictures != null && pictures.size() > 1) {
            switch (pictures.size()) {
                case 2:
                case 4:
                    manager = new GridLayoutManager(context, 2){
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }

                        @Override
                        public boolean canScrollHorizontally() {
                            return false;
                        }
                    };

                    layoutParams.width = recy2distance;
                    bindingView.recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
                        @Override
                        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                            super.getItemOffsets(outRect, view, parent, state);
                            int index = parent.getChildAdapterPosition(view);
                            View top = view.findViewById(R.id.top);
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.container);
                            if (index == 0 || index == 1) {
                                top.setVisibility(View.GONE);
                            } else {
                                top.setVisibility(View.VISIBLE);

                            }
                            if (index % 2 == 0) {
                                linearLayout.setGravity(Gravity.LEFT);
                            } else {
                                linearLayout.setGravity(Gravity.RIGHT);
                            }


                        }
                    });
                    break;
                default:
                    bindingView.recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
                        @Override
                        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                            super.getItemOffsets(outRect, view, parent, state);
                            int index = parent.getChildAdapterPosition(view);
                            View top = view.findViewById(R.id.top);
                            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.container);
                            if (index == 0 || index == 1 || index == 2) {
                                top.setVisibility(View.GONE);
                            } else {
                                top.setVisibility(View.VISIBLE);
                            }
                            if (index % 3 == 0) {
                                linearLayout.setGravity(Gravity.LEFT);
                            } else if (index % 3 == 1) {
                                linearLayout.setGravity(Gravity.CENTER);
                            } else {
                                linearLayout.setGravity(Gravity.RIGHT);
                            }


                        }
                    });
                    manager = new GridLayoutManager(context, 3){
                        @Override
                        public boolean canScrollVertically() {
                            return false;
                        }

                        @Override
                        public boolean canScrollHorizontally() {
                            return false;
                        }
                    };
                    layoutParams.width = recy3distance;
                    break;

            }
            bindingView.recyclerView.setLayoutParams(layoutParams);
            bindingView.recyclerView.setAdapter(mAdapter);
            bindingView.recyclerView.setLayoutManager(manager);
            List<Visitable> visitables = new ArrayList<>();
            visitables.addAll(pictures);
            mAdapter.addData(visitables, false);

        }


    }

    private PresenterClick click = new PresenterClick() {
        @Override
        public void click(View view, Visitable visitable) {
            WeiboArticle article = (WeiboArticle) visitable;
            switch (view.getId()) {
                case R.id.send_lin:

                    break;
                case R.id.message_lin:

                    break;
                case R.id.praise_lin:
                    boolean flag = article.isPraise();
                    article.setPraise(!flag);
                    break;
            }
        }
    };
}
