package com.puxiang.jumi.ui;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.puxiang.jumi.R;
import com.puxiang.jumi.bean.OrderListItem;
import com.puxiang.jumi.ui.adapter.ProductRecyclerAdapter;
import com.rogers.kit.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;

/**
 * Created by nick on 15/10/26.
 */
public class ProductListActivity extends BaseActivity implements ObservableScrollViewCallbacks {


    private Toolbar toolbar;
    private PtrFrameLayout frame;
    private MaterialHeader header;
    private ObservableRecyclerView mRecyclerView;
    private ProductRecyclerAdapter mAdapter;
    private ObservableRecyclerView.LayoutManager mLayoutManager;
    private List<OrderListItem> mOrderListItems = new ArrayList<OrderListItem>();
    private int mCurrentPage = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_product_list);
        initViews();
    }

    private void initViews() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toolbar.setNavigationIcon(getResources().getDrawable(R.mipmap.ic_back));
        if (toolbar != null) {
            //toolbar.setNavigationIcon(R.mipmap.ic_back);
            setSupportActionBar(toolbar);
        }
        getSupportActionBar().setTitle("产品列表");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        frame = (PtrFrameLayout) findViewById(R.id.ptr_frame);
        header = new MaterialHeader(getBaseContext());

        header.setPadding(0, 20, 0, 20);
        header.setPtrFrameLayout(frame);

        frame.setLoadingMinTime(1000);
        frame.setDurationToCloseHeader(300);
        frame.setHeaderView(header);
        frame.addPtrUIHandler(header);

        frame.setDurationToClose(100);
        frame.setPinContent(true);

        frame.setPtrHandler(new PtrHandler() {
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout ptrFrameLayout, View view, View view2) {
                return mRecyclerView.getCurrentScrollY() == 0;
            }

            @Override
            public void onRefreshBegin(final PtrFrameLayout ptrFrameLayout) {
                getNewsList(mAdapter, mCurrentPage, false);
                ptrFrameLayout.refreshComplete();
            }
        });

        mRecyclerView = (ObservableRecyclerView) findViewById(R.id.prod_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setScrollViewCallbacks(this);


        //得到数据
        getNewsList(mAdapter, 0, false);

    }


    /**
     * 获取某一页的数据
     * @param adapter
     * @param currentPage 页码
     * @param forced      是否强制刷新
     */
    private void getNewsList(ProductRecyclerAdapter adapter,int currentPage,boolean forced) {

        OrderListItem orderListItem1 = new OrderListItem();
        orderListItem1.setContent("原价￥988");
        orderListItem1.setTitle("欧美办公室桌椅套餐1");
        orderListItem1.setPrice("￥388");
        orderListItem1.setStatus("月销量2790单");
        mOrderListItems.add(orderListItem1);

        OrderListItem orderListItem2 = new OrderListItem();
        orderListItem2.setContent("原价￥1288");
        orderListItem2.setTitle("欧美办公室桌椅套餐2");
        orderListItem2.setPrice("￥588");
        orderListItem2.setStatus("月销量6832单");
        mOrderListItems.add(orderListItem2);

        OrderListItem orderListItem3 = new OrderListItem();
        orderListItem3.setContent("原价￥1088");
        orderListItem3.setTitle("欧美办公室桌椅套餐3");
        orderListItem3.setPrice("￥488");
        orderListItem3.setStatus("月销量3632单");
        mOrderListItems.add(orderListItem3);

        OrderListItem orderListItem4 = new OrderListItem();
        orderListItem4.setContent("原价￥1588");
        orderListItem4.setTitle("欧美办公室桌椅套餐");
        orderListItem4.setPrice("￥688");
        orderListItem4.setStatus("月销量1082单");
        mOrderListItems.add(orderListItem4);

        int total = mOrderListItems.size();
        //不强制刷新时，如果此页已存在则直接从内存中加载
        if (!forced && total>0 ){
            //mAdapter.addNews(mOrderListItems);
            mAdapter = new ProductRecyclerAdapter(this,mOrderListItems);
            mRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
            return;
        }

        if(forced && mOrderListItems.size()>0){
            mOrderListItems.clear();
        }
//        LoadNewsListTask loadDataTask = new LoadNewsListTask(adapter,mNewsType,forced);
//        loadDataTask.execute(currentPage);
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
//
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
    }


}