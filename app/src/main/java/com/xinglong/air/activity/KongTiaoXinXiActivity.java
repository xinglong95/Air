package com.xinglong.air.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.xinglong.air.R;
import com.xinglong.air.base.RootActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class KongTiaoXinXiActivity extends RootActivity {

    @Bind(R.id.iv_back)
    ImageView ivBack;
    @Bind(R.id.lv_kongtiaoxinxi)
    ListView lvKongtiaoxinxi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kong_tiao_xin_xi);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.iv_back)
    public void onViewClicked() {
        me.finish();
    }
}
