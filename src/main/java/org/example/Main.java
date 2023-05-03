package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a string:");
        String input = scanner.nextLine();

        // Convert input to binary string
        StringBuilder binaryString = new StringBuilder();
        for (char c : input.toCharArray()) {
            String binary = Integer.toBinaryString(c);
            // Pad with leading zeros to ensure 7-bit length
            binaryString.append("0000000".substring(binary.length()) + binary);
        }

        // Encode binary string using Chuck Norris Unary Code
        StringBuilder encodedString = new StringBuilder();
        int i = 0;
        while (i < binaryString.length()) {
            // Determine bit value and count of consecutive bits
            char bit = binaryString.charAt(i);
            int count = 1;
            while (i < binaryString.length() - 1 && binaryString.charAt(i + 1) == bit) {
                count++;
                i++;
            }
            i++;

            // Append encoded block to output string
            encodedString.append(bit == '0' ? "00 " : "0 ");
            for (int j = 0; j < count; j++) {
                encodedString.append("0");
            }
            encodedString.append(" ");
        }

        // Print result
        System.out.println("The result:");
        System.out.println(encodedString.toString().trim());
    }
}