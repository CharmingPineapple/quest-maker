package com.example.data.storage.database.database.general.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;

import com.example.data.storage.database.database.general.WeaponDBHelper;
import com.example.data.storage.models.WeaponStorage;

import java.util.ArrayList;
import java.util.List;

public class WeaponDBAdapter {

    private WeaponDBHelper dbHelper;
    private SQLiteDatabase database;

    public WeaponDBAdapter(Context context) {
        dbHelper = new WeaponDBHelper(context.getApplicationContext());
    }

    public WeaponDBAdapter open() {
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public long getCount() {
        return DatabaseUtils.queryNumEntries(database, WeaponDBHelper.TABLE_NAME);
    }

    // (#)
    private Cursor getAllEntries() {
        String[] columns = new String[]{
                WeaponDBHelper.KEY_ID,
                WeaponDBHelper.KEY_NAME,
                WeaponDBHelper.KEY_DAMAGE_TYPE,
                WeaponDBHelper.KEY_HANDED,
                WeaponDBHelper.KEY_PREFSTAT,
                WeaponDBHelper.KEY_DAMAGE,
                WeaponDBHelper.KEY_SPEED,
                WeaponDBHelper.KEY_SPEED_EQUIP,
                WeaponDBHelper.KEY_HIT_CHANCE,
                WeaponDBHelper.KEY_THROW_DAMAGE,
                WeaponDBHelper.KEY_SELL_PRICE,
                WeaponDBHelper.KEY_DESCR};

        return database.query(WeaponDBHelper.TABLE_NAME, columns, null, null, null, null, null);
    }

    // (#)
    public List<WeaponStorage> getAllWeapon() {
        ArrayList<WeaponStorage> weaponStorageArrayList = new ArrayList<>();
        Cursor cursor = getAllEntries();

        int id_column_id = cursor.getColumnIndex(WeaponDBHelper.KEY_ID);
        int name_column_id = cursor.getColumnIndex(WeaponDBHelper.KEY_NAME);
        int damage_type_column_id = cursor.getColumnIndex(WeaponDBHelper.KEY_DAMAGE_TYPE);
        int handed_column_id = cursor.getColumnIndex(WeaponDBHelper.KEY_HANDED);
        int preferred_stat_column_id = cursor.getColumnIndex(WeaponDBHelper.KEY_PREFSTAT);
        int damage_column_id = cursor.getColumnIndex(WeaponDBHelper.KEY_DAMAGE);
        int speed_column_id = cursor.getColumnIndex(WeaponDBHelper.KEY_SPEED);
        int speed_equip_column_id = cursor.getColumnIndex(WeaponDBHelper.KEY_SPEED_EQUIP);
        int hit_chance_column_id = cursor.getColumnIndex(WeaponDBHelper.KEY_HIT_CHANCE);
        int throw_damage_column_id = cursor.getColumnIndex(WeaponDBHelper.KEY_THROW_DAMAGE);
        int sell_price_column_id = cursor.getColumnIndex(WeaponDBHelper.KEY_SELL_PRICE);
        int description_column_id = cursor.getColumnIndex(WeaponDBHelper.KEY_DESCR);

        while (cursor.moveToNext()) {
            int id = cursor.getInt(id_column_id);
            String name = cursor.getString(name_column_id);
            String damage_type = cursor.getString(damage_type_column_id);
            int handed = cursor.getInt(handed_column_id);
            String preferred_stat = cursor.getString(preferred_stat_column_id);
            int damage = cursor.getInt(damage_column_id);
            int speed = cursor.getInt(speed_column_id);
            int speed_equip = cursor.getInt(speed_equip_column_id);
            int hit_chance = cursor.getInt(hit_chance_column_id);
            int throw_damage = cursor.getInt(throw_damage_column_id);
            int sell_price = cursor.getInt(sell_price_column_id);
            String description = cursor.getString(description_column_id);

            weaponStorageArrayList.add(new WeaponStorage(
                    name,
                    damage_type,
                    handed,
                    preferred_stat,
                    damage,
                    speed,
                    speed_equip,
                    hit_chance,
                    throw_damage,
                    sell_price,
                    description));
        }

        cursor.close();
        return weaponStorageArrayList;
    }

    /*public void saveAllSkill(List<WeaponDBHelper> list) {
        for (WeaponDBHelper one : list) {
            updateValue(one.text, one.value);
        }
    }*/

    /*public int getValueOf(String skillName) {

        int value = -1;

        //Cursor cursor;

        String query = String.format("select * from %s where %s=?", WeaponDBHelper.TABLE_NAME, WeaponDBHelper.KEY_NAME);
        Cursor cursor = database.rawQuery(query, new String[]{skillName});
        int columnIndex = cursor.getColumnIndex(WeaponDBHelper.KEY_VALUE);

        return value;
    }*/

    /*// Возвращает количество изменённых элементов
    public void updateValue(String skillName, int value) {

        String whereClause = WeaponDBHelper.KEY_NAME + " = " + "'" + skillName + "'";
        ContentValues contentValues = new ContentValues();
        contentValues.put(WeaponDBHelper.KEY_VALUE, (int) value);
        database.update(WeaponDBHelper.TABLE_NAME, contentValues, whereClause, null);
    }*/

}
