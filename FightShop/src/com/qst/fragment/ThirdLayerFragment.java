package com.qst.fragment;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fightshop.R;
import com.shizhefei.fragment.LazyFragment;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.IndicatorViewPager.IndicatorFragmentPagerAdapter;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;

public class ThirdLayerFragment extends LazyFragment{
	private IndicatorViewPager mIndicatorViewPager;
	private LayoutInflater mInflate;
	@Override
	protected void onCreateViewLazy(Bundle savedInstanceState) {
		super.onCreateViewLazy(savedInstanceState);
		setContentView(R.layout.fragment_third);
		Log.d("firstfragment","Thirdfragment");
		Resources res = getResources();
		ViewPager viewPager = (ViewPager) findViewById(R.id.fragment_third_viewPager);
		Indicator indicator = (Indicator) findViewById(R.id.fragment_third_indicator);
		
		
		
		indicator.setScrollBar(new ColorBar(getApplicationContext(), Color.BLUE, 5));
		int selectColor = res.getColor(R.color.tab_main_text_1);
		int unSelectColor = res.getColor(R.color.tab_main_text_2);
		mIndicatorViewPager = new IndicatorViewPager(indicator, viewPager);
		indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(unSelectColor,selectColor));

		mInflate = LayoutInflater.from(getApplicationContext());
		mIndicatorViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
}

	private class MyAdapter extends IndicatorFragmentPagerAdapter {

		public MyAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
		}

		@Override
		public int getCount() {
			return 2;
		}

		@Override
		public View getViewForTab(int position, View convertView, ViewGroup container) {
			if (convertView == null) {
				convertView = mInflate.inflate(R.layout.tab_top, container,false);
			}
			TextView textView = (TextView) convertView;
			if(position==0){
				textView.setText("¿â´æ");
			}else if(position==1){
				textView.setText("½ø»õ");
			}
			
			return convertView;
		}

		@Override
		public Fragment getFragmentForPage(int position) {
			ThirdInventoryLazyerFragment thirdInventoryLazyerFragment = new ThirdInventoryLazyerFragment();
			ThirdStoreLazyFragment thirdStoreLazyFragment = new ThirdStoreLazyFragment();
			if(position==0){
			return thirdInventoryLazyerFragment;
			}else if(position==1){
				return thirdStoreLazyFragment;
			}else{
				return thirdInventoryLazyerFragment;
			}
		
		}
	}
}
