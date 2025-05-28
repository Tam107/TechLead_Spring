package com.techlead.model.core4;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Employee {
    private String id;
    private String name;
    private double totalSalary;
    private double calculatedTotalSalary;
    private Map<String, Double> shiftsRate;
    private List<WorkingDay> workingDays;

    public Employee(String id, String name, double totalSalary) {
        this.id = id;
        this.name = name;
        this.totalSalary = totalSalary;
        this.shiftsRate = new LinkedHashMap<>();
        this.workingDays = new ArrayList<>();
    }
    public void addWorkingDay(WorkingDay workingDay){
        workingDays.add(workingDay);
        calculatedTotalSalary += workingDay.getTotalAmount();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getCalculatedTotalSalary() {
        return calculatedTotalSalary;
    }

    public void setCalculatedTotalSalary(double calculatedTotalSalary) {
        this.calculatedTotalSalary = totalSalary;
    }

    public Map<String, Double> getShiftsRate() {
        return shiftsRate;
    }

    public void setShiftsRate(Map<String, Double> shiftsRate) {
        this.shiftsRate = shiftsRate;
    }

    public List<WorkingDay> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(List<WorkingDay> workingDays) {
        this.workingDays = workingDays;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Employee: ").append(id).append(" - ").append(name).append("\n");
        sb.append("Total Salary: ").append(String.format("%.2f", totalSalary)).append("\n");

        for (WorkingDay workingDay : workingDays) {

            sb.append("  Day ").append(workingDay.getDate()).append(": Total Salary Per Day=").append(String.format("%.2f", workingDay.getTotalAmount()) )
                    .append(", Shifts=").append(workingDay.getShifts()).append("\n");

        }

        return sb.toString();
    }

}
