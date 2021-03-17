package com.company;

import java.util.concurrent.ForkJoinPool;

public class DataRace {
        static boolean flag = false;//w0

        static void raiseFlag() {
            flag = true;//w1
        }

        public static void main(String... args) {
            ForkJoinPool.commonPool().execute(DataRace::raiseFlag);
            while (!flag);
            System.out.print(flag);
        }
    }
