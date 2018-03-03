package handler;

import java.util.ArrayList;

import dao.eventDao;
import model.event;

/**
 * Created by camer on 2/16/2018.
 */

public class eventHandler extends Handler {
    private eventDao myDao = new eventDao();
    /**
     * Retrieves all events for the ancestors of the current user
     * @param id ID of current user
     */
    public ArrayList<event> all(String id){
        return myDao.getAllEvents(id);
    }

    /**
     * Retrieves the event associated with the specific id
     * @param id id of the event
     */
    public event one(String id){
        return myDao.getEvent(id);
    }

    /**
     *
     * @param data Data required to add the event [date, type, country, city, parent_id]
     * @return id of the Person to add the event to
     */
    public event addEvent(String[] data){
        double[] location = {Double.parseDouble(data[data.length-2]),Double.parseDouble(data[data.length-1])};
        event myEvent = myDao.createevent(data,location);
        return myEvent;
    }
}
