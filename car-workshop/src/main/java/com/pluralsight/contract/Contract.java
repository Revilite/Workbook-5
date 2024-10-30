package com.pluralsight.contract;

import com.pluralsight.cars.Vehicle;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Contract {
    protected String date;
    protected String customerName;
    protected String customerEmail;
    protected Vehicle vehicleSold;
    protected double totalPrice;
    protected double monthlyPayment;

    public Contract(String customerName, String customerEmail, Vehicle vehicleSold) {
        LocalDate date = LocalDate.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        this.date = date.format(dtf);
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
