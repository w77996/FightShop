package com.qst.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fightshop.R;
import com.shizhefei.fragment.LazyFragment;

public class ThirdInventoryLazyerFragment extends LazyFragment {
	private Spinner mSpinner;
	private ListView mListView;
	private List<Map<String, Object>> mListData = new ArrayList<Map<String, Object>>();
	private ListViewBaseAdpter mListViewBaseAdpter;

	@Override
	public void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_third_inventory);
		Log.d("fragment", "Thirdinventoryfragment");

		mListData = getData();
		mListView = (ListView) findViewById(R.id.lv_third);
		mListViewBaseAdpter = new ListViewBaseAdpter();
		mListView.setAdapter(mListViewBaseAdpter);

		final String m[] = { "����", "�����", "��ʳ" };

		mSpinner = (Spinner) findViewById(R.id.sp_third);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_spinner_item,
				m);
		mSpinner.setAdapter(adapter);
		mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				System.out.println(m[position]);

			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {

			}
		});

	}

	private class ListViewBaseAdpter extends BaseAdapter {
		
		
		@Override
		public int getCount() {
			// TODO �Զ����ɵķ������
			return mListData.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO �Զ����ɵķ������
			return mListData.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO �Զ����ɵķ������
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder viewHolder = null;
			if (convertView == null) {
				viewHolder = new ViewHolder();
				LayoutInflater inflater = LayoutInflater
						.from(getApplicationContext());
				convertView = inflater.inflate(R.layout.listview_third_item,
						null);

				viewHolder.mImage = (ImageView) convertView
						.findViewById(R.id.iv_third_listvimg);
				viewHolder.mName = (TextView) convertView
						.findViewById(R.id.tv_third_listname);
				viewHolder.mNum = (TextView) convertView
						.findViewById(R.id.tv_third_listnum);
				convertView.setTag(viewHolder);
			} else {
				viewHolder = (ViewHolder) convertView.getTag();
			}
			viewHolder.mName.setText("��Ʒ����");
			viewHolder.mNum.setText("��Ʒ����");
			return convertView;
		}

	}

	static class ViewHolder {
		public ImageView mImage;
		public TextView mNum;
		public TextView mName;
	}

	private List<Map<String, Object>> getData() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;
		for (int i = 0; i < 20; i++) {
			map = new HashMap<String, Object>();
			map.put("img", R.drawable.ic_launcher);
			map.put("title", "��ȭ��");
			map.put("info", "����Դ������...");
			list.add(map);
		}
		return list;
	}

}
