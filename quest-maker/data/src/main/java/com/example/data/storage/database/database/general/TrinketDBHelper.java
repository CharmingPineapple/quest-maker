package com.example.data.storage.database.database.general;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TrinketDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "trinketDB";
    public static final String TABLE_NAME = "trinketTable";
    public static final int DB_VERSION = 1;

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_TRAITS = "traits";
    public static final String KEY_EFFECT = "effect";

    // (?) - Нужен ли source или выбор будет настраиваться в сюжете
    // по идее он нужен, чтобы понимать, будет ли это в магазине,
    // пока что оставлю
    public static final String KEY_SOURCE = "source";
    public static final String KEY_BUY_PRICE = "buy_price";
    public static final String KEY_SELL_PRICE = "sell_price";
    public static final String KEY_DESCR = "description";

    public TrinketDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME
                + "("
                + KEY_ID + " integer primary key,"
                + KEY_NAME + " text,"
                + KEY_TRAITS + " text,"
                + KEY_EFFECT + " text,"
                + KEY_SOURCE + " text,"
                + KEY_BUY_PRICE + " integer,"
                + KEY_SELL_PRICE + " integer,"
                + KEY_DESCR + " text"
                + ") ");

        sqLiteDatabase.execSQL("insert into " + TABLE_NAME
                + "("
                + KEY_NAME          + ", "
                + KEY_TRAITS        + ", "
                + KEY_EFFECT        + ", "
                + KEY_SOURCE        + ", "
                + KEY_BUY_PRICE     + ", "
                + KEY_SELL_PRICE    + ", "
                + KEY_DESCR         + ")"
                + "values "

                + "('Bottle [Blood]', 'food', 'Kills you after drinking it', 'events',  0, 1, 'Filled with boiling blood'),"
                + "('Bandage', 'medicine, cloth', 'you can heal one minor INJURY while keeping this item in the inventory', 'pharmacy, Illegal Den.',  1, 0, ''),"
                + "('Cigarettes', 'addictive', '+1 Reason, adds status \"Nicotine Rush\"', 'shop, vending Machine, Illegal Den',  2, 1, 'Smoking kills.')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
