package org.application.Strategy;

public class Base64Encryptor extends EncodingStrategy {
    private static final String BASE64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";

    @Override
    protected String encrypt(String text, int key) {
        // Combina il testo con la chiave prima di applicare l'encoding Base64
        String textToEncode = text + key;

        // Converte il testo in un array di byte
        byte[] bytesToEncode = textToEncode.getBytes();

        // Crea una stringa per immagazzinare il risultato
        StringBuilder encodedResult = new StringBuilder();

        // Itera attraverso i gruppi di tre byte e applica l'encoding Base64
        for (int i = 0; i < bytesToEncode.length; i += 3) {
            int group = (bytesToEncode[i] << 16) | ((i + 1 < bytesToEncode.length ? bytesToEncode[i + 1] : 0) << 8) | (i + 2 < bytesToEncode.length ? bytesToEncode[i + 2] : 0);

            encodedResult.append(BASE64_CHARS.charAt((group >> 18) & 0x3F));
            encodedResult.append(BASE64_CHARS.charAt((group >> 12) & 0x3F));
            encodedResult.append((i + 1 < bytesToEncode.length) ? BASE64_CHARS.charAt((group >> 6) & 0x3F) : '=');
            encodedResult.append((i + 2 < bytesToEncode.length) ? BASE64_CHARS.charAt(group & 0x3F) : '=');
        }

        return encodedResult.toString();
    }

    @Override
    protected String decrypt(String text, int key) {
        // Rimuove i caratteri di padding se presenti
        text = text.replaceAll("=+$", "");

        // Crea un array di byte da decodificare
        byte[] decodedBytes = new byte[text.length() * 3 / 4];
        int decodedLength = 0;

        // Itera attraverso i gruppi di quattro caratteri Base64 e decodifica
        for (int i = 0; i < text.length(); i += 4) {
            int group = (BASE64_CHARS.indexOf(text.charAt(i)) << 18) |
                    (BASE64_CHARS.indexOf(text.charAt(i + 1)) << 12) |
                    (BASE64_CHARS.indexOf(i + 2 < text.length() ? text.charAt(i + 2) : 'A') << 6) |
                    (BASE64_CHARS.indexOf(i + 3 < text.length() ? text.charAt(i + 3) : 'A'));

            decodedBytes[decodedLength++] = (byte) ((group >> 16) & 0xFF);
            if (i + 2 < text.length()) decodedBytes[decodedLength++] = (byte) ((group >> 8) & 0xFF);
            if (i + 3 < text.length()) decodedBytes[decodedLength++] = (byte) (group & 0xFF);
        }

        // Rimuove la chiave dalla fine del testo decodificato

        return new String(decodedBytes, 0, decodedLength - String.valueOf(key).length());
    }
}
