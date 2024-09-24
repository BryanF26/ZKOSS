package com.fif.Model;

import java.util.Date;

public class Person {
    private String id;
    private String username;
    private String gender;
    private Date birthday;
    private int age;
    private String province;

    public Person(String id, String username, String gender, Date birthday, int age, String province) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.province = province;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
