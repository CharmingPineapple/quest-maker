package com.example.data.storage.database.database.general.adapter;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;


import com.example.data.storage.database.database.general.InjuryDBHelper;
import com.example.data.storage.models.viewer.InjuryStorage;

import java.util.ArrayList;
import java.util.List;

public class InjuryDBAdapter {

    private InjuryDBHelper dbHelper;
    private SQLiteDatabase database;

    public InjuryDBAdapter(Context context) {
        dbHelper = new InjuryDBHelper(context.getApplicationContext());
    }

    public InjuryDBAdapter open() {
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long getCount() {
        return DatabaseUtils.queryNumEntries(database, InjuryDBHelper.TABLE_NAME);
    }

    // (#)
    private Cursor getAllEntries() {
        String[] columns = new String[]{
                InjuryDBHelper.KEY_ID,
                InjuryDBHelper.KEY_NAME,
                InjuryDBHelper.KEY_TYPE,
                InjuryDBHelper.KEY_EFFECT,
                InjuryDBHelper.KEY_DESCR
        };

        return database.query(InjuryDBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // (#)
    public List<InjuryStorage> getAllInjury() {
        ArrayList<InjuryStorage> injuryStorageStorageArrayList = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(InjuryDBHelper.KEY_ID);
        int name_column_id = cursor.getColumnIndex(InjuryDBHelper.KEY_NAME);
        int type_column_id = cursor.getColumnIndex(InjuryDBHelper.KEY_TYPE);
        int effect_column_id = cursor.getColumnIndex(InjuryDBHelper.KEY_EFFECT);
        int description_column_id = cursor.getColumnIndex(InjuryDBHelper.KEY_DESCR);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(id_column_id);
            String name = cursor.getString(name_column_id);
            String type = cursor.getString(type_column_id);
            String effect = cursor.getString(effect_column_id);
            String description = cursor.getString(description_column_id);

            injuryStorageStorageArrayList.add(new InjuryStorage(
                    name,
                    type,
                    effect,
                    description
            ));
        }

        cursor.close();
        return injuryStorageStorageArrayList;
    }

}
