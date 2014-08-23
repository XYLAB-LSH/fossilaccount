package com.fossil.fossilaccount;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fossil.account.adapter.TotalAdapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment implements OnItemClickListener {
	private Context context;
	private Activity act;
	private TextView tv_top_center;
	// private DatePicker datePicker;
	private GridView gv_total_info;
	private List<Map<String, Object>> items;
	private TotalAdapter adapter;
	private int[] icons = { R.drawable.plane, R.drawable.car, R.drawable.shone,
			R.drawable.test1, R.drawable.test2, R.drawable.test3,
			R.drawable.test4, R.drawable.test5, R.drawable.test6};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View parentView = inflater
				.inflate(R.layout.fragment2, container, false);
		initView(parentView);
		return parentView;
	}

	private void initView(View view) {
		context = getActivity().getApplicationContext();
		act = getActivity();
		tv_top_center = (TextView) view.findViewById(R.id.tv_top_center);
		getDate();
		// tv_top_center.setText("统计");
		// datePicker = (DatePicker) view.findViewById(R.id.datePicker);
		// setDatePicker();
		gv_total_info = (GridView) view.findViewById(R.id.gv_total_info);
		getitems();
		adapter = new TotalAdapter(context, items);
		gv_total_info.setAdapter(adapter);
		gv_total_info.setOnItemClickListener(this);
	}

	private void getitems() {
		items = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 9; i++) {
			Map map = new HashMap();
			map.put("icon", icons[i] + "");
			map.put("consumeid", "1");
			map.put("money", 1000 + i + "");
			items.add(map);
		}
	}

	private void getDate() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int monthOfYear = calendar.get(Calendar.MONTH);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		tv_top_center.setText(year + "年" + (monthOfYear + 1) + "月" + dayOfMonth
				+ "日");
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Map map = (Map) adapter.getItem(position);
		Intent intent = new Intent(act, DetailInfoAct.class);
		intent.putExtra("time", tv_top_center.getText().toString());
		intent.putExtra("consumeid", map.get("consumeid").toString());
		startActivity(intent);

	}

}
