package com.company;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import org.apache.commons.codec.binary.Base64;

public class AES {
    //Generating Key
    private final String ALGORITHM ="AES";
    private final byte[] keyValue = "1234567891234567".getBytes();
    public Key generateKey() throws Exception{
        Key key = new SecretKeySpec(keyValue,ALGORITHM);
        return key;
    }
    //Encryption
    public String encrypt(String valueToEncrypt, Key key) throws  Exception{
        Cipher cipher =Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] encryptValue = cipher.doFinal(valueToEncrypt.getBytes());
        byte[] encryptedByteValue = new Base64().encode(encryptValue);
        String result = new String(encryptedByteValue);
        System.out.println("Encrypted Value: "+result);
        return result;
    }
    //Decryption
    public String decrypt(String encryptedValue, Key key) throws  Exception{
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE,key);
        byte[] decodedByte = new Base64().decode(encryptedValue.getBytes());
        byte[] encryptedVal = cipher.doFinal(decodedByte);
        String result = new String(encryptedVal);
        System.out.println("Decrypted Value: "+result);
        return result;
    }
}
