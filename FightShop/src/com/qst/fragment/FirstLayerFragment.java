package com.qst.fragment;



import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;


import com.example.fightshop.R;
import com.qst.activity.TodayOrderDetailActivity;
import com.shizhefei.fragment.LazyFragment;


public class FirstLayerFragment extends LazyFragment{
	
	 private ListView mlv_frist_goodslist;
	 private ArrayAdapter<String> arr_adapter;
	 private LinearLayout mLinearLayout;
	 
	@Override
	
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_first_main);
		Log.d("firstfragment","firstfragment");
		mLinearLayout = (LinearLayout)findViewById(R.id.linearlayout_firt_today);
		mlv_frist_goodslist = (ListView) findViewById(R.id.lv_frist_goodslist);
		String[]arr_data = {"���֣�10","ѩ�̣�20","��Ƭ��30","���ȣ�40","�����۲裺50","�ɰ��ࣺ60"};
		arr_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arr_data);
	    /*arr_adapter = new ArrayAdapter<String>(FirstLayerFragment.this, android.R.layout.simple_list_item_1,arr_data);*/
		mlv_frist_goodslist.setAdapter(arr_adapter);
		
		mLinearLayout.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO �Զ����ɵķ������
				Intent intent =new Intent (getApplicationContext(),TodayOrderDetailActivity.class);
				startActivity(intent);
			}
		});
		
}
	

}
