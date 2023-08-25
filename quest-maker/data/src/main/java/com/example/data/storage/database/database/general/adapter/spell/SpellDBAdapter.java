package com.example.data.storage.database.database.general.adapter.spell;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.data.storage.database.database.general.spell.SpellDBHelper;

import com.example.data.storage.models.viewer.SpellStorage;

import java.util.ArrayList;
import java.util.List;

public class SpellDBAdapter {

    private SpellDBHelper dbHelper;
    private SQLiteDatabase database;

    public SpellDBAdapter(Context context) {
        dbHelper = new SpellDBHelper(context.getApplicationContext());
    }

    public SpellDBAdapter open() {
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long getCount() {
        return DatabaseUtils.queryNumEntries(database, SpellDBHelper.TABLE_NAME);
    }

    // (#)
    private Cursor getAllEntries() {
        String[] columns = new String[]{
                SpellDBHelper.KEY_ID,
                SpellDBHelper.KEY_NAME,
                SpellDBHelper.KEY_TYPE,
                SpellDBHelper.KEY_DESCR,
                SpellDBHelper.KEY_COST
        };

        return database.query(SpellDBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // (#)
    public List<SpellStorage> getAllInjury() {
        ArrayList<SpellStorage> spellStorageStorageArrayList = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(SpellDBHelper.KEY_ID);
        int name_column_id = cursor.getColumnIndex(SpellDBHelper.KEY_NAME);
        int type_column_id = cursor.getColumnIndex(SpellDBHelper.KEY_TYPE);
        int description_column_id = cursor.getColumnIndex(SpellDBHelper.KEY_DESCR);
        int cost_column_id = cursor.getColumnIndex(SpellDBHelper.KEY_COST);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(id_column_id);
            String name = cursor.getString(name_column_id);
            String type = cursor.getString(type_column_id);
            String description = cursor.getString(description_column_id);
            String cost = cursor.getString(cost_column_id);

            spellStorageStorageArrayList.add(new SpellStorage(
                    name,
                    type,
                    description,
                    cost
            ));
        }

        cursor.close();
        return spellStorageStorageArrayList;
    }

}
