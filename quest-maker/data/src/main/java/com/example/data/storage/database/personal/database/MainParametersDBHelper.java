package com.example.data.storage.database.personal.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// (!) - problem
// (?) - don't know
// (#) - testing

public class MainParametersDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "CharacteristicsDB";
    public static final String TABLE_NAME = "PersParamTable";
    public static final int DB_VERSION = 1;
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name-param";
    public static final String KEY_VALUE= "value";

    public MainParametersDBHelper(Context context) {
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
                + "('STA', 21), "   // Stamina
                + "('REA', 21), "   // Reason
                + "('FND', 6), "    // Money
                //+ "('LVL', 1), "  // Level
                //+ "('EXP', 0), "  // Experience
                //+ "('DOOM' 0), "  // Doom
                + "('BUL', 0), "    // Bullets
                + "('CIG', 0)"      // Cigarettes
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
