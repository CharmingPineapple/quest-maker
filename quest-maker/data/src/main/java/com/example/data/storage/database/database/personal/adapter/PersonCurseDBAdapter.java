package com.example.data.storage.database.database.personal.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.data.storage.database.database.personal.PersonCurseDBHelper;
import com.example.data.storage.models.author.ItemStorage;

import java.util.ArrayList;
import java.util.List;

public class PersonCurseDBAdapter {

    private PersonCurseDBHelper dbHelper;
    private SQLiteDatabase database;

    public PersonCurseDBAdapter(Context context){
        dbHelper = new PersonCurseDBHelper(context.getApplicationContext());
    }

    public PersonCurseDBAdapter open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, PersonCurseDBHelper.TABLE_NAME);
    }

    // (#)
    private Cursor getAllEntries(){
        String[] columns = new String[] {PersonCurseDBHelper.KEY_ID, PersonCurseDBHelper.KEY_NAME, PersonCurseDBHelper.KEY_TYPE};
        return  database.query(PersonCurseDBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // (#)
    public List<ItemStorage> getAllItem(){
        ArrayList<ItemStorage> itemList = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(PersonCurseDBHelper.KEY_ID);
        int name_column_id = cursor.getColumnIndex(PersonCurseDBHelper.KEY_NAME);
        int type_column_id = cursor.getColumnIndex(PersonCurseDBHelper.KEY_TYPE);

        while (cursor.moveToNext()){
            String name = cursor.getString(name_column_id);
            String type = cursor.getString(type_column_id);

            itemList.add(new ItemStorage(name, type));
        }

        cursor.close();
        return  itemList;
    }

    public void saveAllItem(List<ItemStorage> list){

        dbHelper.clear(database);

        for(ItemStorage one: list){
            insert(one);
        }
    }

    public void insert(ItemStorage one){

        ContentValues contentValues = new ContentValues();
        contentValues.put(PersonCurseDBHelper.KEY_NAME, one.name);
        contentValues.put(PersonCurseDBHelper.KEY_TYPE, one.type);
        database.insert(PersonCurseDBHelper.TABLE_NAME, null, contentValues);

    }


}
