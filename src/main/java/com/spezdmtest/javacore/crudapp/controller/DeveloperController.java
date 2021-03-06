package com.spezdmtest.javacore.crudapp.controller;

import com.spezdmtest.javacore.crudapp.model.Developer;
import com.spezdmtest.javacore.crudapp.model.Skill;
import com.spezdmtest.javacore.crudapp.repository.DeveloperRepository;
import com.spezdmtest.javacore.crudapp.repository.json.JsonDeveloperRepositoryImpl;

import java.util.List;

public class DeveloperController {
    private final DeveloperRepository repoDev = new JsonDeveloperRepositoryImpl();

    public List<Developer> getAllDev() {
        return repoDev.getAll();
    }

    public Developer createDev(String FirstName, String LastName, List<Skill> skills) {
        Developer d = new Developer();
        d.setFirstName(FirstName);
        d.setLastName(LastName);
        d.setSkills(skills);
        return repoDev.save(d);
    }

    public Developer updateDev(Long id, String FirstName, String Lastname) {
        Developer d = new Developer();
        d.setId(id);
        d.setFirstName(FirstName);
        d.setLastName(Lastname);
        return repoDev.update(d);
    }

    public void deleteByIdDev(Long id) {
        repoDev.deleteById(id);
    }
}
