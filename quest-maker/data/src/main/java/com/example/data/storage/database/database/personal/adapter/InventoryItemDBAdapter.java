package com.example.data.storage.database.database.personal.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.data.storage.database.database.personal.InventoryItemDBHelper;
import com.example.data.storage.models.author.ItemStorage;

import java.util.ArrayList;
import java.util.List;

public class InventoryItemDBAdapter {

    private InventoryItemDBHelper dbHelper;
    private SQLiteDatabase database;

    public InventoryItemDBAdapter(Context context){
        dbHelper = new InventoryItemDBHelper(context.getApplicationContext());
    }

    public InventoryItemDBAdapter open(){
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbHelper.close();
    }

    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, InventoryItemDBHelper.TABLE_NAME);
    }

    // (#)
    private Cursor getAllEntries(){
        String[] columns = new String[] {InventoryItemDBHelper.KEY_ID, InventoryItemDBHelper.KEY_NAME, InventoryItemDBHelper.KEY_TYPE};
        //String[] columns = new String[] {ItemDBHelper.KEY_ID, ItemDBHelper.KEY_NAME, ItemDBHelper.KEY_TYPE, ItemDBHelper.KEY_ITEM_ID};
        return  database.query(InventoryItemDBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // (#)
    public List<ItemStorage> getAllItem(){
        ArrayList<ItemStorage> itemList = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(InventoryItemDBHelper.KEY_ID);
        int name_column_id = cursor.getColumnIndex(InventoryItemDBHelper.KEY_NAME);
        int type_column_id = cursor.getColumnIndex(InventoryItemDBHelper.KEY_TYPE);
        //int item_id_column_id = cursor.getColumnIndex(ItemDBHelper.KEY_ITEM_ID);


        while (cursor.moveToNext()){
            int id = cursor.getInt(id_column_id);
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
        contentValues.put(InventoryItemDBHelper.KEY_NAME, one.name);
        contentValues.put(InventoryItemDBHelper.KEY_TYPE, one.type);
        database.insert(InventoryItemDBHelper.TABLE_NAME, null, contentValues);

    }


}
