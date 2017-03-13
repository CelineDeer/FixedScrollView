package com.example;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements FixedScrollView.OnScrollListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RelativeLayout mTopBuyLayout;
    private RelativeLayout mScrollBuyLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTopBuyLayout = (RelativeLayout) findViewById(R.id.layout_top_buy);
        mScrollBuyLayout = (RelativeLayout) findViewById(R.id.buy);
        final FixedScrollView scrollView = (FixedScrollView) findViewById(R.id.detail_scrollview);
        scrollView.setOnScrollListener(this);
        // 布局状态改变监听器，页面绘制完成会回调onGlobalLayout()方法
        // 手动调用onScroll()，此时ScrollView滑动距离为0，mTopBuyLayout调用layout方法
        // 此时两个购买框重合
        findViewById(R.id.parent).getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener() {
                    @Override
                    public void onGlobalLayout() {
                        onScroll(scrollView.getScrollY());
                    }
                });
    }

    @Override
    public void onScroll(int scrollY) {
        int scrollBuyLayout2Top = Math.max(scrollY, mScrollBuyLayout.getTop());
        mTopBuyLayout.layout(0, scrollBuyLayout2Top, mTopBuyLayout.getWidth(), scrollBuyLayout2Top
                + mTopBuyLayout.getHeight());
    }
}
