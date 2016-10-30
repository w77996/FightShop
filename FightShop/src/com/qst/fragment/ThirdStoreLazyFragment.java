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
	        String[] arr_data = {"可口可乐：10  10","雪碧汽水：20  20","高达薯片：30  30","三全香肠：40  33","卫龙辣条：50  33"};
	        arr_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arr_data);
	        mListView.setAdapter(arr_adapter);*/
	}
}
