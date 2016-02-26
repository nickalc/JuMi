package com.puxiang.jumi.ui;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.puxiang.jumi.R;
import com.puxiang.jumi.view.SlidingTabLayout;
import com.rogers.kit.base.BaseActivity;

/**
 * Created by nick on 15/10/26.
 */
public class ProductDetailActivity extends BaseActivity {


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
        getSupportActionBar().setTitle("产品详情");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}