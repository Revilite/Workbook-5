package com.pluralsight.contract;

import com.pluralsight.cars.Vehicle;

public class LeaseContract extends Contract {
    protected double expectedEndingValue;
    protected double leaseFee;
    protected int loanAmount;



    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        expectedEndingValue = vehicleSold.getPrice() / 2;
        leaseFee = vehicleSold.getPrice() * .07;
        monthlyPayment = .04;
        loanAmount = 36;
    }

    @Override
    public double getMonthlyPayment() {
        return expectedEndingValue * .04;
    }

    @Override
    public double getTotalPrice() {
        return (expectedEndingValue + (expectedEndingValue * monthlyPayment) * loanAmount) + leaseFee;
    }
}
