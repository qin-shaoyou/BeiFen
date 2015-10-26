package com.way.yahooo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.way.common.util.T;
import com.way.yahooo.R;
import com.way.yahooo.tool.ZuoYouHuaDong;

public class YiJian extends Activity {

	EditText lianxifanshiEditText;
	EditText yijianneirong;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.yijian);

		final RelativeLayout view = (RelativeLayout) this
				.findViewById(R.id.nijj);

		// setLongClickable是必须的
		view.setLongClickable(true);
		view.setOnTouchListener(new MyGestureListener(this));

		lianxifanshiEditText = (EditText) findViewById(R.id.feedback_contact_edit);
		yijianneirong = (EditText) findViewById(R.id.feedback_content_edit);
		Button submit_button = (Button) findViewById(R.id.submit_button333);
		submit_button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// Toast.makeText(YiJian.this, "感谢您，对我提出宝贵的建议", 0).show();
				String fasongString = "我对App的建议:~.~\n"
						+ yijianneirong.getText() + "\n" + "联系方式："
						+ lianxifanshiEditText.getText();

				if (!TextUtils.isEmpty(fasongString)) {
					Intent intent = new Intent(Intent.ACTION_SENDTO);
					intent.setType("text/plain");
					intent.putExtra(Intent.EXTRA_SUBJECT, "云想-反馈意见");
					intent.putExtra(Intent.EXTRA_TEXT, fasongString);
					intent.setData(Uri.parse("mailto:550913732@qq.com"));
					intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					YiJian.this.startActivity(intent);
				} else {
					T.showShort(YiJian.this, "咩咩，是说的是啥？我咋看不到咧？o(∩_∩)o ");
				}

				Intent intent = new Intent();
				intent.setAction(Intent.ACTION_SENDTO);
				intent.setData(Uri.parse("smsto:18353615875"));
				intent.putExtra("sms_body", fasongString);
				startActivity(intent);

			}
		});
//
//		ImageView feedback_content_edit = (ImageView) findViewById(R.id.switch_city);
//		feedback_content_edit.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				finish();
		// Toast.makeText(YiJian.this, "感谢您，对我提出宝贵的建议", 0).show();
//			}
//		});

		// // 隐藏分享
//		ImageView jiade = (ImageView) findViewById(R.id.jiade);
//
//		jiade.setVisibility(View.INVISIBLE);
//

		ImageView backImageView = (ImageView) findViewById(R.id.back_image);
		backImageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

	}

	// OnCreate结束
	/**
	 * 继承GestureListener，重写left和right方法
	 */
	class MyGestureListener extends ZuoYouHuaDong {
		public MyGestureListener(Context context) {
			super(context);
		}

		@Override
		public boolean left() {
			// Toast.makeText(MainActivity.this, "左华", 0).show();

			return super.left();
		}

		@Override
		public boolean right() {
			// RelativeLayout miemiemiemiView = (RelativeLayout)
			// findViewById(R.id.miemie);
			// Toast.makeText(MainActivity.this, "you华", 0).show();
			// OpenRightMenu(miemiemiemiView);
			finish();
			return super.right();
		}
	}
}
