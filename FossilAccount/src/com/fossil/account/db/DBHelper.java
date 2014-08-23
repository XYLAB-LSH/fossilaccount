package com.fossil.account.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {  
  
    private static final String DATABASE_NAME = "account.db";  
    private static final int DATABASE_VERSION = 1;  
      
    public DBHelper(Context context) {  
        //CursorFactory����Ϊnull,ʹ��Ĭ��ֵ  
        super(context, DATABASE_NAME, null, DATABASE_VERSION);  
    }  
  
    //���ݿ��һ�α�����ʱonCreate�ᱻ����  
    @Override  
    public void onCreate(SQLiteDatabase db) {  
        db.execSQL("CREATE TABLE IF NOT EXISTS user" +  
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, userid INTEGER,nickname VARCHAR, level INTEGER, logo VARCHAR)");  
        db.execSQL("CREATE TABLE IF NOT EXISTS consumedetail" +  
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, detailid INTEGER,userid INTEGER,time VARCHAR, kindid INTEGER, money VARCHAR,tips VARCHAR)");  
        db.execSQL("CREATE TABLE IF NOT EXISTS consumekind" +  
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, kindid INTEGER,kinddes  VARCHAR)");  

    
    }  
  
    //���DATABASE_VERSIONֵ����Ϊ2,ϵͳ�����������ݿ�汾��ͬ,�������onUpgrade  
    @Override  
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  
       
    }  
}  