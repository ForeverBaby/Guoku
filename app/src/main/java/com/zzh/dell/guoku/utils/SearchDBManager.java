package com.zzh.dell.guoku.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ishinagi_moeta on 2016/10/21.
 */
public class SearchDBManager extends SQLiteOpenHelper {
    private static String name = "temp.db";
    private static Integer version = 1;
    static private SearchDBManager helper;

    static public SearchDBManager getManager(Context context) {
        if (helper == null) {
            helper = new SearchDBManager(context);
        }
        return helper;
    }

    private SearchDBManager(Context context) {
        super(context, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table records(id integer primary key autoincrement,name varchar(200))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * 插入数据
     */
    public void insertData(SQLiteDatabase db, String tempName) {
        db = helper.getWritableDatabase();
        db.execSQL("insert into records(name) values('" + tempName + "')");
        db.close();
    }

    /**
     * 模糊查询数据
     */
    public Cursor queryData(String tempName) {
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name like '%" + tempName + "%' order by id desc ", null);
        return cursor;
    }

    /**
     * 检查数据库中是否已经有该条记录
     */
    public boolean hasData(String tempName) {
        Cursor cursor = helper.getReadableDatabase().rawQuery(
                "select id as _id,name from records where name =?", new String[]{tempName});
        //判断是否有下一个
        return cursor.moveToNext();
    }

    /**
     * 清空数据
     */
    public void deleteData(SQLiteDatabase db) {
        db = helper.getWritableDatabase();
        db.execSQL("delete from records");
        db.close();
    }

}
