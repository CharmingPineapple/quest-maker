package com.example.domain.models.viewer;

public class Weapon {

    public String name;
    public String damage_type;
    public String handed;
    public String preferred_stat;
    public String damage;
    public String speed;
    public String speed_equip;
    public String hit_chance;
    public String throw_damage;
    public String sell_price;
    public String description;

    public Weapon(String name,
                  String damage_type,
                  String handed,
                  String preferred_stat,
                  String damage,
                  String speed,
                  String speed_equip,
                  String hit_chance,
                  String throw_damage,
                  String sell_price,
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
