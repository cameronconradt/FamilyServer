package dao;

import model.event;
import model.events;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by camer on 2/16/2018.
 */

public class eventDao extends Dao {
    ArrayList<event> events = new ArrayList<>();
    /**
     *
     * @param data string array [date, type, country, city, parent_id]
     * @param location double array [latitude, longitude]
     */
    public event createevent(String[] data, double[] location){
        String temp = null;
        event tempevent = new event(data, location, temp);
        addModel(tempevent);
        tempevent = (event) getModel(tempevent);
        events.add(tempevent);
        return tempevent;
    }

    /**
     *
     * @param id unique id to remove
     */
    public void removeEvent(String id){
        for(event event: events){
            if(event.getId().equals(id)){
                deleteModel(event);
                events.remove(event);
                break;
            }
        }
        //TODO: sql integration of remove
    }

    /**
     *
     * @param id event ID
     * @return return event associated with the id
     */
    public event getEvent(String id) throws SQLException{
        for(event event : events){
            if(event.getId().equals(id)){
                return event;
            }
        }

        //TODO: sql integration of get
        return null;}

    /**
     *
     * @param id Root Person ID
     * @return all events associated with root id
     */
    public events getAllEvents(String id) throws SQLException{
        ArrayList<event> toReturn = new ArrayList<>();
        for(event event : events){
            if(event.getPerson_id().equals(id)){
                toReturn.add(event);
            }
        }

        //TODO: sql integration to find all events

        return null;}

    public static void replaceModel(event model){
        try {
            sqlCommand("update events set " + model.getData() + " where id='" + model.getId() + "'");
            //update events set *** data *** where id='event_id'
            System.out.println("Successfully replaced Event");
        }
        catch(SQLException e){
            System.out.println("Could not replaced Event " + e.getMessage());
        }
    }

}
