package com.puxiang.jumi.ui;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.puxiang.jumi.R;
import com.puxiang.jumi.ui.adapter.OrderDetailViewPagerAdapter;
import com.puxiang.jumi.view.SlidingTabLayout;
import com.puxiang.jumi.view.smartlayout.SmartTabLayout;
import com.rogers.kit.base.BaseActivity;

/**
 * Created by nick on 15/10/26.
 */
public class OrderDetailActivity extends BaseActivity {


    ViewPager pager;
    private String titles[] = new String[]{"订单状态", "订单详情"};
    private Toolbar toolbar;

    SlidingTabLayout slidingTabLayout;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_order_detail);
        initViews();
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.ic_back));
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setTitle("订单详情");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        pager = (ViewPager) findViewById(R.id.viewpager);


        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);

        pager.setAdapter(new OrderDetailViewPagerAdapter(getSupportFragmentManager(), titles));

        viewPagerTab.setViewPager(pager);

//        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
//        pager.setAdapter(new OrderDetailViewPagerAdapter(getSupportFragmentManager(), titles));
//
//        slidingTabLayout.setViewPager(pager);
//        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
//            @Override
//            public int getIndicatorColor(int position) {
//                return R.color.awesome_orange;
//            }
//        });
    }

}