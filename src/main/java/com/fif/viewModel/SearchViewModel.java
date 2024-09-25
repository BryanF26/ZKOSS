package com.fif.viewModel;

import com.fif.Model.Person;
import com.fif.service.impl.PersonServiceImpl;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
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
    private boolean submitDisabled = true;
    private boolean termChecked = false;
    private String submitStyle = "background-color: #b0b0b0; color: white; border: none; padding: 8px 16px; margin-left: 10px; border-radius: 5px; cursor: not-allowed;";
    private boolean formVisible = false;
    private boolean tableVisible = true;

    private List<Person> personList = new ListModelList<>();

    private Person selectedPerson;

    private PersonServiceImpl personService = new PersonServiceImpl();

    public SearchViewModel(){
        personList.addAll(personService.findAll());
    }

    @Command
    @NotifyChange({"username", "gender", "birthday", "age", "province","submitDisabled","submitStyle","termChecked"})
    public void add(){
        personService.add(UUID.randomUUID().toString(),username,gender,birthday,age,province);
        reset();
        Executions.getCurrent().sendRedirect("/table.zul");
        search();
    }

    @Command
    @NotifyChange("selectedPerson")
    public void search(){
        selectedPerson = null;
        personList.clear();
        personList.addAll(personService.search(keyword));
    }

    @Command
    @NotifyChange("selectedPerson")
    public void delete(){
        if(selectedPerson == null) throw new RuntimeException("Please select person before delete");
        personService.delete(selectedPerson);
        search();
    }

    @Command
    @NotifyChange({"username", "gender", "birthday", "age", "province","selectedPerson","tableVisible","formVisible"})
    public void update(){
        if(selectedPerson == null) throw new RuntimeException("Please select person before edit");
        personService.update(selectedPerson,username,gender,birthday,age,province);
        cancelUpdate();
    }

    @Command
    @NotifyChange({"username", "gender", "birthday", "age", "province","selectedPerson","tableVisible","formVisible"})
    public void cancelUpdate(){
        username = "";
        gender = null;
        birthday = null;
        age = 0;
        province = null;
        tableVisible = true;
        formVisible = false;
        search();
    }

    @Command
    @NotifyChange({"username", "gender", "birthday", "age", "province","formVisible","tableVisible"})
    public void updateForm(){
        if(selectedPerson == null) throw new RuntimeException("Please select person before edit");
        tableVisible = false;
        formVisible = true;
        username = selectedPerson.getUsername();
        gender = selectedPerson.getGender();
        birthday = selectedPerson.getBirthday();
        age = selectedPerson.getAge();
        province = selectedPerson.getProvince();
    }

    @Command
    @NotifyChange({"username", "gender", "birthday", "age", "province","submitDisabled","submitStyle","termChecked"})
    public void reset(){
        username = "";
        gender = null;
        birthday = null;
        age = 0;
        province = null;
        termChecked = false;
        submitDisabled = true;
        submitStyle = "background-color: #b0b0b0; color: white; border: none; padding: 8px 16px; margin-left: 10px; border-radius: 5px; cursor: not-allowed;";
    }

    @Command
    @NotifyChange({"submitDisabled", "submitStyle"})
    public void onSubmitButton(){
        submitDisabled = !submitDisabled;
        if (submitDisabled) {
            submitStyle = "background-color: #b0b0b0; color: white; border: none; padding: 8px 16px; margin-left: 10px; border-radius: 5px; cursor: not-allowed;";
        } else {
            submitStyle = "background-color: #28a745; color: white; border: none; padding: 8px 16px; margin-left: 10px; border-radius: 5px; cursor: pointer;";
        }
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

    public boolean isSubmitDisabled() {
        return submitDisabled;
    }

    public void setSubmitDisabled(boolean submitDisabled) {
        this.submitDisabled = submitDisabled;
    }

    public String getSubmitStyle() {
        return submitStyle;
    }

    public void setSubmitStyle(String submitStyle) {
        this.submitStyle = submitStyle;
    }

    public boolean isTermChecked() {
        return termChecked;
    }

    public void setTermChecked(boolean termChecked) {
        this.termChecked = termChecked;
    }

    public boolean isFormVisible() {
        return formVisible;
    }

    public void setFormVisible(boolean formVisible) {
        this.formVisible = formVisible;
    }

    public boolean isTableVisible() {
        return tableVisible;
    }

    public void setTableVisible(boolean tableVisible) {
        this.tableVisible = tableVisible;
    }

}
