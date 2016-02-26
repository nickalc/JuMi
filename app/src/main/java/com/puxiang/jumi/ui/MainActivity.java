package com.puxiang.jumi.ui;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.puxiang.jumi.R;
import com.puxiang.jumi.ui.fragments.HomeFagment;
import com.puxiang.jumi.ui.fragments.OrderFagment;
import com.puxiang.jumi.ui.fragments.YSHomeFagment;
import com.rogers.kit.base.BaseActivity;

/**
 * Created by nick on 15/10/21.
 */
public class MainActivity extends BaseActivity {



    private FrameLayout mHomeContent;
    private RadioGroup mHomeRadioGroup;
    private RadioButton mHomeHomeRb;
    private RadioButton mHomeOrderRb;
    private RadioButton mHomeMeRb;

    static final int NUM_ITEMS = 3;//一共四个fragment



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //去掉Activity上面的状态栏
       // Window window = getWindow();
       // window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
       // window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                 //   | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

           // window.setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(getResources().getColor(R.color.awesome_orange));
        }

        setContentView(R.layout.activity_main);


        initView();

    }


    protected void initView() {
        mHomeContent = (FrameLayout) findViewById(R.id.content_frame); //tab上方的区域
        mHomeRadioGroup = (RadioGroup) findViewById(R.id.radiogroup);  //底部的四个tab
        mHomeHomeRb = (RadioButton) findViewById(R.id.radio_home);
        mHomeOrderRb = (RadioButton) findViewById(R.id.radio_order);
        mHomeMeRb = (RadioButton) findViewById(R.id.radio_me);

        //监听事件：为底部的RadioGroup绑定状态改变的监听事件
        mHomeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = 0;
                switch (checkedId) {
                    case R.id.radio_home:
                        index = 0;
                        break;
                    case R.id.radio_order:
                        index = 1;
                        break;
                    case R.id.radio_me:
                        index = 2;
                        break;
                }
                //通过fragments这个adapter还有index来替换帧布局中的内容
                Fragment fragment = (Fragment) fragments.instantiateItem(mHomeContent, index);
                //一开始将帧布局中 的内容设置为第一个
                fragments.setPrimaryItem(mHomeContent, 0, fragment);
                fragments.finishUpdate(mHomeContent);

            }
        });
    }

    //第一次启动时，我们让mHomeHomeRb这个radiobutton处于选中状态。
    // 当然了，在这之前，先要在布局文件中设置其他的某一个radiobutton（只要不是mHomeHomeRb就行）
    // 的属性为android:checked="true"，才会出发下面的这个check方法切换到mHomeHomeRb
    @Override
    protected void onStart() {
        super.onStart();
        mHomeRadioGroup.check(R.id.radio_home);
    }

    //用adapter来管理三个Fragment界面的变化。注意，我这里用的Fragment都是v4包里面的
    FragmentStatePagerAdapter fragments = new FragmentStatePagerAdapter(getSupportFragmentManager()) {

        @Override
        public int getCount() {
            return NUM_ITEMS;//一共有四个Fragment
        }

        //进行Fragment的初始化
        @Override
        public Fragment getItem(int i) {
            Fragment fragment = null;
            switch (i) {
                case 0://首页
                    fragment = new HomeFagment();
                    break;
                case 1://订单
                    fragment = new OrderFagment();
                    break;
                case 2://我
                  //  fragment = new MeFagment();
                    fragment = new YSHomeFagment();
                    break;
                default:
                    new HomeFagment();
                    break;
            }

            return fragment;
        }
    };




}
