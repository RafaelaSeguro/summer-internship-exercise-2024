package com.premiumminds.internship.teknonymy;

/**
 * Object to store name and the level of the generation of the descendant
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
