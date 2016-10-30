package com.qst.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.fightshop.R;
import com.qst.activity.OrderListActiviry;
import com.shizhefei.fragment.LazyFragment;

public class SecondLayerFragment extends LazyFragment{
	private Button mButtonSure;
	private Button mButtonCancel;
	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_second);
		Log.d("firstfragment","secondfragment");
		
		mButtonSure = (Button)findViewById(R.id.btn_second_sure);
		mButtonCancel = (Button)findViewById(R.id.btn_second_cancel);
		
		mButtonSure.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO 自动生成的方法存根
					Intent intent = new Intent(getApplicationContext(),OrderListActiviry.class);
					startActivity(intent);
			}
		});
		
}

}
