package com.xinglong.air.base;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.xinglong.air.R;

/**
 * Created by xinglong on 2017/5/27. 基类
 */

public class RootActivity extends BaseFragmentActivity{
    private LinearLayout rootView;
    private View contentView;
    public Activity me;
//    public TitleBar tb;
    private View zhanwei;
    public int width;
    public int height;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rootView = (LinearLayout) getLayoutInflater().inflate(R.layout.rootview, null);
        me=this;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
//        }
//        tb=new TitleBar(rootView);
//        CSApplication.addActivity(me);
        WindowManager wm = (WindowManager)me
                .getSystemService(Context.WINDOW_SERVICE);
        width= wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
}
