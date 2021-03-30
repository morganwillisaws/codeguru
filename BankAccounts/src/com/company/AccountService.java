package com.company;

import java.io.FileWriter;

public class AccountService {

    public void transfer(Account accountA, Account accountB, double amount) {
        synchronized(accountA)
        {
            withdraw(accountA, amount);
            System.out.print(amount+" is withdrawn from account a\n");

            try{Thread.sleep(500);}
            catch(Exception e){System.out.println(e);}

            synchronized(accountB)
            {
                deposit(accountB, amount);
                System.out.print(amount+" is deposited into account b\n");
            }
        }
    }

    private double deposit(Account account, double amount) {
        try{
            account.setBalance(account.getBalance() + amount);
            FileWriter myWriter = new FileWriter(account.getAccountName() + ".txt");
            myWriter.write(String.valueOf(account.getBalance()));
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return account.getBalance();
    }

    private double withdraw(Account account, double amount) {
        try{
            account.setBalance(account.getBalance() - amount);
            FileWriter myWriter = new FileWriter(account.getAccountName() + ".txt");
            myWriter.write(String.valueOf(account.getBalance()));
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
        return account.getBalance();
    }
}
