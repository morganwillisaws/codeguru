package com.company;

public class Main {

    public static void main(String[] args) {
        // Create and run two threads simulating two different people
        // sending each other money at the same time
        Account a = new Account(200, "Bob");
        Account b = new Account(150, "Dave");

        Thread1 T1 = new Thread1(a, b);
        Thread2 T2 = new Thread2(a, b);
        T1.start();
        T2.start();
    }
}
