package model;

/**
 * Created by camer on 2/16/2018.
 */

public class Person extends Model  {
    private String id;
    private User descendant;
    private String firstName;
    private String lastName;
    private String gender;
    private String father;
    private String mother;
    private String spouse;
    private String[] events_IDs;

    public void addEvent(event toAdd){
    }
    public void removeEvent(event toRemove){
    }
    public String[] getEvents() {
        return events_IDs;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    /**
     *
     * @param data String array with all data for a new person
     *             [id, firstName, lastName, gender]
     * @param descendant User that owns this person
     */
    public Person(String[] data, User descendant){}

    public String getId() {
        return id;
    }

    public User getDescendant() {
        return descendant;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getFather() {
        return father;
    }

    public String getMother() {
        return mother;
    }

    public String getSpouse() {
        return spouse;
    }


}
