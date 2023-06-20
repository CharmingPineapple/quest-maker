package com.example.quest_maker.domain.database.general;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// (!) - problem
// (?) - don't know
// (#) - testing

public class weaponsDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "weaponsDB";
    public static final String TABLE_NAME = "weaponsTable";
    public static final int DB_VERSION = 1;

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DAMAGETYPE = "damage-type";
    public static final String KEY_HANDED = "handed";
    public static final String KEY_PREFSTAT = "preferred-stat";
    public static final String KEY_DAMAGE = "damage";
    public static final String KEY_SPEED = "speed";
    public static final String KEY_HITCHANCE = "hit-chance";
    public static final String KEY_SELLPRICE = "sell-price";
    public static final String KEY_DESCR = "description";

    public weaponsDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME
                + "("
                + KEY_ID + " integer primary key,"
                + KEY_NAME + " text,"
                + KEY_DAMAGETYPE + " text,"
                + KEY_HANDED + " integer,"
                + KEY_PREFSTAT + " text,"
                + KEY_DAMAGE + " integer,"
                + KEY_SPEED + " integer,"
                + KEY_HITCHANCE + " integer,"
                + KEY_SELLPRICE + " integer,"
                + KEY_DESCR  + " text,"
                + ") ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
