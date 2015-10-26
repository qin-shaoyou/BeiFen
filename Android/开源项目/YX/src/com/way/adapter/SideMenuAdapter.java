package com.way.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.way.beans.Category;
import com.way.beans.City;
import com.way.beans.Item;
import com.way.yahooo.R;

public class SideMenuAdapter extends BaseAdapter {
	private static final int ITEM_TYPE = 0;
	private static final int CATEGORY_TYPE = 1;
	private final List<Object> mItems;
	private final LayoutInflater mLayoutInflater;

	public SideMenuAdapter(Context context) {
		mItems = new ArrayList<Object>();
		mLayoutInflater = LayoutInflater.from(context);
	}

	public void addContent(List<City> tmpCities) {
		mItems.clear();
		mItems.add(new Category("地区"));
		mItems.add(new Item(Item.INFINITE_ID, "我的城市", R.drawable.editloc));
		for (int i = 0; i < tmpCities.size(); i++)
			mItems.add(new Item(i, tmpCities.get(i).getName(), R.drawable.loc));
		mItems.add(new Category("其他"));
		// mItems.add(new Item(Item.SETTING_ID, "设置",
		// R.drawable.sidebar_icon_settings_dark));
		mItems.add(new Item(Item.FEEDBACK_ID, "意见与建议", R.drawable.xinxing));
		// mItems.add(new Item(Item.SHARE_ID, "分享",
		// R.drawable.sidebar_icon_share_dark));
		mItems.add(new Item(Item.HELP_ID, "帮助", R.drawable.caonimag));
		mItems.add(new Item(Item.SET_ID, "设置", R.drawable.set));
		mItems.add(new Item(Item.ABOUT_ID, "关于", R.drawable.wujiaoxing));
		notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		return mItems.size();
	}

	@Override
	public Object getItem(int position) {
		return mItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public int getItemViewType(int position) {
		return getItem(position) instanceof Item ? ITEM_TYPE : CATEGORY_TYPE;
	}

	@Override
	public int getViewTypeCount() {
		return 2;
	}

	@Override
	public boolean isEnabled(int position) {
		return getItem(position) instanceof Item;
	}

	@Override
	public boolean areAllItemsEnabled() {
		return false;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		int type = getItemViewType(position);
		if (convertView == null
				|| convertView.getTag(R.drawable.ic_launcher + type) == null) {
			switch (type) {
			case ITEM_TYPE:
				convertView = mLayoutInflater.inflate(
						R.layout.sidemenu_list_item_item, parent, false);
				break;
			case CATEGORY_TYPE:
				convertView = mLayoutInflater.inflate(
						R.layout.sidemenu_list_item_category, parent, false);
				break;

			default:
				break;
			}
			viewHolder = buildHolder(convertView);
			convertView.setTag(R.drawable.ic_launcher + type, viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag(R.drawable.ic_launcher
					+ type);
		}
		bindViewData(viewHolder, position);
		return convertView;
	}

	private ViewHolder buildHolder(View convertView) {
		ViewHolder holder = new ViewHolder();
		holder.titleView = (TextView) convertView;
		return holder;
	}

	private void bindViewData(ViewHolder holder, final int position) {
		Object item = getItem(position);
		switch (getItemViewType(position)) {
		case ITEM_TYPE:
			holder.titleView.setText(((Item) item).mTitleStr);
			holder.titleView.setCompoundDrawablesWithIntrinsicBounds(
					((Item) item).mIconRes, 0, 0, 0);
			break;
		case CATEGORY_TYPE:
			holder.titleView.setText(((Category) item).mTitleStr);
			break;

		default:
			break;
		}
	}

	private static final class ViewHolder {
		TextView titleView;
	}
}
