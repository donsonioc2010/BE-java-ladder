package com.ladder.entity;

import com.ladder.utils.StringUtils;

import java.util.List;

public class Person {
    private final List<String> persons;

    private Person(List<String> persons) {
        this.persons = persons;
    }

    public static Person of(String inputPersonNames) {
        List<String> nameList = StringUtils.parseStringToList(inputPersonNames);

        return new Person(nameList);
    }

    public List<String> getPersons() {
        return persons;
    }

    public int getPersonSize() {
        return persons.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        persons.forEach(person ->
            sb.append(StringUtils.getFixString(person))
                .append(" ")
        );
        sb.append("\n");

        return sb.toString();
    }
}
