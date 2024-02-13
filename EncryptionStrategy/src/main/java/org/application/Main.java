package org.application;


import org.application.Strategy.Base64Encryptor;
import org.application.Strategy.Context;
import org.application.Strategy.HexEncoding;
import org.application.Strategy.SimpleEncryptor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

         Context context=new Context(); //Implementazione di default di una strategia
        //Context context=new Context(new Base64Encryptor());// Implementazione strategia Base64
        //Context context=new Context(new HexEncoding()); //Implementazione strategia HexEncoding
        //Context context=new Context(new SimpleEncryptor()); // Implementazione strategia SimpleEncryptor

        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il testo da criptare: ");
        String text = scanner.nextLine();
        System.out.print("Inserisci la chiave: ");
        int key = scanner.nextInt();
        String encryptedText = context.encrypt(text, key);
        System.out.println("Testo criptato: " + context.encrypt(text, key));
        System.out.println("Testo decriptato: " + context.decrypt(encryptedText, key));
    }
}