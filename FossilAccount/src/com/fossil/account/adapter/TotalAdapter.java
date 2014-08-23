package com.fossil.account.adapter;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fossil.fossilaccount.R;

public class TotalAdapter extends BaseAdapter {
	Context context;
	List<Map<String, Object>> items;
	LayoutInflater mInflater;

	public TotalAdapter(Context context, List<Map<String, Object>> items) {
		this.context = context;
		this.items = items;
		System.out.println("items:" + items.toString());
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder hodler;
		if (convertView == null) {
			hodler = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_total_info, null);
			hodler.iv_consume_icon = (ImageView) convertView
					.findViewById(R.id.iv_consume_icon);
			hodler.consume_text = (TextView) convertView
					.findViewById(R.id.consume_text);

			convertView.setTag(hodler);
		} else {
			hodler = (ViewHolder) convertView.getTag();
		}

		hodler.iv_consume_icon.setBackgroundResource(Integer.parseInt(items
				.get(position).get("icon").toString()));
		String strConsumeid = items.get(position).get("consumeid").toString();
		int conid = Integer.parseInt(strConsumeid);
		String des = "∆‰À˚";
		switch (conid) {
		case 1:
			des = "”È¿÷";
			break;

		default:
			break;
		}
		hodler.consume_text.setText(des + ": "
				+ items.get(position).get("money").toString());
		return convertView;
	}

	class ViewHolder {
		ImageView iv_consume_icon;
		TextView consume_text;

	}
}
