package com.cst.skeleton.adapter.base;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 基础列表Adapter
 * @author MonsterStorm
 *
 * @param <T>
 */
public class BaseListAdapter<T> extends BaseAdapter {
	protected Context mContext;
	protected LayoutInflater mInflater;
	protected List<T> mList;
	
	public BaseListAdapter(Context context, List<T> list){
		this.mContext = context;
		this.mList = list;
		mInflater = LayoutInflater.from(context);
	}

	public void setList(List<T> list){
		this.mList = list;
	}
	
	@Override
	public int getCount() {
		if (mList != null) {
			return mList.size();
		}
		return 0;
	}

	@Override
	public T getItem(int position) {
		if (mList != null && position < mList.size()) {
			return mList.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return null;
	}
}
