package service;

import java.sql.SQLException;

import dao.auth_tokenDao;
import dao.userDao;
import model.Model;
import model.User;
import model.auth_token;
import model.loginResponse;

/**
 * Created by camer on 2/16/2018.
 */

public class registerService extends Service {


    public static Model register(User user){
        if(user == null)
            return new Model("User blank");
        User find = null;
        userDao uDao = new userDao();
        try{
            find = uDao.getUserByName(user.getUsername());
        }
        catch(SQLException e){
            return new Model("Username already exists");
        }

        try{
            uDao.addUser(user);
        }
        catch(SQLException e){
            return new Model("Could not add the user");
        }

        fillService.generateFamily(user,4);
        auth_token token = null;
        auth_tokenDao aDao = new auth_tokenDao();
        try{
            find = uDao.getUserByName(user.getUsername());
            token = aDao.getWithName(user.getUsername());
        }
        catch(SQLException e){
            return new Model("failed retrieving user");
        }
        return new loginResponse(token.getId(),user.getUsername(),user.getPersonid());
    }
}
