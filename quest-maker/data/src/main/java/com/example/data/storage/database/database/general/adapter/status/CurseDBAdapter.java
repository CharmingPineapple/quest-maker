package com.example.data.storage.database.database.general.adapter.status;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.data.storage.database.database.general.status.CurseDBHelper;
import com.example.data.storage.models.viewer.StatusStorage;

import java.util.ArrayList;
import java.util.List;

public class CurseDBAdapter {

    private CurseDBHelper dbHelper;
    private SQLiteDatabase database;

    public CurseDBAdapter(Context context) {
        dbHelper = new CurseDBHelper(context.getApplicationContext());
    }

    public CurseDBAdapter open() {
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long getCount() {
        return DatabaseUtils.queryNumEntries(database, CurseDBHelper.TABLE_NAME);
    }

    // (#)
    private Cursor getAllEntries() {
        String[] columns = new String[]{
                CurseDBHelper.KEY_ID,
                CurseDBHelper.KEY_NAME,
                CurseDBHelper.KEY_TYPE,
                CurseDBHelper.KEY_EFFECT,
                CurseDBHelper.KEY_DESCR
        };

        return database.query(CurseDBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // (#)
    public List<StatusStorage> getAllCurse() {
        ArrayList<StatusStorage> statusStorageStorageArrayList = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(CurseDBHelper.KEY_ID);
        int name_column_id = cursor.getColumnIndex(CurseDBHelper.KEY_NAME);
        int type_column_id = cursor.getColumnIndex(CurseDBHelper.KEY_TYPE);
        int effect_column_id = cursor.getColumnIndex(CurseDBHelper.KEY_EFFECT);
        int description_column_id = cursor.getColumnIndex(CurseDBHelper.KEY_DESCR);

        while (cursor.moveToNext()) {

            int id = cursor.getInt(id_column_id);
            String name = cursor.getString(name_column_id);
            String type = cursor.getString(type_column_id);
            String effect = cursor.getString(effect_column_id);
            String description = cursor.getString(description_column_id);

            statusStorageStorageArrayList.add(new StatusStorage(
                    name,
                    type,
                    effect,
                    description
            ));
        }

        cursor.close();
        return statusStorageStorageArrayList;
    }

}
