package com.example.data.storage.database.database.general.inventory;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class EquipmentDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "equipmentDB";
    public static final String TABLE_NAME = "equipmentTable";
    public static final int DB_VERSION = 1;

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_TRAITS = "traits";
    public static final String KEY_EFFECT = "effect";
    public static final String KEY_THROW_DAMAGE = "throw_damage";

    // (?) - Нужен ли source или выбор будет настраиваться в сюжете
    // по идее он нужен, чтобы понимать, будет ли это в магазине,
    // пока что оставлю
    public static final String KEY_SOURCE = "source";
    public static final String KEY_BUY_PRICE = "buy_price";
    public static final String KEY_SELL_PRICE = "sell_price";
    public static final String KEY_DESCR = "description";

    public EquipmentDBHelper(Context context) {
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
                + KEY_THROW_DAMAGE + " integer,"
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
                + KEY_THROW_DAMAGE  + ", "
                + KEY_SOURCE        + ", "
                + KEY_BUY_PRICE     + ", "
                + KEY_SELL_PRICE    + ", "
                + KEY_DESCR         + ")"
                + "values "

                + "('Backpack', 'item', 'allows 2 additional inventory slots', 2, 'shop',  2, 1, 'You could fit a lot in here...'),"
                + "('Backpack2', 'item', 'allows 2 additional inventory slots', 2, 'shop',  2, 1, 'You could fit a lot in here...')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
