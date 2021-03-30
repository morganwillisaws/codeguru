package com.company;

public class Thread1 extends Thread {
    private AccountService service = new AccountService();
    private Account a;
    private Account b;

    Thread1(Account a, Account b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        service.transfer(a, b, 55);
    }
}