package com.fif.controller;

import com.fif.Model.Person;
import com.fif.service.impl.PersonServiceImpl;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;

import java.util.Set;

public class SearchController extends SelectorComposer<Component> {

    @Wire
    private Textbox keyword;

    @Wire
    private Listbox personListBox;

    @Wire
    private Label birthdayLabel;

    @Wire
    private Label ageLabel;

    @Wire
    private Label provinceLabel;

    private ListModelList<Person> modelList = new ListModelList<>();

    private PersonServiceImpl personService = new PersonServiceImpl();

    public SearchController (){
        modelList.addAll(personService.findAll());
    }

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        personListBox.setModel(modelList);
    }

    @Listen("onClick = #searchButton; onOK = window")
    public void search(){
        String word = keyword.getValue();
        modelList.clear();
        modelList.addAll(personService.search(word));
    }

    @Listen("onSelect = #personListBox")
    public void showDetail(){
        Set<Person> personSet = modelList.getSelection();
        Person person = personSet.iterator().next();
        birthdayLabel.setValue("Birthday :"+person.getBirthday());
        ageLabel.setValue("Age :"+person.getAge());
        provinceLabel.setValue("Province :"+person.getProvince());
    }
}
