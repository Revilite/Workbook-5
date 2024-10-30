package com.pluralsight.contract;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    public void saveToFile(String line) {
        try {
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter("./src/main/resources/WorkshopFiles/contract.csv", true));
            buffWrite.write(line);
            buffWrite.close();
        } catch (IOException e) {
            System.out.println("Could not save into file :(");
        }
    }

}