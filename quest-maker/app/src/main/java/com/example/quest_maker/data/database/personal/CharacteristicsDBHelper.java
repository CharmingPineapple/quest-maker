package com.example.quest_maker.data.database.personal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// (!) - problem
// (?) - thinking
// (#) - testing

public class CharacteristicsDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "CharacteristicsDB";
    public static final String TABLE_NAME = "CharacteristicsTable";
    public static final int DB_VERSION = 1;

    // (?) - Add image of weapon?

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_VALUE= "value";

    public CharacteristicsDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME
                + "("
                + KEY_ID + " integer primary key,"
                + KEY_NAME + " text,"
                + KEY_VALUE + " integer"
                + ") ");

        sqLiteDatabase.execSQL("insert into " + TABLE_NAME
        + "(" + KEY_NAME + ") " + "VALUES "
        + "('STR'), "   // Strength
        + "('DEX'), "   // Dexterity
        + "('PER'), "   // Perception
        + "('KNW'), "   // Knowledge
        + "('CHR'), "   // Charisma
        + "('LCK')"     // Luck
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
