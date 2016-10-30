package com.qst.activity;


import com.example.fightshop.R;
import com.qst.db.ShopDB;
import com.qst.fragment.FirstLayerFragment;
import com.qst.fragment.FourLayerFragment;
import com.qst.fragment.SecondLayerFragment;
import com.qst.fragment.ThirdLayerFragment;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.IndicatorViewPager.IndicatorFragmentPagerAdapter;
import com.shizhefei.view.viewpager.SViewPager;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;


public class MainActivity extends FragmentActivity{
	private IndicatorViewPager mIndicatorViewPager;
	public ShopDB mShop;
	public SQLiteDatabase mShopDBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
    	SViewPager viewPager = (SViewPager) findViewById(R.id.tabmain_viewPager);
		Indicator indicator = (Indicator) findViewById(R.id.tabmain_indicator);
		
		mIndicatorViewPager = new IndicatorViewPager(indicator, viewPager);
		mIndicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
		
		mShop = new ShopDB(this);
		mShopDBase = mShop.getWritableDatabase();

		
    }
    
    private class MyAdapter extends IndicatorFragmentPagerAdapter {
		private String[] tabNames = { "首页", "记录", "进货", "设置" };
		private int[] tabIcons = { R.drawable._95, R.drawable.input, R.drawable.store,
				R.drawable._03};
		private LayoutInflater inflater;

		public MyAdapter(FragmentManager fragmentManager) {
			super(fragmentManager);
			inflater = LayoutInflater.from(getApplicationContext());
		}
		
		@Override
		public int getCount() {
			return tabNames.length;
		}
		/**
		 * 底部选项卡初始化设置
		 */
		@Override
		public View getViewForTab(int position, View convertView, ViewGroup container) {
			if (convertView == null) {
				convertView = (TextView) inflater.inflate(R.layout.tb_main, container, false);
			}
			TextView textView = (TextView) convertView;
			textView.setText(tabNames[position]);
			
			textView.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[position], 0, 0);
			return textView;
		}
		
		/**
		 * 点击按钮时切换的Fragment
		 * 
		 */

		@Override
		public Fragment getFragmentForPage(int position) {
			FirstLayerFragment mainFragment = new FirstLayerFragment();
			SecondLayerFragment secondLayerFragment =new SecondLayerFragment();
			ThirdLayerFragment thirdLayerFragment = new ThirdLayerFragment();
			FourLayerFragment fourLayerFragment = new FourLayerFragment();
			if(position==0){
				return mainFragment;
			}else if(position ==1){
				return secondLayerFragment;
			}else if(position ==2){
				return thirdLayerFragment;
			}else if(position==3){
				return fourLayerFragment;
			}else{
				return mainFragment;
			}
			
		}
	}
   
}
