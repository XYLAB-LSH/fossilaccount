package com.fossil.fossilaccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fossil.account.adapter.DayInfoAdapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment1 extends Fragment {
	private TextView tv_top_center, btn_save;
	private ListView lv_day_info;
	private List<Map<String, Object>> items;
	private DayInfoAdapter adapter;
	private Context context;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		context = getActivity().getApplicationContext();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View parentView = inflater
				.inflate(R.layout.fragment1, container, false);
		initView(parentView);

		return parentView;
	}

	private void initView(View view) {
		tv_top_center = (TextView) view.findViewById(R.id.tv_top_center);
		tv_top_center.setText("¼ÇÒ»±Ê");
		btn_save = (TextView) view.findViewById(R.id.btn_save);
		btn_save.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(context, "ÔÝÎ´¿ª·Å£¬¾´ÇëÆÚ´ý", 1000).show();
			}
		});
		lv_day_info = (ListView) view.findViewById(R.id.lv_day_info);

		getitems();
		adapter = new DayInfoAdapter(context, items);
		lv_day_info.setAdapter(adapter);

	}

	private void getitems() {
		items = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("time", "10:11");
			map.put("kind", "³Ô·¹");
			map.put("money", "15");
			items.add(map);
		}

	}
}
