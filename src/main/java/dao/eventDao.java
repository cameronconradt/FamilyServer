package dao;

import model.event;
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
    public event getEvent(String id) {
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
    public ArrayList<event> getAllEvents(String id){
        ArrayList<event> toReturn = new ArrayList<>();
        for(event event : events){
            if(event.getPerson_id().equals(id)){
                toReturn.add(event);
            }
        }

        //TODO: sql integration to find all events

        return null;}

}
