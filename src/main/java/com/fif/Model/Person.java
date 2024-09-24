package com.fif.Model;

public class Person {
    private long id;
    private String username;
    private String gender;
    private String birthday;
    private int age;
    private String province;

    public Person(long id, String username, String gender, String birthday, int age, String province) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.birthday = birthday;
        this.age = age;
        this.province = province;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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
