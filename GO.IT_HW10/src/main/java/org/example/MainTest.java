package org.example;

import java.io.*;


import static org.example.FileHandler.*;
//import static org.example.utils.FileHandler.*;

public class MainTest {
    public static void main(String[] args) {

        System.out.println("Task one:\n");
        File file = new File(".\\src\\main\\FileForTask1.txt");
        phoneFinderFromFile(file);

        System.out.println("\nTask two:\n");
        File fileTwo = new File(".\\src\\main\\FileForTask2.txt");
        File fileForWrite = new File(".\\src\\main\\user.json");
        readUserToJson(fileTwo, fileForWrite);

        System.out.println("\nTask three:\n");
        File fileForTaskThree = new File(".\\src\\main\\words.txt");
        frequencyCalculator(fileForTaskThree);

    }
}