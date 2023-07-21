package com.example.data.storage.database.database.general;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class InjuryDBHelper  extends SQLiteOpenHelper {

    public static final String DB_NAME = "injuryDB";
    public static final String TABLE_NAME = "injuryTable";
    public static final int DB_VERSION = 1;

    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name"; //
    public static final String KEY_TYPE = "type"; //
    //public static final String KEY_TRAITS = "traits";
    public static final String KEY_EFFECT = "effect"; //

    // (?) - Возможно, не нужно и цена будет определяться просто по типу травмы (Будет же свод всех игровых параметров)
    //public static final String KEY_TREATMENT_PRICE = "treatment_price"; //
    public static final String KEY_DESCR = "description"; //

    public InjuryDBHelper(Context context) {
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

                + "('Broken Bone', 'major', '-1 Strength -1 Dexterity', 'terrible pain'),"
                + "('Coughing Blood', 'minor', '-2 Dexterity', '*cough-cough*'),"
                + "('Tiny Cuts', 'minor', 'No effect', 'Nothing unusual'),"
                + "('Abdominal Cut', 'major', '-10% Max Stamina', 'I feel weak')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // (?)
    }
}
