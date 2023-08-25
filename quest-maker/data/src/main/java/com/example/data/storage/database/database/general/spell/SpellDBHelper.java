package com.example.data.storage.database.database.general.spell;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SpellDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "spellDB";
    public static final String TABLE_NAME = "spellTable";
    public static final int DB_VERSION = 1;

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_TYPE = "type";
    public static final String KEY_DESCR = "description";
    public static final String KEY_COST = "cost";

    public SpellDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME
                + "("
                + KEY_ID + " integer primary key,"
                + KEY_NAME + " text,"
                + KEY_TYPE + " text,"
                + KEY_DESCR + " text,"
                + KEY_COST + " text"
                + ") ");

        sqLiteDatabase.execSQL("insert into " + TABLE_NAME
                + "("
                + KEY_NAME + ", "
                + KEY_TYPE + ", "
                + KEY_DESCR + ", "
                + KEY_COST + ")"
                + "values "

                + "('Ithotu Flame', 'combat', 'Deals 8 damage', ' +2% DOOM; -1 REA; -1 STA'),"
                + "('Grow Teeth', 'support', 'Adds a new combat action, [BITE], until the end of current mystery', '-2 STA'),"
                + "('Flesh Regrowth', 'support', '+3 STA', '-2 Max STA'),"
                + "('KNpha Ritual', 'ritual', 'When your allies die, a random stat gets raised by 1', '-2 REA'),"
                + "('Seal of Savvesh', 'seal', 'Discard on use, +1 STR permanently', '-4 REA')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
