package com.way.yahooo;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.way.yahooo.R;
import com.way.yahooo.tool.ZuoYouHuaDong;

public class About extends Activity {
	private TextView youxiangTextView;
	private TextView dao1;
	private TextView dao2;
	private TextView dao3;
	private LinearLayout dao4;
	private LinearLayout dao5;
	private EditText passEditTex;
	private final Boolean i = true;
	private Boolean i2 = true;
	private Boolean i3 = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.about);

		ImageView backImageView = (ImageView) this
				.findViewById(R.id.thisback_image);
		backImageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		// 左滑关闭
		final RelativeLayout view = (RelativeLayout) this
				.findViewById(R.id.brand2);
		EditText inputServer = new EditText(this);
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// setLongClickable是必须的
		view.setLongClickable(true);
		view.setOnTouchListener(new MyGestureListener(this));
		youxiangTextView = (TextView) findViewById(R.id.youxiang);

		youxiangTextView.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);// 下划线
		youxiangTextView.setText("550913732@qq.com");
		youxiangTextView.setTextColor(Color.WHITE);
		TextView copy = (TextView) findViewById(R.id.copyright);
		// 我的app图标
		ImageView brand = (ImageView) findViewById(R.id.brand);

		brand.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Boolean sBoolean = !(dao1.getVisibility() == View.VISIBLE);
				if (sBoolean) {

					dao1.setVisibility(View.VISIBLE);
					dao2.setVisibility(View.VISIBLE);
					dao3.setVisibility(View.INVISIBLE);
					dao4.setVisibility(View.INVISIBLE);
					dao5.setVisibility(View.INVISIBLE);

				} else if (!sBoolean) {
					dao1.setVisibility(View.INVISIBLE);
					dao2.setVisibility(View.INVISIBLE);
					dao3.setVisibility(View.VISIBLE);
					dao4.setVisibility(View.VISIBLE);
					dao5.setVisibility(View.VISIBLE);

				}
			}
		});

		brand.setOnLongClickListener(new OnLongClickListener() {

			@Override
			public boolean onLongClick(View v) {

				// builder.setTitle("Server").setIcon(android.R.drawable.ic_dialog_info).setView(inputServer)
				// .setNegativeButton("Cancel", null);
				// builder.setPositiveButton("Ok", new
				// DialogInterface.OnClickListener() {
				//
				// @Override
				// public void onClick(DialogInterface dialog, int which) {
				// inputServer.getText().toString();
				// }
				// });
				// builder.show();

				return false;
			}
		});

		youxiangTextView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// 发送邮件
				Intent intent = new Intent(Intent.ACTION_SEND);
				intent.setType("plain/text");
				intent.putExtra(intent.EXTRA_EMAIL, youxiangTextView.getText()
						.toString());
				intent.putExtra(Intent.EXTRA_SUBJECT, "MIEMIE");
				// intent.putExtra(Intent.EXTRA_TEXT, value)
				startActivity(intent);
			}
		});



		Button okButton = (Button) findViewById(R.id.OK);

		dao1 = (TextView) findViewById(R.id.daokedao1);
		dao2 = (TextView) findViewById(R.id.daokedao2);
		dao3 = (TextView) findViewById(R.id.app_information);
		dao4 = (LinearLayout) findViewById(R.id.upgradeLayout);
		dao5 = (LinearLayout) findViewById(R.id.dao5);

		passEditTex = (EditText) findViewById(R.id.pass);

		copy.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Button ok2 = (Button) findViewById(R.id.OK2);
				Button okButton = (Button) findViewById(R.id.OK);
				dao3.setVisibility(View.INVISIBLE);
				dao4.setVisibility(View.INVISIBLE);
				dao5.setVisibility(View.INVISIBLE);
				okButton.setVisibility(View.VISIBLE);
				passEditTex.setVisibility(View.VISIBLE);
				ok2.setVisibility(View.VISIBLE);
			}
		});
		Button ok2 = (Button) findViewById(R.id.OK2);
		ok2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Button ok2 = (Button) findViewById(R.id.OK2);
				Button okButton = (Button) findViewById(R.id.OK);
				dao3.setVisibility(View.VISIBLE);
				dao4.setVisibility(View.VISIBLE);
				dao5.setVisibility(View.VISIBLE);
				okButton.setVisibility(View.INVISIBLE);
				passEditTex.setVisibility(View.INVISIBLE);
				ok2.setVisibility(View.INVISIBLE);
			}
		});
		okButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (passEditTex.getText().toString().equals("25341")) {
					Toast.makeText(About.this, "口令正确", 0).show();
					String guoyanfei = "感谢有你。不离不弃  你是我前进的动力源泉 咩咩";
					AlertDialog.Builder diaBuilder = new AlertDialog.Builder(
							About.this);
					diaBuilder.setTitle("致谢宝贝儿（郭燕飞）：");
					diaBuilder.setMessage(guoyanfei);
					diaBuilder.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									nimas();

								}
							});
					diaBuilder.setNegativeButton("Soulmate",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									nimas();
								}
							});
					diaBuilder.show();

				} else if (i && i2 && i3) {
					Toast.makeText(About.this, "错误，还剩两次机会!", 0).show();
					i2 = false;
				} else if (!i2 && i3) {
					Toast.makeText(About.this, "错误，还剩一次机会!", 0).show();
					i3 = false;
				} else if (!i3) {
					Toast.makeText(About.this, "Game Over", 1).show();
					finish();
				}

			}
		});

	}

	private void nimas() {
		String url = "http://www.lovewith.me/u/22721"; // web
														// address

		Intent intent = new Intent(Intent.ACTION_VIEW);

		intent.setData(Uri.parse(url));

		startActivity(intent);
	}

	// Oncreate 结束

	/**
	 * 继承GestureListener，重写left和right方法
	 */
	private class MyGestureListener extends ZuoYouHuaDong {
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
