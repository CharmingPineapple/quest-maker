package com.example.data.storage.models.viewer;

public class SpellStorage {

     /*

    name
    type
    description
    cost

     */

    public String name;
    public String type;
    public String description;
    public String cost;

    public SpellStorage(String name,
                         String type,
                         String description,
                         String cost) {

        this.name = name;
        this.type = type;
        this.description = description;
        this.cost = cost;
    }

}
