package com.fossil.fossilaccount;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class WelcomeAct extends Activity {
	private Context context;
	private Activity act;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		context = this;
		act = this;
		handler.sendEmptyMessageDelayed(1, 2000);
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
