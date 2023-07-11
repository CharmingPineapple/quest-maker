package com.example.domain.usecase.skill;

import com.example.domain.models.PersonItem;
import com.example.domain.repository.AuthorRepositoryInterface;

import java.util.List;

public class GetSkillUseCase {

    // (?) - final ?? Why?
    private final AuthorRepositoryInterface authorRepositoryInterface;

    public GetSkillUseCase(AuthorRepositoryInterface authorRepositoryInterface) {
        this.authorRepositoryInterface = authorRepositoryInterface;
    }



    // (#) - одиночные get и save в мейкере не нужны
    public String execute(PersonItem skill){
        // (!) - Добавить в слой presentatin проверку,
        // и что characteristic.name подходящее

        int value = authorRepositoryInterface.getSkill(skill);

        // (#)
        if (value >= 0)
            return Integer.toString(value);
        else
            return "v<0";   // (!) - Один раз возвращает верное значение, а потом только "lol"
    }

    public List<PersonItem> getAll(){
        // (!) - Добавить в слой presentatin проверку,
        // и что characteristic.name подходящее

        return authorRepositoryInterface.getAllSkill();
    }

}
