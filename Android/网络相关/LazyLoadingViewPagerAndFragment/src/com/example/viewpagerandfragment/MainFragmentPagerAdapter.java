package com.example.viewpagerandfragment;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

	List<Fragment> listFragment;
	
	public MainFragmentPagerAdapter(FragmentManager fm,List<Fragment> listFragment) {
		super(fm);
		this.listFragment=listFragment;
	}

	@Override
	public Fragment getItem(int arg0) {
		return listFragment.get(arg0);
	}

	@Override
	public int getCount() {
		return listFragment.size();
	}

}
