package model;

import java.util.ArrayList;

/**
 * Created by camer on 2/16/2018.
 */

public class User extends Model  {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String gender;
    private String personid;
    private String id;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
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

    public String getId() {
        return id;
    }

    public String getData(){
        return new String("username = " + username + ", password = " + password + ", email = " + email + ", firstName = " + firstName + ", lastName = " + lastName + ", gender = " + gender);
    }

    /**
     *
     * @param data array of Strings to be loaded into a new user.
     *             [username, password, email, firstName, lastName, gender, id]
     */
    public User(String[] data){}
}
