package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        //adding a line here testing things
        System.out.println("Please enter your name");
        String name = in.nextLine();

        do{
            //this could be an infinite loop!
            //String comparison using ==
            if(name == "Morgan") {
                break;
            }

        } while(true);

        System.out.println("Please select Rock, Paper, or Scissors");

    }
}
