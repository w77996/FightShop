package com.qst.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.fightshop.R;
import com.qst.adapter.OrderDetailAdapter;
import com.qst.entity.OrderDetailItemBean;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TodayOrderDetailActivity  extends Activity{

	    private ListView mlv_today_detail_order_detail;
	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.activity_today_detail);

	       /* listView = (ListView) findViewById(R.id.listView);
	        String[]arr_data = {"���֣�10","ѩ�̣�20","��Ƭ��30","���ȣ�40","�ɰ��ࣺ50","�ɰ��ࣺ50","�ɰ��ࣺ50","�ɰ��ࣺ50","�ɰ��ࣺ50","�ɰ��ࣺ50"};
	        arr_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr_data);
	        listView.setAdapter(arr_adapter);*/

	        mlv_today_detail_order_detail = (ListView) findViewById(R.id.lv_today_detail_order_detail);
	        List<OrderDetailItemBean> itemBeenList = new ArrayList<OrderDetailItemBean>();
	        itemBeenList.add(new OrderDetailItemBean("9.28","���֣�1�� ��Ƭ��2�� �ɰ��ࣺ2�� ���ȣ�5�� ������1�� ѩ�̣�3","��50"));
	        itemBeenList.add(new OrderDetailItemBean("10.08","��Ƭ��2�� ���ȣ�5�� ��Ƭ��4�� ���֣�3�� ������ 1","��18"));
	        itemBeenList.add(new OrderDetailItemBean("10.17","�ɰ��ࣺ3�� ���֣�1�� ���ȣ�3","��10"));
	        for(int i = 0;i < 17; i++){
	            itemBeenList.add(new OrderDetailItemBean("10.27","ѩ��:3","��3"));
	        }
	        mlv_today_detail_order_detail.setAdapter(new OrderDetailAdapter(this,itemBeenList));
	        
	        mlv_today_detail_order_detail.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO �Զ����ɵķ������
					Intent intent = new Intent(getApplication(),SingleOrderDetailActivity.class);
					intent.putExtra("position data", mlv_today_detail_order_detail.getItemAtPosition(position).toString());
					startActivity(intent);
					
				}
			});
	    }

}
