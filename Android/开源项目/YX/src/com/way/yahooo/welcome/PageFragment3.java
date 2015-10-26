package com.way.yahooo.welcome;

import shaoyou.MainActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.way.yahooo.R;

public class PageFragment3 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout root = (LinearLayout) inflater.inflate(R.layout.page3,
				null);

		return root;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		TextView aaTextView = (TextView) getView().findViewById(R.id.jinru);
		aaTextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Toast.makeText(getActivity(), "a", 0).show();
				Intent in = new Intent(getActivity(), MainActivity.class);
				startActivity(in);
				// 我了个大槽
				SharedPreferences sharedPreferences = getActivity()
						.getSharedPreferences("huanying", Context.MODE_PRIVATE); // 私有数据
				Editor editor = sharedPreferences.edit();// 获取编辑器
				editor.putString("nimabi", "ok");

				editor.commit();// 提交修改

			}
		});

	}

	@Override
	public void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}
}
