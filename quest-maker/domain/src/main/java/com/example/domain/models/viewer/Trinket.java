package com.example.domain.models.viewer;

public class Trinket {

    public String name;
    public String traits;
    public String effect;
    public String source;
    public String buy_price;
    public String sell_price;
    public String description;


    public Trinket(String name,
                     String traits,
                     String effect,
                     String source,
                     String buy_price,
                     String sell_price,
                     String description) {

        this.name = name;
        this.traits = traits;
        this.effect = effect;
        this.source = source;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
        this.description = description;
    }

}
