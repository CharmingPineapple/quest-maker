package com.example.data.storage.database.database.personal.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.data.storage.database.database.personal.ItemDBHelper;
import com.example.data.storage.models.PersonItemStorage;

import java.util.ArrayList;
import java.util.List;

public class ItemDBAdapter {

    private ItemDBHelper dbHelper;
    private SQLiteDatabase database;

    public ItemDBAdapter(Context context){
        dbHelper = new ItemDBHelper(context.getApplicationContext());
    }

    public ItemDBAdapter open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, ItemDBHelper.TABLE_NAME);
    }

    // (#)
    private Cursor getAllEntries(){
        String[] columns = new String[] {ItemDBHelper.KEY_ID, ItemDBHelper.KEY_TYPE, ItemDBHelper.KEY_ITEM_ID};
        return  database.query(ItemDBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // (#)
    public List<PersonItemStorage> getAllItem(){
        ArrayList<PersonItemStorage> ItemParams = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(ItemDBHelper.KEY_ID);
        int type_column_id = cursor.getColumnIndex(ItemDBHelper.KEY_TYPE);
        int item_id_column_id = cursor.getColumnIndex(ItemDBHelper.KEY_ITEM_ID);


        while (cursor.moveToNext()){
            int id = cursor.getInt(id_column_id);
            String type = cursor.getString(type_column_id);
            int item_id = cursor.getInt(item_id_column_id);
            ItemParams.add(new PersonItemStorage(type, item_id));
        }

        cursor.close();
        return  ItemParams;
    }

    public void saveAllItem(List<PersonItemStorage> list){

        dbHelper.clear(database);

        for(PersonItemStorage one: list){
            insert(one);
        }
    }

    public void insert(PersonItemStorage one){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ItemDBHelper.KEY_TYPE, one.text);
        contentValues.put(ItemDBHelper.KEY_ITEM_ID, one.value);
        database.insert(ItemDBHelper.TABLE_NAME, null, contentValues);

    }


}
