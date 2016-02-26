package com.rogers.kit.tools;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.readystatesoftware.systembartint.SystemBarTintManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rogers on 2015/10/19.
 */
public class CommonUtil {
    private static final String TAG = CommonUtil.class.getSimpleName();


    /**
     * 点击EditText 以外的其他地方 隐藏 软键盘
     * 建议在setContentView之后调用
     *
     * @param activity  activity
     * @param container 根布局(所要监听的区域)
     */
    public static void autoHideKeyboard(final Activity activity, final View container) {

        //Set up touch listener for non-text box views to hide keyboard.
        if (!(container instanceof EditText)) {

            container.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View v, MotionEvent event) {
                    container.requestFocus();
                    container.setFocusableInTouchMode(true);
                    hideSoftKeyboard(activity);
                    return false;
                }

            });
        }


        //If a layout container, iterate over children and seed recursion.
        if (container instanceof ViewGroup) {

            for (int i = 0; i < ((ViewGroup) container).getChildCount(); i++) {

                View innerView = ((ViewGroup) container).getChildAt(i);
                autoHideKeyboard(activity, innerView);
            }
        }
    }

    public static void hideSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            View focus = activity.getCurrentFocus();
            if (focus != null) {
                inputMethodManager.hideSoftInputFromWindow(focus.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置虚拟按钮为半透明状态
     *
     * @param activity activity
     * @param colorId  颜色id
     */
    public static void setNavigationBarColor(Activity activity, int colorId) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setNavigationBarColor(colorId);
        }

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            SystemBarTintManager manager = new SystemBarTintManager(activity);
            manager.setNavigationBarTintEnabled(true);
            manager.setNavigationBarTintColor(colorId);
        }
    }


    /**
     * 给状态栏设置颜色,针对 4.4 , 5.0 在style文件中已经配置
     * 提示:如果出现布局上移了,请确认你的activity 对应的xml根布局是否有配置 fillSystemWindow=true
     *
     * @param activity activity
     * @param colorId  颜色id,请用 getResource.getColor(xxx) 传入
     */
    public static void setStatusBarColor(Activity activity, int colorId) {

        if (Build.VERSION.SDK_INT == Build.VERSION_CODES.KITKAT) {
            SystemBarTintManager manager = new SystemBarTintManager(activity);
            manager.setStatusBarTintEnabled(true);
            manager.setStatusBarTintColor(colorId);
        }
    }

    /**
     * @return 是否符合规范
     * @Description 当前输入的邮箱地址是否符合规范
     */
    public static boolean isCorrectEmail(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    /**
     * 密码必须是数字和字母的组合，且必须是6-20位
     *
     * @param string
     * @return 是否符合要求
     */
    public static boolean isCorrectPassword(String string) {
        String str = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(string);
        return m.matches();
    }

    /**
     * 输入必须是字母或汉字
     *
     * @param string
     * @return 是否符合要求
     */
    public static boolean isorrectName(String string) {
        String str = "^([A-Za-z]|[\\u4E00-\\u9FA5])+$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(string);
        return m.matches();
    }


    /**
     * 检查网络是否连接
     * @param context
     * @return
     */
    public boolean isNetworkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }
    /**
     * px转dp
     */
    public static int dip2px(Context context, float dipValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    /**
     * dp转px
     */
    public static int px2dip(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

}
