package com.pluralsight.contract;


import java.util.List;
import java.util.Scanner;

public class AdminUserInterface {
    //Tried to set .env file but can figure out how to import right class
    private ContractDataManager cdm = new ContractDataManager();

    public void logIn(String password) {
        //Set your password in configurations when running the file
        if (password.equalsIgnoreCase(System.getenv("PASSWORD"))) {
            cdm.initContracts();
            displayContracts();
        } else {
            System.out.println("Incorrect Password");
        }
    }

    public void displayContracts() {
        Scanner scan = new Scanner(System.in);


        System.out.println("""
                ━━━━━━━━━━━━━☛ Contracts ☚━━━━━━━━━━━━━━
                
                 Display all Contract               (1)
                 Display last 10 Contracts          (2)
                """);
        String userInput = scan.nextLine();

        switch (userInput) {
            case ("1"):
                processDisplayAllContracts();
                break;
            case ("2"):
                processDisplayTenContracts();
                break;
            default:
                System.out.println("Incorrect answer");
        }

    }

    public String displayContractList(List<Contract> contracts) {
        StringBuilder sb = new StringBuilder();

        for (Contract contract : contracts) {

            //Contract variables
            String name = contract.getCustomerName();
            String date = contract.getDate();
            String email = contract.getCustomerEmail();
            double monthlyPayment = contract.getMonthlyPayment();
            double totalAmount = contract.getTotalPrice();
            int vin = contract.getVehicleSold().getVin();

            String heading = "  Type    Date          Name             Email                    Sales Tax/Ending Value   Recording Fee / Lease Fee     Total Amount    Finance Status   Monthly Payment         Vin\n";

            if (contract instanceof SalesContract) {
                double salesTax = ((SalesContract) contract).getSalesTaxAmount();
                double recordingFee = ((SalesContract) contract).getRecordingFee();
                boolean isFinancing = ((SalesContract) contract).isFinancing();
                String salesFormat = String.format("╎Sale   %-10s     %-15s    %-30s   %-20.2f   %-20.2f     %-20.2f    %-3s        %-12.2f     %-10d  ╎\n", date, name, email, salesTax, recordingFee, totalAmount, isFinancing ? "YES" : "NO", monthlyPayment, vin);

                if (contracts.size() == 1) {
                    sb.append("╭──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮\n");
                    sb.append(salesFormat);
                    sb.append("╰──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╯\n");
                } else if (contracts.get(0) == contract) {
                    sb.append(heading);
                    sb.append("╭──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮\n");
                    sb.append(salesFormat);
                } else if (contracts.get(contracts.size() - 1) == contract) {
                    sb.append(salesFormat);
                    sb.append("╰──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╯\n");
                } else {
                    sb.append(salesFormat);
                }
            } else if (contract instanceof LeaseContract) {
                double expectedEndingValue = ((LeaseContract) contract).getExpectedEndingValue();
                double leaseFee = ((LeaseContract) contract).getLeaseFee();
                String leaseFormat = String.format("╎Lease  %-10s     %-15s    %-30s   %-20.2f   %-20.2f     %-20.2f    N/A        %-12.2f     %-10d  ╎\n", date, name, email, expectedEndingValue, leaseFee, totalAmount, monthlyPayment, vin);

                if (contracts.size() == 1) {
                    sb.append("╭──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮\n");
                    sb.append(leaseFormat);
                    sb.append("╰──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╯\n");
                } else if (contracts.get(0) == contract) {
                    sb.append(heading);
                    sb.append("╭──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╮\n");
                    sb.append(leaseFormat);
                } else if (contracts.get(contracts.size() - 1) == contract) {
                    sb.append(leaseFormat);
                    sb.append("╰──────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────╯\n");
                } else {
                    sb.append(leaseFormat);
                }

            }
        }
        return sb.toString();
    }

    public void processDisplayAllContracts() {
        System.out.print(displayContractList(cdm.getAllContracts()));
    }

    public void processDisplayTenContracts() {
        System.out.print(displayContractList(cdm.getLastTenContracts()));
    }

}
