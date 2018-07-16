package com.xinglong.air.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class NoScrollPagerAdapter extends PagerAdapter {
	private ArrayList<View> mListViews;  
    
    public NoScrollPagerAdapter(ArrayList<View> mListViews) {  
        this.mListViews = mListViews;//构造方法，参数是我们的页卡，这样比较方便。  
    }  
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		 if (mListViews != null) {
             return mListViews.size();
         }      
         return 0;
	}
     @Override
    public Object instantiateItem(ViewGroup container, int position) {
    	   container.addView(mListViews.get(position), 0); 
           return mListViews.get(position);
   }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
    	// TODO Auto-generated method stub
    	  container.removeView(mListViews.get(position));
    }
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return (arg0 == arg1);
	}
	
}
