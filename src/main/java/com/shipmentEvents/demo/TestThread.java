package com.company;


public class TestThread {
    public static BankAccount accountA = new BankAccount();
    public static BankAccount accountB = new BankAccount();

    public static void main(String args[]) {
        // both accounts have a starting balance
        accountA.deposit(200);
        accountB.deposit(325);

        // Create and run two threads simulating two different people
        // sending each other money at the same time
        ThreadDemo1 T1 = new ThreadDemo1();
        ThreadDemo2 T2 = new ThreadDemo2();
        T1.start();
        T2.start();
    }

    private static class ThreadDemo1 extends Thread {
        public void run() {
            synchronized (accountA) {
                System.out.println("Thread 1: Holding account A...");

                accountA.deposit(100.00);
                System.out.println("Thread 1: Waiting for account B to complete withdrawal...");

                synchronized (accountB) {
                    accountB.withdraw(100.00);
                    System.out.println("Thread 1: Withdrawing $100 from account B...");
                }
            }
        }
    }
    private static class ThreadDemo2 extends Thread {
        public void run() {
            synchronized (accountB) {
                System.out.println("Thread 2: Holding account B...");

                accountB.deposit(50);
                System.out.println("Thread 2: Waiting for account A to complete withdrawal...");

                synchronized (accountA) {
                    accountA.withdraw(50);
                    System.out.println("Thread 2: Withdrawing $50 from account A...");
                }
            }
        }
    }

    private static class BankAccount {
        private static double balance;

        public double deposit(double amount) {
            try{
                balance += amount;
                Thread.sleep(100);
            } catch (Exception e) { }
            return balance;
        }

        public double withdraw(double amount) {
            try{
                balance -= amount;
                Thread.sleep(100);
            } catch (Exception e) { }
            return balance;        }
    }


}

