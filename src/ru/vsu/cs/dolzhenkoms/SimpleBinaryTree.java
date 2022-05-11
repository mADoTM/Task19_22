package ru.vsu.cs.dolzhenkoms;

import java.util.Scanner;


public class SimpleBinaryTree {

    public static void main(String[] args) {
        int countBoys = readNumber("boys" );
        int countGirls = readNumber("girls" );
        int countGroups = getCountGroups(countBoys, countGirls);

        printCountGroups(countBoys, countGirls, countGroups);
    }

    private static int readNumber(String childrenType) {
        System.out.printf("Write count of %s - ", childrenType);
        Scanner scn = new Scanner(System.in);
        int num = scn.nextInt();

        if (num < 0) {
            System.out.println("Entered wrong data. Please retry...");
            System.exit(0);
        }

        return num;
    }

    private static int getCountGroups(int countBoys, int countGirls) {
        int countGroups = 0;

        while (countBoys > 0 && countGirls > 0) {
            countBoys--;
            countGirls--;
            if (countBoys > 0 || countGirls > 0) {
                if (countBoys >= countGirls) {
                    countBoys--;
                } else {
                    countGirls--;
                }
                countGroups++;
            }
        }

        return countGroups;
    }

    private static void printCountGroups(int countBoys, int countGirls, int countGroups) {
        if (countGroups == 0) {
            System.out.println("You can't make no one groups.");
        } else {
            System.out.printf("You can make %d groups from %d boys and %d girls", countGroups, countBoys, countGirls);
        }
    }
}