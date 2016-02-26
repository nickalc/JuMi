package com.puxiang.jumi.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.Toast;

import com.puxiang.jumi.R;
import com.puxiang.jumi.ui.adapter.HomeExpandableListviewAdapter;
import com.puxiang.jumi.ui.adapter.HomeMenuAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import krelve.view.Kanner;


/**
 *  Created by nick on 15/10/21.
 */
public class YSHomeFagment extends Fragment implements AdapterView.OnItemClickListener{

    private View rootView;//缓存Fragment view
    private ExpandableListView expandableListView;
    private Kanner kanner;
    private GridView menuGrid;
    private HomeExpandableListviewAdapter mAdapter;
    HomeMenuAdapter menuAdapter;
    private List<Map<String, Object>> groupData = new ArrayList<Map<String, Object>>();
    private List<List<Map<String, Object>>> childData = new ArrayList<List<Map<String, Object>>>();
    private List<HashMap<String, Object>> mList;

    private String IMAGE_ITEM = "imgage_item";
    private String TEXT_ITEM = "text_item";
    private String[] arrText = new String[]{
            "Picture 1", "Picture 2", "Picture 3",
            "Picture 4", "Picture 5", "Picture 6",
            "Picture 7", "Picture 8", "Picture 9"
    };
    private int[] arrImages=new int[]{
            R.mipmap.menu_1, R.mipmap.menu_2,R.mipmap.menu_3,
            R.mipmap.menu_4, R.mipmap.menu_5, R.mipmap.menu_6,
            R.mipmap.menu_7, R.mipmap.menu_8, R.mipmap.menu_9
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_ys_home, container, false);
            initViews(rootView);
        }
        //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }

        return rootView;
    }

    private void initViews(View view){

        expandableListView = (ExpandableListView) view.findViewById(R.id.pull_refresh_expandable_list);
        mAdapter = new HomeExpandableListviewAdapter(getActivity(), groupData,childData);
        expandableListView.setAdapter(mAdapter);

        initHeadview();

        initData();
    }

    private void initHeadview(){

        View headerView = getActivity().getLayoutInflater().inflate(R.layout.home_expandlistview_head, null);
        menuGrid  = (GridView) headerView.findViewById(R.id.gridview);
        menuAdapter = new HomeMenuAdapter(getActivity(),getGridViewData(),0);
        menuGrid.setAdapter(menuAdapter);

        kanner = (Kanner) headerView.findViewById(R.id.kanner);
        kanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "You Select 轮播页" , Toast.LENGTH_SHORT).show();
            }
        });

        int[] imagesRes = {R.mipmap.a, R.mipmap.b, R.mipmap.c};
        kanner.setImagesRes(imagesRes);

//        SimpleAdapter saImageItems = new SimpleAdapter(getActivity(),
//                getGridViewData(),
//                R.layout.grid_view_menu_item,
//                new String[] { IMAGE_ITEM},
//                new int[] { R.id.itemImage });
        // 设置GridView的adapter。GridView继承于AbsListView。
        //menuGrid.setAdapter(saImageItems);
        menuGrid.setOnItemClickListener(this);


        expandableListView.addHeaderView(headerView);
    }

    /**
     * 获取GridView的数据
     */
    private List<HashMap<String, Object>> getGridViewData() {
        List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();

        for (int i=0; i<9; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put(IMAGE_ITEM, arrImages[i]);
            map.put(TEXT_ITEM, arrText[i]);
            list.add(map);
        }

        return list;
    }

    /**
     * GridView的点击回调函数
     *
     * @param adapter  -- GridView对应的dapterView
     * @param view     -- AdapterView中被点击的视图(它是由adapter提供的一个视图)。
     * @param position -- 视图在adapter中的位置。
     * @param rowid    -- 被点击元素的行id。
     */
    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position, long rowid) {

        // 根据元素位置获取对应的值
        HashMap<String, Object> item = (HashMap<String, Object>) adapter.getItemAtPosition(position);

        String itemText=(String)item.get(TEXT_ITEM);
        Object object=item.get(IMAGE_ITEM);
        Toast.makeText(getActivity(), "You Select " + itemText, Toast.LENGTH_SHORT).show();
    }



    private void initData(){

        Map<String, Object> map_ = new HashMap<String, Object>();
        map_.put("title", "饮食");
        map_.put("more", "更多");
        groupData.add(map_);

        List<Map<String, Object>> childList = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("titleProb", "坐月子吃什么好?");
        map.put("tetleDesc", "月子期间有两大任务");
        childList.add(map);

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("titleProb", "月子妈妈的养生要点");
        map1.put("tetleDesc", "月子期间有两大任务");
        childList.add(map1);

        childData.add(childList);

        Map<String, Object> map_1 = new HashMap<String, Object>();
        map_1.put("title", "健康");
        map_1.put("more", "更多");
        groupData.add(map_1);

        List<Map<String, Object>> childList1 = new ArrayList<Map<String, Object>>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        map2.put("titleProb", "坐月子吃什么好?");
        map2.put("tetleDesc", "月子期间有两大任务");
        childList1.add(map2);

        Map<String, Object> map3 = new HashMap<String, Object>();
        map3.put("titleProb", "月子妈妈的养生要点");
        map3.put("tetleDesc", "月子期间有两大任务");
        childList1.add(map3);

        childData.add(childList1);

        mAdapter.notifyDataSetChanged();

        //遍历所有group,将所有项设置成默认展开
        int groupCount = groupData.size();//mPullRefreshListView.getRefreshableView().getCount();
        for (int i=0; i<groupCount; i++) {
            expandableListView.expandGroup(i);
        };
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

