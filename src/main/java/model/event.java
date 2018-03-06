package model;

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

    public String getPerson_id() {
        return person_id;
    }
    public String getData(){
        return new String("date = " + date + ", type = " + type + ", latitude = " + Double.toString(latitude) + ", longitude = " + Double.toString(longitude) + ", country = " + country + ", city = " + city + ", person_id = " + person_id);

    }
    /**
     *
     * @param data string array [date, type, country, city, person_id]
     * @param location double array [latitude, longitude]
     */
    public event(String[] data, double[] location, String id){}

    public event(String id) {}

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


}
