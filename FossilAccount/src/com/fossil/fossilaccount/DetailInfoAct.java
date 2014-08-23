package com.fossil.fossilaccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;

import com.fossil.account.adapter.ConsumInfoAdapter;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;

public class DetailInfoAct extends Activity {
	private Context context;
	private Activity act;
	private ExpandableListView lv_consume_info;
	private List<Map<String, Object>> items;
	private List<String> childitems;
	String time;
	String consumeid;
	private ConsumInfoAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_info);
		initView();
	}
	public void onResume() {
	    super.onResume();
	    MobclickAgent.onPageStart("SplashScreen"); //统计页面
	    MobclickAgent.onResume(this);          //统计时长
	}
	public void onPause() {
	    super.onPause();
	    MobclickAgent.onPageEnd("SplashScreen"); // 保证 onPageEnd 在onPause 之前调用,因为 onPause 中会保存信息 
	    MobclickAgent.onPause(this);
	}
	private void initView() {
		context = this;
		act = this;
		PushAgent.getInstance(context).onAppStart();
		lv_consume_info = (ExpandableListView) findViewById(R.id.lv_consume_info);
		lv_consume_info.setGroupIndicator(null); // 去图标
		try {
			Intent intent = getIntent();
			time = intent.getStringExtra("time");
			consumeid = intent.getStringExtra("consumeid");
		} catch (Exception e) {
			// TODO: handle exception
			act.finish();
		}
		getitems();
		adapter = new ConsumInfoAdapter(context, items, childitems);
		lv_consume_info.setAdapter(adapter);
//关闭其他项
		lv_consume_info.setOnGroupExpandListener(new OnGroupExpandListener() {

			@Override
			public void onGroupExpand(int groupPosition) {
				for (int i = 0; i < items.size(); i++) {
					if (groupPosition != i) {
						lv_consume_info.collapseGroup(i);
					}
				}

			}

		});
	}

	private void getitems() {
		items = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 10; i++) {
			Map map = new HashMap();
			map.put("money", "20" + new Random().nextInt(10));
			map.put("time", "10:10");
			map.put("des", "备注：时间地点人物");
			items.add(map);
		}

		childitems = new ArrayList<String>();

		for (int i = 0; i < items.size(); i++) {
			String des = items.get(i).get("des").toString();
			childitems.add(des);
		}

	}
}
