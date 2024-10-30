package com.pluralsight.contract;

import com.pluralsight.cars.Vehicle;

public class SalesContract extends Contract {
    protected double salesTaxAmount;
    protected double recordingFee;
    protected int processingFee;
    protected boolean isFinancing;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinancing) {
        super(date, customerName, customerEmail, vehicleSold);
        salesTaxAmount = .05;
        recordingFee = 100;
        if (vehicleSold.getPrice() < 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }
        this.isFinancing = isFinancing;

        if (isFinancing && vehicleSold.getPrice() >= 10000) {
            monthlyPayment = getTotalPrice() * .0425;
        } else if (isFinancing && vehicleSold.getPrice() < 10000) {
            monthlyPayment = getTotalPrice() * .0525;
        } else {
            monthlyPayment = 0;
        }

    }

    public double getSalesTaxAmount() {
        return salesTaxAmount * vehicleSold.getPrice();
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public int getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(int processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinancing() {
        return isFinancing;
    }

    public void setFinancing(boolean financing) {
        isFinancing = financing;
    }


    @Override
    public double getTotalPrice() {
        return vehicleSold.getPrice() + recordingFee + processingFee + getSalesTaxAmount();
    }

    @Override
    public double getMonthlyPayment() {
        return Math.floor(monthlyPayment * 100) / 100;
    }


}
