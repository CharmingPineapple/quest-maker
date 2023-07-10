package com.example.data.storage.database.database.personal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ItemDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "ItemDB";
    public static final String TABLE_NAME = "ItemTable";
    public static final int DB_VERSION = 1;
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_TYPE = "type";
    public static final String KEY_ITEM_ID = "item_id";



    public ItemDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME
                + "("
                + KEY_ID + " integer primary key,"
                + KEY_NAME + " text, "
                + KEY_TYPE + " text, "
                + KEY_ITEM_ID + " integer"
                + ") ");

        // (#)
        sqLiteDatabase.execSQL("insert into " + TABLE_NAME
                + "("
                + KEY_NAME    + ", "
                + KEY_TYPE    + ", "
                + KEY_ITEM_ID + ")"
                + "values "

                + "('Baseball Bat', 'weapon',  0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }

    public void clear(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_NAME);
    }
}
