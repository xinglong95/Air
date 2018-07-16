package com.xinglong.air;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import com.xinglong.air.fragment.GuZhangFragment;
import com.xinglong.air.fragment.SheBeiFragment;
import com.xinglong.air.fragment.WoDeFragment;
import com.xinglong.air.fragment.ZhuYeFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.fl_main)
    FrameLayout flMain;
    @Bind(R.id.radioGroup_home)
    RadioGroup radioGroupHome;
    int checkid;
    private FragmentManager fragmentManager;
    GuZhangFragment guZhangFragment;
    SheBeiFragment sheBeiFragment;
    ZhuYeFragment zhuYeFragment;
    WoDeFragment woDeFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        radioGroupHome.setOnCheckedChangeListener(this);
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);
        checkid = R.id.rbt_shouye;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rbt_shouye:
                setTabSelection(0);
                checkid = i;
                break;
            case R.id.rbt_shebei:
                setTabSelection(1);
                checkid = i;
                break;
            case R.id.rbt_guzhang:
                setTabSelection(2);
                checkid = i;
                break;
            case R.id.rbt_wode:
                setTabSelection(3);
                checkid = i;
                break;

        }
    }
    /**
     * ca根据传入的index参数来设置选中的tab页。
     *
     * @param index 每个tab页对应的下标。0主页，1检索，2消息，3我的
     */
    private void setTabSelection(int index) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        hideFragments(transaction);
        switch (index) {
            case 0:
                if (zhuYeFragment == null) {
                    zhuYeFragment = new ZhuYeFragment();
                    transaction.add(R.id.fl_main, zhuYeFragment);
                } else {
                    transaction.show(zhuYeFragment);
                }
                break;
            case 1:
                if (sheBeiFragment == null) {
                    sheBeiFragment = new SheBeiFragment();
                    transaction.add(R.id.fl_main, sheBeiFragment);
                } else {
                    transaction.show(sheBeiFragment);
                }
                break;
            case 2:
                if (guZhangFragment == null) {
                    guZhangFragment = new GuZhangFragment();
                    transaction.add(R.id.fl_main, guZhangFragment);
                } else {
                    transaction.show(guZhangFragment);
                }
                break;
            case 3:
                if (woDeFragment == null) {
                    woDeFragment = new WoDeFragment();
                    transaction.add(R.id.fl_main, woDeFragment);
                } else {
                    transaction.show(woDeFragment);
                }
                break;
        }
        transaction.commit();
    }
    /**
     * 将所有的Fragment都置为隐藏状态。
     *
     * @param transaction 用于对Fragment执行操作的事务
     */
    private void hideFragments(FragmentTransaction transaction) {
        if (zhuYeFragment != null) {
            transaction.hide(zhuYeFragment);
        }
        if (sheBeiFragment != null) {
            transaction.hide(sheBeiFragment);
        }
        if (guZhangFragment != null) {
            transaction.hide(guZhangFragment);
        }
        if (woDeFragment != null) {
            transaction.hide(woDeFragment);
        }
    }

}
