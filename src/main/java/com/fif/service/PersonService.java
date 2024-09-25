package com.fif.service;

import com.fif.Model.Person;

import java.util.Date;
import java.util.List;

public interface PersonService {
    public List<Person> findAll();

    public List<Person> search(String keyword);

    public void add(String id, String username, String gender, Date birthday, int age, String province);

    public void delete(Person person);

    public void update(Person person, String username, String gender, Date birthday, int age, String province);
}
