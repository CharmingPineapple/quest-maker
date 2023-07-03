package com.example.domain.usecase;

import com.example.domain.models.Skill;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;
import java.util.Objects;

public class SaveSkillUseCase {

    // (?) - final ?? Why?
    private final AuthorRepositoryInterface authorRepositoryInterface;

    public SaveSkillUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }

    public void execute(Skill skill){

        // (!) - Добавить в слой presentatin проверку,
        // что saveCharacteristicParam.value == GetCharacteristicUseCase.execute()
        // и что saveCharacteristicParam.destination и saveCharacteristicParam.value подходящее

        if (!Objects.equals(skill.value, ""))
            authorRepositoryInterface.saveSkill(skill);
        else {
            skill.value = "0";
            authorRepositoryInterface.saveSkill(skill);
        }
    }

    public void saveAll(List<Skill> list){
        // (!) - Добавить в слой presentatin проверку,
        // и что characteristic.name подходящее

        authorRepositoryInterface.saveAllSkill(list);
    }

}
