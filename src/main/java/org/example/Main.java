package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Please input operation (encode/decode/exit):");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("encode")) {
                encode();
            } else if (userInput.equalsIgnoreCase("decode")) {
                decode();
            } else if (userInput.equalsIgnoreCase("exit")) {
                System.out.println("Bye!");
                return;
            } else {
                System.out.printf("There is no '%s' operation\n", userInput);
            }
            System.out.println();
        }
    }

    public static void encode() {
        System.out.println("Input string:");
        Scanner scanner = new Scanner(System.in);
        char[] userInput = scanner.nextLine().toCharArray();
        StringBuilder inputConvertedToBinary = new StringBuilder();
        for (int i = 0; i < userInput.length; i++) {
            String binary = Integer.toBinaryString(userInput[i]);
            if (binary.length() == 6) {
                binary = "0" + binary;
            }
            inputConvertedToBinary.append(binary);
        }
        StringBuilder charConvertedToBinary = new StringBuilder();
        for (int i = 0; i < inputConvertedToBinary.length(); i++) {
            if (i > 0 && inputConvertedToBinary.charAt(i - 1) == inputConvertedToBinary.charAt(i)) {
                charConvertedToBinary.append("0");
            } else if (inputConvertedToBinary.charAt(i) == '0') {
                charConvertedToBinary.append("00 0");
            } else if (inputConvertedToBinary.charAt(i) == '1') {
                charConvertedToBinary.append("0 0");
            }
            if (i < inputConvertedToBinary.length() - 1 && inputConvertedToBinary.charAt(i + 1) != inputConvertedToBinary.charAt(i)) {
                charConvertedToBinary.append(" ");
            }
        }
        System.out.println("Encoded string:\n" + charConvertedToBinary);
    }

    public static void decode() {
        System.out.println("Input encoded string:");
        Scanner scanner = new Scanner(System.in);
        String[] userInput = scanner.nextLine().split(" ");
        StringBuilder decodedInput = new StringBuilder();
        if (userInput.length % 2 != 0) {
            System.out.println("Encoded string is not valid.");
            return;
        }
        for (int i = 0; i < userInput.length; i += 2) {
            String firstBlock = userInput[i];
            String secondBlock = userInput[i + 1];
            for (int j = 0; j < secondBlock.length(); j++) {
                if (firstBlock.equals("0")) {
                    decodedInput.append("1");
                } else if (firstBlock.equals("00")){
                    decodedInput.append("0");
                } else {
                    System.out.println("Encoded string is not valid.");
                    return;
                }
            }
        }
        if (decodedInput.length() % 7 != 0) {
            System.out.println("Encoded string is not valid.");
            return;
        }
        StringBuilder convertedFromBinary = new StringBuilder();
        for (int i = 0; i < decodedInput.length(); i += 7) {
            String binary = decodedInput.substring(i, i + 7);
            convertedFromBinary.append((char) Integer.parseInt(binary, 2));
        }
        System.out.println("Decoded string:\n" + convertedFromBinary);
    }
}