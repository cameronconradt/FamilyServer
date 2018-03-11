package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.auth_token;

/**
 * Created by camer on 2/16/2018.
 */

public class auth_tokenDao extends Dao {
    ArrayList<auth_token> tokens = new ArrayList<>();
    /**
     *
     * @param id ID of auth_token to remove
     */
    public void removeAuth_Token(String id){}

    /**
     * Creates a new unique auth token
     *@param id ID of person to attach auth_token to
     */
    public void createAuth_Token(String id, String token){
        auth_token tempToken = new auth_token(token, id);
        Connection connection = connect();
        if(connection == null) {
            throw new NullPointerException();
        }
        try {
        PreparedStatement prep = connection.prepareStatement("insert into auth_tokens values(?, ?);");
//		userName TEXT, password TEXT, authCode TEXT, userId INTEGER

        prep.setString(1, tempToken.getId());
        prep.setString(2, tempToken.getUserId());
        prep.addBatch();

        connection.setAutoCommit(false);
        prep.executeBatch();
        connection.setAutoCommit(true);
        connection.close();
        } catch (SQLException e) {
            System.err.println("Couldn't close the connection!");
            e.printStackTrace();
        }

        tokens.add(tempToken);
    }

    public static void replaceModel(auth_token model){
        try {
            sqlCommand("update auth_tokens set " + model.getData() + " where id='" + model.getId() + "'");
            //update users set *** data *** where id='user_id'
            System.out.println("Successfully replaced auth_token");
        }
        catch(SQLException e){
            System.out.println("Could not update auth_token " + e.getMessage());
        }
    }

    public auth_token getWithId(String id) throws SQLException{
        Connection connection = connect();
        if(connection == null) {
            throw new NullPointerException();
        }
        Statement statement;
        ResultSet rs = null;
        auth_token token = null;
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery("select * from auth_tokens where id=\""+ id + "\";");

        } catch (SQLException e) {
            System.err.println("The attempt to get the user info failed!");
            e.printStackTrace();
        }

        token = new auth_token(rs.getString(1),rs.getString(2));

        try{
            connection.close();
        }
        catch(SQLException e){
            System.err.print("Couldn't close connection");
            e.printStackTrace();
        }
        return token;
    }

    public auth_token getWithName(String username){

    }
}
