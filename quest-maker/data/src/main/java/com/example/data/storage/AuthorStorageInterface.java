package com.example.data.storage;

import com.example.data.storage.models.PersonItemStorage;
import com.example.domain.models.PersonItem;


import java.util.List;

public interface AuthorStorageInterface {

    void saveSkill(PersonItemStorage skillStorage);

    int getSkill(PersonItemStorage skillStorage);

    List<PersonItemStorage> getAllSkill();

    void saveAllSkill(List<PersonItemStorage> listCS);

    List<PersonItemStorage> getAllMainParameter();

    void saveAllMainParameter(List<PersonItemStorage> listCS);

    List<PersonItemStorage> getAllItem();

    void saveAllItem(List<PersonItemStorage> list);
}
