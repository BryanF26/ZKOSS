package com.fif.viewModel;

import com.fif.entity.Person;
import com.fif.services.PersonService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;
import java.util.Date;
import java.util.List;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class SearchViewModel{

    @WireVariable
    private PersonService personService;
    private String keyword;
    private String username;
    private String gender;
    private Date birthday;
    private int age;
    private String province;
    private boolean submitDisabled;
    private boolean termChecked;
    private String submitStyle;
    private boolean formVisible;
    private boolean tableVisible;
    private List<Person> personList;
    private Person selectedPerson;

    @Init
    public void init(){
        keyword="";
        submitDisabled = true;
        termChecked = false;
        submitStyle = "background-color: #b0b0b0; color: white; border: none; padding: 8px 16px; margin-left: 10px; border-radius: 5px; cursor: not-allowed;";
        formVisible = false;
        tableVisible = true;
        personList = new ListModelList<>();
//        personService.addPerson(new Person("John Doe", "Male", java.sql.Date.valueOf(LocalDate.of(1998,3,12)), 34, "Jakarta"));
//        personService.addPerson(new Person("Jane Smith", "Female", java.sql.Date.valueOf(LocalDate.of(2000,7,5)), 32, "Aceh"));
//        personService.addPerson(new Person("Michael Johnson", "Male", java.sql.Date.valueOf(LocalDate.of(1995,4,18)), 39, "Lampung"));
//        personService.addPerson(new Person("Emily Davis", "Female", java.sql.Date.valueOf(LocalDate.of(1992,11,27)), 29, "Jambi"));
//        personService.addPerson(new Person("Chris Brown", "Male", java.sql.Date.valueOf(LocalDate.of(2001,1,8)), 36, "Bali"));
//        personService.addPerson(new Person("Laura Wilson", "Female", java.sql.Date.valueOf(LocalDate.of(1999,8,14)), 31, "Riau"));
//        personService.addPerson(new Person("David Miller", "Male", java.sql.Date.valueOf(LocalDate.of(1990,9,3)), 37, "Jakarta"));
//        personService.addPerson(new Person("Sophia Moore", "Female", java.sql.Date.valueOf(LocalDate.of(1997,6,22)), 33, "Aceh"));
//        personService.addPerson(new Person("Daniel Anderson", "Male", java.sql.Date.valueOf(LocalDate.of(1988,9,30)), 35, "Lampung"));
//        personService.addPerson(new Person("Mia Thomas", "Female", java.sql.Date.valueOf(LocalDate.of(1994,11,16)), 30, "Jambi"));
        personList.addAll(personService.getPersons());
    }

    @Command
    @NotifyChange({"username", "gender", "birthday", "age", "province","submitDisabled","submitStyle","termChecked"})
    public void add(){
        personService.addPerson(new Person(username,gender,birthday,age,province));
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
        personService.deletePerson(selectedPerson);
        selectedPerson = null;
        personList.clear();
        personList.addAll(personService.getPersons());
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
        username = null;
        gender = null;
        birthday = null;
        age = 0;
        province = null;
        tableVisible = true;
        formVisible = false;
        selectedPerson = null;
        personList.clear();
        personList.addAll(personService.getPersons());
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
        username = null;
        gender = null;
        birthday = null;
        age = 0;
        province = null;
        termChecked = false;
        submitDisabled = true;
        submitStyle = "background-color: #b0b0b0; color: white; border: none; padding: 8px 16px; margin-left: 10px; border-radius: 5px; cursor: not-allowed;";
    }

    @Command
    @NotifyChange({"submitDisabled", "submitStyle","termChecked"})
    public void onSubmitButton(){
        submitDisabled = !submitDisabled;
        if (submitDisabled || username == null || gender == null || birthday == null || age == 0 || province == null) {
            termChecked = false;
            submitStyle = "background-color: #b0b0b0; color: white; border: none; padding: 8px 16px; margin-left: 10px; border-radius: 5px; cursor: not-allowed;";
        } else {
            termChecked = true;
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
