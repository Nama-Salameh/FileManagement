package fileManagment.EncryptedDecrypted.impl;
import Exceptions.IOFileException;
import fileManagment.EncryptedDecrypted.intf.IEncrypted;
import fileManagment.EncryptedDecrypted.intf.IEncryptedContent;
import fileManagment.FileRepository.ImportingFiles.intf.IFileReader;
import fileManagment.FileRepository.ImportingFiles.impl.filesReader;

import java.io.UnsupportedEncodingException;
import java.security.*;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptedContentBonus implements IEncryptedContent {
    public byte[] Encrypt(String path) throws IOFileException {

        //Creating KeyPair generator object
        KeyPairGenerator keyPairGen;
        try {
            keyPairGen = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        //Initializing the key pair generator
        keyPairGen.initialize(2048);

        //Generating the pair of keys
        KeyPair pair = keyPairGen.generateKeyPair();

        //Getting the public key from the key pair
        PublicKey publicKey = pair.getPublic();

        //Creating a Cipher object
        Cipher cipher;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }

        //Initializing a Cipher object
        try {
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        //Adding data to the cipher
        IFileReader iFileReader = new filesReader();
        byte[] input = iFileReader.ReadingContentAsBytes(path);
        cipher.update(input);

        //encrypting the data
        byte[] cipherText;
        try {
            cipherText = cipher.doFinal();
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println(new String(cipherText, "UTF8"));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return cipherText;
    }
}