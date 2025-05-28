package com.techlead.model.core4;

public class Shift {

    private String shiftName;
    private double hours;
    private double amount;

    public Shift(String shiftName, double hours, double amount) {
        this.shiftName = shiftName;
        this.hours = hours;
        this.amount = amount;
    }

    public String getShiftName() {
        return shiftName;
    }

    public void setShiftName(String shiftName) {
        this.shiftName = shiftName;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "shiftName='" + shiftName + '\'' +
                ", hours=" + hours +
                ", amount=" + amount +
                '}';
    }
}
