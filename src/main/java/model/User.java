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
    private String id;
    private ArrayList<auth_token> auth_tokens;

    /**
     * generates new unique auth token
     */
    public void generateAuth_Token(){

    }

    /**
     * Removes specific auth_token
     * @param toRemove Token to remove
     */
    public void removeAuth_Token(auth_token toRemove){

    }

    public ArrayList<auth_token> getAuth_tokens() {
        return auth_tokens;
    }

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

    /**
     *
     * @param data array of Strings to be loaded into a new user.
     *             [username, password, email, firstName, lastName, gender, id]
     */
    public User(String[] data){}
}
