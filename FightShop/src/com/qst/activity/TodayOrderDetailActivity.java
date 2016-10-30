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
	        String[]arr_data = {"可乐：10","雪碧：20","薯片：30","咖啡：40","可爱多：50","可爱多：50","可爱多：50","可爱多：50","可爱多：50","可爱多：50"};
	        arr_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr_data);
	        listView.setAdapter(arr_adapter);*/

	        mlv_today_detail_order_detail = (ListView) findViewById(R.id.lv_today_detail_order_detail);
	        List<OrderDetailItemBean> itemBeenList = new ArrayList<OrderDetailItemBean>();
	        itemBeenList.add(new OrderDetailItemBean("9.28","可乐：1， 薯片：2， 可爱多：2， 咖啡：5， 烤肠：1， 雪碧：3","金额：50"));
	        itemBeenList.add(new OrderDetailItemBean("10.08","薯片：2， 咖啡：5， 麦片：4， 可乐：3， 烤肠： 1","金额：18"));
	        itemBeenList.add(new OrderDetailItemBean("10.17","可爱多：3， 可乐：1， 咖啡：3","金额：10"));
	        for(int i = 0;i < 17; i++){
	            itemBeenList.add(new OrderDetailItemBean("10.27","雪碧:3","金额：3"));
	        }
	        mlv_today_detail_order_detail.setAdapter(new OrderDetailAdapter(this,itemBeenList));
	        
	        mlv_today_detail_order_detail.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					// TODO 自动生成的方法存根
					Intent intent = new Intent(getApplication(),SingleOrderDetailActivity.class);
					intent.putExtra("position data", mlv_today_detail_order_detail.getItemAtPosition(position).toString());
					startActivity(intent);
					
				}
			});
	    }

}
