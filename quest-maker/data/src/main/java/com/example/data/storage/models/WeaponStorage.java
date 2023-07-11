package com.example.data.storage.models;

public class WeaponStorage {

    public String name;
    public String damage_type;
    public int handed;
    public String preferred_stat;
    public int damage;
    public int speed;
    public int speed_equip;
    public int hit_chance;
    public int throw_damage;
    public int sell_price;
    public String description;

    public WeaponStorage(String name,
                         String damage_type,
                         int handed,
                         String preferred_stat,
                         int damage,
                         int speed,
                         int speed_equip,
                         int hit_chance,
                         int throw_damage,
                         int sell_price,
                         String description) {

        this.name = name;
        this.damage_type = damage_type;
        this.handed = handed;
        this.preferred_stat = preferred_stat;
        this.damage = damage;
        this.speed = speed;
        this.speed_equip = speed_equip;
        this.hit_chance = hit_chance;
        this.throw_damage = throw_damage;
        this.sell_price = sell_price;
        this.description = description;
    }

}
