package com.pluralsight.contract;

import com.pluralsight.cars.Vehicle;

public class LeaseContract extends Contract {
    protected double expectedEndingValue;
    protected double leaseFee;


    public LeaseContract(String customerName, String customerEmail, Vehicle vehicleSold) {
        super(customerName, customerEmail, vehicleSold);
        expectedEndingValue = vehicleSold.getPrice() / 2;
        leaseFee = vehicleSold.getPrice() * .07;
    }

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public double getLeaseFee() {
        return Math.floor(leaseFee * 100) / 100;
    }

    @Override
    public double getMonthlyPayment() {
        return expectedEndingValue * Math.pow((1 + (.04 / 12)), 36) - expectedEndingValue; // monthly compound interest formula;
    }

    @Override
    public double getTotalPrice() {
        return expectedEndingValue + leaseFee;
    }

    @Override
    public String toString() {
        return String.format("""
                LEASE|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f|%.2f\n
                """, date, customerName, customerEmail, vehicleSold.getVin(), vehicleSold.getYear(), vehicleSold.getMake(), vehicleSold.getModel(), vehicleSold.getVehicleType(), vehicleSold.getColor(), vehicleSold.getOdometer(), vehicleSold.getPrice(), expectedEndingValue, leaseFee, totalPrice, monthlyPayment);
    }
}
//total price  = leasefee * (36 * monthly payment) == half of principle == expected ending value
// 4% / 12 + whatever is covered by the rest of the payment
// Residual 15997.50
// Lease fee 2239.65
//