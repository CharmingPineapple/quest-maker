package com.example.data.storage.database.database.personal.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.data.storage.database.database.personal.SkillDBHelper;
import com.example.data.storage.models.PersonItemStorage;

import java.util.ArrayList;
import java.util.List;

public class SkillDBAdapter {

    private SkillDBHelper dbHelper;
    private SQLiteDatabase database;

    public SkillDBAdapter(Context context){
        dbHelper = new SkillDBHelper(context.getApplicationContext());
    }

    public SkillDBAdapter open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, SkillDBHelper.TABLE_NAME);
    }

    // (#)
    private Cursor getAllEntries(){
        String[] columns = new String[] {SkillDBHelper.KEY_ID, SkillDBHelper.KEY_NAME, SkillDBHelper.KEY_VALUE};
        return  database.query(SkillDBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // (#)
    public List<PersonItemStorage> getAllSkill(){
        ArrayList<PersonItemStorage> SkillParams = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(SkillDBHelper.KEY_ID);
        int name_column_id = cursor.getColumnIndex(SkillDBHelper.KEY_NAME);
        int value_column_id = cursor.getColumnIndex(SkillDBHelper.KEY_VALUE);


        while (cursor.moveToNext()){
            int id = cursor.getInt(id_column_id);
            String name = cursor.getString(name_column_id);
            int value = cursor.getInt(value_column_id);

            SkillParams.add(new PersonItemStorage(name, value));
        }

        cursor.close();
        return  SkillParams;
    }

    public void saveAllSkill(List<PersonItemStorage> list){
        for(PersonItemStorage one: list){
            updateValue(one.text, one.value);
        }
    }

    public int getValueOf(String skillName){

        int value = -1;

        //Cursor cursor;

        String query = String.format("select * from %s where %s=?", SkillDBHelper.TABLE_NAME, SkillDBHelper.KEY_NAME);
        Cursor cursor = database.rawQuery(query, new String[]{ skillName });
        int columnIndex = cursor.getColumnIndex(SkillDBHelper.KEY_VALUE);

        return value;
    }

    // Возвращает количество изменённых элементов
    public void updateValue(String skillName, int value){

        String whereClause = SkillDBHelper.KEY_NAME + " = " + "'" + skillName + "'";
        ContentValues contentValues = new ContentValues();
        contentValues.put(SkillDBHelper.KEY_VALUE, (int) value);
        database.update(SkillDBHelper.TABLE_NAME, contentValues, whereClause, null);
    }

}
