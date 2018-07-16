package com.xinglong.air.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xinglong.air.R;
import com.xinglong.air.base.BasePanel;
import com.xinglong.air.bean.ShengShiXiangMuXuanZeBean;


public class XiangmuXuanzeAdapter extends BaseExpandableListAdapter {
	Context context;
	//子视图显示文字
    CPanel cp;
    GPanel gp;
	ShengShiXiangMuXuanZeBean bean;
	public XiangmuXuanzeAdapter(Context context, ShengShiXiangMuXuanZeBean bean){
		this.context=context;
		this.bean=bean;
	}
	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return bean.getShiDatas().size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return bean.getShiDatas().get(groupPosition).getXiangMuDatas().size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater= LayoutInflater.from(context);
		convertView=inflater.inflate(R.layout.layout_profile_node, null);
		gp=new GPanel(convertView);
		gp.tv_sheng.setText(bean.getShiDatas().get(groupPosition).getShiName());
		if(groupPosition==0){
			gp.line_groupshang.setVisibility(View.INVISIBLE);
		}

			if(groupPosition==bean.getShiDatas().size()-1){
			gp.line_groupquanxia.setVisibility(View.INVISIBLE);

		}

		 if(!isExpanded){
			gp.line_groupxia.setVisibility(View.INVISIBLE);
			gp.line_groupshang.setVisibility(View.INVISIBLE);
		 }
		return convertView;
	}

	@Override
	public View getChildView(final int groupPosition, final int childPosition,
							 boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater= LayoutInflater.from(context);
		convertView=inflater.inflate(R.layout.layout_selectable_header, null);
		cp=new CPanel(convertView);
		cp.tv_itemvalue.setText(bean.getShiDatas().get(groupPosition).getXiangMuDatas().get(childPosition).getXiangMuName());
		if(bean.getShiDatas().get(groupPosition).getXiangMuDatas().get(childPosition).isChecked()){
			cp.cb_xuanze.setChecked(true);
		}
		cp.cb_xuanze.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
				if(b){
					bean.getShiDatas().get(groupPosition).getXiangMuDatas().get(childPosition).setChecked(true);
				}else {
					bean.getShiDatas().get(groupPosition).getXiangMuDatas().get(childPosition).setChecked(false);
				}
			}
		});
		if(isLastChild){
			cp.tv_diergenxia.setVisibility(View.INVISIBLE);
		}
		if(isLastChild&&groupPosition==bean.getShiDatas().size()-1){
			cp.tv_diergenxia.setVisibility(View.INVISIBLE);
			cp.line_zuichangxian.setVisibility(View.INVISIBLE);
		}
		if(groupPosition==bean.getShiDatas().size()-1){
			cp.line_zuichangxian.setVisibility(View.INVISIBLE);
		}

		return convertView;
	}
	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}
	public class GPanel extends BasePanel {
		TextView tv_sheng,line_groupshang,line_groupxia,line_groupquanshang,line_groupquanxia;
        ImageView iv_info_next;
		LinearLayout line_groupchang;
		public GPanel(View convertView) {
			super(convertView);
			tv_sheng=(TextView) convertView.findViewById(R.id.tv_sheng);
			line_groupchang=convertView.findViewById(R.id.line_groupchagn);
			line_groupshang=convertView.findViewById(R.id.line_groupshang);
			line_groupxia=convertView.findViewById(R.id.line_groupxia);
			line_groupquanshang=convertView.findViewById(R.id.line_groupquanshang);
			line_groupquanxia=convertView.findViewById(R.id.line_groupquanxia);
		}
	}
	public class CPanel extends BasePanel {
		TextView tv_itemvalue,tv_diergenxia;
		CheckBox cb_xuanze;
		LinearLayout line_zuichangxian;
		public CPanel(View convertView) {
			super(convertView);
			tv_itemvalue=(TextView) convertView.findViewById(R.id.tv_itemvalue);
			cb_xuanze=(CheckBox) convertView.findViewById(R.id.cb_xuanze);
			tv_diergenxia=convertView.findViewById(R.id.tv_diergenxia);
			line_zuichangxian=convertView.findViewById(R.id.line_zuichangxian);

		}
	}
}
