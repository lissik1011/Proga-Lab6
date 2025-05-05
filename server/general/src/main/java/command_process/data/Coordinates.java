package command_process.data;
import java.io.Serializable;

import command_process.helpfull.Validation;

public class Coordinates implements Validation, Serializable{
    private Integer x; //Поле не может быть null
    private Float y; //Значение поля должно быть больше -858, Поле не может быть null

    public Coordinates(Integer x, Float y){
        this.x = x;
        this.y = y;   
    }

    @Override
    public String toString(){
        return String.format("(%s; %s)", x, y);
    }

    public String toCSV(){
        return String.format("%s, %s", x, y);
    }

    @Override
    public boolean validate(){
        if (x == null) return false;
        else if (y <= -868 || y == null) return false;
        return true;
    }

    // get
    public Integer getX() {
        return x;
    }
    public Float getY() {
        return y;
    }

    // set
    public void setX(Integer x) {
        this.x = x;
    }
    public void setY(Float y) {
        this.y = y;
    }
}