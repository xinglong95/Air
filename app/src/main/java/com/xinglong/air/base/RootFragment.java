package com.xinglong.air.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.lang.reflect.Field;

public class RootFragment extends BaseFragment {
	public float dp;
//	private LoadingDialog loading;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		dp = 10;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		try {
			Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
			childFragmentManager.setAccessible(true);
			childFragmentManager.set(this, null);
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * 缓冲图标
	 * @param show
	 */
//	protected void Loading(boolean show) {
//		if (loading != null) {
//		} else {
//			loading = new LoadingDialog(getActivity());
//		}
//		if (show) {
//			loading.show();
//			loading.startloading();
//		} else {
//			loading.dismiss();
//		}
//	}
}
