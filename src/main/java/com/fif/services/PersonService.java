package com.fif.services;
import com.fif.entity.Person;
import java.util.Date;
import java.util.List;

public interface PersonService {

    Person addPerson(Person person);

    List<Person> getPersons();

    void deletePerson(Person person);

    List<Person> search(String keyword);

    void update(Person person, String username, String gender, Date birthday, int age, String province);
}
