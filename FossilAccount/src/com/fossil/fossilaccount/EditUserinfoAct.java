package com.fossil.fossilaccount;

import com.fossil.account.util.MyShareprefrence;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditUserinfoAct extends Activity implements OnClickListener {
	private Context context;
	private Activity act;
	private TextView tv_top_center;
	private EditText et_nickname;
	private Button btn_post_userinfo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_userinfo);
		initView();
	}

	private void initView() {
		context = this;
		act = this;
		tv_top_center = (TextView) findViewById(R.id.tv_top_center);
		tv_top_center.setText("信息设置");
		et_nickname = (EditText) findViewById(R.id.et_nickname);				
		btn_post_userinfo = (Button) findViewById(R.id.btn_post_userinfo);
		btn_post_userinfo.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_post_userinfo:
			String val_nickname = et_nickname.getText().toString().trim();
			if (val_nickname.equals("")) {
				Toast.makeText(context, "请先填写资料", 1000).show();
				return;
			}
			MyShareprefrence.getInstance(context).setNickName(val_nickname);
			Toast.makeText(context, "资料设置成功", 1000).show();
			
			
			Intent backIntent = new Intent(act, Fragment3.class);
			setResult(RESULT_OK,backIntent);
			act.finish();
			break;

		default:
			break;
		}
	}

}
