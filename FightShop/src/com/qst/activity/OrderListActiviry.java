package com.qst.activity;


import java.util.ArrayList;
import java.util.List;

import com.example.fightshop.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class OrderListActiviry extends Activity{
	private ListView mOrderList;
	private List<String> mDataList = new ArrayList<String>();
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO 自动生成的方法存根
			super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			setContentView(R.layout.activity_orderlist);
			getData();
			mOrderList = (ListView)findViewById(R.id.lv_orderlist);
			mOrderList.setAdapter(new OrderListViewAdapter());
			
			
		}
		
		private class OrderListViewAdapter extends BaseAdapter{

			@Override
			public int getCount() {
				// TODO 自动生成的方法存根
				return mDataList.size();
			}

			@Override
			public Object getItem(int position) {
				// TODO 自动生成的方法存根
				return mDataList.get(position);
			}

			@Override
			public long getItemId(int position) {
				// TODO 自动生成的方法存根
				return position;
			}

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ViewHolder viewHolder;
				if(convertView==null){
					viewHolder = new ViewHolder();
					LayoutInflater inflate = LayoutInflater.from(getApplicationContext());
					convertView = inflate.inflate(R.layout.listview_orderlist_item, null);
					convertView.setTag(viewHolder);
				
				}else{
					viewHolder = (ViewHolder) convertView.getTag();
				}
				return convertView;
			}
		
		}
		
		private static class ViewHolder{
			
		}
		
		private void getData(){
			for(int i =0;i<20;i++){
				mDataList.add(i+"");
			}
		
		}
}
