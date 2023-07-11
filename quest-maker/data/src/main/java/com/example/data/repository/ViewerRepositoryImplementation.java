package com.example.data.repository;

import com.example.data.storage.AuthorStorageInterface;
import com.example.data.storage.models.WeaponStorage;
import com.example.domain.models.Weapon;
import com.example.domain.repository.ViewerRepositoryInterface;

import java.util.ArrayList;
import java.util.List;

public class ViewerRepositoryImplementation  implements ViewerRepositoryInterface {

    private AuthorStorageInterface authorStorageInterface;

    public ViewerRepositoryImplementation(AuthorStorageInterface authorStorageInterface){
        this.authorStorageInterface = authorStorageInterface;
    }

    public List<Weapon> getAllWeapon(){
        List<WeaponStorage> listS = authorStorageInterface.getAllWeapon();
        List<Weapon> listD = new ArrayList<>();

        for(WeaponStorage one : listS){
            listD.add(weaponMapToDomain(one));
        }

        return listD;
    }

    /*private WeaponStorage weaponMapToStorage(Weapon one){
        return new WeaponStorage(
                one.name,
                one.damage_type,
                Integer.parseInt(one.handed),
                one.preferred_stat,
                Integer.parseInt(one.damage),
                Integer.parseInt(one.speed),
                Integer.parseInt(one.speed_equip),
                Integer.parseInt(one.hit_chance),
                Integer.parseInt(one.throw_damage),
                Integer.parseInt(one.sell_price),
                one.description
        );
    }*/

    private Weapon weaponMapToDomain(WeaponStorage one){
        return new Weapon(
                one.name,
                one.damage_type,
                Integer.toString(one.handed),
                one.preferred_stat,
                Integer.toString(one.damage),
                Integer.toString(one.speed),
                Integer.toString(one.speed_equip),
                Integer.toString(one.hit_chance),
                Integer.toString(one.throw_damage),
                Integer.toString(one.sell_price),
                one.description
        );
    }

}
