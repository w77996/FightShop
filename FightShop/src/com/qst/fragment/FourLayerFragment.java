package com.qst.fragment;

import android.os.Bundle;
import android.util.Log;

import com.example.fightshop.R;
import com.shizhefei.fragment.LazyFragment;

public class FourLayerFragment extends LazyFragment{
	
	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_four);
		Log.d("fragment","fourfragment");
		
}

}
