package model;

/**
 * Created by camer on 3/10/2018.
 */

public class loginRequest extends Model {

    public String username;
    public String password;

    public loginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String toString(){
        return ("username: ") + username + ", password: " + password;
    }

    public boolean isValid(){
        if(username == null || password == null || username.equals("") || password.equals(""))
            return false;
        return true;
    }
}
