package dao;

import java.util.ArrayList;

import model.auth_token;

/**
 * Created by camer on 2/16/2018.
 */

public class auth_tokenDao extends Dao {
    ArrayList<auth_token> tokens = new ArrayList<>();
    /**
     *
     * @param id ID of auth_token to remove
     */
    public void removeAuth_Token(String id){}

    /**
     * Creates a new unique auth token
     *@param id ID of person to attach auth_token to
     */
    public void createAuth_Token(String id, String token){
        auth_token tempToken = new auth_token(token, id);
        addModel(tempToken);
        tokens.add(tempToken);
    }
}
