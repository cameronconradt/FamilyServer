package dao;

import java.util.ArrayList;

import model.User;

/**
 * Created by camer on 2/16/2018.
 */

public class userDao extends Dao {
    ArrayList<User> users = new ArrayList<>();
    /**
     * Adds a new person to the database
     * @param data array of Strings to be loaded into a new user.
     *             [username, password, email, firstName, lastName, gender, id]
     */
    public void newUser(String[] data){
        users.add(new User(data));
        //TODO: sql newUser
    }

    /**
     *
     * @param id ID of user
     * @return User associated with given id
     */
    public User getUser(String id){
        for(User user : users){
            if(user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
}
