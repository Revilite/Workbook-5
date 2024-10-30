package com.pluralsight.contract;

public class ContractDataManager {
    public void saveContract(Contract contract) {
        new ContractFileManager().saveToFile(contract.toString());
    }
}
