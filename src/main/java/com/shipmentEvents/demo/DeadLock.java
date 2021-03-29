package com.company;

public class Deadlock {

    public static PeanutButter pb = new PeanutButter();
    public static Jelly jelly = new Jelly();

    public static void main(String args[]) throws InterruptedException {
        // represents person 1
        Thread threadA = new Thread(() -> {
            synchronized (pb) {
                System.out.println("Person 1 is spreading peanut butter");
                pb.spreadPeanutButter();
            }

                synchronized (jelly) {
                    System.out.println("Person 1 is spreading Jelly");
                    jelly.spreadJelly(); }

        });

        // represents person 2
        Thread threadB = new Thread(() -> {
            synchronized (jelly) {
                System.out.println("Person 2 is spreading jelly");
                jelly.spreadJelly();
            }
                synchronized (pb) {
                    System.out.println("Person 2 is spreading peanut butter");
                    pb.spreadPeanutButter();
                }

        });

        threadA.start();
        threadB.start();
    }
}

class PeanutButter {
    public String spreadPeanutButter() {
        try{
            Thread.sleep(100);
        } catch (Exception e) { }
        return "peanut butter has been spread";
    }
}

class Jelly {
    public String spreadJelly() {
        try{
            Thread.sleep(100);
        } catch (Exception e) { }
        return "jelly has been spread";
    }
}
