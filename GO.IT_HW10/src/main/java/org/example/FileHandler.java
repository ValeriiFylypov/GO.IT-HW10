package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern; 

public class FileHandler {

    public static void phoneFinderFromFile(File file) {
        ArrayList strList = getArrayListFromFile(file);
        if (strList == null) return;

        String regex = "^((\\d{3}\\-)|(\\(\\d{3}\\)\\s))\\d{3}\\-\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        for (Object o : strList) {
            Matcher matcher = pattern.matcher(o.toString());
            if (matcher.matches()) {
                System.out.println(o);
            }
            ;
        }
    }

    public static void readUserToJson(File file, File fileToWrite) {
        ArrayList strList = getArrayListFromFile(file);
        if (strList == null) return;

        ArrayList userList = new ArrayList<>();

        for (int i = 1; i < strList.size(); i++) {
            String[] str = strList.get(i).toString().split(" ");
            userList.add(new User(str[0], Integer.parseInt(str[1])));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        StringBuilder strToFile = new StringBuilder("[\n");

        for (Object o : userList) {
            strToFile.append(gson.toJson(o))
                    .append(",\n");
        }

        strToFile.delete(strToFile.length() - 2, strToFile.length());
        strToFile = new StringBuilder(strToFile.toString().replace("\n", "\n  "));
        strToFile.append("\n]");

        writeToFile(fileToWrite, strToFile.toString());

        System.out.println("Completed (see file)");

    }

    public static void frequencyCalculator(File file) {
        ArrayList strList = getArrayListFromFile(file);
        if (strList == null) return;

        ArrayList wordsList = new ArrayList<>();

        for (int i = 0; i < strList.size(); i++) {
            String[] str = strList.get(i).toString().split(" ");
            for (int j = 0; j < str.length; j++) {
                wordsList.add(str[j]);
            }
        }

        ArrayList words = new ArrayList();
        ArrayList frequencies = new ArrayList();


        for (int i = 0; i < wordsList.size(); i++) {
            int position = words.indexOf(wordsList.get(i));
            if (position >= 0) {
                frequencies.set(position, Integer.parseInt(frequencies.get(position).toString()) + 1);
            } else {
                words.add(wordsList.get(i));
                frequencies.add(1);
            }
        }

        sortListsByFrequency(words, frequencies);

        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + " " + frequencies.get(i));
        }

    }

    private static ArrayList getArrayListFromFile(File file) {
        if (!file.exists()) {
            System.out.println("File not found");
            return null;
        }
        ArrayList str = new ArrayList();
        try (FileInputStream fis = new FileInputStream(file); Scanner s = new Scanner(fis)) {
            while (s.hasNextLine()) {
                str.add(s.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return str;
    }

    private static void writeToFile(File fileToWrite, String toWrite) {

        try (Writer writer = new FileWriter(fileToWrite)) {
            writer.write(toWrite);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void sortListsByFrequency(ArrayList words, ArrayList frequencies) {
        boolean sorted = false;
        String tempW;
        int tempF;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < frequencies.size() - 1; i++) {
                if (Integer.parseInt(frequencies.get(i).toString()) < Integer.parseInt(frequencies.get(i + 1).toString())) {
                    tempW = words.get(i).toString();
                    tempF = Integer.parseInt(frequencies.get(i).toString());
                    words.set(i, words.get(i + 1));
                    frequencies.set(i, frequencies.get(i + 1));
                    words.set(i + 1, tempW);
                    frequencies.set(i + 1, tempF);
                    sorted = false;
                }
            }
        }
    }
}