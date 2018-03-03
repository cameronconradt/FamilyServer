package dao;
import java.sql.*;
import java.util.ArrayList;

import model.Model;

/**
 * Created by camer on 2/16/2018.
 */

public class Dao {
    /**
     * clears the Database
     */
        public void clear(){}

        public void createTables(){}

        public void replaceModel(Model toReplace){}

        public Model getModel(Model toFind) {return null;}

        public void deleteModel(Model toDelete){}

        public void addModel(Model toAdd) {}

        public ArrayList<Model> convertToModels(String toConvert){return null;}
}
