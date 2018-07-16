package com.xinglong.air.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xinglong.air.R;
import com.xinglong.air.activity.LoginActivity;
import com.xinglong.air.activity.XiangMuXuanZeActivity;
import com.xinglong.air.base.AirApplication;
import com.xinglong.air.base.RootFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 主界面之我的界面
 */
public class WoDeFragment extends RootFragment {


    @Bind(R.id.tv_tuichudenglu)
    TextView tvTuichudenglu;
    @Bind(R.id.tv_xiangmuxuanze)
    TextView tvXiangmuxuanze;

    @Override
    protected int initViewLayoutId() {
        // TODO Auto-generated method stub
        return R.layout.fragment_wode;
    }


    protected void initdata() {

    }


    @Override
    public void onResume() {

        super.onResume();

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        if (!hidden) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);

    }

    @OnClick({R.id.tv_xiangmuxuanze, R.id.tv_tuichudenglu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_xiangmuxuanze:
                startActivity(new Intent(getActivity(), XiangMuXuanZeActivity.class));
                break;
            case R.id.tv_tuichudenglu:
                AirApplication.setLoginInfo("", "", "", 0);
                getActivity().startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
                break;
        }
    }
}
