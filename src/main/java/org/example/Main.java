package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a string:");
        String inputString = scanner.nextLine();

        StringBuilder outputString = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            outputString.append(c).append(" ");
        }
        System.out.println(outputString.toString());
    }
}