package com.wolf.recyclerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nanchaodong on 2017/3/22.
 * 自定义流式布局
 */

public class WrapAutoLayout extends ViewGroup {
    public WrapAutoLayout(Context context) {
        super(context);
    }

    public WrapAutoLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private List<List<View>> mAllView = new ArrayList<List<View>>();
    private List<Integer> mLineHeight = new ArrayList<Integer>();
    private List<Integer> mLineWidth = new ArrayList<Integer>();

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {
        mAllView.clear();
        mLineHeight.clear();
        int width = getWidth();
        int lineHeight = 0;
        int lineWidth = 0;
        List<View> lineViews = new ArrayList<View>();
        int cCount = getChildCount();
        for (int j = 0; j < cCount; j++) {
            View childView = getChildAt(j);
            MarginLayoutParams lp = (MarginLayoutParams) childView.getLayoutParams();
            int childWidth = childView.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = childView.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            if (childWidth + lineWidth > width) {//换行
                mLineHeight.add(lineHeight);
                mAllView.add(lineViews);
                mLineWidth.add((width - lineWidth) / 2);
                lineWidth = childWidth;
                lineViews = new ArrayList<View>();
                lineViews.add(childView);
            } else {
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
                lineViews.add(childView);
            }
            if (j == cCount - 1) {
                mLineWidth.add((width - lineWidth) / 2);
                mLineHeight.add(lineHeight);
                mAllView.add(lineViews);
            }
        }

        int top = 0;
        int lineNums = mAllView.size();
        for (int j = 0; j < lineNums; j++) {
            int left = mLineWidth.get(j);
            lineViews = mAllView.get(j);
            lineHeight = mLineHeight.get(i);
            for (int z = 0; z < lineViews.size(); z++) {
                View child = lineViews.get(z);
                if (child.getVisibility() == GONE) {
                    continue;
                }
                MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
                int lc = left + lp.leftMargin;
                int tc = top + lp.topMargin;
                int rc = lc + child.getMeasuredWidth();
                int bc = tc + child.getMeasuredHeight();
                child.layout(lc, tc, rc, bc);
                left += child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;

            }
            top += lineHeight;
        }


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeght = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        //如果是wrap_content 记录宽高
        int width = 0;
        int height = 0;
        /**
         * 记录每一行的宽度，width不断去最大值
         */
        int lineWidth = 0;
        /**
         * 记录每一行的高度 累加至height
         */
        int lineHeight = 0;
        int cCount = getChildCount();
        for (int i = 0; i < cCount; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            if (lineWidth + childWidth > sizeWidth) {
                width = Math.max(lineWidth, childWidth);
                lineWidth = childWidth;
                height += lineHeight;
                lineHeight = childHeight;
            } else {
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }
            if (i == cCount - 1) {
                width = Math.max(lineWidth, width);
                height += lineHeight;
            }
        }
        setMeasuredDimension((modeWidth == MeasureSpec.EXACTLY) ? sizeWidth : width, (modeHeight == MeasureSpec.EXACTLY) ? sizeHeght : height);

    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}
