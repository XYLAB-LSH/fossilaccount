package com.fossil.fossilaccount;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

public class MainActivity extends FragmentActivity   {

	// ����FragmentTabHost����
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

	private void initView() {
		mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
		mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
		// �õ�fragment�ĸ���
		int count = fragments.length;
		for (int i = 0; i < count; i++) {
			// Ϊÿһ��Tab��ť����ͼ�ꡢ���ֺ�����
			TabSpec tabSpec = mTabHost.newTabSpec(i + "").setIndicator(i + "");
			// ��Tab��ť��ӽ�Tabѡ���
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