package com.qst.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fightshop.R;
import com.shizhefei.fragment.LazyFragment;

public class ThirdStoreLazyFragment extends LazyFragment{
/*	private ListView mListView;
	private ArrayAdapter<String> arr_adapter;*/
	@Override
	public void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_third_store);
		Log.d("fragment","ThirdStorefragment");
		/*mListView = (ListView) findViewById(R.id.lv_third_list);
	        String[] arr_data = {"�ɿڿ��֣�10  10","ѩ����ˮ��20  20","�ߴ���Ƭ��30  30","��ȫ�㳦��40  33","����������50  33"};
	        arr_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arr_data);
	        mListView.setAdapter(arr_adapter);*/
	}
}
