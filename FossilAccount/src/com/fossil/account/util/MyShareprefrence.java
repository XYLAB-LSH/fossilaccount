package com.fossil.account.util;

import android.content.Context;
import android.content.SharedPreferences;

public class MyShareprefrence {
	private static SharedPreferences share;
	private static MyShareprefrence instance;
	private static String LOCAL_NAME = "fossil";

	public static MyShareprefrence getInstance(Context context) {
		if (instance == null) {
			instance = new MyShareprefrence();
			share = context.getSharedPreferences(LOCAL_NAME,
					Context.MODE_PRIVATE);
		}
		return instance;
	}

	public void setLogoPath(String logoPath) {
		share.edit().putString("logopath", logoPath).commit();
	}

	public String getLogoPath() {
		return share.getString("logopath", "");
	}

	public void setNickName(String nickName) {
		share.edit().putString("nickname", nickName).commit();
	}

	public String getNickName() {
		return share.getString("nickname", "hello");
	}

	public void clearAll() {
		setLogoPath("");
	}
}
