package model;

/**
 * Created by camer on 2/16/2018.
 */

public class auth_token extends Model {
    private String token;
    private String person_id;

    public String getToken() {
        return token;
    }

    public String getPerson_id() { return person_id;}

    /**
     *
     * @param token Token to store
     */
    public auth_token(String token, String person_id){this.token = token; this.person_id = person_id;}
}
