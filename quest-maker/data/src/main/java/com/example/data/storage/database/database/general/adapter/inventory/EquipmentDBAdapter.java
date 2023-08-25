package com.example.data.storage.database.database.general.adapter.inventory;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.data.storage.database.database.general.inventory.EquipmentDBHelper;
import com.example.data.storage.models.viewer.EquipmentStorage;

import java.util.ArrayList;
import java.util.List;

public class EquipmentDBAdapter {

    private EquipmentDBHelper dbHelper;
    private SQLiteDatabase database;

    public EquipmentDBAdapter(Context context) {
        dbHelper = new EquipmentDBHelper(context.getApplicationContext());
    }

    public EquipmentDBAdapter open() {
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long getCount() {
        return DatabaseUtils.queryNumEntries(database, EquipmentDBHelper.TABLE_NAME);
    }

    // (#)
    private Cursor getAllEntries() {
        String[] columns = new String[]{
                EquipmentDBHelper.KEY_ID,
                EquipmentDBHelper.KEY_NAME,
                EquipmentDBHelper.KEY_TRAITS,
                EquipmentDBHelper.KEY_EFFECT,
                EquipmentDBHelper.KEY_THROW_DAMAGE,
                EquipmentDBHelper.KEY_SOURCE,
                EquipmentDBHelper.KEY_BUY_PRICE,
                EquipmentDBHelper.KEY_SELL_PRICE,
                EquipmentDBHelper.KEY_DESCR
        };

        return database.query(EquipmentDBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // (#)
    public List<EquipmentStorage> getAllEquipment() {
        ArrayList<EquipmentStorage> equipmentStorageArrayList = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(EquipmentDBHelper.KEY_ID);
        int name_column_id = cursor.getColumnIndex(EquipmentDBHelper.KEY_NAME);
        int traits_column_id = cursor.getColumnIndex(EquipmentDBHelper.KEY_TRAITS);
        int effect_column_id = cursor.getColumnIndex(EquipmentDBHelper.KEY_EFFECT);
        int throw_damage_column_id = cursor.getColumnIndex(EquipmentDBHelper.KEY_THROW_DAMAGE);
        int source_column_id = cursor.getColumnIndex(EquipmentDBHelper.KEY_SOURCE);
        int buy_price_column_id = cursor.getColumnIndex(EquipmentDBHelper.KEY_BUY_PRICE);
        int sell_price_column_id = cursor.getColumnIndex(EquipmentDBHelper.KEY_SELL_PRICE);
        int description_column_id = cursor.getColumnIndex(EquipmentDBHelper.KEY_DESCR);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(id_column_id);
            String name = cursor.getString(name_column_id);
            String traits = cursor.getString(traits_column_id);
            String effect = cursor.getString(effect_column_id);
            int throw_damage = cursor.getInt(throw_damage_column_id);
            String source = cursor.getString(source_column_id);
            int buy_price = cursor.getInt(buy_price_column_id);
            int sell_price = cursor.getInt(sell_price_column_id);
            String description = cursor.getString(description_column_id);

            equipmentStorageArrayList.add(new EquipmentStorage(
                    name,
                    traits,
                    effect,
                    throw_damage,
                    source,
                    buy_price,
                    sell_price,
                    description
            ));
        }

        cursor.close();
        return equipmentStorageArrayList;
    }
}
