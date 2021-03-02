package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

public class BufferedReaderExample {
    public static void main(String[] args) {


            try {
                BufferedReader br = new BufferedReader(new FileReader("test.txt"));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
    }
}
