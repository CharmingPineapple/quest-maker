package com.example.quest_maker.data.storage.database.personal.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.quest_maker.data.storage.database.personal.database.CharacteristicsDBHelper;
import com.example.quest_maker.data.storage.models.CharacteristicStorage;

import java.util.ArrayList;
import java.util.List;

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

    // (#)
    private Cursor getAllEntries(){
        String[] columns = new String[] {CharacteristicsDBHelper.KEY_ID, CharacteristicsDBHelper.KEY_NAME, CharacteristicsDBHelper.KEY_VALUE};
        return  database.query(CharacteristicsDBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // (#)
    public List<CharacteristicStorage> getAllCharacteristics(){
        ArrayList<CharacteristicStorage> characteristicParams = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(CharacteristicsDBHelper.KEY_ID);
        int name_column_id = cursor.getColumnIndex(CharacteristicsDBHelper.KEY_NAME);
        int value_column_id = cursor.getColumnIndex(CharacteristicsDBHelper.KEY_VALUE);


        while (cursor.moveToNext()){
            int id = cursor.getInt(id_column_id);
            String name = cursor.getString(name_column_id);
            int value = cursor.getInt(value_column_id);
            characteristicParams.add(new CharacteristicStorage(name, value));
        }

        cursor.close();
        return  characteristicParams;
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

        String whereClause = CharacteristicsDBHelper.KEY_NAME + " = " + "'" + characteristicName + "'";
        ContentValues contentValues = new ContentValues();
        contentValues.put(CharacteristicsDBHelper.KEY_VALUE, (int) value);
        return database.update(CharacteristicsDBHelper.TABLE_NAME, contentValues, whereClause, null);
    }

}
