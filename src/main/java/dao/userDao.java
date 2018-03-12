package dao;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.User;
import sun.swing.SwingLazyValue;

/**
 * Created by camer on 2/16/2018.
 */

public class userDao extends Dao {


    public User getUser(String username) throws SQLException{
        Connection connect = connect();
        if(connect == null){
            throw new NullPointerException();
        }

        Statement state;
        ResultSet result = null;
        try{
            state = connect.createStatement();
            result = state.executeQuery("select * from users where username=\"" + username + "\";");
        }
        catch(SQLException e){
            System.err.println("Could not retrieve user");
            e.printStackTrace();
        }

        //username, password, email, firstName, lastName,gender,personid, id
        String[] data = new String[8];
        for(int i = 1; i < 9; i++){
            data[i-1]=result.getString(i);
        }
        try{
            connect.close();
        }
        catch (SQLException e){
            System.err.println("Connection not closed");
            e.printStackTrace();
        }
        return new User(data);

    }
    public String addUser(User user) throws SQLException{
        Connection connect = connect();
        if(connect == null){
            throw new NullPointerException();
        }
        PreparedStatement state = connect.prepareStatement("insert into users values(?,?,?,?,?,?,?,?);");
        if(user.getId() != null){
            state.setString(8,user.getId());
        }
        state.setString(1,user.getUsername());
        state.setString(2,user.getPassword());
        state.setString(3,user.getEmail());
        state.setString(4,user.getFirstName());
        state.setString(5,user.getLastName());
        state.setString(6,user.getGender());
        state.setString(7,user.getPersonid());
        state.addBatch();

        connect.setAutoCommit(false);
        state.executeBatch();
        connect.setAutoCommit(true);

        try{
            connect.close();
        }
        catch (SQLException e){
            System.err.println("Connection not closed");
            e.printStackTrace();
        }
        return "User added to table Users";
    }
    public String addUsers(User[] users) throws SQLException{
            for(User user : users){
                try{
                    if(user.isValid())
                        addUser(user);
                }
                catch (SQLException e){
                    System.err.println("User not added " + user.getUsername());
                }
            }
            return "Users added";
    }

}
