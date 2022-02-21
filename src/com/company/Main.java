package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
	var aes = new AES();
    var key = aes.generateKey();
    String encryptvalue= aes.encrypt("My name is Jeff and I love Java",key);
    aes.decrypt(encryptvalue,key);
    }
}
