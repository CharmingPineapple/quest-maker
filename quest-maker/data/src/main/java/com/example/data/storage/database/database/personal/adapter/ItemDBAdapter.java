package com.example.data.storage.database.database.personal.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.data.storage.database.database.personal.ItemDBHelper;
import com.example.data.storage.models.InventoryItemStorage;

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
        String[] columns = new String[] {ItemDBHelper.KEY_ID, ItemDBHelper.KEY_NAME, ItemDBHelper.KEY_TYPE};
        //String[] columns = new String[] {ItemDBHelper.KEY_ID, ItemDBHelper.KEY_NAME, ItemDBHelper.KEY_TYPE, ItemDBHelper.KEY_ITEM_ID};
        return  database.query(ItemDBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // (#)
    public List<InventoryItemStorage> getAllItem(){
        ArrayList<InventoryItemStorage> ItemParams = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(ItemDBHelper.KEY_ID);
        int name_column_id = cursor.getColumnIndex(ItemDBHelper.KEY_NAME);
        int type_column_id = cursor.getColumnIndex(ItemDBHelper.KEY_TYPE);
        //int item_id_column_id = cursor.getColumnIndex(ItemDBHelper.KEY_ITEM_ID);


        while (cursor.moveToNext()){
            int id = cursor.getInt(id_column_id);
            String name = cursor.getString(name_column_id);
            String type = cursor.getString(type_column_id);

            ItemParams.add(new InventoryItemStorage(name, type));
        }

        cursor.close();
        return  ItemParams;
    }

    public void saveAllItem(List<InventoryItemStorage> list){

        dbHelper.clear(database);

        for(InventoryItemStorage one: list){
            insert(one);
        }
    }

    public void insert(InventoryItemStorage one){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ItemDBHelper.KEY_NAME, one.name);
        contentValues.put(ItemDBHelper.KEY_TYPE, one.type);
        database.insert(ItemDBHelper.TABLE_NAME, null, contentValues);

    }


}
