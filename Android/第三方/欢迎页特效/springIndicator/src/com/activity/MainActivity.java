package com.activity;

import github.chenupt.multiplemodel.viewpager.ModelPagerAdapter;
import github.chenupt.multiplemodel.viewpager.PagerManager;
import github.chenupt.springindicator.SpringIndicator;

import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.example.springindicator.R;
import com.google.common.collect.Lists;

public class MainActivity extends FragmentActivity {
	private ViewPager viewPager;
	private List<PageFragment> fragments;
	private FragmentManager fragmentManager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.main);
		
		viewPager = (ViewPager) findViewById(R.id.viewpager);
        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
        //初始化ViewPager
        PagerManager manager = new PagerManager();
        manager.setTitles(getTitles());
        //添加4个ViewPager页面
        manager.addFragment(new PageFragment());
        manager.addFragment(new PageFragment());
        manager.addFragment(new PageFragment());
        manager.addFragment(new PageFragment());
        ModelPagerAdapter adapter = new ModelPagerAdapter(getSupportFragmentManager(), manager);
        viewPager.setAdapter(adapter);
		
        springIndicator.setViewPager(viewPager);
	}
	private List<String> getTitles(){
        return Lists.newArrayList("1", "2", "3", "4");
    }
}
