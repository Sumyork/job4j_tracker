package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> checkSurname = surname -> surname.getSurname().contains(key);
        Predicate<Person> checkName = name -> name.getName().contains(key);
        Predicate<Person> checkPhone = phone -> phone.getPhone().contains(key);
        Predicate<Person> checkAddress = address -> address.getAddress().contains(key);
        Predicate<Person> combine = checkSurname.or(checkName.or(checkPhone.or(checkAddress)));
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
