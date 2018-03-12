package dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;

/**
 * Created by camer on 2/16/2018.
 */

public class userDao extends Dao {


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

    public User getUserByName(String username){

    }
    public static void replaceModel(User model){
        try {
            sqlCommand(new String("update users set " + model.getData() + " where id='" + model.getId() + "'"));
            System.out.println("Successfully replaced user");
            //update users set *** data *** where id='user_id'
        }
        catch(SQLException e){
            System.out.print("Could not replace user " + e.getMessage());
        }
    }
}
