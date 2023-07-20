package com.example.data.storage.database;

import android.content.Context;

import com.example.data.storage.ViewerStorageInterface;
import com.example.data.storage.database.database.general.adapter.EquipmentDBAdapter;
import com.example.data.storage.database.database.general.adapter.TrinketDBAdapter;
import com.example.data.storage.database.database.general.adapter.WeaponDBAdapter;
import com.example.data.storage.models.viewer.EquipmentStorage;
import com.example.data.storage.models.viewer.TrinketStorage;
import com.example.data.storage.models.viewer.WeaponStorage;

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

    public List<EquipmentStorage> getAllEquipment() {
        EquipmentDBAdapter equipmentDBAdapter = new EquipmentDBAdapter(context);
        equipmentDBAdapter.open();
        List<EquipmentStorage> EquipmentStorageList = equipmentDBAdapter.getAllEquipment();
        equipmentDBAdapter.close();

        return EquipmentStorageList;
    }

    public List<TrinketStorage> getAllTrinket() {
        TrinketDBAdapter trinketDBAdapter = new TrinketDBAdapter(context);
        trinketDBAdapter.open();
        List<TrinketStorage> trinketStorageList = trinketDBAdapter.getAllTrinket();
        trinketDBAdapter.close();

        return trinketStorageList;
    }

}
