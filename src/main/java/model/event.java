package model;

import java.lang.reflect.Field;

/**
 * Created by camer on 2/16/2018.
 */

public class event extends Model  {
    private String date;
    private String type;
    private double latitude;
    private double longitude;
    private String country;
    private String city;
    private String id;
    private String person_id;
    private String user_id;



    public String getData(){
        return new String("date = " + date + ", type = " + type + ", latitude = " + Double.toString(latitude) + ", longitude = " + Double.toString(longitude) + ", country = " + country + ", city = " + city + ", person_id = " + person_id);
    }
    /**
     *
     * @param data string array [id(do not set),user_id,date,type,country,city,latitude,longitude,person_id]
     */
    public event(Object[] data){}

    public event(User user) {}

    public event(String id) {}

    public boolean isValid(){
        for (Field f: getClass().getDeclaredFields())
        {
            try {
                if (f != getClass().getDeclaredField("id")) {
                    if(f.get(this) == null || f.get(this).equals(""))
                        return false;
                }
            }
            catch(NoSuchFieldException e){
                System.err.println("event.isvalid should never happen");
            }
            catch (IllegalAccessException e){
                System.err.println("event.isvalid should never happen");
            }
        }
        return true;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getCountry() {
        return country;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getCity(){ return city;}

    public void setDate(String date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getUser_id() {return user_id;}
    public void setUser_id(String id){user_id = id;}
    public String getPerson_id() {
        return person_id;
    }
    public void setPerson_id(String id){person_id = id;}


}
