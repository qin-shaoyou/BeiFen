package com.example.viewpagerandfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainTab03 extends Fragment
{
	private boolean isVisibleToUser ;
	private boolean isInit;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		View newsLayout = inflater.inflate(R.layout.main_tab_03, container, false);
		System.err.println("MainTab03--");
		
		
		if(getUserVisibleHint() && isVisibleToUser){
			initView();
		}
		return newsLayout;
	}

	//设置当前界面可见
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		super.setUserVisibleHint(isVisibleToUser);
		
		if(isVisibleToUser){
			this.isVisibleToUser=true;
		}
	}
	
	public void initView(){
		if(!isInit){
			System.err.println("加载第33333333个界面");
			isInit=true;
		}
	}
}
