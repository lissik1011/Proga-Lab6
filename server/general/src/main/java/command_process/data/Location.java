package command_process.data;
import java.io.Serializable;

import command_process.helpfull.Validation;

public class Location implements Validation, Serializable {
    private Float x; //Поле не может быть null
    private Double y; //Поле не может быть null
    private String name; //Строка не может быть пустой, Поле может быть null

    public Location(Float x, Double y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    public String toString(){
        return String.format("{(%s; %s), %s}", x, y, name);
    }

    public String toCSV(){
        return String.format("%s, %s, %s", x, y, name);
    }

    @Override
    public boolean validate(){
        if (x == null) return false;
        else if (y == null) return false;
        else if (name == null || name.isEmpty()) return false;
        return true;
    }

    // get
    public Float getX() {
        return x;
    }
    public Double getY() {
        return y;
    }
    public String getName() {
        return name;
    }

    // set
    public void setX(Float x) {
        this.x = x;
    }
    public void setY(Double y) {
        this.y = y;
    }
    public void setName(String name) {
        this.name = name;
    }
}