package com.techlead.model.core4;

import java.util.ArrayList;
import java.util.List;

public class WorkingDay {

    private String date;
    private double totalHours;
    private double totalAmount;
    private List<Shift> shifts;

    public WorkingDay(String day) {
        this.date = day;
        this.totalHours = 0.0;
        this.totalAmount = 0.0;
        this.shifts = new ArrayList<>();
    }

    public void addShift(Shift shift, double hours, double amount) {
        shifts.add(shift);
        totalHours += shift.getHours();
        totalAmount += shift.getAmount();
    }

    public double totalHoursCal() {
        double total = 0.0;
        for (Shift shift : shifts) {
            total += shift.getHours(); // Cộng số giờ của từng ca
        }
        return total;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getTotalHours() {
        return totalHours;
    }

    public void setTotalHours(double totalHours) {
        this.totalHours = totalHours;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Shift> getShifts() {
        return shifts;
    }

    public void setShifts(List<Shift> shifts) {
        this.shifts = shifts;
    }
}
