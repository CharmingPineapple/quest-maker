package com.example.data.storage.database.personal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PersonDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "PersonDB";
    public static final String TABLE_NAME = "PersonTable";
    public static final int DB_VERSION = 1;
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DESCR = "description";
    public static final String KEY_PICTURE= "picture";
    public static final String KEY_OTHER= "other";

    public PersonDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME
                + "("
                + KEY_ID + " integer primary key,"
                + KEY_NAME + " text,"
                + KEY_DESCR + " text,"
                + KEY_PICTURE + " blob,"
                + KEY_OTHER + " text"
                + ") ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
