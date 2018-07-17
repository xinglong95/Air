package com.xinglong.air.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.citzx.cslibrary.net.RequestCallBack;
import com.citzx.cslibrary.net.XutilHttpHelp;
import com.citzx.cslibrary.utils.ToastUtil;
import com.xinglong.air.R;
import com.xinglong.air.base.APIConfig;
import com.xinglong.air.base.RootActivity;
import com.xinglong.air.base.XiangMuXuanZeBean;

import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XianLuXinXiActivity extends RootActivity {

    @Bind(R.id.et_sousuo)
    EditText etSousuo;
    @Bind(R.id.btn_sousuo)
    Button btnSousuo;
    @Bind(R.id.lv_xianluxinxi)
    ListView lvXianluxinxi;
    @Bind(R.id.iv_back)
    ImageView ivBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xian_lu_xin_xi);
        initData();
        ButterKnife.bind(this);
    }

    private void initData() {
        getXiangMu();
    }

    private void getXiangMu() {
        RequestParams params = new RequestParams(APIConfig.postlogin);
        params.setMethod(HttpMethod.GET);
        params.addParameter("GetProjectInfo", true);
        XutilHttpHelp.getInstance().BaseInfoHttp(params, me, new RequestCallBack<XiangMuXuanZeBean>() {
            @Override
            public void onSuccess(XiangMuXuanZeBean result) {
                if (null != result.getData()) {
//                    setText(result);
                }
            }

            @Override
            public void onError(Exception error, String msg) {
                ToastUtil.showShort("登录失败");
                super.onError(error, msg);
            }
        });
    }

    @OnClick({R.id.iv_back, R.id.btn_sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                me.finish();
                break;
            case R.id.btn_sousuo:
                break;
        }
    }
}
