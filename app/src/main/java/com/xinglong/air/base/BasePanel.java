package com.xinglong.air.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
/**
 * @category 基础容器
 * @author jinghq
 */
public class BasePanel {

	public Context context;
	public Activity act;
	public Dialog dialog;
	public View v;

	public int isView = 0;

	public BasePanel(Activity act) {
		isView = 0;
		context = act;
		this.act = act;
	}

	public BasePanel(Dialog dialog) {
		isView = 1;
		context = dialog.getContext();
		this.dialog = dialog;
	}

	public BasePanel(View v) {
		context = v.getContext();
		isView = 2;
		this.v = v;
	}

	public View view(int res) {
		View view = null;
		switch (isView) {
		case 0:
			view = act.findViewById(res);
			break;
		case 1:
			view = dialog.findViewById(res);
			break;
		case 2:
			view = v.findViewById(res);
			break;
		default:
			break;
		}
		return view;
	}

	/**
	 * @category 隐藏自己
	 */
	public void hide() {
		hide(v);
	}

	public View load(int id) {
		return view(id);
	}

	public RelativeLayout loadRelative(int id) {
		return (RelativeLayout) view(id);
	}

	public LinearLayout loadLinear(int id) {
		return (LinearLayout) view(id);
	}

	public ListView loadList(int id) {
		return (ListView) view(id);
	}

	public GridView loadGrid(int id) {
		return (GridView) view(id);
	}

	public ProgressBar loadProgressBar(int id) {
		return (ProgressBar) view(id);
	}

	public TextView loadText(int id) {
		return (TextView) view(id);
	}

	public Button loadButton(int id) {
		return (Button) view(id);
	}

	public CheckBox loadCheckBox(int id) {
		return (CheckBox) view(id);
	}

	public EditText loadEdit(int id) {
		return (EditText) view(id);
	}

	public ImageView loadImage(int id) {
		return (ImageView) view(id);
	}

	public ImageButton loadImageButton(int id) {
		return (ImageButton) view(id);
	}

	public View loadView(int id) {
		return view(id);
	}

	public void notSee(View v) {
		v.setVisibility(View.INVISIBLE);
	}

	/** @category 设置TV的文�? */
	public void text(TextView tv, String text) {
		try {
			tv.setText(text);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public String getText(TextView tv) {
		return tv.getText().toString();
	}

	public String getText(EditText et) {
		return et.getText().toString();
	}

	public void hide(View v) {
		v.setVisibility(View.GONE);
	}

	public void show(View v) {
		v.setVisibility(View.VISIBLE);
	}

	public void bg(View v, int resId) {
		v.setBackgroundResource(resId);
	}

	/**
	 * @category 自动加载布局,并获取好自定义Panel
	 */
	public static View loadLayout(Context context, View contentView,
                                  int layoutId) {
		if (contentView == null) {
			contentView = LayoutInflater.from(context).inflate(layoutId, null);
		}
		return contentView;
	}
}
