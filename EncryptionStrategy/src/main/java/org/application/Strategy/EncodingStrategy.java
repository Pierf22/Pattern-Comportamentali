package org.application.Strategy;

public abstract class EncodingStrategy {
    //visibilità protected per non permettere l'accesso al Main(client)
    protected abstract String encrypt(String text, int key);
    protected abstract String decrypt(String text, int key);
}
