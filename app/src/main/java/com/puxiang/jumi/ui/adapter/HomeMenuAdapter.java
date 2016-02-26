package com.puxiang.jumi.ui.adapter;

/**
 * Created by nick on 15/10/22.
 */

import android.content.Context;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.puxiang.jumi.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeMenuAdapter extends BaseAdapter {
    private List<HashMap<String, Object>> mList;// 定义一个list对象
    private Context mContext;// 上下文
    public static final int APP_PAGE_SIZE = 8;// 每一页装载数据的大小
    private PackageManager pm;// 定义一个PackageManager对象

    /**
     * 构造方法
     *
     * @param context 上下文
     * @param list    所有APP的集合
     * @param page    当前页
     */
    public HomeMenuAdapter(Context context, List<HashMap<String, Object>> list, int page) {
        mContext = context;
        pm = context.getPackageManager();
        mList = new ArrayList<HashMap<String, Object>>();
        // 根据当前页计算装载的应用，每页只装载8个
        int i = page * APP_PAGE_SIZE;// 当前页的其实位置
        int iEnd = i + APP_PAGE_SIZE;// 所有数据的结束位置
        while ((i < list.size()) && (i < iEnd)) {
            mList.add(list.get(i));
            i++;
        }
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return mList.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mList.get(position);
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(
                    R.layout.item_home_menu, parent, false);
        }
        final HashMap<String, Object> appInfo = mList.get(position);
        ImageView appicon = (ImageView) convertView.findViewById(R.id.menu_icon);
        final TextView appname = (TextView) convertView.findViewById(R.id.menu_name);
        appicon.setImageResource(R.mipmap.menu_1);
      //  appname.setText(appInfo.get("text_item").toString());
        convertView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(mContext, appInfo.get("name")+"建设中",Toast.LENGTH_SHORT).show();
            }
        });
        return convertView;
    }

}
