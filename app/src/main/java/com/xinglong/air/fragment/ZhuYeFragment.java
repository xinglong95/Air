package com.xinglong.air.fragment;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.citzx.cslibrary.net.RequestCallBack;
import com.citzx.cslibrary.net.XutilHttpHelp;
import com.citzx.cslibrary.utils.ToastUtil;
import com.xinglong.air.R;
import com.xinglong.air.activity.KongTiaoXinXiActivity;
import com.xinglong.air.activity.XianLuXinXiActivity;
import com.xinglong.air.base.APIConfig;
import com.xinglong.air.base.RootFragment;
import com.xinglong.air.bean.KongTiaoGuangZhangBean;
import com.xinglong.air.bean.KongTiapYunXingBean;
import com.xinglong.air.bean.LieJianLv;
import com.xinglong.air.ui.CircleProgressBarView;
import com.xinglong.air.ui.ProductProgressBar;

import org.xutils.http.HttpMethod;
import org.xutils.http.RequestParams;

import java.lang.reflect.Field;
import java.text.NumberFormat;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @category主界面之【主页】
 */
public class ZhuYeFragment extends RootFragment {

    @Bind(R.id.tv_xianluxinxi)
    TextView tvXianluxinxi;
    @Bind(R.id.tv_kongtiaogaikuang)
    TextView tvKongtiaogaikuang;
    @Bind(R.id.tv_jiankzngzhishu)
    TextView tvJiankzngzhishu;
    @Bind(R.id.product_progress_liejianlv)
    ProductProgressBar productProgressLiejianlv;
    @Bind(R.id.cp_yunxingzhong)
    CircleProgressBarView cpYunxingzhong;
    @Bind(R.id.cp_tingzhiyunxing)
    CircleProgressBarView cpTingzhiyunxing;
    @Bind(R.id.cp_yanzhong)
    CircleProgressBarView cpYanzhong;
    @Bind(R.id.cp_yiban)
    CircleProgressBarView cpYiban;
    @Bind(R.id.cp_qingwei)
    CircleProgressBarView cpQingwei;
    @Bind(R.id.cp_zhengchang)
    CircleProgressBarView cpZhengchang;

    @Override
    protected int initViewLayoutId() {
        return R.layout.fragment_home;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        Typeface typeFace = Typeface.createFromAsset(getActivity().getAssets(), "fonts/digital-7.ttf");
        tvJiankzngzhishu.setTypeface(typeFace, Typeface.BOLD_ITALIC);

        initData();
        return rootView;
    }

    private void initData() {
        getLieJianLv();
        getGongZuoZhuangTai();
        getYunXingLiang();
    }

    /**
     * @param fenzi
     * @param fenfu
     * @return  求百分比
     */
    private int getProgress(int fenzi,int fenfu){
        int progress=0;
        NumberFormat numberFormat = NumberFormat.getInstance();
        // 设置精确到小数点后2位
        numberFormat.setMaximumFractionDigits(0);
        String result = numberFormat.format((float)fenzi/(float)fenfu*100);
        progress=Integer.parseInt(result);
        return progress;
    }

    /**
     * @param view
     * @param fenzi
     * @param fenmu  设置圆形进度条
     */
    private void setProgress4CPview(CircleProgressBarView view,int fenzi,int fenmu){
        view.setProgressWithAnimation(getProgress(fenzi,fenmu));
        view.startProgressAnimation();
        view.setCenterText(fenzi+"");
    }
    /**
     * 获取工作状态
     */
    private void getGongZuoZhuangTai() {
        RequestParams params = new RequestParams(APIConfig.postlogin);
        params.setMethod(HttpMethod.GET);
        params.addParameter("GetErrOverview", true);
        XutilHttpHelp.getInstance().BaseInfoHttp(params, getActivity(), new RequestCallBack<KongTiaoGuangZhangBean>() {
            @Override
            public void onSuccess(KongTiaoGuangZhangBean result) {
                if (null!=result.getData()) {
                    setProgress4CPview(cpYanzhong,result.getData().getSeriousFault(),result.getData().getTotal());
                    setProgress4CPview(cpYiban,result.getData().getGeneralFault(),result.getData().getTotal());
                    setProgress4CPview(cpQingwei,result.getData().getMinorFault(),result.getData().getTotal());
                    setProgress4CPview(cpZhengchang,result.getData().getNormal(),result.getData().getTotal());
                }
            }

            @Override
            public void onError(Exception error, String msg) {
                ToastUtil.showShort("请求失败，请检查网络接口");
                super.onError(error, msg);
            }
        });
    }
    /**
     * 获取运行量
     */
    private void getYunXingLiang() {
        RequestParams params = new RequestParams(APIConfig.postlogin);
        params.setMethod(HttpMethod.GET);
        params.addParameter("GetProjectOverview", true);
        XutilHttpHelp.getInstance().BaseInfoHttp(params, getActivity(), new RequestCallBack<KongTiapYunXingBean>() {
            @Override
            public void onSuccess(KongTiapYunXingBean result) {
                if (null!=result.getData()) {
                    setProgress4CPview(cpYunxingzhong,result.getData().getRunning(),result.getData().getTotal());
                    setProgress4CPview(cpTingzhiyunxing,result.getData().getStop(),result.getData().getTotal());
                }
            }

            @Override
            public void onError(Exception error, String msg) {
                ToastUtil.showShort("请求失败，请检查网络接口");
                super.onError(error, msg);
            }
        });
    }
    private void getLieJianLv() {
        RequestParams params = new RequestParams(APIConfig.postlogin);
        params.setMethod(HttpMethod.GET);
        params.addParameter("GetHealthInfo", true);
        XutilHttpHelp.getInstance().BaseInfoHttp(params, getActivity(), new RequestCallBack<LieJianLv>() {
            @Override
            public void onSuccess(LieJianLv result) {
                if (result.getData().getHealthStatus() != 0) {
                    productProgressLiejianlv.setProgress(result.getData().getHealthStatus());
                }
            }

            @Override
            public void onError(Exception error, String msg) {
                ToastUtil.showShort("请求失败，请检查网络接口");
                super.onError(error, msg);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.tv_xianluxinxi, R.id.tv_kongtiaogaikuang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_xianluxinxi:
                getActivity().startActivity(new Intent(getActivity(), XianLuXinXiActivity.class));
                break;
            case R.id.tv_kongtiaogaikuang:
                getActivity().startActivity(new Intent(getActivity(), KongTiaoXinXiActivity.class));
                break;
        }
    }
}
