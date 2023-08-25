package com.example.data.storage.database.database.general.adapter.inventory;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.data.storage.database.database.general.inventory.TrinketDBHelper;
import com.example.data.storage.models.viewer.TrinketStorage;

import java.util.ArrayList;
import java.util.List;

public class TrinketDBAdapter {

    private TrinketDBHelper dbHelper;
    private SQLiteDatabase database;

    public TrinketDBAdapter(Context context) {
        dbHelper = new TrinketDBHelper(context.getApplicationContext());
    }

    public TrinketDBAdapter open() {
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long getCount() {
        return DatabaseUtils.queryNumEntries(database, TrinketDBHelper.TABLE_NAME);
    }

    // (#)
    private Cursor getAllEntries() {
        String[] columns = new String[]{
                TrinketDBHelper.KEY_ID,
                TrinketDBHelper.KEY_NAME,
                TrinketDBHelper.KEY_TRAITS,
                TrinketDBHelper.KEY_EFFECT,
                TrinketDBHelper.KEY_SOURCE,
                TrinketDBHelper.KEY_BUY_PRICE,
                TrinketDBHelper.KEY_SELL_PRICE,
                TrinketDBHelper.KEY_DESCR
        };

        return database.query(TrinketDBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // (#)
    public List<TrinketStorage> getAllTrinket() {
        ArrayList<TrinketStorage> trinketStorageArrayList = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(TrinketDBHelper.KEY_ID);
        int name_column_id = cursor.getColumnIndex(TrinketDBHelper.KEY_NAME);
        int traits_column_id = cursor.getColumnIndex(TrinketDBHelper.KEY_TRAITS);
        int effect_column_id = cursor.getColumnIndex(TrinketDBHelper.KEY_EFFECT);
        int source_column_id = cursor.getColumnIndex(TrinketDBHelper.KEY_SOURCE);
        int buy_price_column_id = cursor.getColumnIndex(TrinketDBHelper.KEY_BUY_PRICE);
        int sell_price_column_id = cursor.getColumnIndex(TrinketDBHelper.KEY_SELL_PRICE);
        int description_column_id = cursor.getColumnIndex(TrinketDBHelper.KEY_DESCR);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(id_column_id);
            String name = cursor.getString(name_column_id);
            String traits = cursor.getString(traits_column_id);
            String effect = cursor.getString(effect_column_id);
            String source = cursor.getString(source_column_id);
            int buy_price = cursor.getInt(buy_price_column_id);
            int sell_price = cursor.getInt(sell_price_column_id);
            String description = cursor.getString(description_column_id);

            trinketStorageArrayList.add(new TrinketStorage(
                    name,
                    traits,
                    effect,
                    source,
                    buy_price,
                    sell_price,
                    description
            ));
        }

        cursor.close();
        return trinketStorageArrayList;
    }

}
