package com.fif.repository;

import com.fif.entity.Person;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

@Repository
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly = true)
    public List<Person> queryAll() {
        Query query = em.createQuery("SELECT p FROM Person p");
        List<Person> result = query.getResultList();
        return result;
    }

    @Transactional(readOnly = true)
    public Person get(Long id) {return em.find(Person.class, id);}

    @Transactional
    public Person save(Person person){
        em.persist(person);
        em.flush();
        return person;
    }

    @Transactional
    public void delete(Person person){
        Person p = get(person.getId());
        if(p != null){
            em.remove(p);
        }
    }

    @Transactional(readOnly = true)
    public List<Person> search(String keyword){
        Query query = em.createQuery("SELECT p FROM Person p WHERE LOWER(p.username) LIKE :kName or LOWER(p.gender) = :kGender");
        query.setParameter("kName", "%" + keyword.toLowerCase() + "%");
        query.setParameter("kGender", keyword.toLowerCase());
        List<Person> result = query.getResultList();
        return result;
    }

    @Transactional
    public void updatePerson(Person person, String username, String gender, Date birthday, int age, String province) {
        Person existingPerson = get(person.getId());
        existingPerson.setUsername(username);
        existingPerson.setGender(gender);
        existingPerson.setBirthday(birthday);
        existingPerson.setAge(age);
        existingPerson.setProvince(province);
        em.merge(existingPerson);
    }
}
