package com.fossil.account.adapter;

import java.util.List;
import java.util.Map;

import com.fossil.fossilaccount.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DayInfoAdapter extends BaseAdapter{
	Context context;
	List<Map<String,Object>> items;
	LayoutInflater mInflater;
	public DayInfoAdapter(Context context,List<Map<String,Object>> items){
		this.context=context;
		this.items=items;
		mInflater=LayoutInflater.from(context);
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
		if(convertView==null){
			hodler=new ViewHolder();
			convertView=mInflater.inflate(R.layout.item_list_dayinfo, null);
			hodler.num=(TextView)convertView.findViewById(R.id.num);
			hodler.kind=(TextView)convertView.findViewById(R.id.kind);
			hodler.money=(TextView)convertView.findViewById(R.id.money);
			hodler.time=(TextView)convertView.findViewById(R.id.time);
			convertView.setTag(hodler);	
		}else{
			hodler=(ViewHolder)convertView.getTag();
		}
		hodler.num.setText(position+1+"");
		hodler.kind.setText(items.get(position).get("kind").toString());
		hodler.money.setText(items.get(position).get("money").toString());
		hodler.time.setText(items.get(position).get("time").toString());
		
		
		return convertView;
	}
class ViewHolder{
	TextView num;
	TextView kind;
	TextView money;
	TextView time;
}
}
