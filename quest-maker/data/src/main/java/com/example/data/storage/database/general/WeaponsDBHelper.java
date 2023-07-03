package com.example.data.storage.database.general;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// (!) - problem
// (?) - don't know
// (#) - testing

public class WeaponsDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "weaponsDB";
    public static final String TABLE_NAME = "weaponsTable";
    public static final int DB_VERSION = 1;

    // TODO("Добавить поле дял добавления картинки
    //  fast to equip
    //  extra damage against smbd
    //  [feature] = -1 STR (example)
    //  Может добавить DB особенностей предметов")

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DAMAGETYPE = "damage-type";
    public static final String KEY_HANDED = "handed";
    public static final String KEY_PREFSTAT = "preferred-stat";
    public static final String KEY_DAMAGE = "damage";
    public static final String KEY_SPEED = "speed";
    public static final String KEY_HITCHANCE = "hit-chance";
    public static final String KEY_THROWDAMAGE = "throw-damage";
    public static final String KEY_SELLPRICE = "sell-price";
    public static final String KEY_DESCR = "description";

    public WeaponsDBHelper(Context context) {
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
                + KEY_THROWDAMAGE + " integer,"
                + KEY_SELLPRICE + " integer,"
                + KEY_DESCR  + " text,"
                + ") ");

        sqLiteDatabase.execSQL("insert into " + TABLE_NAME
                + "("
                + KEY_NAME        + ", "
                + KEY_DAMAGETYPE  + ", "
                + KEY_HANDED      + ", "
                + KEY_PREFSTAT    + ", " // (*) - Влияет на скорость использования оружия
                + KEY_DAMAGE      + ", "
                + KEY_SPEED       + ", "
                + KEY_HITCHANCE   + ", "
                + KEY_SELLPRICE   + ", "
                + KEY_DESCR       + ") "
                + "VALUES "

                + "('Baseball Bat', 'BLUNT', 2, 'STR', 4, 95, 80, 4, 1, 'Baseball bat used by schools team.')"
                /*+ "('STA', 21), "   // Stamina
                + "('REA', 21), "   // Reason
                + "('FND', 6), "    // Money
                //+ "('LVL', 1), "  // Level
                //+ "('EXP', 0), "  // Experience
                //+ "('DOOM' 0), "  // Doom
                + "('BUL', 0), "    // Bullets
                + "('CIG', 0)"      // Cigarettes*/
        );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
