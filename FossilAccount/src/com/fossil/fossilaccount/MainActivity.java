package com.fossil.fossilaccount;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost.TabSpec;

import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;

public class MainActivity extends FragmentActivity   {

	// 定义FragmentTabHost对象
	private FragmentTabHost mTabHost;
	private RadioGroup mTabRg;

	private final Class[] fragments = { Fragment1.class, Fragment2.class,
			Fragment3.class};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		initView();
	}
	public void onResume() {
	    super.onResume();
	    MobclickAgent.onResume(this);       //统计时长
	}
	public void onPause() {
	    super.onPause();
	    MobclickAgent.onPause(this);
	}
	private void initView() {
		
		 PushAgent mPushAgent = PushAgent.getInstance(this);
		 mPushAgent.enable();
		 PushAgent.getInstance(this).onAppStart();
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		// 得到fragment的个数
		int count = fragments.length;
		for (int i = 0; i < count; i++) {
			// 为每一个Tab按钮设置图标、文字和内容
			TabSpec tabSpec = mTabHost.newTabSpec(i + "").setIndicator(i + "");
			// 将Tab按钮添加进Tab选项卡中
			mTabHost.addTab(tabSpec, fragments[i], null);
		}

		mTabRg = (RadioGroup) findViewById(R.id.tab_rg_menu);
		mTabRg.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.tab_rb_1:
					mTabHost.setCurrentTab(0);
					break;
				case R.id.tab_rb_2:
					mTabHost.setCurrentTab(1);

					break;
				case R.id.tab_rb_3:

					mTabHost.setCurrentTab(2);
					break;
		

				default:
					break;
				}
			}
		});

		mTabHost.setCurrentTab(0);
	}

	



}