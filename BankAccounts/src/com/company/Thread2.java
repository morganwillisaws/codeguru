package com.company;


public class Thread2 extends Thread {
    private AccountService service = new AccountService();
    private Account a;
    private Account b;

    Thread2(Account a, Account b) {
        this.a = a;
        this.b = b;
    }

    public void run() {
        service.transfer(b, a, 100);
    }
}
