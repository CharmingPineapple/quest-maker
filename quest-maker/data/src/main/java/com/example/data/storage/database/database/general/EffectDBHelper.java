package com.example.data.storage.database.database.general;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EffectDBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "EffectDB";
    public static final String TABLE_NAME = "EffectTable";
    public static final int DB_VERSION = 1;
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";
    public static final String KEY_TAG = "tag";
    public static final String KEY_DEST = "destination";
    public static final String KEY_VALUE = "value";
    public static final String KEY_DESCR = "description";

    public EffectDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME
                + "("
                + KEY_ID + " integer primary key,"
                + KEY_NAME + " text,"
                + KEY_TAG + " text,"
                + KEY_DEST + " text,"
                + KEY_VALUE + " integer,"
                + KEY_DESCR + " text"
                + ") ");

        sqLiteDatabase.execSQL("insert into " + TABLE_NAME
                + "("
                + KEY_NAME  + ", "
                + KEY_TAG   + ", "
                + KEY_DEST  + ", "
                + KEY_VALUE + ", "
                + KEY_DESCR + ") "
                + "values "

                + "('weak', 'test-tag', 'STR', -1, 'effect description')"
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
