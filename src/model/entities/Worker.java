package model.entities;

import model.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> hourContracts = new ArrayList<>();

    public Worker(){}

    public Worker(String name, WorkerLevel level, double baseSalary, Department department){
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getHourContracts() {
        return hourContracts;
    }

    public void addContract(HourContract contract){
        this.hourContracts.add(contract);
    }
    public void removeContract(HourContract contract){
        this.hourContracts.remove(contract);
    }

    public double income(int year, int month){
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract contract: hourContracts){
            cal.setTime(contract.getDate());
            int c_month = 1 + cal.get(Calendar.MONTH);
            int c_year = cal.get(Calendar.YEAR);
            if(c_month == month && c_year ==year) {
                sum += contract.totalValue();
            }
        }
        return sum;
    }

    public String toString(){
        return String.format("Name: %s%nDepartment: %s%n" +
                "", name, department.getName());
    }
}
