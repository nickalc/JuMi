package com.rogers.kit.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.rogers.kit.R;
import com.rogers.kit.tools.CommonUtil;

public class BaseActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private ActionBar actionBar;
    private Button doneButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
    public void setupToolBar(String title,int statusBarColor){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        doneButton = (Button) toolbar.findViewById(R.id.btn_toolbar_done);
        doneButton.setVisibility(View.GONE);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        CommonUtil.setNavigationBarColor(this, getResources().getColor(statusBarColor));
        CommonUtil.setStatusBarColor(this, getResources().getColor(statusBarColor));
    }
}
