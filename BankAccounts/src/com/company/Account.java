package com.company;

public class Account {

    private double balance;
    private String accountName;

    Account(double balance, String accountName){
        this.balance = balance;
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }
}
