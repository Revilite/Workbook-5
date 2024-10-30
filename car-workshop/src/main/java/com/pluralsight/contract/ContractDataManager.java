package com.pluralsight.contract;

public class ContractDataManager {
    public void saveContract(Contract contract) {

        if (contract instanceof SalesContract) {
            //type of contract, date, name, email, vin, year, make, model, type, color, odometer,
            // price, sales tax, recording fee, processing fee, total price, if financing,
            // monthly price of financing
            String date = contract.getDate();
            String name = contract.getCustomerName();
            String email = contract.getCustomerEmail();
            int vin = contract.getVehicleSold().getVin();
            int year = contract.getVehicleSold().getYear();
            String make = contract.getVehicleSold().getMake();
            String model = contract.getVehicleSold().getModel();
            String type = contract.getVehicleSold().getVehicleType();
            String color = contract.getVehicleSold().getColor();
            int odometer = contract.getVehicleSold().getOdometer();
            double price = contract.getVehicleSold().getPrice();
            double salesTax = ((SalesContract) contract).getSalesTaxAmount();
            double recordingFee = ((SalesContract) contract).getRecordingFee();
            double processingFee = ((SalesContract) contract).getProcessingFee();
            double totalPrice = contract.getTotalPrice();
            boolean isFinancing = ((SalesContract) contract).isFinancing();
            double monthlyPrice = contract.getMonthlyPayment();

            String saveToCSV = String.format("""
                    Sale|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f
                    """, date, name, email, vin, year, make, model, type, color, odometer, price, salesTax, recordingFee, processingFee, totalPrice, isFinancing, monthlyPrice);

            new ContractFileManager().saveToFile(saveToCSV);
        }


    }
}
