package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class BufferedReaderExample {
    public static void main(String[] args) {
        writeToFile(promptForContact());
    }

    private static Contact promptForContact() {
        Scanner in = new Scanner(System.in);

        //adding a line here testing things
        System.out.println("Please enter the contact name:");
        String name = in.nextLine();

        System.out.println("Please enter the contact phone number:");
        String number = in.nextLine();

        Contact person = new Contact();
        person.setName(name);
        person.setPhoneNumber(number);

        return person;
    }


    public static void writeToFile(Contact contact) {
        try {
            //BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            FileWriter myWriter = new FileWriter("contacts.txt");
            myWriter.write(contact.toString());
        } catch (Exception e) {
            // do nothing who cares
        }
    }
}
