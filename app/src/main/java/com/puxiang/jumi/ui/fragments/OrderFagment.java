package com.puxiang.jumi.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ksoichiro.android.observablescrollview.ObservableRecyclerView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.puxiang.jumi.R;
import com.puxiang.jumi.bean.OrderListItem;
import com.puxiang.jumi.ui.adapter.MyOrderAdapter;

import java.util.ArrayList;
import java.util.List;

import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;
import in.srain.cube.views.ptr.header.MaterialHeader;


/**
 *  Created by nick on 15/10/21.
 */
public class OrderFagment extends Fragment implements ObservableScrollViewCallbacks {

    private Toolbar mToolbar;
    private PtrFrameLayout frame;
    private MaterialHeader header;
    private ObservableRecyclerView mRecyclerView;
    private MyOrderAdapter mAdapter;
    private ObservableRecyclerView.LayoutManager mLayoutManager;
    //缓存
    private List<OrderListItem> mOrderListItems = new ArrayList<OrderListItem>();
    private int mCurrentPage = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_order,null);
        initViews(view);
        return view;
    }


    private void initViews(View view){

        Activity parentActivity = getActivity();

        mToolbar = (android.support.v7.widget.Toolbar) view.findViewById(R.id.toolbar);
        frame = (PtrFrameLayout) view.findViewById(R.id.ptr_frame);
        header = new MaterialHeader(parentActivity.getBaseContext());

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

        mRecyclerView = (ObservableRecyclerView) view.findViewById(R.id.my_order_recycler_view);
        mLayoutManager = new LinearLayoutManager(parentActivity);

        //mRecyclerView.setScrollViewCallbacks((ObservableScrollViewCallbacks) parentActivity);

        //mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setScrollViewCallbacks(this);
       // mRecyclerView.setItemAnimator(newDefaultItemAnimator());


        //设置adapter
//        mAdapter = new MyOrderAdapter(getActivity(),mOrderListItems);
//        mRecyclerView.setAdapter(mAdapter);


        //得到数据
        getNewsList(mAdapter, 0, false);
    }


    /**
     * 获取某一页的数据
     * @param adapter
     * @param currentPage 页码
     * @param forced      是否强制刷新
     */
    private void getNewsList(MyOrderAdapter adapter,int currentPage,boolean forced) {

        OrderListItem orderListItem1 = new OrderListItem();
        orderListItem1.setContent("测试");
        orderListItem1.setTitle("欧美办公室桌椅套餐1");
        orderListItem1.setPrice("￥38");
        orderListItem1.setStatus("1");
        orderListItem1.setDate("2015-10-26 10:33");
        mOrderListItems.add(orderListItem1);

        OrderListItem orderListItem2 = new OrderListItem();
        orderListItem2.setContent("测试");
        orderListItem2.setTitle("欧美办公室桌椅套餐2");
        orderListItem2.setPrice("￥58");
        orderListItem2.setStatus("2");
        orderListItem2.setDate("2015-10-20 14:29");
        mOrderListItems.add(orderListItem2);

        OrderListItem orderListItem3 = new OrderListItem();
        orderListItem3.setContent("测试");
        orderListItem3.setTitle("欧美办公室桌椅套餐1");
        orderListItem3.setPrice("￥48");
        orderListItem3.setStatus("2");
        orderListItem3.setDate("2015-10-16 19:54");
        mOrderListItems.add(orderListItem3);

        OrderListItem orderListItem4 = new OrderListItem();
        orderListItem4.setContent("测试");
        orderListItem4.setTitle("欧美办公室桌椅套餐1");
        orderListItem4.setPrice("￥48");
        orderListItem4.setStatus("2");
        orderListItem4.setDate("2015-10-16 19:54");
        mOrderListItems.add(orderListItem4);

        int total = mOrderListItems.size();
        //不强制刷新时，如果此页已存在则直接从内存中加载
        if (!forced && total>0 ){
            //mAdapter.addNews(mOrderListItems);
            mAdapter = new MyOrderAdapter(getActivity(),mOrderListItems);
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
//        ActionBar ab = getSupportActionBar();
//        if (ab == null) {
//            return;
//        }
//        if (scrollState == ScrollState.UP) {
//            if (ab.isShowing()) {
//                ab.hide();
//            }
//        } else if (scrollState == ScrollState.DOWN) {
//            if (!ab.isShowing()) {
//                ab.show();
//            }
//        }
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
    }

    //重写setMenuVisibility方法，不然会出现叠层的现象
    @Override
    public void setMenuVisibility(boolean menuVisibile) {
        super.setMenuVisibility(menuVisibile);
        if (this.getView() != null) {
            this.getView().setVisibility(menuVisibile ? View.VISIBLE : View.GONE);
        }
    }
}
