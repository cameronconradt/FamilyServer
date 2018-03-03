package handler;

import java.util.ArrayList;

import model.Model;

/**
 * Created by camer on 2/16/2018.
 */

public class jsonHandler extends Handler {
    /**
     * Converts an array of objects into JSON and sends the data back to the server
     * @param objects objects to convert
     * @return JSON formatted version of given objects
     */
    public String objectToJSON(ArrayList<Model> objects){
        return null;
    }

    /**
     * Converts JSON object and returns it to the handler
     * @param data JSON string
     * @return Array of all objects in JSON
     */
    public ArrayList<Model> JSONToObject(String data){
        return null;
    }
}
