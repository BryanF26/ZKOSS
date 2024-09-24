package com.fif.repository;

import com.fif.Model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PersonRepository {
    public static List<Person> people = new ArrayList<>();
    static {
        people.add( new Person(
                UUID.randomUUID().toString()
                ,"John Doe"
                ,"Male"
                ,java.sql.Date.valueOf(LocalDate.of(1998,3,12))
                ,26
                ,"Jakarta"));

        people.add( new Person(
                UUID.randomUUID().toString()
                ,"Jane Smith"
                ,"Female"
                ,java.sql.Date.valueOf(LocalDate.of(2000,7,5))
                ,24
                ,"Bali"));

        people.add( new Person(
                UUID.randomUUID().toString()
                ,"Mike Johnson"
                ,"Male"
                ,java.sql.Date.valueOf(LocalDate.of(1995,4,18))
                ,29
                ,"Bandung"));

        people.add( new Person(
                UUID.randomUUID().toString()
                ,"Linda Lee"
                ,"Female"
                ,java.sql.Date.valueOf(LocalDate.of(1992,11,27))
                ,31
                ,"Surabaya"));

        people.add( new Person(
                UUID.randomUUID().toString()
                ,"Alex Wong"
                ,"Male"
                ,java.sql.Date.valueOf(LocalDate.of(2001,1,8))
                ,23
                ,"Medan"));

        people.add( new Person(
                UUID.randomUUID().toString()
                ,"Emily Davis"
                ,"Female"
                ,java.sql.Date.valueOf(LocalDate.of(1999,8,14))
                ,25
                ,"Yogyakarta"));

        people.add( new Person(
                UUID.randomUUID().toString()
                ,"Brian Wilson"
                ,"Male"
                ,java.sql.Date.valueOf(LocalDate.of(1990,9,3))
                ,34
                ,"Malang"));

        people.add( new Person(
                UUID.randomUUID().toString()
                ,"Sophie Brown"
                ,"Female"
                ,java.sql.Date.valueOf(LocalDate.of(1997,6,22))
                ,27
                ,"Semarang"));

        people.add( new Person(
                UUID.randomUUID().toString()
                ,"David Miller"
                ,"Male"
                ,java.sql.Date.valueOf(LocalDate.of(1988,9,30))
                ,35
                ,"Lampung"));

        people.add( new Person(
                UUID.randomUUID().toString()
                ,"Alice Green"
                ,"Female"
                ,java.sql.Date.valueOf(LocalDate.of(1994,11,16))
                ,29
                ,"Aceh"));

    }

    public List<Person> findAll(){
        return people;
    }

    public void addPerson(Person person){
        people.add(person);
    }

    public void deletePerson(Person person){
        people.remove(person);
    }
}
