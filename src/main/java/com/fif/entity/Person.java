package com.fif.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "Person")
public class Person implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(nullable = false)
    String username;

    @Column(nullable = false)
    String gender;

    @Column(nullable = false)
    Date birthday;

    @Column(nullable = false)
    int age;

    @Column(nullable = false)
    String province;

    public Person(){

    }

    public Person(String username, String gender, Date birthday, int age, String province) {
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.province = province;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
