package com.example.myapplication;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileSave {
    public static void run(){
        String filename = "data.txt";
        String[] dataLines = {
                "2001 10 11 55 99",
                "2002 20 22 44 99",
                "2003 30 33 33 99",
                "2004 40 44 22 99",
                "2005 50 55 81 99",
                "2006 60 66 56 99",
                "2008 70 77 58 99",
                "2009 80 88 66 99",
                "2010 90 99 68 99",
                "2011 99 88 77 99",
                "2012 95 77 78 88",
                "2013 85 66 79 88",
                "2014 75 55 88 88",
                "2015 65 44 81 88",
                "2016 55 33 82 88",
                "2017 45 22 83 88",
                "2018 35 11 84 88",
                "2019 25 90 85 88",
                "2020 15 80 86 88"
        };

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : dataLines) {
                writer.write(line);
                writer.newLine();
            }

        } catch (IOException e) {

        }

    }


}








