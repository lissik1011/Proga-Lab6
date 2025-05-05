package command_process.data;
import java.io.Serializable;

import command_process.helpfull.Validation;

public class Person implements Validation, Serializable {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Float weight; //Поле не может быть null, Значение поля должно быть больше 0
    private String passportID; //Длина строки не должна быть больше 32, Поле не может быть null
    private Location location; //Поле не может быть null

    public Person(String name, Float weight, String passportID, Location location){
        this.name = name;
        this.weight = weight;
        this.passportID = passportID;
        this.location = location;
    }

    @Override
    public String toString(){
        return String.format("name: %s, weight: %s, passportID: %s, Location: %s", 
        name, weight, passportID, location);
    }

    public String toCSV(){
        return String.format("%s, %s, %s, %s", 
        name, weight, passportID, location.toCSV());
    }

    @Override
    public boolean validate(){
        if (name.isEmpty()) return false;
        else if (weight <= 0 || weight == null) return false;
        else if (passportID == null || passportID.length() > 32) return false;
        else if (location == null || !location.validate()) return false;
        return true;
    }

    // get
    public String getName() {
        return name;
    }
    public Float getWeight() {
        return weight;
    }
    public String getPassportID() {
        return passportID;
    }
    public Location getLocation() {
        return location;
    }

    // set
    public void setName(String name) {
        this.name = name;
    }
    public void setWeight(Float weight) {
        this.weight = weight;
    }
    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }
    public void setLocation(Location location) {
        this.location = location;
    }
    
}