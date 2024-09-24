package com.fif.service.impl;

import com.fif.Model.Person;
import com.fif.repository.PersonRepository;
import com.fif.service.PersonService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private List<Person> personList = new ArrayList<Person>();
    private PersonRepository repository = new PersonRepository();

    public PersonServiceImpl() {
        personList = repository.findAll();
    }

    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public List<Person> search(String keyword) {
        List<Person> res = new ArrayList<Person>();
        if(keyword == null || "".equals(keyword)){
            res = personList;
        } else{
            for (Person p : personList){
                if(p.getUsername().toLowerCase().contains(keyword.toLowerCase())){
                    res.add(p);
                }
            }
        }
        return res;
    }

    @Override
    public void add(String id, String username, String gender, Date birthday, int age, String province) {
        repository.addPerson(new Person(id, username, gender, birthday, age, province));
    }

    @Override
    public void delete(Person person) {
        repository.deletePerson(person);
    }
}
