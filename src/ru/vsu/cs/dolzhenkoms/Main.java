package ru.vsu.cs.dolzhenkoms;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = readFileSource();
        Obfuscator obfuscator = new Obfuscator(filePath);
        obfuscator.execute();
    }

    private static String readFileSource() {
        System.out.print("Write source of Java-file - ");

        Scanner scn = new Scanner(System.in);
        String source = scn.next();

        if(!FileUtils.isFileExist(source)) {
            System.out.println("This file does not exist. Please retry...");
            return readFileSource();
        }

        return source;
    }
}
