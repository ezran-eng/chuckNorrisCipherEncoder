package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string:");
        String input = scanner.nextLine();
        System.out.println("The result:");
        for (char c : input.toCharArray()) {
            String binary = String.format("%7s", Integer.toBinaryString(c)).replace(' ', '0');
            System.out.println(c + " = " + binary);
        }
    }
}