package com.example;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/**
 * @author renhe
 *         监听ScrollView在Y轴滑动距离实现大众点评购买框悬浮效果
 */

public class FixedScrollView extends ScrollView {

    private OnScrollListener mScrollListener;

    public FixedScrollView(Context context) {
        super(context);
    }

    public FixedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FixedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected int computeVerticalScrollRange() {
        return super.computeVerticalScrollRange();
    }

    /**
     * 设置滚动监听
     *
     * @param listener {@link OnScrollListener}
     */
    public void setOnScrollListener(OnScrollListener listener) {
        this.mScrollListener = listener;
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mScrollListener != null) {
            mScrollListener.onScroll(t);
        }
    }

    interface OnScrollListener {

        /**
         * @param scrollY ScrollView在Y轴滑动的距离
         */
        void onScroll(int scrollY);
    }
}
