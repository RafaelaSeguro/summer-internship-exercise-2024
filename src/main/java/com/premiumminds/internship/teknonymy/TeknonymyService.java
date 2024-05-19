package com.premiumminds.internship.teknonymy;

import java.util.LinkedList;
import java.util.Queue;

class TeknonymyService implements ITeknonymyService {

  /**
   * Method to get a Person Teknonymy Name
   * 
   * @param Person person
   * @return String which is the Teknonymy Name 
   */
  @Override
  public String getTeknonymy(Person person) {
    
    // In case the person has no descendants, returns empty string
    if (person.children() == null || person.children().length == 0) {
      return "";
    }

    // Searches through descendants to find which one to use for the teknonymy
    Info info = searchDescendants(person);

    // Creates the teknonymy string and returns it
    return getTeknonymyString(person.sex(), info.getPerson().name(), info.getLevel());

  };


  /**
   * Method that finds the oldest descendant of the most distant generation
   * 
   * @param Person person
   * @return Info which stores the information related to the chosen descendant
   */
  public Info searchDescendants(Person person) {
    
    Info solution = new Info(person, 0);

    Queue<Info> unvisited = new LinkedList<>();

    // Starts by adding the first generation to the queue of descendants
    for (Person p : person.children())
      unvisited.add(new Info(p, 1));

    // Until all descendants have been analysed
    while (!unvisited.isEmpty()){
      Info current = unvisited.remove();

      // Add next generation to queue
      if (current.getPerson().children() != null){
        for (Person p : current.getPerson().children())
        unvisited.add(new Info(p, current.getLevel()+1));
      }

      // Updates the solution if the generation level is higher or the descendant is older for the same generation
      if (current.getLevel()>solution.getLevel()){
        solution = current;
      } else if (current.getLevel() == solution.getLevel()){
        if (current.getPerson().dateOfBirth().isBefore(solution.getPerson().dateOfBirth())){
          solution = current;
        }
      }
    }

    return solution;
  };


  /**
   * Method that constructs the teknonomy string
   * 
   * @param Character sex
   * @param String name of descendant
   * @param int level corresponding to descendant
   * @return String which is the Teknonymy Name 
   */
  public String getTeknonymyString(Character sex, String name, int level) {
    
    StringBuilder teknonomy = new StringBuilder();

    String sexID = (sex == 'M') ? ("father") : ("mother");

    if (level > 1) {

      for (int i=2; i<level; i++){

        teknonomy.append("great-");
      }
  
      teknonomy.append("grand");
    }

    teknonomy.append(sexID);
    teknonomy.append(" of ").append(name);

    return teknonomy.toString();
  };
}
