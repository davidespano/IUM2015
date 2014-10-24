package com.example.davide.iumex2;

import java.util.Calendar;

/**
 * Created by davide on 04/10/14.
 */
public class Person {

    private String name;
    private String surname;
    private Calendar birthDate;

    public Person(){
        this.name = "";
        this.surname = "";
        this.birthDate = Calendar.getInstance();

        // impostiamo la data al primo gennaio del 1994
        this.birthDate.set(Calendar.YEAR, 1994);
        this.birthDate.set(Calendar.MONTH, 1);
        this.birthDate.set(Calendar.DAY_OF_MONTH, 1);
    }

    public Person(String name, String surname, Calendar birthDate){
        this.setName(name);
        this.setSurname(surname);
        this.setBirthDate(birthDate);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }
}
