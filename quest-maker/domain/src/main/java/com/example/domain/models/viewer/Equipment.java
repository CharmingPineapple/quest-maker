package com.example.domain.models.viewer;

public class Equipment {


    /*

    id
    name
    traits
    effect
    source
    buy_price
    sell_price
    description

    */

    public String name;
    public String traits;
    public String effect;
    public String throw_damage;
    public String source;
    public String buy_price;
    public String sell_price;
    public String description;


    public Equipment(String name,
                     String traits,
                     String effect,
                     String throw_damage,
                     String source,
                     String buy_price,
                     String sell_price,
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
