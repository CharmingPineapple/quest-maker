package com.example.domain.models;

import java.util.ArrayList;
import java.util.List;

public class CharacteristicList {

    public List<Characteristic> list = new ArrayList<>();

    public CharacteristicList(List<Characteristic> list){
        this.list = list;
    }

    public CharacteristicList(){}


    public void add(Characteristic one) {
        list.add(one);
    }

    public int size(){
        return list.size();
    }

    public Characteristic get(int index) {
        return list.get(index);
    }

    public void clear() {
        list.clear();
    }

}
