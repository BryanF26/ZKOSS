package com.fif.service.impl;

import com.fif.Model.Person;
import com.fif.service.PersonService;

import java.util.ArrayList;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    private List<Person> personList = new ArrayList<Person>();
    private long id = 1L;

    public PersonServiceImpl() {
        personList.add( new Person(
                id++,
        "John Doe"
        ,"Male"
        ,"12 March 1998"
        ,26
        ,"Jakarta"));

        personList.add( new Person(
                id++
        ,"Jane Smith"
        ,"Female"
        ,"5 July 2000"
        ,24
        ,"Bali"));

        personList.add( new Person(
                id++
        ,"Mike Johnson"
        ,"Male"
        ,"18 April 1995"
        ,29
        ,"Bandung"));

        personList.add( new Person(
                id++
        ,"Linda Lee"
        ,"Female"
        ,"27 November 1992"
        ,31
        ,"Surabaya"));

        personList.add( new Person(
                id++
        ,"Alex Wong"
        ,"Male"
        ,"8 January 2001"
        ,23
        ,"Medan"));

        personList.add( new Person(
                id++
        ,"Emily Davis"
        ,"Female"
        ,"14 August 1999"
        ,25
        ,"Yogyakarta"));

        personList.add( new Person(
                id++
        ,"Brian Wilson"
        ,"Male"
        ,"3 September 1990"
        ,34
        ,"Malang"));

        personList.add( new Person(
                id++
        ,"Sophie Brown"
        ,"Female"
        ,"22 June 1997"
        ,27
        ,"Semarang"));

        personList.add( new Person(
                id++
        ,"David Miller"
        ,"Male"
        ,"30 October 1988"
        ,35
        ,"Lampung"));

        personList.add( new Person(
                id++
        ,"Alice Green"
        ,"Female"
        ,"16 December 1994"
        ,29
        ,"Aceh"));
    }

    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public List<Person> search(String keyword) {
        List<Person> res = new ArrayList<Person>();
        if(keyword.isEmpty()){
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
}
