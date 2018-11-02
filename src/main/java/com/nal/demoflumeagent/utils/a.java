package com.nal.demoflumeagent.utils;

import java.io.File;

public class a {
    public static void main(String[] args) {
        File folder = new File("./apache-flume-1.8.0-bin");
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }
}
