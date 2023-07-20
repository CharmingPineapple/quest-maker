package com.example.data.storage.models.viewer;

public class InjuryStorage {

    /*

    name
    type
    effect
    description

     */

    public String name;
    public String type;
    public String effect;
    public String description;

    public InjuryStorage(String name,
                         String type,
                         String effect,
                         String description) {

        this.name = name;
        this.type = type;
        this.effect = effect;
        this.description = description;
    }

}
