package com.xinglong.air.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.lang.reflect.Field;

public class BaseFragment extends Fragment {
	public Activity ac;
	public BaseFragment me;
	protected View mainView = null;
	protected int layoutId = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		me = this;
		ac = this.getActivity();
		layoutId=initViewLayoutId();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

		initView(inflater, container);

		if (mainView != null) {
			return mainView;
		} else {
			return super.onCreateView(inflater, container, savedInstanceState);
		}

	}

	/**
	 * @category 初始化父控，件，
	 * @param inflater
	 * @param container
	 * @param
	 * @return void
	 */
	private void initView(LayoutInflater inflater, ViewGroup container) {
		
		if(layoutId==0){
			mainView=new View(ac);
		}else{
			mainView = inflater.inflate(layoutId, container, false);
		}
		initView();
	}

	/**
	 * @category 初始化
	 * @return void
	 */
	protected void initView() {

	}

	/** 
	 * @category 主布
	 * @return
	 * @return int
	 */
	protected int initViewLayoutId() {
		return 0;
	}

	/**
	 * @category use this you should have used {@link }
	 * @param Id
	 * @return
	 * @return View
	 */
	protected View findViewById(int Id) {

		return mainView.findViewById(Id);
	}

	public Activity getValidActivity() {

		return this.getActivity();

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

}
