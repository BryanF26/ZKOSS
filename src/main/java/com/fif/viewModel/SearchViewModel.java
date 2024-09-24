package com.fif.viewModel;

import com.fif.Model.Person;
import com.fif.service.impl.PersonServiceImpl;
import org.zkoss.bind.annotation.Command;
import org.zkoss.zul.ListModelList;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class SearchViewModel{

    private String keyword;
    private String username;
    private String gender;
    private Date birthday;
    private int age;
    private String province;

    private List<Person> personList = new ListModelList<>();

    private Person selectedPerson;

    private PersonServiceImpl personService = new PersonServiceImpl();

    public SearchViewModel(){
        personList.addAll(personService.findAll());
    }

    @Command
    public void add(){
        personService.add(UUID.randomUUID().toString(), this.username, this.gender, this.birthday, this.age, this.province);
        search();
    }

    @Command
    public void search(){
        selectedPerson = null;
        personList.clear();
        personList.addAll(personService.search(keyword));
    }

    @Command
    public void delete(){
        if(selectedPerson == null) throw new RuntimeException("Please select person before delete");
        personService.delete(selectedPerson);
        search();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public void setSelectedPerson(Person selectedPerson) {
        this.selectedPerson = selectedPerson;
    }
}
