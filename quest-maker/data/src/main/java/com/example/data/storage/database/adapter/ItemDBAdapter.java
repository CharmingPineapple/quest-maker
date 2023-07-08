package com.example.data.storage.database.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.data.storage.database.database.personal.ItemDBHelper;
import com.example.data.storage.database.database.personal.SkillDBHelper;
import com.example.data.storage.models.ItemStorage;
import com.example.data.storage.models.SkillStorage;

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
    public List<ItemStorage> getAllItem(){
        ArrayList<ItemStorage> ItemParams = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(ItemDBHelper.KEY_ID);
        int type_column_id = cursor.getColumnIndex(ItemDBHelper.KEY_TYPE);
        int item_id_column_id = cursor.getColumnIndex(ItemDBHelper.KEY_ITEM_ID);


        while (cursor.moveToNext()){
            int id = cursor.getInt(id_column_id);
            String type = cursor.getString(type_column_id);
            int item_id = cursor.getInt(item_id_column_id);
            ItemParams.add(new ItemStorage(type, item_id));
        }

        cursor.close();
        return  ItemParams;
    }

    public void saveAllItem(List<ItemStorage> list){

        dbHelper.clear(database);

        for(ItemStorage one: list){
            insert(one);
        }
    }

    /*public int getValueOf(String ){

        int value = -1;

        //Cursor cursor;

        String query = String.format("select * from %s where %s=?", SkillDBHelper.TABLE_NAME, SkillDBHelper.KEY_NAME);
        Cursor cursor = database.rawQuery(query, new String[]{ skillName });
        int columnIndex = cursor.getColumnIndex(SkillDBHelper.KEY_VALUE);


        // (#)
        if (cursor.moveToFirst()){
            if (columnIndex != -1){
                value = cursor.getInt(columnIndex);
            }  else {
                Log.e("CharacteristicsDBAdapter", "getValueOf(String skillName) can't find CharacteristicsDBHelper.KEY_VALUE in CharacteristicsDBHelper.TABLE_NAME");
            }
        } else {
            Log.e("CharacteristicsDBAdapter", "getValueOf(String skillName) can't find skillName in CharacteristicsDBHelper.KEY_NAME");
        }

        return value;
    }*/

    /*public void updateValue(String type, int item_id){

        String whereClause = ItemDBHelper.KEY_TYPE + " = " + "'" + type + "'";
        ContentValues contentValues = new ContentValues();
        contentValues.put(ItemDBHelper.KEY_VALUE, (int) item_id);
        database.update(ItemDBHelper.TABLE_NAME, contentValues, whereClause, null);
    }*/

    public void insert(ItemStorage one){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ItemDBHelper.KEY_TYPE, one.type);
        contentValues.put(ItemDBHelper.KEY_ITEM_ID, one.id);
        database.insert(ItemDBHelper.TABLE_NAME, null, contentValues);

    }


}
