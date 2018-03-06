package dao;

import java.awt.Event;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Person;
import model.User;
import model.event;

/**
 * Created by camer on 2/16/2018.
 */

public class personDao extends Dao {
    ArrayList<Person> people = new ArrayList<>();
    /**
     * Adds a new person to the database
     * @param data String array with all data for a new person
     *             [id, firstName, lastName, gender]
     * @param descendant User that owns this person
     */
    public void createPerson(String[] data, User descendant){
        Person newPerson = new Person(data,descendant);
        people.add(newPerson);
        //TODO: sql add person
    }

    /**
     * Removes specific person
     * @param id id of person to remove
     */
    public void removePerson(String id){
        for(Person person: people){
            if(person.getId().equals(id)){
                deleteModel(person);
                people.remove(person);
                break;
            }
        }
        //TODO: sql removePerson
    }

    /**
     *
     * @param id id of person to return
     * @return Person associated with ID
     */
    public Person getPerson(String id){
        for(Person person: people){
            if(person.getId().equals(id)){
                return person;
            }
        }
        //TOOD: sql getPerson
        return null;
    }

    /**
     *
     * @param id id of root person
     * @return list of all persons attached to root person
     */
    public ArrayList<Person> getAllPersons(String id){
        ArrayList<Person> toReturn = new ArrayList<>();
        for(Person person : people){
            if(person.getDescendant().getId().equals(id)){
                toReturn.add(person);
            }
        }
        //TODO: sql getAllPersons
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
