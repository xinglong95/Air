package com.xinglong.air.base;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.map.offline.MKOfflineMap;
import com.citzx.cslibrary.core.LibraryApplication;
import com.code19.library.L;
import com.xinglong.air.utils.MSPUtils;

import org.xutils.x;


/**
 * Created by Administrator on 2017/2/23.
 */

public class AirApplication extends Application{
    private static AirApplication mApplication;

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        AirApplication.context = context;
    }

    private static Context context;

    public static MSPUtils sp = null;

    private static  MKOfflineMap mOffline;

    public final static String UserName="UserName";//验证令牌
    public final static String PassWord="PassWord";//验证令牌
    public final static String TOKEN="Token";//验证令牌
    public final static String ZIDONG="ZiDong";//自动登录
    private static String userName;//13455262992
    private static String token;//0
    private static String passWord;//0





    public static String getToken() {
        return sp.getString(TOKEN);
    }

    public static void setToken(String str) {
        token = str;
        sp.setString(TOKEN, str);
        LibraryApplication.setToken(str);
    }

    public static String getPassWord() {
        return sp.getString(PassWord);
    }
    public static String getUserName() {
        return sp.getString(UserName);
    }
    public static int getisAuto() {
        return sp.getInt(ZIDONG);
    }

//    public static List<Activity> activities=new ArrayList<>();
//    public static Activity mainactivity;
//
//
//
//    public  static HashMap<String,Activity> activityHashMap=new HashMap<String, Activity>();
    @Override
    public void onCreate() {
        super.onCreate();
        mApplication=this;
        AirApplication.context = mApplication;
        LibraryApplication.init(mApplication);
        x.Ext.init(mApplication);
        context = getApplicationContext();
        sp = new MSPUtils(this);
        L.init(true,"Air");

    }

    /**
     * @param token
     */
    public static void setLoginInfo(String username,String password,String token,int isauto) {
        sp.setString(UserName,username);
        sp.setString(PassWord,password);
        sp.setInt(ZIDONG,isauto);
        setToken(token);
    }

    /**
     * 移除存在sp的账号密码
     */
    public static void reMoveLoginInfo(){
        sp.remove(UserName);
        sp.remove(PassWord);
        sp.remove(TOKEN);
        LibraryApplication.setShouJiHao("");
        LibraryApplication.setUUID("");
        LibraryApplication.setToken("");
    }
//    public static void removeActivity(Activity activity){
//        activities.remove(activity);
//    }
//    public static void removeActivityexceptMain(){
//        for(Activity activity:activities){
//            activity.finish();
//        }
//    }
//    public static Activity getMainactivity() {
//        return mainactivity;
//    }
//
//    public static void setMainactivity(Activity mainactivity) {
//        CSApplication.mainactivity = mainactivity;
//    }
//    public static void removeAllActiviyies(){
//        for(Activity activity:activities){
//            activity.finish();
//        }
//        mainactivity.finish();
//    }

}
