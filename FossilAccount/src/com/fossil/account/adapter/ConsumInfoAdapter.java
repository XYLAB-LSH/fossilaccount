package com.fossil.account.adapter;

import java.util.List;
import java.util.Map;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.fossil.fossilaccount.R;

public class ConsumInfoAdapter extends BaseExpandableListAdapter {
	Context context;
	List<Map<String, Object>> items;
	List<String> childitem;
	LayoutInflater mInflater, mInflater1;

	public ConsumInfoAdapter(Context context, List<Map<String, Object>> items,
			List<String> childitem) {
		this.context = context;
		this.items = items;
		this.childitem = childitem;
		mInflater = LayoutInflater.from(context);
		mInflater1 = LayoutInflater.from(context);
	}

	@Override
	public int getGroupCount() {
		return items.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		String des = childitem.get(groupPosition).toString();
		if (des.equals("")) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return items.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childitem.get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		ViewHolder hodler;
		if (convertView == null) {
			hodler = new ViewHolder();
			convertView = mInflater.inflate(R.layout.item_list_dayinfo, null);
			hodler.num = (TextView) convertView.findViewById(R.id.num);
			hodler.kind = (TextView) convertView.findViewById(R.id.kind);
			hodler.money = (TextView) convertView.findViewById(R.id.money);
			hodler.time = (TextView) convertView.findViewById(R.id.time);
			convertView.setTag(hodler);
		} else {
			hodler = (ViewHolder) convertView.getTag();
		}
		hodler.num.setText(groupPosition + 1 + "");
		hodler.kind.setText(items.get(groupPosition).get("money").toString());
		String des = items.get(groupPosition).get("des").toString();
		if (des.equals("")) {
			des = "нч";
		} else {
			des = "сп";
		}
		hodler.money.setText(des);
		hodler.time.setText(items.get(groupPosition).get("time").toString());
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder1 hodler1;
		if (convertView == null) {
			hodler1 = new ViewHolder1();
			convertView = mInflater1.inflate(R.layout.item_child_layout, null);
			hodler1.tv_child_item = (TextView) convertView
					.findViewById(R.id.tv_child_item);
			convertView.setTag(hodler1);
		} else {
			hodler1 = (ViewHolder1) convertView.getTag();
		}
		hodler1.tv_child_item.setText(childitem.get(childPosition).toString());
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	class ViewHolder {
		TextView num;
		TextView kind;
		TextView money;
		TextView time;
	}

	class ViewHolder1 {
		TextView tv_child_item;
	}
}
