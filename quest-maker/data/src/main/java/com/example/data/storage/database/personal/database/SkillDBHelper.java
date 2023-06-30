package com.example.data.storage.database.personal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// (!) - problem
// (?) - thinking
// (#) - testing

public class SkillDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "SkillDB";
    public static final String TABLE_NAME = "SkillTable";
    public static final int DB_VERSION = 1;

    // (?) - Add image of weapon?

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_VALUE= "value";

    public SkillDBHelper(Context context) {
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
        + "(" + KEY_NAME + ", " + KEY_VALUE + ") " + "VALUES "
        + "('STR', 7), "   // Strength
        + "('DEX', 7), "   // Dexterity
        + "('PER', 7), "   // Perception
        + "('KNW', 7), "   // Knowledge
        + "('CHR', 7), "   // Charisma
        + "('LCK', 0)"   // Luck
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
