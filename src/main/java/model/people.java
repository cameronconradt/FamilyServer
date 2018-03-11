package model;

/**
 * Created by camer on 3/10/2018.
 */

public class people extends Model {
    public Person[] getPeople() {
        return people;
    }

    public void setPeople(Person[] people) {
        this.people = people;
    }

    private Person[] people;

    public people(Object[] people){
        if(people.getClass().equals(Person.class))
            this.people = (Person[]) people;
    }
}
