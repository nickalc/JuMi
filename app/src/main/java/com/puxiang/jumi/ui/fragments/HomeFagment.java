package com.puxiang.jumi.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.puxiang.jumi.R;
import com.puxiang.jumi.base.App;
import com.puxiang.jumi.bean.Engine;
import com.puxiang.jumi.ui.ProductListActivity;
import com.puxiang.jumi.ui.adapter.HomeMenuAdapter;
import com.puxiang.jumi.ui.adapter.HomeViewPagerAdapter;
import com.viewpagerindicator.LinePageIndicator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.bgabanner.BGABanner;


/**
 * Created by nick on 15/10/21.
 */
public class HomeFagment extends Fragment {

    private BGABanner mDefaultBanner;
    private List<View> mDefaultViews;
    private LinePageIndicator mIndicator;
    private ViewPager viewPager;
    private Engine mEngine;
    private static int APP_PAGE_SIZE = 8;
    private ArrayList<GridView> array;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        mEngine = App.getInstance().getEngine();

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);

        initDefault(view);
        initViews(view);
        return view;
    }

    private void initDefault(View view) {
        mDefaultBanner = (BGABanner) view.findViewById(R.id.banner_main_default);
        mDefaultViews = getViews(5);
        mDefaultBanner.setViews(mDefaultViews);

       // BannerModel bannerModel = new BannerModel();
        List<String> imgs = new ArrayList<String>();
        imgs.add("http://120.25.164.72/resources/index_banner.png");
        imgs.add("http://120.25.164.72/resources/index_banner.png");
        imgs.add("http://120.25.164.72/resources/index_banner.png");
        imgs.add("http://120.25.164.72/resources/index_banner.png");
        imgs.add("http://120.25.164.72/resources/index_banner.png");

        List<String> tips = new ArrayList<String>();
        tips.add("梦想家居");
        tips.add("梦想家居");
        tips.add("梦想家居");
        tips.add("梦想家居");
        tips.add("梦想家居");

//        mEngine.fiveItem().enqueue(new Callback<BannerModel>() {
//            @Override
//            public void onResponse(retrofit.Response<BannerModel> response) {
//                BannerModel bannerModel = response.body();
                SimpleDraweeView simpleDraweeView;
                for (int i = 0; i < mDefaultViews.size(); i++) {
                    simpleDraweeView = (SimpleDraweeView) mDefaultViews.get(i);
                    simpleDraweeView.setImageURI(Uri.parse(imgs.get(i)));

                    // 为每一页添加点击事件
                    final int finalPosition = i;
                    simpleDraweeView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                          //  Toast.makeText(App.getInstance(), "点击了第" + (finalPosition + 1) + "页", Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(getActivity(), ProductListActivity.class);
                            getActivity().startActivity(intent);
                        }
                    });
                }
                mDefaultBanner.setTips(tips);
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//           }
//        });
    }


    public void initViews(View view) {

        viewPager = (ViewPager)view.findViewById(R.id.myviewpager);

//        final PackageManager packageManager = getActivity().getPackageManager();
//        final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
//        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//        // get all apps
//        final List<ResolveInfo> apps = packageManager.queryIntentActivities(mainIntent, 0);
//        // the total pages
//        final int PageCount = (int)Math.ceil(apps.size()/APP_PAGE_SIZE);


        final List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();

        HashMap<String,Object> map = new HashMap<String,Object>();
        map.put("name", "装修及家具");
        map.put("icon", R.mipmap.menu1);
        list.add(map);

        HashMap<String,Object> map2 = new HashMap<String,Object>();
        map2.put("name", "办公文仪");
        map2.put("icon", R.mipmap.menu2);
        list.add(map2);

        HashMap<String,Object> map3 = new HashMap<String,Object>();
        map3.put("name", "快递服务");
        map3.put("icon", R.mipmap.menu3);
        list.add(map3);

        HashMap<String,Object> map4 = new HashMap<String,Object>();
        map4.put("name", "机票服务");
        map4.put("icon", R.mipmap.menu4);
        list.add(map4);

        HashMap<String,Object> map5 = new HashMap<String,Object>();
        map5.put("name", "财税服务");
        map5.put("icon", R.mipmap.menu5);
        list.add(map5);

        HashMap<String,Object> map6 = new HashMap<String,Object>();
        map6.put("name", "律师服务");
        map6.put("icon", R.mipmap.menu6);
        list.add(map6);

        HashMap<String,Object> map7 = new HashMap<String,Object>();
        map7.put("name", "资产评估");
        map7.put("icon", R.mipmap.menu7);
        list.add(map7);

        HashMap<String,Object> map8 = new HashMap<String,Object>();
        map8.put("name", "洗衣服务");
        map8.put("icon", R.mipmap.menu8);
        list.add(map8);

        HashMap<String,Object> map9 = new HashMap<String,Object>();
        map9.put("name","洗衣服务");
        map9.put("icon", R.mipmap.menu8);
        list.add(map9);

        HashMap<String,Object> map10 = new HashMap<String,Object>();
        map10.put("name","其他");
        map10.put("icon",R.mipmap.menu8);
        list.add(map10);

        final int PageCount = 2;//(int)Math.ceil(list.size()/APP_PAGE_SIZE);
        array = new ArrayList<GridView>();
        for (int i=0; i<PageCount; i++) {
            GridView appPage = new GridView(getActivity());
            appPage.setAdapter(new HomeMenuAdapter(getActivity(), list, i));
            appPage.setNumColumns(4);
            appPage.setVerticalSpacing(30);
            array.add(appPage);
        }

        viewPager.setAdapter(new HomeViewPagerAdapter(getActivity(),array));
        mIndicator = (LinePageIndicator)view.findViewById(R.id.indicator);
        mIndicator.setViewPager(viewPager);
    }



    private List<View> getViews(int count) {
        List<View> views = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            views.add(getActivity().getLayoutInflater().inflate(R.layout.view_image, null));
        }
        return views;
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


