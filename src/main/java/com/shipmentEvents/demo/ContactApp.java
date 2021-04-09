package com.company;

import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactApp {

    private static Map<String, Contact> contacts = new HashMap<>();

    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        System.out.println("Please enter the contact name:");
        String name = in.nextLine();

        System.out.println("Please enter the contact phone number:");
        String number = in.nextLine();

        Contact person1 = new Contact();
        person1.setName(name);
        person1.setPhoneNumber(number);

        // add contact to map
        if(!contacts.containsKey(person1.getName())) {
            contacts.put(person1.getName(), person1);
        }

        System.out.println("Please enter the contact name:");
        name = in.nextLine();

        System.out.println("Please enter the contact phone number:");
        number = in.nextLine();

        Contact person2 = new Contact();
        person2.setName(name);
        person2.setPhoneNumber(number);

        // add contact to map
        if(!contacts.containsKey(person2.getName())) {
            contacts.put(person2.getName(), person2);
        }

        writeToFile();
    }


    public static void writeToFile() throws Exception {
        try {
            FileWriter myWriter = new FileWriter("contacts.txt");
            myWriter.write(contacts.toString());
            myWriter.close();
        } catch (Exception e) { }
    }
}
