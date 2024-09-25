package com.fif.services.impl;
import com.fif.entity.Person;
import com.fif.repository.PersonRepository;
import com.fif.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service("personService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    public Person addPerson(Person person){
        return personRepository.save(person);
    }

    public List<Person> getPersons(){
        return personRepository.queryAll();
    }

    public void deletePerson(Person person){
        personRepository.delete(person);
    }

    public List<Person> search(String keyword) {
        return personRepository.search(keyword);
    }

    public void update(Person person, String username, String gender, Date birthday, int age, String province) {
        personRepository.updatePerson(person, username, gender, birthday, age, province);
    }
}
