package com.xinglong.air.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.citzx.cslibrary.net.RequestCallBack;
import com.citzx.cslibrary.net.XutilHttpHelp;
import com.citzx.cslibrary.utils.MTextUtils;
import com.citzx.cslibrary.utils.ToastUtil;
import com.xinglong.air.MainActivity;
import com.xinglong.air.R;
import com.xinglong.air.base.APIConfig;
import com.xinglong.air.base.AirApplication;
import com.xinglong.air.base.RootActivity;
import com.xinglong.air.bean.UserLoginBean;

import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 */
public class LoginActivity extends RootActivity {

    @Bind(R.id.et_username)
    EditText etUsername;
    @Bind(R.id.et_password)
    EditText etPassword;
    @Bind(R.id.btn_denglu)
    Button btnDenglu;
    @Bind(R.id.cb_iszidong)
    CheckBox cbIszidong;
    String username="";
    String password="";
    int isAutoLogin=0;//0为不自动登录，1为自动登录
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        cbIszidong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    isAutoLogin=1;
                }else{
                    isAutoLogin=0;
                }
            }
        });
        isAutoLogin=AirApplication.getisAuto();
        if (isAutoLogin==1&&MTextUtils.notEmpty(AirApplication.getToken())){
            etUsername.setText(AirApplication.getUserName());
            etPassword.setText(AirApplication.getPassWord());
            cbIszidong.setChecked(true);
            getText();
            Login();
        }
    }
    private void getText(){
        username=etUsername.getText().toString();
        password=etPassword.getText().toString();
    }
    private void Login(){
        RequestParams params=new RequestParams(APIConfig.postlogin);
        params.setMethod(HttpMethod.POST);
        params.addBodyParameter("UserName",username);
        params.addBodyParameter("PassWord",password);
        XutilHttpHelp.getInstance().BaseInfoHttp(params, me, new RequestCallBack<UserLoginBean>() {
            @Override
            public void onSuccess(UserLoginBean result) {
                if (MTextUtils.notEmpty(result.getToken())){
                    AirApplication.setLoginInfo(username,password,result.getToken(),isAutoLogin);
                    startActivity(new Intent(me, XiangMuXuanZeActivity.class));
                    ToastUtil.showShort("登录成功");
                    me.finish();
                }
            }

            @Override
            public void onError(Exception error, String msg) {
                ToastUtil.showShort("登录失败");
                super.onError(error, msg);
            }
        });
    }

    @OnClick(R.id.btn_denglu)
    public void onViewClicked() {
        getText();
        Login();
    }
}
