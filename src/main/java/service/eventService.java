package service;

import java.awt.Event;
import java.util.ArrayList;

/**
 * Created by camer on 2/16/2018.
 */

public class eventService extends Service {
    /**
     * Retrieves all events for the ancestors of the current user
     * @param id ID of the user
     * @return ArrayList of all events
     */
    public ArrayList<Event> all(String id){return null;}

    /**
     * Retrieves the event associated with the specific id
     * @param id id of the event
     * @return event associated with ID
     */
    public Event one(String id){return null;}
}
