package com.qst.activity;

import com.example.fightshop.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SingleOrderDetailActivity extends Activity{
	private ListView mListView;
	private ArrayAdapter<String> arr_adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO �Զ����ɵķ������
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_singleorder_detail);
		
		System.out.println(getIntent().getStringExtra("position data"));
		mListView = (ListView) findViewById(R.id.lv_third_list);
        String[] arr_data = {"�ɿڿ��֣�10  10","ѩ����ˮ��20  20","�ߴ���Ƭ��30  30","��ȫ�㳦��40  33","����������50  33"};
        arr_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr_data);
        mListView.setAdapter(arr_adapter);
	}

}
