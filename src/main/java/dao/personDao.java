package dao;

import java.awt.Event;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.plaf.nimbus.State;

import model.Person;
import model.User;
import model.event;
import model.people;


/**
 * Created by camer on 2/16/2018.
 */

public class personDao extends Dao {

    public static String addUser(User user) throws SQLException{
        Person person = new Person(user);
        person.setDescendant_id("temp");
        if(!addPerson(person).equals("Person added to table"))
            return "User not added to people table";
        Connection connect = Dao.connect();
        if(connect == null)
            throw new NullPointerException();

        Statement state;
        ResultSet result = null;
        try{
            state = connect.createStatement();
            result = state.executeQuery("select * from people where descendant_id=\"temp\";");
        }
        catch(SQLException e){
            System.err.println("Couldn't retrieve person");
            e.printStackTrace();
        }
        //[id,descendant_id,user_id,firstName,lastName,gender,father,mother,spouse]
        ArrayList<String> data = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            data.add(result.getString(i));
        }
        try{
            connect.close();
        }
        catch (SQLException e){
            System.err.println("Couldn't close connection");
            e.printStackTrace();
        }
        person = new Person(data.toArray());
        person.setDescendant_id(person.getId());
        removePerson(person.getId());
        if(!addPerson(person).equals("Person added to table"))
            return "User not added to people table";

        return "User added to People table";

    }

    public static String addPerson(Person person) throws SQLException{
        Connection connect = Dao.connect();
        if(connect == null){
            throw new NullPointerException();
        }
        if(!person.isValid())
            return "person invalid";

        PreparedStatement state = connect.prepareStatement("insert into people values(?,?,?,?,?,?,?,?,?");

        //[id,descendant_id,user_id,firstName,lastName,gender,father,mother,spouse]

        state.setString(2,person.getDescendant());
        state.setString(3,person.getUser_id());
        state.setString(4,person.getFirstName());
        state.setString(5,person.getLastName());
        state.setString(6,person.getGender());
        state.setString(7,person.getFather());
        state.setString(8,person.getMother());
        state.setString(9,person.getSpouse());
        state.addBatch();

        connect.setAutoCommit(false);
        state.executeBatch();
        connect.setAutoCommit(true);
        try{
            connect.close();
        }
        catch (SQLException e){
            System.err.println("Couldn't close connection");
            e.printStackTrace();
        }
        return "Person added to table";
    }
    /**
     * Removes specific person
     * @param id id of person to remove
     */
    public static void removePerson(String id)throws SQLException{
        Connection connect = Dao.connect();
        if(connect == null){
            throw new NullPointerException();
        }

        Statement state = connect.createStatement();
        state.executeUpdate("delete from people where id=\"" + id + "\";");

        try{
            connect.close();
        }
        catch (SQLException e){
            System.err.println("Couldn't close connection");
            e.printStackTrace();
        }
    }

    /**
     *
     * @param id id of person to return
     * @return Person associated with ID
     */
    public Person getPerson(String id) throws SQLException{

        Connection connect = Dao.connect();
        if(connect == null){
            throw new NullPointerException();
        }
        Statement state;
        ResultSet result = null;
        try{
            state = connect.createStatement();
            result = state.executeQuery("select * from people where id=\"" + id + "\";");
        }catch(SQLException e){
            System.err.println("Couldn't retrieve person");
            e.printStackTrace();
        }
        //[id,descendant_id,user_id,firstName,lastName,gender,father,mother,spouse]
        ArrayList<String> data = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            data.add(result.getString(i));
        }
        try{
            connect.close();
        }
        catch (SQLException e){
            System.err.println("Couldn't close connection");
            e.printStackTrace();
        }
        return new Person(data.toArray());
    }

    /**
     *
     * @param user_id id of root user
     * @return list of all persons attached to root person
     */
    public people getAllPersons(String user_id)throws SQLException{
        Connection connect = Dao.connect();
        if(connect == null){
            throw new NullPointerException();
        }
        Statement state;
        ResultSet result = null;
        try{
            state = connect.createStatement();
            result = state.executeQuery("select * from people where user_id=\"" + user_id + "\";");
        }catch(SQLException e){
            System.err.println("Couldn't retrieve person");
            e.printStackTrace();
        }
        people toReturn = new people();
        while(result.next()) {
            //[id,descendant_id,user_id,firstName,lastName,gender,father,mother,spouse]
            ArrayList<String> data = new ArrayList<>();
            for (int i = 1; i < 10; i++) {
                data.add(result.getString(i));
            }
            toReturn.addPerson(new Person(data.toArray()));
        }
        try{
            connect.close();
        }
        catch (SQLException e){
            System.err.println("Couldn't close connection");
            e.printStackTrace();
        }
        return toReturn;

    }

    public static void replaceModel(Person model){
        try {
            sqlCommand("update people set " + model.getData() + " where id='" + model.getId() + "'");
            System.out.println("Successfully replaced Person");
            //update users set *** data *** where id='user_id'
        }
        catch(SQLException e){
            System.out.println("Could not replace Person " + e.getMessage());
        }
    }
}
