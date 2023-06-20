package com.example.quest_maker.model.database.personal;

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
    public static final String KEY_NAME = "name";
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
                + "(" + KEY_NAME + ") " + "VALUES "
                + "('STA'), "   // Stamina
                + "('REA'), "   // Reason
                + "('FND'), "   // Money
                + "('LVL'), "   // Level
                + "('EXP'), "   // Experience
                + "('BUL'), "   // Bullets
                + "('CIG')"     // Cigarettes
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
