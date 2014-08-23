package com.fossil.fossilaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;

public class WelcomeAct extends Activity {
	private Context context;
	private Activity act;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		context = this;
		act = this;
		 MobclickAgent.openActivityDurationTrack(false);
		 MobclickAgent.updateOnlineConfig( context );
		 PushAgent.getInstance(context).onAppStart();
		 
		 
		handler.sendEmptyMessageDelayed(1, 2000);
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
	public Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			switch (msg.what) {
			case 1:
				startActivity(new Intent(act, MainActivity.class));
				act.finish();
				break;

			default:
				break;
			}
		}

	};

}
