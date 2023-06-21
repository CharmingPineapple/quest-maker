package com.example.quest_maker.data.database.personal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class CharacteristicsDBAdapter {

    private CharacteristicsDBHelper dbHelper;
    private SQLiteDatabase database;

    public CharacteristicsDBAdapter(Context context){
        dbHelper = new CharacteristicsDBHelper(context.getApplicationContext());
    }

    public CharacteristicsDBAdapter open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, CharacteristicsDBHelper.TABLE_NAME);
    }

    public int getValueOf(String characteristicName){

        int value = -1;

        //Cursor cursor;

        String query = String.format("select * from %s where %s=?", CharacteristicsDBHelper.TABLE_NAME, CharacteristicsDBHelper.KEY_NAME);
        Cursor cursor = database.rawQuery(query, new String[]{ characteristicName });
        int columnIndex = cursor.getColumnIndex(CharacteristicsDBHelper.KEY_VALUE);


        // (#)
        if (cursor.moveToFirst()){
          if (columnIndex != -1){
                value = cursor.getInt(columnIndex);
            }  else {
              Log.e("CharacteristicsDBAdapter", "getValueOf(String characteristicName) can't find CharacteristicsDBHelper.KEY_VALUE in CharacteristicsDBHelper.TABLE_NAME");
            }
        } else {
            Log.e("CharacteristicsDBAdapter", "getValueOf(String characteristicName) can't find characteristicName in CharacteristicsDBHelper.KEY_NAME");
        }

        return value;
    }

    // Возвращает количество изменённых элементов
    public int updateValue(String characteristicName, int value){

        String whereClause = CharacteristicsDBHelper.KEY_NAME + " = " + characteristicName;
        ContentValues contentValues = new ContentValues();
        contentValues.put(CharacteristicsDBHelper.KEY_VALUE, value);
        return database.update(CharacteristicsDBHelper.TABLE_NAME, contentValues, whereClause, null);
    }

}
