package blog2

import grails.gorm.transactions.Transactional

import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

@Transactional
class EncryptionService {

    private final Cipher blowfishCipher
    private final SecretKey secretKey

    EncryptionService(){

        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish")
        // initialize key generator for the size of key to generate
        keyGenerator.init(128)

        secretKey = keyGenerator.generateKey()
//        println secretKey

        blowfishCipher = Cipher.getInstance("Blowfish")
    }

    String encrypt(String clearText){

//        println("Encrypting clearText: " + clearText)

        // puts the cipher in encryption mode
        blowfishCipher.init(Cipher.ENCRYPT_MODE, secretKey)

        byte[] clearTextByteArray = clearText.getBytes("UTF-8")
        byte[] cipherTextByteArray = blowfishCipher.doFinal(clearTextByteArray) // convert

        String cipherText = new String(cipherTextByteArray)

//        println("Cipher text for " + clearText + " is " + cipherText)

        return cipherText
    }

    String decrypt(String cipherText){

//        println("Decrypting cipherText: " + cipherText)

        // puts the cipher in decryption mode
        blowfishCipher.init(Cipher.DECRYPT_MODE, secretKey)

        byte[] cipherTextByteArray = cipherText.getBytes("UTF-8")
        byte[] clearTextByteArray = blowfishCipher.doFinal(cipherTextByteArray)

        String clearText = new String(clearTextByteArray)

//        println("Clear text for " + clearText + " is " + cipherText)

        return clearText
    }
}
