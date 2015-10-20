package com.activity;

import github.chenupt.ModelPagerAdapter;
import github.chenupt.PagerManager;
import github.chenupt.SpringIndicator;

import java.util.List;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.activity.welcome.PageFragment1;
import com.activity.welcome.PageFragment2;
import com.activity.welcome.PageFragment3;
import com.activity.welcome.PageFragment4;
import com.example.springindicator.R;
import com.google.common.collect.Lists;

public class Welcome extends FragmentActivity {
	private ViewPager viewPager;
	private List<PageFragment1> fragments;
	private FragmentManager fragmentManager;

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
		manager.addFragment(new PageFragment4());
		ModelPagerAdapter adapter = new ModelPagerAdapter(
				getSupportFragmentManager(), manager);
		viewPager.setAdapter(adapter);

		springIndicator.setViewPager(viewPager);

		if (manager.getFragmentCount() == 0) {
			Toast.makeText(Welcome.this, "1", 0).show();
		} else if (manager.getFragmentCount() == 1) {
			Toast.makeText(Welcome.this, "2", 0).show();
		}
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

	}

	private List<String> getTitles() {
		return Lists.newArrayList("Ⅰ", "Ⅱ", "Ⅲ", "Ⅳ");
	}
}
