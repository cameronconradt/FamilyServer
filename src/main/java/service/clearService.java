package service;

import dao.Dao;

/**
 * Created by camer on 2/16/2018.
 */

public class clearService extends Service  {
    /**
     * Clears the database of all entries
     *
     */
    public static String clear(){
        Dao.clear();
        return new String("Database cleared");
    }
}
