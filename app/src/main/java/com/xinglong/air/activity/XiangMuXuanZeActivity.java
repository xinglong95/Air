package com.xinglong.air.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.citzx.cslibrary.net.RequestCallBack;
import com.citzx.cslibrary.net.XutilHttpHelp;
import com.citzx.cslibrary.utils.ToastUtil;
import com.multilevel.treelist.Node;
import com.xinglong.air.MainActivity;
import com.xinglong.air.R;
import com.xinglong.air.adapter.XiangmuXuanzeAdapter;
import com.xinglong.air.base.APIConfig;
import com.xinglong.air.base.RootActivity;
import com.xinglong.air.base.XiangMuXuanZeBean;
import com.xinglong.air.bean.ShengShiXiangMuXuanZeBean;

import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class XiangMuXuanZeActivity extends RootActivity {
    String xx = "";


    protected List<Node> mDatas = new ArrayList<Node>();
    @Bind(R.id.line_xiangmuxuanze)
    LinearLayout lineXiangmuxuanze;
    @Bind(R.id.tv_queding)
    TextView tvQueding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_mu_xuan_ze);
        ButterKnife.bind(this);
       getXiangMu();
//        initData(savedInstanceState);
    }

    private void initData(Bundle savedInstanceState) {
        ArrayList<ShengShiXiangMuXuanZeBean.XiangMuDatas> xiangmuDatasArrayList = new ArrayList<>();
        ShengShiXiangMuXuanZeBean.XiangMuDatas xiangMuDatas = new ShengShiXiangMuXuanZeBean.XiangMuDatas();
        xiangMuDatas.setChecked(false);
        xiangMuDatas.setXiangMuID("1");
        xiangMuDatas.setXiangMuName("青岛1");
        ShengShiXiangMuXuanZeBean.XiangMuDatas xiangMuDatas2 = new ShengShiXiangMuXuanZeBean.XiangMuDatas();
        xiangMuDatas2.setChecked(false);
        xiangMuDatas2.setXiangMuID("2");
        xiangMuDatas2.setXiangMuName("青岛2");
        ShengShiXiangMuXuanZeBean.XiangMuDatas xiangMuDatas3 = new ShengShiXiangMuXuanZeBean.XiangMuDatas();
        xiangMuDatas3.setChecked(false);
        xiangMuDatas3.setXiangMuID("3");
        xiangMuDatas3.setXiangMuName("青岛3");
        xiangmuDatasArrayList.add(xiangMuDatas);
        xiangmuDatasArrayList.add(xiangMuDatas2);
        xiangmuDatasArrayList.add(xiangMuDatas3);


        ArrayList<ShengShiXiangMuXuanZeBean.XiangMuDatas> xiangmuDatasArrayList1 = new ArrayList<>();
        ShengShiXiangMuXuanZeBean.XiangMuDatas xiangMuDatas1 = new ShengShiXiangMuXuanZeBean.XiangMuDatas();
        xiangMuDatas1.setChecked(false);
        xiangMuDatas1.setXiangMuID("1");
        xiangMuDatas1.setXiangMuName("烟台1");
        ShengShiXiangMuXuanZeBean.XiangMuDatas xiangMuDatas21 = new ShengShiXiangMuXuanZeBean.XiangMuDatas();
        xiangMuDatas21.setChecked(false);
        xiangMuDatas21.setXiangMuID("2");
        xiangMuDatas21.setXiangMuName("烟台2");
        ShengShiXiangMuXuanZeBean.XiangMuDatas xiangMuDatas31 = new ShengShiXiangMuXuanZeBean.XiangMuDatas();
        xiangMuDatas31.setChecked(false);
        xiangMuDatas31.setXiangMuID("3");
        xiangMuDatas31.setXiangMuName("烟台3");
        xiangmuDatasArrayList1.add(xiangMuDatas1);
        xiangmuDatasArrayList1.add(xiangMuDatas21);
        xiangmuDatasArrayList1.add(xiangMuDatas31);

        ArrayList<ShengShiXiangMuXuanZeBean.XiangMuDatas> xiangmuDatasArrayList11 = new ArrayList<>();
        ShengShiXiangMuXuanZeBean.XiangMuDatas xiangMuDatas11 = new ShengShiXiangMuXuanZeBean.XiangMuDatas();
        xiangMuDatas11.setChecked(false);
        xiangMuDatas11.setXiangMuID("1");
        xiangMuDatas11.setXiangMuName("威海1");
        ShengShiXiangMuXuanZeBean.XiangMuDatas xiangMuDatas211 = new ShengShiXiangMuXuanZeBean.XiangMuDatas();
        xiangMuDatas211.setChecked(false);
        xiangMuDatas211.setXiangMuID("2");
        xiangMuDatas211.setXiangMuName("威海2");
        ShengShiXiangMuXuanZeBean.XiangMuDatas xiangMuDatas311 = new ShengShiXiangMuXuanZeBean.XiangMuDatas();
        xiangMuDatas311.setChecked(false);
        xiangMuDatas311.setXiangMuID("3");
        xiangMuDatas311.setXiangMuName("威海3");
        xiangmuDatasArrayList11.add(xiangMuDatas11);
        xiangmuDatasArrayList11.add(xiangMuDatas211);
        xiangmuDatasArrayList11.add(xiangMuDatas311);


        ShengShiXiangMuXuanZeBean bean = new ShengShiXiangMuXuanZeBean();
        ArrayList<ShengShiXiangMuXuanZeBean.ShiDatas> shiDatasArrayList = new ArrayList<>();
        ShengShiXiangMuXuanZeBean.ShiDatas datas = new ShengShiXiangMuXuanZeBean.ShiDatas();
        datas.setShiName("青岛市");
        datas.setXiangMuDatas(xiangmuDatasArrayList);
        ShengShiXiangMuXuanZeBean.ShiDatas datas1 = new ShengShiXiangMuXuanZeBean.ShiDatas();
        datas1.setShiName("烟台市");
        datas1.setXiangMuDatas(xiangmuDatasArrayList1);
        ShengShiXiangMuXuanZeBean.ShiDatas datas2 = new ShengShiXiangMuXuanZeBean.ShiDatas();
        datas2.setShiName("威海市");
        datas2.setXiangMuDatas(xiangmuDatasArrayList11);
        shiDatasArrayList.add(datas);
        shiDatasArrayList.add(datas1);
        shiDatasArrayList.add(datas2);
        bean.setShiDatas(shiDatasArrayList);

        ArrayList<ShengShiXiangMuXuanZeBean> shengShiXiangMuXuanZeBeans = new ArrayList<>();
        shengShiXiangMuXuanZeBeans.add(bean);
        LayoutInflater inflater = getLayoutInflater();
        lineXiangmuxuanze.removeAllViews();
        for (int i = 0; i < shengShiXiangMuXuanZeBeans.size(); i++) {
            View view = inflater.inflate(R.layout.layout_xiangmuxuanze_item, null);
            final ExpandableListView listView = view.findViewById(R.id.ex_listview);
            TextView tv_shengname = view.findViewById(R.id.tv_shengname);
            tv_shengname.setText(shengShiXiangMuXuanZeBeans.get(i).getShengName());
            final XiangmuXuanzeAdapter adapter = new XiangmuXuanzeAdapter(this, shengShiXiangMuXuanZeBeans.get(i));
            listView.setAdapter(adapter);
            listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                @Override
                public void onGroupExpand(int groupPosition) {
                    for (int i = 0; i < adapter.getGroupCount(); i++) {
                        if (groupPosition != i) {
                            listView.collapseGroup(i);
                        }
                    }
                }
            });
            lineXiangmuxuanze.addView(view);
        }
    }

    private void getXiangMu() {
        RequestParams params = new RequestParams(APIConfig.postlogin);
        params.setMethod(HttpMethod.GET);
        params.addParameter("GetProjectInfo", true);
        XutilHttpHelp.getInstance().BaseInfoHttp(params, me, new RequestCallBack<XiangMuXuanZeBean>() {
            @Override
            public void onSuccess(XiangMuXuanZeBean result) {
                if (null != result.getData()) {
                    formatData(result);
                }
            }

            @Override
            public void onError(Exception error, String msg) {
                ToastUtil.showShort("登录失败");
                super.onError(error, msg);
            }
        });

    }

    /**
     * 对数据进行组装
     */
    private void formatData(XiangMuXuanZeBean bean) {
        List<XiangMuXuanZeBean.DataBean> dataBeans = bean.getData();
        ArrayList<ShengShiXiangMuXuanZeBean> shengShiXiangMuXuanZeBeans = new ArrayList<>();
        for (int i = 0; i < dataBeans.size(); i++) {
            ShengShiXiangMuXuanZeBean shengShiXiangMuXuanZeBean = new ShengShiXiangMuXuanZeBean();
            XiangMuXuanZeBean.DataBean dataBean = dataBeans.get(i);
            ShengShiXiangMuXuanZeBean.ShiDatas datas = new ShengShiXiangMuXuanZeBean.ShiDatas();
            //第一层
            shengShiXiangMuXuanZeBean.setShengName(dataBean.getName());
            datas.setShiName(dataBean.getName());
            //第二层  获取市
            List<XiangMuXuanZeBean.DataBean.ChildrenBeanXXX> childrenBeanXXXList = dataBean.getChildren();
            ArrayList<ShengShiXiangMuXuanZeBean.ShiDatas> shiDatasArrayList = new ArrayList<>();
            for (int i1 = 0; i1 < childrenBeanXXXList.size(); i1++) {
                XiangMuXuanZeBean.DataBean.ChildrenBeanXXX childrenBeanXXX = childrenBeanXXXList.get(i1);
                ShengShiXiangMuXuanZeBean.ShiDatas shiData = new ShengShiXiangMuXuanZeBean.ShiDatas();
                shiData.setShiName(childrenBeanXXX.getName());
                shiDatasArrayList.add(shiData);
                //第三层 获取项目单位
                List<XiangMuXuanZeBean.DataBean.ChildrenBeanXXX.ChildrenBeanXX> childrenBeanXXXList_3 = childrenBeanXXX.getChildren();
                ArrayList<ShengShiXiangMuXuanZeBean.XiangMuDatas> xiangmuDatasArrayList = new ArrayList<>();
                for (int i2 = 0; i2 < childrenBeanXXXList_3.size(); i2++) {
                    ShengShiXiangMuXuanZeBean.XiangMuDatas xiangMuDatas = new ShengShiXiangMuXuanZeBean.XiangMuDatas();
                    xiangMuDatas.setXiangMuName(childrenBeanXXXList_3.get(i2).getName());
                    xiangMuDatas.setXiangMuID(childrenBeanXXXList_3.get(i2).getId());
                    xiangMuDatas.setChecked(false);
                    xiangmuDatasArrayList.add(xiangMuDatas);
                }
                shiData.setXiangMuDatas(xiangmuDatasArrayList);
            }
            shengShiXiangMuXuanZeBean.setShiDatas(shiDatasArrayList);
            shengShiXiangMuXuanZeBeans.add(shengShiXiangMuXuanZeBean);
        }

        //布局
        LayoutInflater inflater = getLayoutInflater();
        lineXiangmuxuanze.removeAllViews();
        for (int i = 0; i < shengShiXiangMuXuanZeBeans.size(); i++) {
            View view = inflater.inflate(R.layout.layout_xiangmuxuanze_item, null);
            final ExpandableListView listView = view.findViewById(R.id.ex_listview);
            TextView tv_shengname = view.findViewById(R.id.tv_shengname);
            tv_shengname.setText(shengShiXiangMuXuanZeBeans.get(i).getShengName());
            final XiangmuXuanzeAdapter adapter = new XiangmuXuanzeAdapter(this, shengShiXiangMuXuanZeBeans.get(i));
            listView.setAdapter(adapter);
            listView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

                @Override
                public void onGroupExpand(int groupPosition) {
                    for (int i = 0; i < adapter.getGroupCount(); i++) {
                        if (groupPosition != i) {
                            listView.collapseGroup(i);
                        }

                    }
                }
            });
            listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                @Override
                public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPosition, int childPosition, long l) {
                    int gourpsSum = adapter.getGroupCount();//组的数量
                    for(int i = 0; i < gourpsSum; i++) {
                        int childSum = adapter.getChildrenCount(i);//组中子项的数量
                        for(int k = 0; k < childSum;k++) {
                            boolean isLast = false;
                            if (k == (childSum - 1)){
                                isLast = true;
                            }
                            CheckBox cBox = (CheckBox) adapter.getChildView(i, k, isLast, null, null).findViewById(R.id.tv_zuoheng);
                            cBox.toggle();//切换CheckBox状态！！！！！！！！！！
                            boolean itemIsCheck=cBox.isChecked();


                            ((BaseExpandableListAdapter) adapter).notifyDataSetChanged();//通知数据发生了变化
                        }
                    }
                    return true;
                }
            });
            lineXiangmuxuanze.addView(view);
        }
    }


    @OnClick(R.id.tv_queding)
    public void onViewClicked() {
        startActivity(new Intent(me, MainActivity.class));
        me.finish();
    }
}
