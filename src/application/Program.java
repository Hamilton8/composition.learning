package application;

import model.entities.Department;
import model.entities.HourContract;
import model.entities.Worker;
import model.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner input  = new Scanner(System.in);
        System.out.println("Enter department's name:");
        String departmentName = input.next();
        System.out.println("Enter Worker Data");
        System.out.println("Name:");
        String workerName = input.next();
        System.out.println("Enter te=he worker level");
        String workerLevel = input.next();
        System.out.println("Enter the base Salary");
        double baseSalary = input.nextDouble();
        System.out.println("How many contracts to this worker:");
        int num  = input.nextInt();
        Worker worker = new Worker(workerName,
                WorkerLevel.valueOf(workerLevel),
                baseSalary,new Department(departmentName));
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        for(int i = 0; i<num; i++){
            System.out.println("Enter the contract #"+(i+1)+" data");
            System.out.println("Enter the date (dd/mm/yyyy):");
            Date date = sdf.parse(input.next());
            System.out.println("Enter value per hour:");
            double valuePerHour = input.nextDouble();
            System.out.println("Duration (hour):");
            int hours = input.nextInt();
            worker.addContract(new HourContract(date,valuePerHour,hours));
        }

        SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");
        System.out.println("Enter the month and the year to calculate income: (mm/yyyy): ");
        Date date = sdf1.parse(input.next());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        double income = worker.income(year,month);
        System.out.println(worker+ String.format("Income of %d/%d is %.2f",month,year,income));

    }
}
