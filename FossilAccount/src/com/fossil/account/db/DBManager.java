package com.fossil.account.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
	 private DBHelper helper;  
	    private SQLiteDatabase db;  
	      
	    public DBManager(Context context) {  
	        helper = new DBHelper(context);  
	        //��ΪgetWritableDatabase�ڲ�������mContext.openOrCreateDatabase(mName, 0, mFactory);  
	        //����Ҫȷ��context�ѳ�ʼ��,���ǿ��԰�ʵ����DBManager�Ĳ������Activity��onCreate��  
	        db = helper.getWritableDatabase();  
	    }  
	    //�ο�
	    //http://blog.csdn.net/yamingli/article/details/9834813
	    
	    
	    
	    
	     
	    public void closeDB() {  
	        db.close();  
	    }  
}
