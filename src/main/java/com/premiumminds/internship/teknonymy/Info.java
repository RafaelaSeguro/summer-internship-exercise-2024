package com.premiumminds.internship.teknonymy;

/**
 * Object to store a person object and the corresponding generation level
 */
public class Info {

    private final Person person;
    private final int level;
    
    public Info(Person person, int level){

        this.person = person;
        this.level = level;
    }

    public Person getPerson(){
        return this.person;
    }

    public int getLevel(){
        return this.level;
    }
}
