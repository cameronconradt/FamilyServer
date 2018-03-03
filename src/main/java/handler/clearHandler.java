package handler;

/**
 * Created by camer on 2/16/2018.
 */

public class clearHandler extends Handler {
    /**
     * Clears the database of all entries
     *
     */
    public void clear(){myDao.clear();}
}
