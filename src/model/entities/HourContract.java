package model.entities;

import java.util.Date;

public class HourContract {
    private Date date;
    private Double valuePerHour;
    private Integer hour;

    public HourContract(){

    }
    public HourContract(Date date, double valuePerHour, int hour){
        this.date = date;
        this.hour = hour;
        this.valuePerHour = valuePerHour;
    }

    //Campo dos setters
    public void setDate(Date date){
        this.date = date;
    }
    public void setValuePerHour(double valuePerHour){
        this.valuePerHour = valuePerHour;
    }
    public void setHour(int hour){
        this.hour = hour;
    }

    public double totalValue(){
        return valuePerHour*hour;
    }

    //Campo dos getters
    public double getVAluePerHour(){
        return valuePerHour;
    }
    public Date getDate(){
        return date;
    }
    public int getHour(){
        return hour;
    }
}
