package dao;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import model.Model;
import model.Person;
import model.User;
import model.auth_token;
import model.event;

/**
 * Created by camer on 2/16/2018.
 */

public class Dao {
    public static Connection connect(){
        Connection connect = null;
        try{
            Class.forName("org.sqlite.JDBC");
            connect = DriverManager.getConnection("jbdc:sqlite:database.db");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return connect;
    }
    /**
     * clears the Database
     */
        public void clear(){createTables();}

        public static void createTables(){
            Connection connection = connect();
            Statement state = null;
            try{
                state = connection.createStatement();
            }
            catch(SQLException e){
                System.out.println("Could not get statement" + e.getMessage());
                return;
            }

            //create users table
            try{
                state.executeUpdate("drop table if exists users");
                state.executeUpdate("create table users" +
                        "(" +
                        "username varchar(255) not null," +
                        "password varchar(255) not null," +
                        "email varchar(255) not null," +
                        "firstName varchar(255) not null," +
                        "lastName varchar(255) not null," +
                        "gender char(1) not null," +
                        "personid integer not null," +
                        "id integer not null primary key autoincrement," +
                        ");");
            }
            catch(SQLException e){
                System.out.println("Could not create table users" + e.getMessage());
                return;
            }
            try{
                state.executeUpdate("drop table if exists people;");
                state.executeUpdate("create table people\n" +
                        "(\n" +
                        "\tFOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE\n" +
                        "\tFOREIGN KEY (descendant_id) REFERENCES people(id) ON DELETE CASCADE\n" +
                        "\tid integer not null primary key autoincrement,\n" +
                        "\tdescendant_id integer not null\n" +
                        "\tuser_id integer not null\n" +
                        "\tfirstName varchar(255) not null,\n" +
                        "\tlastName varchar(255) not null,\n" +
                        "\tgender char(1) not null,\n" +
                        "\tfather varchar(255),\n" +
                        "\tmother varchar(255),\n" +
                        "\tspouse varchar(255),\t\n" +
                        ");");
            }
            catch(SQLException e){
                System.out.println("Could not create table people" + e.getMessage());
                return;
            }
            try{
                state.executeUpdate("drop table if exists auth_tokens;");
                state.executeUpdate("create table auth_tokens\n" +
                        "(\n" +
                        "\tuser_id integer not null\n" +
                        "\tid vahrchar(255) not null \n" +
                        "\tFOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE\n" +
                        ");");
            }
            catch(SQLException e){
                System.out.println("Could not create table auth_tokens" + e.getMessage());
                return;
            }
            try{
                state.executeUpdate("drop table if exists events");
                state.executeUpdate("create table events\n" +
                        "(\n" +
                        "\tuser_id integer not null,\n" +
                        "\tFOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE\n" +
                        "\tdate date not null,\n" +
                        "\ttype varchar(255) not null,\n" +
                        "\tcountry varchar(255) not null,\n" +
                        "\tcity varchar(255) not null,\n" +
                        "\tid integer not null primary key autoincrement,\n" +
                        "\tlatitude double not null,\n" +
                        "\tlongitude double not null\n" +
                        ");");
            }
            catch (SQLException e){
                System.out.println("Could not create table events" + e.getMessage());
            }


        }

        public static void sqlCommand(String command) throws SQLException{
            Connection connection = connect();
            if(connection == null){
                throw new NullPointerException();
            }
            Statement state = connection.createStatement();
            state.executeUpdate(command);
        }

        public static ResultSet sqlQuery(String query) throws SQLException{
            Connection connection = connect();
            if(connection == null){
                throw new NullPointerException();
            }
            Statement state = connection.createStatement();
            return state.executeQuery(query);
        }

        public static ArrayList<Model> convertToModels(String toConvert){
            ArrayList<Model> models = new ArrayList<>();
            Map<String, ArrayList<String>> data = new HashMap<>();
            Scanner scanner = new Scanner(toConvert);
            String table = new String();
            if(scanner.hasNext()) {
                table = scanner.next();
                scanner.next();
            }
            String temp = new String();
            String name = new String();
            while(scanner.hasNext()){
                if(temp.equals(":")){
                    if(scanner.hasNext()){
                        name = scanner.next();
                        scanner.next();
                        scanner.next();
                    }
                    while (!temp.equals(":") && scanner.hasNext()){
                        data.get(name).add(temp);
                        temp = scanner.next();
                    }
                }
            }
            if(data.get("password")!= null) {
                String[] userData = data.get("password").toArray(new String[data.get("password").size()]);
                User tempusr = new User(userData);
            }
        }
}
