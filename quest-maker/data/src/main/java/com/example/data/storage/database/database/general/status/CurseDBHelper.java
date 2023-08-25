package com.example.data.storage.database.database.general.status;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CurseDBHelper   extends SQLiteOpenHelper {

    public static final String DB_NAME = "curseDB";
    public static final String TABLE_NAME = "curseTable";
    public static final int DB_VERSION = 1;

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name"; //
    public static final String KEY_TYPE = "type"; //
    public static final String KEY_EFFECT = "effect"; //

    public static final String KEY_DESCR = "description"; //

    public CurseDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME
                + "("
                + KEY_ID + " integer primary key,"
                + KEY_NAME + " text,"
                + KEY_TYPE + " text,"
                + KEY_EFFECT + " text,"
                + KEY_DESCR + " text"
                + ") ");

        sqLiteDatabase.execSQL("insert into " + TABLE_NAME
                + "("
                + KEY_NAME          + ", "
                + KEY_TYPE          + ", "
                + KEY_EFFECT        + ", "
                + KEY_DESCR         + ")"
                + "values "

                + "('Fearful', 'mental', 'lose 1 REASON at the start of each enemy encounter', 'Im worried'),"
                + "('Cursed Signs', 'mutation', '+3% Doom when casting a spell', 'charred skin forms weird signs'),"
                + "('Nicotine Rush ', 'mental', '0.9x Combat multiplier', '-1 Cigarette each investigation. All combat actions are faster'),"
                + "('Nicotine Withdrawal', 'mental', '1.2x combat multiplier', 'All combat actions are slower')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
