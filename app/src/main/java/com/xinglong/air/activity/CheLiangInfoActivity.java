package com.xinglong.air.activity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.citzx.cslibrary.net.RequestCallBack;
import com.citzx.cslibrary.net.XutilHttpHelp;
import com.citzx.cslibrary.utils.MTextUtils;
import com.citzx.cslibrary.utils.MyTimeUtils;
import com.citzx.cslibrary.utils.ToastUtil;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.xinglong.air.R;
import com.xinglong.air.adapter.NoScrollPagerAdapter;
import com.xinglong.air.base.APIConfig;
import com.xinglong.air.base.ConstantConfig;
import com.xinglong.air.base.RootActivity;
import com.xinglong.air.bean.ChartDatasBean;
import com.xinglong.air.bean.KongTiaoShiShiBean;
import com.xinglong.air.bean.SheBeiListBean;
import com.xinglong.air.ui.NoScrollViewPager;

import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 第三次提交
 */
public class CheLiangInfoActivity extends RootActivity implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.rv_kongtiaoxuanze)
    RecyclerView rvKongtiaoxuanze;
    @Bind(R.id.rg_kongtiaoxuanze)
    RadioGroup rgKongtiaoxuanze;
    @Bind(R.id.vp_zhuangkuang)
    NoScrollViewPager vpZhuangkuang;
    @Bind(R.id.tv_kongtiaozhuangkuang)
    TextView tv_kongtiaozhuangkuang;

    private GalleryAdapter mAdapter;
    private List<ChartDatasBean> chartDatasBeans;
    private View view_shishi;//
    private View view_lishi;//
    private View view_kongzhi;//
    private ArrayList<View> viewLists;
    private NoScrollPagerAdapter noScrollPagerAdapter;
    ViewHolder_lishi viewHolder_lishi;
    ViewHolder_ShiShi viewHolder_shiShi;
    ViewHolder_kongzhi viewHolder_kongzhi;
    SheBeiListBean.DataBean.ChildrenBeanXXXX.ChildrenBeanXXX.ChildrenBeanXX bean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_che_liang_info);
        ButterKnife.bind(this);
        initView();
        initDatas();
    }

    private void initView() {
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvKongtiaoxuanze.setLayoutManager(linearLayoutManager);
//设置适配器
        rgKongtiaoxuanze.setOnCheckedChangeListener(this);
        viewLists = new ArrayList<View>();
        LayoutInflater lf = getLayoutInflater().from(this);
        view_shishi = lf.inflate(R.layout.item_shishishuju, null);
        view_lishi = lf.inflate(R.layout.item_lishishuju, null);
        view_kongzhi = lf.inflate(R.layout.item_kongzhishuju, null);
        viewHolder_lishi = new ViewHolder_lishi(view_lishi);
        viewHolder_shiShi = new ViewHolder_ShiShi(view_shishi);
        viewHolder_kongzhi = new ViewHolder_kongzhi(view_kongzhi);
        viewLists.add(view_shishi);//
        viewLists.add(view_lishi);//
        viewLists.add(view_kongzhi);//
    }

    int fengsu = 0;
    int wendu = 0;
    int xinfengfakaidu = 0;
    int huifengfakaidu = 0;
    int yasuojipinlv = 0;
    int pengzhangfakaidu = 0;

    private void intitKongZhi() {
        viewHolder_kongzhi.ivFengsujia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fengsu++;
                setKongZhiText();
            }
        });
        viewHolder_kongzhi.ivFengsujian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fengsu--;
                setKongZhiText();
            }
        });
        viewHolder_kongzhi.ivWendujia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wendu++;
                setKongZhiText();
            }
        });
        viewHolder_kongzhi.ivWendujian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wendu--;
                setKongZhiText();
            }
        });
        viewHolder_kongzhi.ivFengfajia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xinfengfakaidu++;
                setKongZhiText();
            }
        });
        viewHolder_kongzhi.ivFengfajian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xinfengfakaidu--;
                setKongZhiText();
            }
        });
        viewHolder_kongzhi.ivHufengfajia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                huifengfakaidu++;
                setKongZhiText();
            }
        });
        viewHolder_kongzhi.ivHuifengfajian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                huifengfakaidu--;
                setKongZhiText();
            }
        });
        viewHolder_kongzhi.ivYasuojijia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yasuojipinlv++;
                setKongZhiText();
            }
        });
        viewHolder_kongzhi.ivYasuojijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                yasuojipinlv--;
                setKongZhiText();
            }
        });
        viewHolder_kongzhi.ivPengzhangfajia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pengzhangfakaidu++;
                setKongZhiText();
            }
        });
        viewHolder_kongzhi.ivPengzhangfajian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pengzhangfakaidu--;
                setKongZhiText();
            }
        });
        viewHolder_kongzhi.rgKongZhiKongTiaoShu.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

            }
        });
        viewHolder_kongzhi.rgKongZhiKongTiaoShu.check(R.id.rbt_kongzhidange);
    }

    private void setKongZhiText() {
        viewHolder_kongzhi.tvFengsu.setText(fengsu + "");
        viewHolder_kongzhi.tvWendu.setText(wendu + "℃");
        viewHolder_kongzhi.tvXinfengfa.setText(xinfengfakaidu + "s");
        viewHolder_kongzhi.tvHuifenghfa.setText(huifengfakaidu + "s");
        viewHolder_kongzhi.tvYasuojipinlv.setText(yasuojipinlv + "HZ");
        viewHolder_kongzhi.tvPengzhangfa.setText(pengzhangfakaidu + "P");
        if (MTextUtils.notEmpty(beanall.getModeOne())){
            switch (beanall.getModeOne()){
                case "0":
                case "1":
                case "2":
                case "3":
                case "4":
                case "5":
                case "6":
                    viewHolder_kongzhi.rgKongtiaokaiguan.check(R.id.rbt_kongtiaodakai);
                    break;
                case "7":
                    viewHolder_kongzhi.rgKongtiaokaiguan.check(R.id.rbt_kongtiaoguanbi);
                    break;
                default:
                    viewHolder_kongzhi.rgKongtiaokaiguan.check(R.id.rbt_kongtiaodakai);
                    break;
            }
        }
        if (MTextUtils.notEmpty(beanall.getModeOne())){
            switch (beanall.getModeOne()){
                case "0":
                case "1":
                case "2":
                    viewHolder_kongzhi.rgYunxingmoshi.check(R.id.rbt_zidong);
                    break;
                case "3":
                case "4":
                    viewHolder_kongzhi.rgYunxingmoshi.check(R.id.rbt_zhileng);
                    break;
                case "5":
                case "6":
                    viewHolder_kongzhi.rgYunxingmoshi.check(R.id.rbt_zhire);
                    break;
                case "7":
                    viewHolder_kongzhi.rgYunxingmoshi.check(R.id.rbt_zidong);
                    break;
                default:
                    viewHolder_kongzhi.rgYunxingmoshi.check(R.id.rbt_zidong);
                    break;
            }
        }


    }
    KongTiaoShiShiBean.DataBean beanall=new KongTiaoShiShiBean.DataBean();
    /**
     * 初始化实时数据
     */
    private void initShiShiData(KongTiaoShiShiBean.DataBean bean) {
        viewHolder_shiShi.tvYunxingmoshi.setText(bean.getModeOneText());
        viewHolder_shiShi.tvShineiwendu.setText(bean.getINAIR_T_10AD_1_A() + "℃");
        viewHolder_shiShi.tvShiwaiwendu.setText(bean.getOUTAIR_T() + "℃");
        viewHolder_shiShi.tvShedingwendu.setText(bean.getLACSetTemp() + "℃");
        viewHolder_shiShi.tvSongfengwendu.setText(bean.getTemperature_A_T() + "℃");
        viewHolder_shiShi.tvShineishidu.setText(bean.getHumidityValue_A() + "℃");
        viewHolder_shiShi.tvNongdu.setText(bean.getCO2_Value() + "ppm");
        viewHolder_shiShi.tvPm.setText(bean.getPM25() + "ug/m3");
        fengsu=Integer.parseInt(MTextUtils.isEmpty(bean.getRunningFrequencyInFan()) ? "" : bean.getRunningFrequencyInFan());
        wendu=Integer.parseInt(MTextUtils.isEmpty(bean.getINAIR_T_10AD_2_A()) ? "" : bean.getINAIR_T_10AD_2_A());
        xinfengfakaidu=Integer.parseInt(MTextUtils.isEmpty(bean.getFreshValveNow()) ? "" : bean.getFreshValveNow());
        huifengfakaidu=Integer.parseInt(MTextUtils.isEmpty(bean.getReflowValveNow()) ? "" : bean.getReflowValveNow());
        yasuojipinlv=Integer.parseInt(MTextUtils.isEmpty(bean.getRunningFrequencyCompA()) ? "" : bean.getRunningFrequencyCompA());
        pengzhangfakaidu=Integer.parseInt(MTextUtils.isEmpty(bean.getV1_NOW_STATE_RDIV256()) ? "" : bean.getV1_NOW_STATE_RDIV256());
        setKongZhiText();
    }

    private void initLiShiData() {
        chartDatasBeans = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            ChartDatasBean bean = new ChartDatasBean();
            bean.setDate("05-" + i);
            bean.setWendu(i * i);
            chartDatasBeans.add(bean);
        }
        initChart(viewHolder_lishi.LineChat_LiShi);
        showLineChart(chartDatasBeans, "温度曲线", Color.parseColor("#2178CE"));
        viewHolder_lishi.TvKaiShiShijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerView pvTime = new TimePickerBuilder(me, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        viewHolder_lishi.TvKaiShiShijian.setText(MyTimeUtils.toString(date,new SimpleDateFormat("yyyy-MM-dd")));
                    }
                }).setSubCalSize(15)
                        .setTitleColor(Color.BLACK)//标题文字颜色
                        .setSubmitColor(getResources().getColor(R.color.white))//确定按钮文字颜色
                        .setCancelColor(getResources().getColor(R.color.white))//取消按钮文字颜色
                        .setTitleBgColor(getResources().getColor(R.color.colorPrimary))//标题背景颜色 Night mode
                        .setBgColor(getResources().getColor(R.color.colorPrimary)).build();//滚轮背景颜色 Night mode.build();
                pvTime.show();
            }
        });
        viewHolder_lishi.TvJieShuShiJian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerView pvTime = new TimePickerBuilder(me, new OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                        viewHolder_lishi.TvJieShuShiJian.setText(MyTimeUtils.toString(date,new SimpleDateFormat("yyyy-MM-dd")));
                    }
                }).setSubCalSize(15)
                        .setTitleColor(Color.BLACK)//标题文字颜色
                        .setSubmitColor(getResources().getColor(R.color.white))//确定按钮文字颜色
                        .setCancelColor(getResources().getColor(R.color.white))//取消按钮文字颜色
                        .setTitleBgColor(getResources().getColor(R.color.colorPrimary))//标题背景颜色 Night mode
                        .setBgColor(getResources().getColor(R.color.colorPrimary)).build();//滚轮背景颜色 Night mode.build();
                pvTime.show();
            }
        });
        viewHolder_lishi.tVchaxuntiaojian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final List<String> chaxuntiaojian= Arrays.asList(new String[]{
                        "设定温度","室内温度","室外温度","送风温度","室内湿度","新风阀_A","新风阀_B","回风阀_A","回风阀_B"
                        ,"内热交_A", "外热交_A","压机频_A","排气温_A","膨胀阀_A","高压值_A","低压值_A"
                        ,"内热交_B", "外热交_B","压机频_B","排气温_B","膨胀阀_B","高压值_B","低压值_B"
                });
                OptionsPickerView pvOptions = new OptionsPickerBuilder(me, new OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int options2, int options3, View v) {
                        viewHolder_lishi.tVchaxuntiaojian.setText(chaxuntiaojian.get(options1));
                    }
                })
                        .setSubmitText("确定")//确定按钮文字
                        .setCancelText("取消")//取消按钮文字
                        .setSubCalSize(15)//确定和取消文字大小
                        .setSubmitColor(getResources().getColor(R.color.white))//确定按钮文字颜色
                        .setCancelColor(getResources().getColor(R.color.white))//取消按钮文字颜色
                        .setTitleBgColor(getResources().getColor(R.color.colorPrimary))//标题背景颜色 Night mode
                        .setBgColor(getResources().getColor(R.color.colorPrimary)).build();//滚轮背景颜色 Night mode.build();

                pvOptions.setPicker(chaxuntiaojian);//添加数据源
                pvOptions.show();
            }
        });

    }

    private void initDatas() {
        Bundle bundle = getIntent().getExtras();
        if (null != bundle) {
            bean = (SheBeiListBean.DataBean.ChildrenBeanXXXX.ChildrenBeanXXX.ChildrenBeanXX) bundle.getSerializable(ConstantConfig.LieCheBean);
        }
        //每次进入，默认第一个为选中
        bean.getChildren().get(0).getChildren().get(0).setSelect(true);//
        mAdapter = new GalleryAdapter(this, bean.getChildren());
        rvKongtiaoxuanze.setAdapter(mAdapter);
        getShiShiShuJu(bean.getChildren().get(0).getChildren().get(0).getId());
        tv_kongtiaozhuangkuang.setText(bean.getChildren().get(0).getChildren().get(0).getName());
        noScrollPagerAdapter = new NoScrollPagerAdapter(viewLists);
        vpZhuangkuang.setAdapter(noScrollPagerAdapter);
        vpZhuangkuang.setNoScroll(false);
        vpZhuangkuang.setCurrentItem(0);
        vpZhuangkuang.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Log.d("PageSelected", i + "");
                switch (i) {
                    case 0:
                        rgKongtiaoxuanze.check(R.id.rb_shishi);
                        break;
                    case 1:
                        rgKongtiaoxuanze.check(R.id.rb_lishi);
                        break;
                    case 2:
                        rgKongtiaoxuanze.check(R.id.rb_kongzhi);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                Log.d("ScrollStateChanged", i + "");
            }
        });
        initLiShiData();
        intitKongZhi();

    }

    /**
     * @param AirconID 获取实时数据
     */
    private void getShiShiShuJu(String AirconID) {
        RequestParams params = new RequestParams(APIConfig.postlogin);
        params.setMethod(HttpMethod.GET);
        params.addParameter("RealTimeInfo", true);
        params.addQueryStringParameter("AirconID", AirconID);
        XutilHttpHelp.getInstance().BaseInfoHttp(params, me, new RequestCallBack<KongTiaoShiShiBean>() {
            @Override
            public void onSuccess(KongTiaoShiShiBean result) {
                if (null != result.getData()) {
                    beanall=result.getData();
                    initShiShiData(result.getData());
                }
            }

            @Override
            public void onError(Exception error, String msg) {
                ToastUtil.showShort("登录失败");
                super.onError(error, msg);
            }
        });
    }

    private XAxis xAxis;                //X轴
    private YAxis leftYAxis;            //左侧Y轴
    private YAxis rightYaxis;           //右侧Y轴
    private Legend legend;              //图例
    private LimitLine limitLine;        //限制线

    /**
     * 初始化折线图的布局-20180701
     */
    private void initChart(LineChart lineChart) {
        /***图表设置***/
        //是否展示网格线
        lineChart.setDrawGridBackground(false);
        //是否显示边界
        lineChart.setDrawBorders(false);
        //是否可以拖动
        lineChart.setDragEnabled(false);
        //是否有触摸事件
        lineChart.setTouchEnabled(true);
        //设置XY轴动画效果
        lineChart.getDescription().setText("");
        lineChart.animateY(2500);
        lineChart.animateX(1500);

        /***XY轴的设置***/
        xAxis = lineChart.getXAxis();
        leftYAxis = lineChart.getAxisLeft();
        rightYaxis = lineChart.getAxisRight();
        //X轴设置显示位置在底部
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);
        //保证Y轴从0开始，不然会上移一点
        leftYAxis.setAxisMinimum(0f);
        rightYaxis.setAxisMinimum(0f);

        /***折线图例 标签 设置***/
        legend = lineChart.getLegend();
        //设置显示类型，LINE CIRCLE SQUARE EMPTY 等等 多种方式，查看LegendForm 即可
        legend.setForm(Legend.LegendForm.LINE);
        legend.setTextSize(12f);
        //显示位置 左下方
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        //是否绘制在图表里面
        legend.setDrawInside(false);
        legend.setEnabled(false);
        lineChart.setBackgroundColor(Color.TRANSPARENT);
//是否显示边界
        lineChart.setDrawBorders(false);
        leftYAxis.setEnabled(false);
        xAxis.setDrawGridLines(false);
        xAxis.setTextColor(Color.WHITE);
        rightYaxis.setDrawGridLines(false);
        rightYaxis.setTextColor(Color.WHITE);
        leftYAxis.setDrawGridLines(false);
    }

    /**
     * 曲线初始化设置 一个LineDataSet 代表一条曲线
     *
     * @param lineDataSet 线条
     * @param color       线条颜色
     * @param mode
     */
    private void initLineDataSet(LineDataSet lineDataSet, int color, LineDataSet.Mode mode) {
        lineDataSet.setColor(color);
        lineDataSet.setCircleColor(color);
        lineDataSet.setLineWidth(1f);
        lineDataSet.setCircleRadius(3f);
        lineDataSet.setDrawCircles(false);
        //设置曲线值的圆点是实心还是空心
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setValueTextSize(10f);
        //设置折线图填充
        lineDataSet.setDrawFilled(false);
        lineDataSet.setFormLineWidth(1f);
        lineDataSet.setFormSize(15.f);
        if (mode == null) {
            //设置曲线展示为圆滑曲线（如果不设置则默认折线）
            lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        } else {
            lineDataSet.setMode(mode);
        }
        lineDataSet.setDrawValues(false);
    }

    /**
     * 展示曲线
     *
     * @param dataList 数据集合
     * @param name     曲线名称
     * @param color    曲线颜色
     */
    public void showLineChart(final List<ChartDatasBean> dataList, String name, int color) {
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            ChartDatasBean data = dataList.get(i);
            /**
             * 在此可查看 Entry构造方法，可发现 可传入数值 Entry(float x, float y)
             * 也可传入Drawable， Entry(float x, float y, Drawable icon) 可在XY轴交点 设置Drawable图像展示
             */
            Entry entry = new Entry(i, (float) data.getWendu());
            entries.add(entry);
        }
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                String tradeDate = dataList.get((int) value % dataList.size()).getDate();
                return tradeDate;
            }
        });
        // 每一个LineDataSet代表一条线
        LineDataSet lineDataSet = new LineDataSet(entries, name);
        initLineDataSet(lineDataSet, color, LineDataSet.Mode.CUBIC_BEZIER);
        LineData lineData = new LineData(lineDataSet);
        viewHolder_lishi.LineChat_LiShi.setData(lineData);
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_shishi:
                vpZhuangkuang.setCurrentItem(0);
                break;
            case R.id.rb_lishi:
                vpZhuangkuang.setCurrentItem(1);
                break;
            case R.id.rb_kongzhi:
                vpZhuangkuang.setCurrentItem(2);
                break;

        }

    }
    public enum ITEM_TYPE {
        CHETOU,
        CHEXIANG,
        CHEWEI
    }
    /**
     * 车辆选择适配器
     */
    public class GalleryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private LayoutInflater mInflater;
        private List<SheBeiListBean.DataBean.ChildrenBeanXXXX.ChildrenBeanXXX.ChildrenBeanXX.ChildrenBeanX> mDatas;
        //建立枚举 2个item 类型

        public GalleryAdapter(Context context, List<SheBeiListBean.DataBean.ChildrenBeanXXXX.ChildrenBeanXXX.ChildrenBeanXX.ChildrenBeanX> datats) {
            mInflater = LayoutInflater.from(context);
            mDatas = datats;
        }

        public class ViewHolder_CheXiang extends RecyclerView.ViewHolder {
            public ViewHolder_CheXiang(View arg0) {
                super(arg0);
            }
            TextView mTxt_1;
            TextView mTxt_2;
            TextView mTxt_cheliang;
        }
        public class ViewHolder_CheTou extends RecyclerView.ViewHolder {
            public ViewHolder_CheTou(View arg0) {
                super(arg0);
            }
            TextView mTxt_1;
            TextView mTxt_2;
            TextView mTxt_cheliang;
        }
        public class ViewHolder_CheWei extends RecyclerView.ViewHolder {
            public ViewHolder_CheWei(View arg0) {
                super(arg0);
            }
            TextView mTxt_1;
            TextView mTxt_2;
            TextView mTxt_cheliang;
        }
        @Override
        public int getItemCount() {
            return mDatas.size();
        }

        /**
         * 创建ViewHolder
         */
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == ITEM_TYPE.CHETOU.ordinal()) {
                View view = mInflater.inflate(R.layout.adapter_kongtiaoxuanze_chetou,
                        viewGroup, false);
                ViewHolder_CheTou viewHolder = new ViewHolder_CheTou(view);
//                viewHolder.mTxt_1 = view.findViewById(R.id.tv_kongtiao1);
//                viewHolder.mTxt_2 = view.findViewById(R.id.tv_kongtiao2);
//                viewHolder.mTxt_cheliang = view.findViewById(R.id.tv_chexianghao);
                return viewHolder;
            } else if(i == ITEM_TYPE.CHEWEI.ordinal()){
                View view = mInflater.inflate(R.layout.adapter_kongtiaoxuanze_chewei,
                        viewGroup, false);
                ViewHolder_CheWei viewHolder = new ViewHolder_CheWei(view);
//                viewHolder.mTxt_1 = view.findViewById(R.id.tv_kongtiao1);
//                viewHolder.mTxt_2 = view.findViewById(R.id.tv_kongtiao2);
//                viewHolder.mTxt_cheliang = view.findViewById(R.id.tv_chexianghao);
                return viewHolder;
            } else {
                View view = mInflater.inflate(R.layout.adapter_kongtiaoxuanze,
                        viewGroup, false);
                ViewHolder_CheXiang viewHolder = new ViewHolder_CheXiang(view);
                viewHolder.mTxt_1 = view.findViewById(R.id.tv_kongtiao1);
                viewHolder.mTxt_2 = view.findViewById(R.id.tv_kongtiao2);
                viewHolder.mTxt_cheliang = view.findViewById(R.id.tv_chexianghao);
                return viewHolder;
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder,final int i) {
            if (viewHolder instanceof ViewHolder_CheTou){

            }else if(viewHolder instanceof ViewHolder_CheWei){

            }else{
                ViewHolder_CheXiang viewHolder_cheXiang= (ViewHolder_CheXiang) viewHolder;
                ChangePic(viewHolder_cheXiang.mTxt_1, mDatas.get(i).getChildren().get(0).isSelect());
                ChangePic(viewHolder_cheXiang.mTxt_2, mDatas.get(i).getChildren().get(1).isSelect());
                viewHolder_cheXiang.mTxt_cheliang.setText(mDatas.get(i).getName());
                viewHolder_cheXiang.mTxt_1.setText(mDatas.get(i).getChildren().get(0).getName());
                viewHolder_cheXiang.mTxt_2.setText(mDatas.get(i).getChildren().get(1).getName());
                viewHolder_cheXiang.mTxt_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for (SheBeiListBean.DataBean.ChildrenBeanXXXX.ChildrenBeanXXX.ChildrenBeanXX.ChildrenBeanX mData : mDatas) {
                            mData.getChildren().get(0).setSelect(false);
                            mData.getChildren().get(1).setSelect(false);
                        }
                        mDatas.get(i).getChildren().get(0).setSelect(true);
                        notifyDataSetChanged();
                        getShiShiShuJu(mDatas.get(i).getChildren().get(0).getId());
                        tv_kongtiaozhuangkuang.setText(mDatas.get(i).getChildren().get(0).getName());

                    }
                });
                viewHolder_cheXiang.mTxt_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        for (SheBeiListBean.DataBean.ChildrenBeanXXXX.ChildrenBeanXXX.ChildrenBeanXX.ChildrenBeanX mData : mDatas) {
                            mData.getChildren().get(0).setSelect(false);
                            mData.getChildren().get(1).setSelect(false);
                        }
                        mDatas.get(i).getChildren().get(1).setSelect(true);
                        notifyDataSetChanged();
                        getShiShiShuJu(mDatas.get(i).getChildren().get(1).getId());
                        tv_kongtiaozhuangkuang.setText(mDatas.get(i).getChildren().get(1).getName());
                    }
                });
            }
        }

        @Override
        public int getItemViewType(int position) {
            int lastpostion=mDatas.size()-1;
            if (position==0){
                return ITEM_TYPE.CHETOU.ordinal();
            }else if(position==lastpostion){
                return ITEM_TYPE.CHEWEI.ordinal();
            }else{
                return ITEM_TYPE.CHEXIANG.ordinal();
            }
        }

        /**
         * 修改空调图片
         */
        private void ChangePic(TextView view, boolean isselect) {
            Drawable drawable = null;
            if (isselect) {
                drawable = me.getResources().getDrawable(R.drawable.icon_kongtiao_x);
            } else {
                drawable = me.getResources().getDrawable(R.drawable.icon_kz_an_l);
            }
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            view.setCompoundDrawables(null, drawable, null, null);
        }

    }
    

    static class ViewHolder_lishi {
        @Bind(R.id.linechat_lishi)
        LineChart LineChat_LiShi;
        @Bind(R.id.tv_chaxuntiaojian)
        TextView tVchaxuntiaojian;
        @Bind(R.id.tv_kaishishijian)
        TextView TvKaiShiShijian;
        @Bind(R.id.tv_jieshushijian)
        TextView TvJieShuShiJian;

        ViewHolder_lishi(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder_ShiShi {
        @Bind(R.id.tv_yunxingmoshi)
        TextView tvYunxingmoshi;
        @Bind(R.id.tv_shiwaiwendu)
        TextView tvShiwaiwendu;
        @Bind(R.id.tv_shineiwendu)
        TextView tvShineiwendu;
        @Bind(R.id.tv_shedingwendu)
        TextView tvShedingwendu;
        @Bind(R.id.tv_songfengwendu)
        TextView tvSongfengwendu;
        @Bind(R.id.tv_shineishidu)
        TextView tvShineishidu;
        @Bind(R.id.tv_nongdu)
        TextView tvNongdu;
        @Bind(R.id.tv_pm)
        TextView tvPm;

        ViewHolder_ShiShi(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static class ViewHolder_kongzhi {
        @Bind(R.id.rbt_kongtiaoguanbi)
        RadioButton rbtKongtiaoguanbi;
        @Bind(R.id.rbt_kongtiaodakai)
        RadioButton rbtKongtiaodakai;
        @Bind(R.id.rbt_kongshisuoyou)
        RadioButton rbtKongZhiSuoYou;
        @Bind(R.id.rbt_kongzhidange)
        RadioButton rbtkongzhidange;
        @Bind(R.id.rg_kongzhikongtiaoshu)
        RadioGroup rgKongZhiKongTiaoShu;
        @Bind(R.id.rg_kongtiaokaiguan)
        RadioGroup rgKongtiaokaiguan;
        @Bind(R.id.rg_yunxingmoshi)
        RadioGroup rgYunxingmoshi;
        @Bind(R.id.iv_fengsujia)
        ImageView ivFengsujia;
        @Bind(R.id.tv_fengsu)
        TextView tvFengsu;
        @Bind(R.id.iv_fengsujian)
        ImageView ivFengsujian;
        @Bind(R.id.iv_wendujian)
        ImageView ivWendujian;
        @Bind(R.id.tv_wendu)
        TextView tvWendu;
        @Bind(R.id.iv_wendujia)
        ImageView ivWendujia;
        @Bind(R.id.iv_fengfajian)
        ImageView ivFengfajian;
        @Bind(R.id.tv_xinfengfa)
        TextView tvXinfengfa;
        @Bind(R.id.iv_fengfajia)
        ImageView ivFengfajia;
        @Bind(R.id.iv_huifengfajian)
        ImageView ivHuifengfajian;
        @Bind(R.id.tv_huifenghfa)
        TextView tvHuifenghfa;
        @Bind(R.id.iv_hufengfajia)
        ImageView ivHufengfajia;
        @Bind(R.id.iv_yasuojijian)
        ImageView ivYasuojijian;
        @Bind(R.id.tv_yasuojipinlv)
        TextView tvYasuojipinlv;
        @Bind(R.id.iv_yasuojijia)
        ImageView ivYasuojijia;
        @Bind(R.id.iv_pengzhangfajian)
        ImageView ivPengzhangfajian;
        @Bind(R.id.tv_pengzhangfa)
        TextView tvPengzhangfa;
        @Bind(R.id.iv_pengzhangfajia)
        ImageView ivPengzhangfajia;


        ViewHolder_kongzhi(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
