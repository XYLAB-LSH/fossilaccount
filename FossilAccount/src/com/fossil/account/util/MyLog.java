package com.fossil.account.util;

import android.util.Log;

public class MyLog {
	private static final boolean DEBUG = true;

	public static void d(String str) {
		if (DEBUG)
			Log.d("MMM", str);
	}

	public static void v(String str) {
		if (DEBUG)
			Log.v("MMM", str);
	}

	public static void e(String str) {
		if (DEBUG)
			Log.e("MMM", str);
	}
}
