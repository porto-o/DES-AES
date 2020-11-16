/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryption;

import java.security.Key;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Aes {

    public Aes() {

    }

    public String encrypt(String message, String key) throws Exception {

        byte[] byteMessage = message.getBytes();
        byte[] byteKey = key.getBytes();

        Key secretKey = new SecretKeySpec(byteKey, "AES");

        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipher = c.doFinal(byteMessage);

        String encryptedMessage = new BASE64Encoder().encode(cipher);
        return encryptedMessage;
    }

    public String decrypt(String encryptedMessage, String key) throws Exception {

        byte[] byteKey = key.getBytes();

        Key secretKey = new SecretKeySpec(byteKey, "AES");

        Cipher c = Cipher.getInstance("AES");
        c.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] byteEncryptedMessage = new BASE64Decoder().decodeBuffer(encryptedMessage);
        byte[] byteMessage = c.doFinal(byteEncryptedMessage);

        String message = new String(byteMessage);
        return message;
    }
    
    public String generatesKey(){
        String key = "";
        Random rand = new Random();
        for (int i = 0; i < 16; i++) {
            int c = rand.nextInt(122-48)+48;
            
            if((c>=58 && c<=64) | (c>=91 && c<=96)){
                i--;
                continue;
            }
            key += ((char)c);
        }
        return key;
    }

}
