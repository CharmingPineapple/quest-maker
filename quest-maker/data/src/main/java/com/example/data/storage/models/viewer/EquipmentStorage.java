package com.example.data.storage.models.viewer;

public class EquipmentStorage {

    /*

    id
    name
    traits
    effect
    throw_damage
    source
    buy_price
    sell_price
    description

    */

    public String name;
    public String traits;
    public String effect;
    public int throw_damage;
    public String source;
    public int buy_price;
    public int sell_price;
    public String description;


    public EquipmentStorage(String name,
                            String traits,
                            String effect,
                            int throw_damage,
                            String source,
                            int buy_price,
                            int sell_price,
                            String description) {

        this.name = name;
        this.traits = traits;
        this.effect = effect;
        this.throw_damage = throw_damage;
        this.source = source;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
        this.description = description;
    }

}
