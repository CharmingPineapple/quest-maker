package com.example.data.storage.database.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.data.storage.database.database.personal.MainParameterDBHelper;
import com.example.data.storage.models.MainParameterStorage;

import java.util.ArrayList;
import java.util.List;

public class MainParameterDBAdapter {

    private MainParameterDBHelper dbHelper;
    private SQLiteDatabase database;

    public MainParameterDBAdapter(Context context){
        dbHelper = new MainParameterDBHelper(context.getApplicationContext());
    }

    public MainParameterDBAdapter open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, MainParameterDBHelper.TABLE_NAME);
    }

    private Cursor getAllEntries(){
        String[] columns = new String[] {MainParameterDBHelper.KEY_ID, MainParameterDBHelper.KEY_NAME, MainParameterDBHelper.KEY_VALUE};
        return  database.query(MainParameterDBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // (#)
    public List<MainParameterStorage> getAllMainParameter(){
        ArrayList<MainParameterStorage> mainParameterStorageParams = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(MainParameterDBHelper.KEY_ID);
        int name_column_id = cursor.getColumnIndex(MainParameterDBHelper.KEY_NAME);
        int value_column_id = cursor.getColumnIndex(MainParameterDBHelper.KEY_VALUE);


        while (cursor.moveToNext()){
            int id = cursor.getInt(id_column_id);
            String name = cursor.getString(name_column_id);
            int value = cursor.getInt(value_column_id);
            mainParameterStorageParams.add(new MainParameterStorage(name, value));
        }

        cursor.close();
        return mainParameterStorageParams;
    }

    public void saveAllMainParameter(List<MainParameterStorage> list){
        for(MainParameterStorage one: list){
            updateValue(one.name, one.value);
        }
    }

    public int getValueOf(String mainParameterName){

        int value = -1;

        //Cursor cursor;

        String query = String.format("select * from %s where %s=?", MainParameterDBHelper.TABLE_NAME, MainParameterDBHelper.KEY_NAME);
        Cursor cursor = database.rawQuery(query, new String[]{ mainParameterName });
        int columnIndex = cursor.getColumnIndex(MainParameterDBHelper.KEY_VALUE);


        // (#)
      /*  if (cursor.moveToFirst()){
            if (columnIndex != -1){
                value = cursor.getInt(columnIndex);
            }  else {
                Log.e("CharacteristicsDBAdapter", "getValueOf(String skillName) can't find CharacteristicsDBHelper.KEY_VALUE in CharacteristicsDBHelper.TABLE_NAME");
            }
        } else {
            Log.e("CharacteristicsDBAdapter", "getValueOf(String skillName) can't find skillName in CharacteristicsDBHelper.KEY_NAME");
        }*/

        return value;
    }

    // Возвращает количество изменённых элементов
    public void updateValue(String mainParameterName, int value){

        String whereClause = MainParameterDBHelper.KEY_NAME + " = " + "'" + mainParameterName + "'";
        ContentValues contentValues = new ContentValues();
        contentValues.put(MainParameterDBHelper.KEY_VALUE, (int) value);
        database.update(MainParameterDBHelper.TABLE_NAME, contentValues, whereClause, null);
    }

}
