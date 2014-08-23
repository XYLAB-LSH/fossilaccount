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
	    MobclickAgent.onPageStart("SplashScreen"); //ͳ��ҳ��
	    MobclickAgent.onResume(this);          //ͳ��ʱ��
	}
	public void onPause() {
	    super.onPause();
	    MobclickAgent.onPageEnd("SplashScreen"); // ��֤ onPageEnd ��onPause ֮ǰ����,��Ϊ onPause �лᱣ����Ϣ 
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
