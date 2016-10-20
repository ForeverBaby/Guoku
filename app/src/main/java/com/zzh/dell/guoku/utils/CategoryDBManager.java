package com.zzh.dell.guoku.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Ishinagi_moeta on 2016/10/19.
 */
public class CategoryDBManager {
    private SQLiteDatabase database;
    private SQLiteDatabase subDatabase;

    private static CategoryDBManager dbManager = null;

    private CategoryDBManager(Context context) {
        database = context.openOrCreateDatabase(CategoryDBInfo.DB_NAME, Context.MODE_PRIVATE, null);
        String createSql = "create table if not exists " + CategoryDBInfo.TABLE_NAME +
                " ( "  + CategoryDBInfo._ID + " integer primary key autoincrement,"
                + CategoryDBInfo.GROUP_ID + " integer,"
                + CategoryDBInfo.GROUP_TITLE + " text )";
        database.execSQL(createSql);

        subDatabase = context.openOrCreateDatabase(CategoryDBInfo.SUB_DB_NAME, Context.MODE_PRIVATE, null);
        createSql = "create table if not exists " + CategoryDBInfo.SUB_TABLE_NAME +
                " ( " + CategoryDBInfo._ID + " integer primary key autoincrement,"
                + CategoryDBInfo.SUB_GROUP_ID + " integer,"
                + CategoryDBInfo.CATEGORY_ID + " integer,"
                + CategoryDBInfo.CATEGORY_TITLE + " text,"
                + CategoryDBInfo.CATEGORY_ICON_SMALL + " text,"
                + CategoryDBInfo.CATEGORY_ICON_LARGE + " text )";
        subDatabase.execSQL(createSql);
    }

    public static CategoryDBManager getDbManager(Context context) {
        if (dbManager == null) {
            dbManager = new CategoryDBManager(context);
        }
        return dbManager;
    }

    public void insert(Context context, int _id, String title) {
        /**
         * 参数1:表名
         * 参数2:要插入的列的名字，如果设为null,给所有列设
         * 参数3:插入的值
         */
        //序列化的对象，其中存储类型为map的key-value
        ContentValues contentValues = new ContentValues();
        //key为列名，value要插入的值
        contentValues.put(CategoryDBInfo.GROUP_ID, _id);
        contentValues.put(CategoryDBInfo.GROUP_TITLE, title);
        database.insert(CategoryDBInfo.TABLE_NAME, null, contentValues);
    }

    public void subInsert(Context context
            , int group_id
            , int category_id
            , String category_title
            , String category_icon_small
            , String category_icon_large) {
        /**
         * 参数1:表名
         * 参数2:要插入的列的名字，如果设为null,给所有列设
         * 参数3:插入的值
         */
        //序列化的对象，其中存储类型为map的key-value
        ContentValues contentValues = new ContentValues();
        //key为列名，value要插入的值
        contentValues.put(CategoryDBInfo.SUB_GROUP_ID, group_id);
        contentValues.put(CategoryDBInfo.CATEGORY_ID, category_id);
        contentValues.put(CategoryDBInfo.CATEGORY_TITLE, category_title);
        contentValues.put(CategoryDBInfo.CATEGORY_ICON_SMALL, category_icon_small);
        contentValues.put(CategoryDBInfo.CATEGORY_ICON_LARGE, category_icon_large);

        subDatabase.insert(CategoryDBInfo.SUB_TABLE_NAME, null, contentValues);
    }

    //无条件查询
    public Cursor queryNoSelection() {
        //无条件查询/查询所有
        /**
         * 参数1:表名
         * 参数2:查询的列名，类型是String[],如果值为null,标识查询所有的列
         * 参数3:查询条件的表达式，相当于sql语句的where 列名 ＝ ？，参数类型为string，如果值为null,表示无条件
         *      例如：表达式 :_id = ?
         * 参数4:查询条件的值,类型是String[]，如果值为null,表示无条件
         *      例如:new String[]{"",""}
         * 参数5:group by：分组，参数类型为string，相当于sql语句的group by 列名
         * 参数6:having：条件表达式，(根据group再次删选)
         * 参数7:order by排序 ，asc/desc ,例如:列名 desc/asc
         * 参数8:limit ,例如：2,1表示含义，从第2条之后取1条数据(从第3条开始取1条数据)
         */
        //查询所有
        Cursor cursor = database.query(CategoryDBInfo.TABLE_NAME, null, null, null, null, null, null, null);
        return cursor;
    }

    //无条件查询
    public Cursor subQueryNoSelection() {
        //无条件查询/查询所有
        /**
         * 参数1:表名
         * 参数2:查询的列名，类型是String[],如果值为null,标识查询所有的列
         * 参数3:查询条件的表达式，相当于sql语句的where 列名 ＝ ？，参数类型为string，如果值为null,表示无条件
         *      例如：表达式 :_id = ?
         * 参数4:查询条件的值,类型是String[]，如果值为null,表示无条件
         *      例如:new String[]{"",""}
         * 参数5:group by：分组，参数类型为string，相当于sql语句的group by 列名
         * 参数6:having：条件表达式，(根据group再次删选)
         * 参数7:order by排序 ，asc/desc ,例如:列名 desc/asc
         * 参数8:limit ,例如：2,1表示含义，从第2条之后取1条数据(从第3条开始取1条数据)
         */
        //查询所有
        Cursor cursor = subDatabase.query(CategoryDBInfo.SUB_TABLE_NAME, null, null, null, null, null, null, null);
        return cursor;
    }

    public Cursor queryById(int id) {
        //无条件查询/查询所有
        /**
         * 参数1:表名
         * 参数2:查询的列名，类型是String[],如果值为null,标识查询所有的列
         * 参数3:查询条件的表达式，相当于sql语句的where 列名 ＝ ？，参数类型为string，如果值为null,表示无条件
         *      例如：表达式 :_id = ?
         * 参数4:查询条件的值,类型是String[]，如果值为null,表示无条件
         *      例如:new String[]{"",""}
         * 参数5:group by：分组，参数类型为string，相当于sql语句的group by 列名
         * 参数6:having：条件表达式，(根据group再次删选)
         * 参数7:order by排序 ，asc/desc ,例如:列名 desc/asc
         * 参数8:limit ,例如：2,1表示含义，从第2条之后取1条数据(从第3条开始取1条数据)
         */
        //按条件查询(当_id = 1 ,指定查询某一列的值，取值的时候列的索引按照指定列的顺序排列(从0开始))
        Cursor cursor = database.query(CategoryDBInfo.TABLE_NAME, new String[]{CategoryDBInfo.GROUP_ID, CategoryDBInfo.GROUP_TITLE},
                CategoryDBInfo.GROUP_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null, null);
        return cursor;
    }

    public Cursor subQueryById(int id) {
        //无条件查询/查询所有
        /**
         * 参数1:表名
         * 参数2:查询的列名，类型是String[],如果值为null,标识查询所有的列
         * 参数3:查询条件的表达式，相当于sql语句的where 列名 ＝ ？，参数类型为string，如果值为null,表示无条件
         *      例如：表达式 :_id = ?
         * 参数4:查询条件的值,类型是String[]，如果值为null,表示无条件
         *      例如:new String[]{"",""}
         * 参数5:group by：分组，参数类型为string，相当于sql语句的group by 列名
         * 参数6:having：条件表达式，(根据group再次删选)
         * 参数7:order by排序 ，asc/desc ,例如:列名 desc/asc
         * 参数8:limit ,例如：2,1表示含义，从第2条之后取1条数据(从第3条开始取1条数据)
         */
        //按条件查询(当_id = 1 ,指定查询某一列的值，取值的时候列的索引按照指定列的顺序排列(从0开始))
        Cursor cursor = subDatabase.query(CategoryDBInfo.SUB_TABLE_NAME, new String[]{
                        CategoryDBInfo.SUB_GROUP_ID
                        , CategoryDBInfo.CATEGORY_ID
                        , CategoryDBInfo.CATEGORY_TITLE
                        , CategoryDBInfo.CATEGORY_ICON_SMALL
                        , CategoryDBInfo.CATEGORY_ICON_LARGE},
                CategoryDBInfo.CATEGORY_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null, null);
        return cursor;
    }

    public Cursor subQueryByGroupId(int id) {
        //无条件查询/查询所有
        /**
         * 参数1:表名
         * 参数2:查询的列名，类型是String[],如果值为null,标识查询所有的列
         * 参数3:查询条件的表达式，相当于sql语句的where 列名 ＝ ？，参数类型为string，如果值为null,表示无条件
         *      例如：表达式 :_id = ?
         * 参数4:查询条件的值,类型是String[]，如果值为null,表示无条件
         *      例如:new String[]{"",""}
         * 参数5:group by：分组，参数类型为string，相当于sql语句的group by 列名
         * 参数6:having：条件表达式，(根据group再次删选)
         * 参数7:order by排序 ，asc/desc ,例如:列名 desc/asc
         * 参数8:limit ,例如：2,1表示含义，从第2条之后取1条数据(从第3条开始取1条数据)
         */
        //按条件查询(当_id = 1 ,指定查询某一列的值，取值的时候列的索引按照指定列的顺序排列(从0开始))
        Cursor cursor = subDatabase.query(CategoryDBInfo.SUB_TABLE_NAME, new String[]{
                        CategoryDBInfo.SUB_GROUP_ID
                        , CategoryDBInfo.CATEGORY_ID
                        , CategoryDBInfo.CATEGORY_TITLE
                        , CategoryDBInfo.CATEGORY_ICON_SMALL
                        , CategoryDBInfo.CATEGORY_ICON_LARGE},
                CategoryDBInfo.SUB_GROUP_ID + " = ?", new String[]{String.valueOf(id)}, null, null, null, null);
        return cursor;
    }

    public Cursor QueryByTitle(String title) {
        //无条件查询/查询所有
        /**
         * 参数1:表名
         * 参数2:查询的列名，类型是String[],如果值为null,标识查询所有的列
         * 参数3:查询条件的表达式，相当于sql语句的where 列名 ＝ ？，参数类型为string，如果值为null,表示无条件
         *      例如：表达式 :_id = ?
         * 参数4:查询条件的值,类型是String[]，如果值为null,表示无条件
         *      例如:new String[]{"",""}
         * 参数5:group by：分组，参数类型为string，相当于sql语句的group by 列名
         * 参数6:having：条件表达式，(根据group再次删选)
         * 参数7:order by排序 ，asc/desc ,例如:列名 desc/asc
         * 参数8:limit ,例如：2,1表示含义，从第2条之后取1条数据(从第3条开始取1条数据)
         */
        //按条件查询(当_id = 1 ,指定查询某一列的值，取值的时候列的索引按照指定列的顺序排列(从0开始))
        Cursor cursor = database.query(CategoryDBInfo.TABLE_NAME, new String[]{CategoryDBInfo.GROUP_ID
                        , CategoryDBInfo.GROUP_TITLE},
                CategoryDBInfo.GROUP_TITLE + " like ?"
                , new String[]{"%" + title + "%"}, null, null, null, null);
        return cursor;
    }

    public Cursor subQueryByTitle(String title) {
        //无条件查询/查询所有
        /**
         * 参数1:表名
         * 参数2:查询的列名，类型是String[],如果值为null,标识查询所有的列
         * 参数3:查询条件的表达式，相当于sql语句的where 列名 ＝ ？，参数类型为string，如果值为null,表示无条件
         *      例如：表达式 :_id = ?
         * 参数4:查询条件的值,类型是String[]，如果值为null,表示无条件
         *      例如:new String[]{"",""}
         * 参数5:group by：分组，参数类型为string，相当于sql语句的group by 列名
         * 参数6:having：条件表达式，(根据group再次删选)
         * 参数7:order by排序 ，asc/desc ,例如:列名 desc/asc
         * 参数8:limit ,例如：2,1表示含义，从第2条之后取1条数据(从第3条开始取1条数据)
         */
        //按条件查询(当_id = 1 ,指定查询某一列的值，取值的时候列的索引按照指定列的顺序排列(从0开始))
        Cursor cursor = subDatabase.query(CategoryDBInfo.SUB_TABLE_NAME, new String[]{
                        CategoryDBInfo.SUB_GROUP_ID
                        , CategoryDBInfo.CATEGORY_ID
                        , CategoryDBInfo.CATEGORY_TITLE
                        , CategoryDBInfo.CATEGORY_ICON_SMALL
                        , CategoryDBInfo.CATEGORY_ICON_LARGE},
                CategoryDBInfo.CATEGORY_TITLE + " like ?"
                , new String[]{"%" + title + "%"}, null, null, null, null);
        return cursor;
    }
}
