package com.way.yahooo.welcome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.way.yahooo.R;

public class PageFragment2 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		LinearLayout root = (LinearLayout) inflater.inflate(
R.layout.page2,
				null);

		return root;
	}


}
