package model;

/**
 * Created by camer on 2/16/2018.
 */

public class Person extends Model  {
    private String id;
    private String user_id;
    private String descendant_id;
    private String firstName;
    private String lastName;
    private String gender;
    private String father;
    private String mother;
    private String spouse;

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
     * @param data [id,descendant_id,user_id,firstName,lastName,gender,father,mother,spouse]
     */
    public Person(Object[] data){

    }

    public Person(User descendant){}

    /**
     *
     * @param data String array with all data for a new person
     *             [id, firstName, lastName, gender]
     * @param descendant User that owns this person
     */
    public Person(String[] data, User descendant){}

    public String getData(){
        return new String("user_id = " + user_id + ", firstName = " + firstName + ", lastName = " + lastName + ", gender = " + gender + ", father = " + father + ", mother = " + mother + ", spouse = " + spouse);
    }

    public String getId() {
        return id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getDescendant() {
        return descendant_id;
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

    public void setId(String id) {
        this.id = id;
    }

    public String getDescendant_id() {
        return descendant_id;
    }

    public void setDescendant_id(String descendant_id) {
        this.descendant_id = descendant_id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
