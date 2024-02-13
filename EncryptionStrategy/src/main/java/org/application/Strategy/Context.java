package org.application.Strategy;

public class Context {
    private EncodingStrategy encodingStrategy;
    public Context(EncodingStrategy encodingStrategy) {
        this.encodingStrategy = encodingStrategy;
    }
    public Context(){
        this.encodingStrategy = new SimpleEncryptor(); //implementazione di default
    }

    public String encrypt(String text, int key) {
        return encodingStrategy.encrypt(text, key);
    }

    public String decrypt(String text, int key) {
        return encodingStrategy.decrypt(text, key);
    }
}
