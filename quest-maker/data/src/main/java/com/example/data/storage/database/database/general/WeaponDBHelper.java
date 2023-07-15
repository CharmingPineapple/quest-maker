package com.example.data.storage.database.database.general;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// (!) - problem
// (?) - don't know
// (#) - testing

public class WeaponDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "weaponsDB";
    public static final String TABLE_NAME = "weaponsTable";
    public static final int DB_VERSION = 1;

    // TODO("Добавить поле для добавления картинки
    //  fast to equip
    //  extra damage against smbd
    //  [feature] = -1 STR (example)
    //  Может добавить DB особенностей предметов")

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DAMAGE_TYPE = "damage_type";
    public static final String KEY_HANDED = "handed";
    public static final String KEY_PREFSTAT = "preferred_stat";
    public static final String KEY_DAMAGE = "damage";
    public static final String KEY_SPEED = "speed";
    public static final String KEY_SPEED_EQUIP = "speed_equip";
    public static final String KEY_HIT_CHANCE = "hit_chance";
    public static final String KEY_THROW_DAMAGE = "throw_damage";
    public static final String KEY_SELL_PRICE = "sell_price";
    public static final String KEY_DESCR = "description";

    public WeaponDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME
                + "("
                + KEY_ID + " integer primary key,"
                + KEY_NAME + " text,"
                + KEY_DAMAGE_TYPE + " text,"
                + KEY_HANDED + " integer,"
                + KEY_PREFSTAT + " text,"
                + KEY_DAMAGE + " integer,"
                + KEY_SPEED + " integer,"
                + KEY_SPEED_EQUIP + " integer,"
                + KEY_HIT_CHANCE + " integer,"
                + KEY_THROW_DAMAGE + " integer,"
                + KEY_SELL_PRICE + " integer,"
                + KEY_DESCR + " text"
                + ") ");

        sqLiteDatabase.execSQL("insert into " + TABLE_NAME
                        + "("
                        + KEY_NAME + ", "
                        + KEY_DAMAGE_TYPE + ", "
                        + KEY_HANDED + ", "
                        + KEY_PREFSTAT + ", " // (*) - Влияет на скорость использования оружия
                        + KEY_DAMAGE + ", "
                        + KEY_SPEED + ", "
                        + KEY_SPEED_EQUIP + ", "
                        + KEY_HIT_CHANCE + ", "
                        + KEY_THROW_DAMAGE + ", "
                        + KEY_SELL_PRICE + ", "
                        + KEY_DESCR + ")"
                        + "values "

                        + "('Baseball Bat', 'BLUNT', 2, 'STR', 4, 95, 20, 80, 4, 1, 'Baseball bat used by schools team.'),"
                        + "('ABOBA', 'BLUNT', 2, 'STR', 4, 95, 20, 80, 4, 1, 'Baseball bat used by schools team.'),"
                        + "('BIBA', 'BLUNT', 2, 'STR', 4, 95, 20, 80, 4, 1, 'Baseball bat used by schools team.')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
