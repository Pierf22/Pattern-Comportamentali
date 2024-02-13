package org.application.Strategy;

public class SimpleEncryptor extends EncodingStrategy {
     protected String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char originalChar = text.charAt(i);
            char encryptedChar = originalChar;
            if (Character.isLowerCase(originalChar)) {
                key= key % 26;
                encryptedChar = (char) ('a' + (originalChar - 'a' + key) % 26);
            } else if (Character.isUpperCase(originalChar)) {
                key= key % 26;
                encryptedChar = (char) ('A' + (originalChar - 'A' + key) % 26);
            } else if (Character.isDigit(originalChar)) {
                key= key % 10;
                encryptedChar = (char) ('0' + (originalChar - '0' + key) % 10);
            }
            encryptedText.append(encryptedChar);
        }

        return encryptedText.toString();
    }

     protected String decrypt(String text, int key) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char encryptedChar = text.charAt(i);
            char decryptedChar = encryptedChar;

            if (Character.isLowerCase(encryptedChar)) {
                key= key % 26;
                decryptedChar = (char) ('a' + (encryptedChar - 'a' - key + 26) % 26);
            } else if (Character.isUpperCase(encryptedChar)) {
                key= key % 26;
                decryptedChar = (char) ('A' + (encryptedChar - 'A' - key + 26) % 26);
            } else if (Character.isDigit(encryptedChar)) {
                key= key % 10;
                decryptedChar = (char) ('0' + (encryptedChar - '0' - key + 10) % 10);
            }

            decryptedText.append(decryptedChar);
        }

        return decryptedText.toString();

}}
