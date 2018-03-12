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


    public static Model serve(User user){
        auth_tokenDao auth_tokenDao = new auth_tokenDao();
        if(user == null)
            return new Model("User blank");
        User find = null;
        userDao uDao = new userDao();
        try{
            find = uDao.getUser(user.getUsername());
        }
        catch(SQLException e){
            return new Model("Username already exists");
        }
        if(find != null){
            return new Model("Username already exists");
        }
        try{
            uDao.addUser(user);
            auth_tokenDao.createAuth_Token(user.getId());
        }
        catch(SQLException e){
            return new Model("Could not add the user");
        }

        fillService.generateFamily(user,4);
        auth_token token = null;
        auth_tokenDao aDao = new auth_tokenDao();
        try{
            find = uDao.getUser(user.getUsername());
            token = aDao.getWithName(user.getUsername());
        }
        catch(SQLException e){
            return new Model("failed retrieving user");
        }
        return new loginResponse(token.getId(),user.getUsername(),user.getPersonid());
    }
}
