package com.example.data.storage.database.database.personal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// (!) - problem
// (?) - don't know
// (#) - testing

public class MainParameterDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "MainParameterDB";
    public static final String TABLE_NAME = "MainParameterTable";
    public static final int DB_VERSION = 1;
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name_param";
    public static final String KEY_VALUE= "value";

    public MainParameterDBHelper(Context context) {
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
                + "('STA', 17), "   // Stamina
                + "('REA', 17), "   // Reason
                + "('FND', 4), "    // Money
                //+ "('LVL', 1), "  // Level
                //+ "('EXP', 0), "  // Experience
                //+ "('DOOM' 0), "  // Doom
                //+ "('CIG', 0),"   // Cigarettes
                //+ "('MXS', 0),"   // Maximum number of spells
                //+ "('MXI', 0),"   // Maximum number of items
                + "('BUL', 0) "     // Bullets
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
