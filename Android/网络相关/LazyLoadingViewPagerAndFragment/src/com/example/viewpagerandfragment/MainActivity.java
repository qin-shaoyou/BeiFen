package com.example.viewpagerandfragment;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	// textView

	private TextView chat_tv;
	private TextView conn_tv;
	private TextView comm_tv;

	private ImageView mTabLine;
	private ViewPager mViewPager;
	private MainFragmentPagerAdapter adapter;
	private List<Fragment> fragmentList;
	private int currentIndex;// 当前viewPager页数
	private int screenWidth; // 屏幕的宽度

	MainTab01 tab1;
	MainTab02 tab2;
	MainTab03 tab3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
		initTabLine();
	}

	private void initView() {
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		chat_tv = (TextView) findViewById(R.id.main_chat_tv);
		conn_tv = (TextView) findViewById(R.id.main_conn_tv);
		comm_tv = (TextView) findViewById(R.id.main_community_tv);

		fragmentList = new ArrayList<Fragment>();

		tab1 = new MainTab01();
		tab2 = new MainTab02();
		tab3 = new MainTab03();
		fragmentList.add(tab1);
		fragmentList.add(tab2);
		fragmentList.add(tab3);

		adapter = new MainFragmentPagerAdapter(
				this.getSupportFragmentManager(), fragmentList);

		mViewPager.setAdapter(adapter);

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				// 初始化所有的tab的textView的字体颜色

				if (mViewPager.getAdapter() instanceof PagerAdapter) {
					FragmentPagerAdapter pagerAdapter = (FragmentPagerAdapter) mViewPager
							.getAdapter();

					if (pagerAdapter.getItem(position) instanceof MainTab01) {
						tab1 = (MainTab01) pagerAdapter.getItem(position);
						if (mViewPager.getCurrentItem() == 1)
							return;
						tab1.initView();
					} else if (pagerAdapter.getItem(position) instanceof MainTab02) {
						tab2 = (MainTab02) pagerAdapter.getItem(position);
						if (mViewPager.getCurrentItem() == 2)
							return;
						tab2.initView();
					} else if (pagerAdapter.getItem(position) instanceof MainTab03) {
						tab3 = (MainTab03) pagerAdapter.getItem(position);
						if (mViewPager.getCurrentItem() == 3)
							return;
						tab3.initView();
					}
				}

				resetTextView();

				switch (position) {

				case 0:
					chat_tv.setTextColor(getResources().getColor(
							R.color.tab_selected));

					break;
				case 1:
					conn_tv.setTextColor(getResources().getColor(
							R.color.tab_selected));

					break;
				case 2:
					comm_tv.setTextColor(getResources().getColor(
							R.color.tab_selected));

					break;
				}
				// 设置当前页码
				currentIndex = position;
			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPixels) {
				// TODO Auto-generated method stub

				LinearLayout.LayoutParams lp = (LayoutParams) mTabLine
						.getLayoutParams();
				if (currentIndex == 0 && position == 0) { // 0-->1

					lp.leftMargin = (int) (positionOffset
							* (screenWidth * 1.0 / 3) + currentIndex
							* (screenWidth / 3));

				} else if (currentIndex == 1 && position == 0) {// 1-->0
					lp.leftMargin = (int) (-(1 - positionOffset)
							* (screenWidth * 1.0 / 3) + currentIndex
							* (screenWidth / 3));

				} else if (currentIndex == 1 && position == 1) {// 1-->2
					lp.leftMargin = (int) (positionOffset
							* (screenWidth * 1.0 / 3) + currentIndex
							* (screenWidth / 3));

				} else if (currentIndex == 2 && position == 1) {// 2-->1
					lp.leftMargin = (int) (-(1 - positionOffset)
							* (screenWidth * 1.0 / 3) + currentIndex
							* (screenWidth / 3));

				}
				mTabLine.setLayoutParams(lp);

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		mViewPager.setCurrentItem(0);

	}

	private void initTabLine() {
		mTabLine = (ImageView) findViewById(R.id.id_tab_line);

		// 获取手机分辨率
		DisplayMetrics outMetrics = new DisplayMetrics();
		getWindow().getWindowManager().getDefaultDisplay()
				.getMetrics(outMetrics);
		screenWidth = outMetrics.widthPixels;
		// 设置mTabLine的长度为手机宽度分辨率的1/3
		LinearLayout.LayoutParams lp = (android.widget.LinearLayout.LayoutParams) mTabLine
				.getLayoutParams();
		lp.width = screenWidth / 3;
		mTabLine.setLayoutParams(lp);
	}

	private void resetTextView() {
		chat_tv.setTextColor(getResources().getColor(R.color.tab_unselected));
		conn_tv.setTextColor(getResources().getColor(R.color.tab_unselected));
		comm_tv.setTextColor(getResources().getColor(R.color.tab_unselected));
	}

	// Tab点击监听
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.main_chat_layout:
			mViewPager.setCurrentItem(0);
			Toast.makeText(MainActivity.this, "0", Toast.LENGTH_SHORT).show();
			break;

		case R.id.main_conn_layout:

			Toast.makeText(MainActivity.this, "1", Toast.LENGTH_SHORT).show();
			mViewPager.setCurrentItem(1);
			break;

		case R.id.main_community_layout:

			Toast.makeText(MainActivity.this, "2", Toast.LENGTH_SHORT).show();
			mViewPager.setCurrentItem(2);
			break;
		}

	}

}
