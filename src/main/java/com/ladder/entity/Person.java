package com.ladder.entity;

public class Person {
    private int personNo;
    private boolean isLast = Boolean.FALSE;

    public Person(int personNo) {
        this.personNo = personNo;
    }

    public Person(int personNo, boolean isLast) {
        this.personNo = personNo;
        this.isLast = isLast;
    }

    public int getPersonNo() {
        return personNo;
    }

    public boolean isLast() {
        return isLast;
    }
}
