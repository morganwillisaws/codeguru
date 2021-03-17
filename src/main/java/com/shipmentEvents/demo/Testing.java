package com.company;

import java.util.concurrent.locks.*;

public class Testing {

    public static class Table {

        private static Lock Flashlight = new ReentrantLock();
        private static Lock Batteries = new ReentrantLock();

        public static void giveFlashLightAndBatteries() {
            try {
                Flashlight.lock();
                Batteries.lock();
                System.out.println("Lights on");
            } finally {
                Batteries.unlock();
                Flashlight.unlock();
            }
        }

        public static void giveBatteriesAndFlashLight() {
            try {
                Batteries.lock();
                Flashlight.lock();
                System.out.println("Lights on");
            } finally {
                Flashlight.unlock();
                Batteries.unlock();
            }
        }
    }

    public static void main(String[] args) {
        // This thread represents person one
        new Thread(new Runnable() {
            public void run() { Table.giveFlashLightAndBatteries(); }
        }).start();

        // This thread represents person two
        new Thread(new Runnable() {
            public void run() { Table.giveBatteriesAndFlashLight(); }
        }).start();
    }
}