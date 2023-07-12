package com.example.data.storage.database;

import android.content.Context;

import com.example.data.storage.ViewerStorageInterface;
import com.example.data.storage.database.database.general.adapter.WeaponDBAdapter;
import com.example.data.storage.models.WeaponStorage;

import java.util.List;

public class DatabaseViewerStorageImplementation implements ViewerStorageInterface {

    private Context context;

    public DatabaseViewerStorageImplementation(Context context){
        this.context = context;
    }

    public List<WeaponStorage> getAllWeapon() {
        WeaponDBAdapter weaponDBAdapter = new WeaponDBAdapter(context);
        weaponDBAdapter.open();
        List<WeaponStorage> weaponStorageList = weaponDBAdapter.getAllWeapon();
        weaponDBAdapter.close();

        return weaponStorageList;
    }

}
