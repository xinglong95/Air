package com.xinglong.air.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

public class BaseFragmentActivity extends FragmentActivity {
	public Context context = this;
	public BaseFragmentActivity me;
	// 输入法管理器
	public InputMethodManager imm = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		me = this;
		context = this;
		// 屏幕全屏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	}

	public void placeView(int Rid, BaseFragment bf) {
		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.replace(Rid, bf);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
//		ft.commit();// 提交
		ft.commitAllowingStateLoss();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

	}

	public String getMyName() {
		return this.getClass().getSimpleName();
	}

	public void layout(int layout) {
		setContentView(layout);

	}

	public View load(int resId) {
		return findViewById(resId);
	}

	public View load(View view, int resId) {
		return view.findViewById(resId);
	}
	/** @category 软键盘的控制 */
	public void input(View v, boolean flag) {
		try {
			if (flag) {// 显示软
				imm.showSoftInput(v, 0);
				// imm.toggleSoftInput(2, 1);
			} else {// 隐藏软
				imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}
}
