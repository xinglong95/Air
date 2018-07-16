package com.xinglong.air.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import com.citzx.cslibrary.net.RequestCallBack;
import com.citzx.cslibrary.net.XutilHttpHelp;
import com.citzx.cslibrary.utils.ToastUtil;
import com.xinglong.air.R;
import com.xinglong.air.activity.CheLiangInfoActivity;
import com.xinglong.air.base.APIConfig;
import com.xinglong.air.base.ConstantConfig;
import com.xinglong.air.base.RootFragment;
import com.xinglong.air.bean.SheBeiListBean;
import com.xinglong.air.utils.AbsBaseAdapter;

import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 主界面之设备界面
 */
@SuppressLint("InflateParams")
public class SheBeiFragment extends RootFragment implements AdapterView.OnItemClickListener{
    @Bind(R.id.et_sousuo)
    EditText etSousuo;
    @Bind(R.id.btn_sousuo)
    Button btnSousuo;
    @Bind(R.id.rg_kongtiaozhuangtai)
    RadioGroup rgKongtiaozhuangtai;
    @Bind(R.id.rg_guzhangzhuangtai)
    RadioGroup rgGuzhangzhuangtai;
    String projectname = "";
    AbsBaseAdapter adapter;
    ArrayList<SheBeiListBean.DataBean.ChildrenBeanXXXX.ChildrenBeanXXX.ChildrenBeanXX> lists;
    @Bind(R.id.lv_liechelist)
    ListView lvLiechelist;
    String AirconOnOffStatus="";//运行状态
    String ErrorStatus="";//故障状态
    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int initViewLayoutId() {
        return R.layout.fragment_shebei;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, view);
        lists = new ArrayList<>();
        rgKongtiaozhuangtai.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                 case R.id.rbt_yunxing:
                     AirconOnOffStatus="run";
                     break;
                 case R.id.rbt_guzhang:
                     AirconOnOffStatus="stop";
                     break;
                }
            }
        });
        rgGuzhangzhuangtai.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.rbt_guzhang:
                        ErrorStatus="err";
                        break;
                    case R.id.rbt_zhengchang:
                        ErrorStatus="normal";
                        break;
                }
            }
        });
        getProject();
        return view;
    }


    private void getText() {
        projectname = etSousuo.getText().toString();
    }
    private void initData(SheBeiListBean bean) {
        lists=new ArrayList<>();
        for (int i = 0; i < bean.getData().getChildren().size(); i++) {
            for (int i1 = 0; i1 < bean.getData().getChildren().get(i).getChildren().size(); i1++) {
                for (int i2 = 0; i2 < bean.getData().getChildren().get(i).getChildren().get(i1).getChildren().size(); i2++) {
                    lists.add(bean.getData().getChildren().get(i).getChildren().get(i1).getChildren().get(i2));
                }
            }
        }
        adapter = new AbsBaseAdapter<SheBeiListBean.DataBean.ChildrenBeanXXXX.ChildrenBeanXXX.ChildrenBeanXX>(getActivity(), R.layout.item_chelianglist) {
            @Override
            protected void bindDatas(ViewHolder viewHolder, SheBeiListBean.DataBean.ChildrenBeanXXXX.ChildrenBeanXXX.ChildrenBeanXX data, int position) {
                viewHolder.bindTextView(R.id.tv_liechemingcheng, data.getName());
            }
        };
        adapter.setDatas(lists);
        lvLiechelist.setAdapter(adapter);
        lvLiechelist.setOnItemClickListener(this);
    }

    private void getProject() {
        getText();
        RequestParams params = new RequestParams(APIConfig.postlogin);
        params.setMethod(HttpMethod.GET);
        params.addParameter("FindAircon", true);
        params.addQueryStringParameter("ProjectName_Find", projectname);
        params.addQueryStringParameter("AirconOnOffStatus", AirconOnOffStatus);
        params.addQueryStringParameter("ErrorStatus", ErrorStatus);
        XutilHttpHelp.getInstance().BaseInfoHttp(params, getActivity(), new RequestCallBack<SheBeiListBean>() {
            @Override
            public void onSuccess(SheBeiListBean result) {
                if (null != result.getData()) {
                    initData(result);
                }
            }

            @Override
            public void onError(Exception error, String msg) {
                ToastUtil.showShort("暂无数据");
                super.onError(error, msg);
            }
        });
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
        ButterKnife.unbind(this);
    }

    @OnClick(R.id.btn_sousuo)
    public void onViewClicked() {
//        startActivity(new Intent(getActivity(), CheLiangInfoActivity.class));
        getProject();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Intent intent=new Intent();
        Bundle bundle=new Bundle();
        bundle.putSerializable(ConstantConfig.LieCheBean,lists.get(i));
        intent.putExtras(bundle);
        intent.setClass(getActivity(), CheLiangInfoActivity.class);
        startActivity(intent);
    }
}
