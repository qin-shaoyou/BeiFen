package com.way.yahooo;

import java.util.List;

import shaoyou.MainActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

import com.google.common.collect.Lists;
import com.huanying.ModelPagerAdapter;
import com.huanying.PagerManager;
import com.huanying.SpringIndicator;
import com.way.yahooo.R;
import com.way.yahooo.welcome.PageFragment1;
import com.way.yahooo.welcome.PageFragment2;
import com.way.yahooo.welcome.PageFragment3;

public class niambi extends FragmentActivity {
	private ViewPager viewPager;
	private List<PageFragment1> fragments;
	private FragmentManager fragmentManager;
	public static final String FIRST_RUN_APP = "firstRunApp";
	@SuppressLint({ "NewApi", "ResourceAsColor" })
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		this.setContentView(R.layout.main);

		// RelativeLayout page1 = (RelativeLayout) findViewById(R.id.page1);
		// Drawable page1color = page1.getBackground();

		// LinearLayout hello = (LinearLayout) findViewById(R.id.hello);
		// hello.setBackgroundColor(getResources().getColor(R.color.black));
		// 如果第一次运行应用就需要定位

		viewPager = (ViewPager) findViewById(R.id.viewpager);
		SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
		View leftviewView = LayoutInflater.from(this).inflate(R.layout.main,
				null);
		// 初始化ViewPager
		PagerManager manager = new PagerManager();
		manager.setTitles(getTitles());
		// 添加4个ViewPager页面

		manager.addFragment(new PageFragment1());
		manager.addFragment(new PageFragment2());
		manager.addFragment(new PageFragment3());

		ModelPagerAdapter adapter = new ModelPagerAdapter(
				getSupportFragmentManager(), manager);
		viewPager.setAdapter(adapter);

		springIndicator.setViewPager(viewPager);

		// springIndicator.getBackground().setAlpha(255);

		// siTextColor ： 指示器上每个tab的文本颜色
		// siSelectedTextColor ： 当前tab的字体颜色
		// siTextBg ： 整个tab的背景颜色
		// siTextSize ： tab上的字体大小
		// siIndicatorColor ： 设置所有tab的统一的颜色，即圆形区域的颜色
		// siIndicatorColors ：
		// 和siIndicatorColor一样，也是设置tab的颜色的，只是其值是个数组，可分别设置每个tab的颜色
		// siRadiusMax ： 当ViewPager切换时， tab产生粘连效果时的最大圆形半径
		// siRadiusMin ：当ViewPager切换时， tab产生粘连效果时的最小圆形半径

		SharedPreferences share = getSharedPreferences("huanying",
				Activity.MODE_WORLD_READABLE);



		String str = share.getString("nimabi", "");
		if (str.equals("ok")) {
			Intent in = new Intent(niambi.this, MainActivity.class);
			startActivity(in);
			finish();

		}
		// Toast.makeText(niambi.this, str, 0).show();


	}

	@Override
	protected void onResume() {
		Log.d("www", "onResume onResume onResume onResume");

		super.onResume();
	}

	@Override
	protected void onResumeFragments() {
		Log.d("www",
				"onResumeFragments onResumeFragments onResumeFragments onResumeFragments");

		super.onResumeFragments();
	}

	// Tab炫酷 的显示文字
	private List<String> getTitles() {
		return Lists.newArrayList("Ⅰ", "Ⅱ", "Ⅲ");
	}

	@Override
	protected void onRestart() {
		Log.d("www", "onRestart onRestart onRestart onRestart");

		super.onRestart();
	}

	@Override
	protected void onDestroy() {
		Log.d("www", "onDestroy onDestroy onDestroy onDestroy");
		super.onDestroy();

	}

	@Override
	protected void onStart() {
		// View leftviewView1 =
		// LayoutInflater.from(this).inflate(R.layout.page1,
		// null);
		Log.d("www", "onStart onStart onStart onStart");
		super.onStart();
	}

	@Override
	protected void onStop() {
		Log.d("www", "onStop onStop onStop onStop");
		finish();
		super.onStop();
	}
}
