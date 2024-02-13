package org.application.Strategy;

public class HexEncoding extends EncodingStrategy {

    @Override
    protected String encrypt(String text, int key) {
        StringBuilder hex = new StringBuilder();
        for (char c : text.toCharArray()) {
            hex.append(String.format("%02x", ((int) c + key) % 256));
        }
        return hex.toString();
    }

    @Override
    protected String decrypt(String text, int key) {
        StringBuilder hex = new StringBuilder();
        for (int i = 0; i < text.length(); i += 2) {
            String pair = text.substring(i, i + 2);
            hex.append((char) ((Integer.parseInt(pair, 16) - key + 256) % 256));
        }
        return hex.toString();
    }
}
