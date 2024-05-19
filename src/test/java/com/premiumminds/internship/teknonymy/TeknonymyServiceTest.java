package com.premiumminds.internship.teknonymy;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class TeknonymyServiceTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public TeknonymyServiceTest() {
  };

  @Test
  public void PersonNoChildrenTest() {
    Person person = new Person("John",'M',null, LocalDateTime.of(1046, 1, 1, 0, 0));
    String result = new TeknonymyService().getTeknonymy(person);
    String expected = "";
    assertEquals(result, expected);
  }

  @Test
  public void PersonOneChildTest() {
    Person person = new Person(
        "John",
        'M',
        new Person[]{ new Person("Holy",'F', null, LocalDateTime.of(1046, 1, 1, 0, 0)) },
        LocalDateTime.of(1046, 1, 1, 0, 0));
    String result = new TeknonymyService().getTeknonymy(person);
    String expected = "father of Holy";
    assertEquals(result, expected);
  }

  @Test
  public void MotherOneChildTest() {
    Person person = new Person(
        "Lucy",
        'F',
        new Person[]{ new Person("Martin",'M', null, LocalDateTime.of(1997, 6, 16, 0, 0)), 
          new Person("Mary",'F', null, LocalDateTime.of(2000, 9, 18, 0, 0)) },
          LocalDateTime.of(1966, 1, 31, 0, 0));
    String result = new TeknonymyService().getTeknonymy(person);
    String expected = "mother of Martin";
    assertEquals(result, expected);
  }

  @Test
  public void exampleTreeTest() {

    Person E = new Person( "Ezequiel", 'M', null, LocalDateTime.of(2019, 1, 1, 0, 0));
    Person F = new Person( "Frank", 'M', null, LocalDateTime.of(2018, 1, 1, 0, 0));
    Person G = new Person( "Gabriel", 'M', null, LocalDateTime.of(2021, 1, 1, 0, 0));
    Person H = new Person( "Hyacinth", 'F', null, LocalDateTime.of(2022, 1, 1, 0, 0));
    
    Person B = new Person( "Brad", 'M', new Person[] {E}, LocalDateTime.of(2000, 1, 1, 0, 0));
    Person C = new Person( "Collin", 'M', null, LocalDateTime.of(2002, 1, 1, 0, 0));
    Person D = new Person( "Daphne", 'F', new Person[] {F, G, H}, LocalDateTime.of(2003, 1, 1, 0, 0));

    Person A = new Person( "Anthony", 'M', new Person[] {B, C, D}, LocalDateTime.of(1980, 1, 1, 0, 0));
    
    String result = new TeknonymyService().getTeknonymy(A);
    String expected = "grandfather of Frank";
    assertEquals(result, expected);
  }

  @Test
  public void greatGrandmotherTest() {

    Person I = new Person( "Inez", 'F', null, LocalDateTime.of(2040, 1, 1, 0, 0));
    Person J = new Person( "Jane", 'F', null, LocalDateTime.of(2043, 1, 1, 0, 0));

    Person E = new Person( "Ezequiel", 'M', new Person[] {J}, LocalDateTime.of(2019, 1, 1, 0, 0));
    Person F = new Person( "Frank", 'M', null, LocalDateTime.of(2018, 1, 1, 0, 0));
    Person G = new Person( "Gabriel", 'M', new Person[] {I}, LocalDateTime.of(2021, 1, 1, 0, 0));
    Person H = new Person( "Hyacinth", 'F', null, LocalDateTime.of(2022, 1, 1, 0, 0));
    
    Person B = new Person( "Brad", 'M', new Person[] {E}, LocalDateTime.of(2000, 1, 1, 0, 0));
    Person C = new Person( "Collin", 'M', null, LocalDateTime.of(2002, 1, 1, 0, 0));
    Person D = new Person( "Daphne", 'F', new Person[] {F, G, H}, LocalDateTime.of(2003, 1, 1, 0, 0));

    Person A = new Person( "Anna", 'F', new Person[] {B, C, D}, LocalDateTime.of(1980, 1, 1, 0, 0));
    
    String result = new TeknonymyService().getTeknonymy(A);
    String expected = "great-grandmother of Inez";
    assertEquals(result, expected);
  }

  @Test
  public void greatGreatTest() {

    Person J = new Person( "James", 'M', null, LocalDateTime.of(2062, 1, 1, 0, 0));

    Person I = new Person( "Inez", 'F', new Person[] {J}, LocalDateTime.of(2040, 1, 1, 0, 0));

    Person E = new Person( "Ezequiel", 'M', null, LocalDateTime.of(2019, 1, 1, 0, 0));
    Person F = new Person( "Frank", 'M', null, LocalDateTime.of(2018, 1, 1, 0, 0));
    Person G = new Person( "Gabriel", 'M', new Person[] {I}, LocalDateTime.of(2021, 1, 1, 0, 0));
    Person H = new Person( "Hyacinth", 'F', null, LocalDateTime.of(2022, 1, 1, 0, 0));
    
    Person B = new Person( "Brad", 'M', new Person[] {E}, LocalDateTime.of(2000, 1, 1, 0, 0));
    Person C = new Person( "Collin", 'M', null, LocalDateTime.of(2002, 1, 1, 0, 0));
    Person D = new Person( "Daphne", 'F', new Person[] {F, G, H}, LocalDateTime.of(2003, 1, 1, 0, 0));

    Person A = new Person( "Anthony", 'M', new Person[] {B, C, D}, LocalDateTime.of(1980, 1, 1, 0, 0));
    
    String result = new TeknonymyService().getTeknonymy(A);
    String expected = "great-great-grandfather of James";
    assertEquals(result, expected);
  }
}