package handler;

import dao.personDao;
import model.Person;
import model.auth_token;
import model.event;

/**
 * Created by camer on 2/16/2018.
 */

public class personHandler extends Handler {
    personDao myDao = new personDao();
    /**
     * Retrieves all family members for user with TOKEN
     * @param token Auth_token of root person
     */
    public void all(String token){

    }

    /**
     * Retrieves person matching ID
     * @param id Id of Person
     */
    public void one(String id){}

    public void addEvent(String id, event event){
        myDao.addEvent(id,event);
    }

}
