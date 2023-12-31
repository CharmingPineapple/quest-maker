package com.example.data.storage.database;

import android.content.Context;

import com.example.data.storage.ViewerStorageInterface;
import com.example.data.storage.database.database.general.adapter.status.CurseDBAdapter;
import com.example.data.storage.database.database.general.adapter.inventory.EquipmentDBAdapter;
import com.example.data.storage.database.database.general.adapter.status.InjuryDBAdapter;
import com.example.data.storage.database.database.general.adapter.inventory.TrinketDBAdapter;
import com.example.data.storage.database.database.general.adapter.inventory.WeaponDBAdapter;
import com.example.data.storage.models.viewer.EquipmentStorage;
import com.example.data.storage.models.viewer.StatusStorage;
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

    public List<StatusStorage> getAllInjury() {
        InjuryDBAdapter injuryDBAdapter = new InjuryDBAdapter(context);
        injuryDBAdapter.open();
        List<StatusStorage> injuryStorageList = injuryDBAdapter.getAllInjury();
        injuryDBAdapter.close();

        return injuryStorageList;
    }

    public List<StatusStorage> getAllCurse() {
        CurseDBAdapter curseDBAdapter = new CurseDBAdapter(context);
        curseDBAdapter.open();
        List<StatusStorage> curseStorageList = curseDBAdapter.getAllCurse();
        curseDBAdapter.close();

        return curseStorageList;
    }

}
