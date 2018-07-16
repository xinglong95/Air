package com.xinglong.air.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinglong.air.R;
import com.xinglong.air.base.RootFragment;

import java.lang.reflect.Field;


/**
 * 主界面之故障界面
 */
@SuppressLint("InflateParams")
public class GuZhangFragment extends RootFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }
    @Override
    protected int initViewLayoutId() {
        return R.layout.fragment_guzhang;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        return view;
    }
    private int getStatusBarHeight() {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, sbar = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            sbar = getContext().getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return sbar;
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
    }
    @Override
    public void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
    }
    public void onHiddenChanged(boolean hidden) {
        if (!hidden) {
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
