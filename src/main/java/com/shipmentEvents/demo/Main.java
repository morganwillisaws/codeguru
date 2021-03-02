package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    // not concurrency safe....
    private static Map<String,String> map = new TreeMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        //adding a line here testing things
        System.out.println("Please enter your name");
        String name = in.nextLine();

        do{
            //this could be an infinite loop!
            //String comparison using ==
            if(name == "Morgan") {
                map.put(name,"test value");
            }

        } while(true);


    }
}
