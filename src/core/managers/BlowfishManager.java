package core.managers;

import core.factories.MetodoEncriptacion;
import core.interfaces.ReadKeyFile;
import core.interfaces.ReadMessageFile;
import core.interfaces.WriteBytesFile;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BlowfishManager extends MetodoEncriptacion {

    private final int KEYSIZE = 8;
    private final String PATH = "C:/encrypt/blowfish/";

    @Override
    public void createKey(String name) throws Exception {
        byte[] key = generatedSequenceOfBytes();
        WriteBytesFile.writeBytesFile(name, key, KEY_EXTENSION, PATH);

    }

    @Override
    public String encryptMessage(String messageName, String message, String keyName) throws Exception {
        byte[] key = ReadKeyFile.readKeyFile(PATH,keyName,KEY_EXTENSION);
        Cipher cipher = Cipher.getInstance("Blowfish");
        SecretKeySpec k = new SecretKeySpec(key, "Blowfish");
        cipher.init(Cipher.ENCRYPT_MODE, k);
        byte[] encryptedData = cipher.doFinal(message.getBytes(StandardCharsets.UTF_8));
        Base64.Encoder oneEncoder = Base64.getEncoder();
        encryptedData = oneEncoder.encode(encryptedData);
        WriteBytesFile.writeBytesFile(messageName, encryptedData, MESSAGE_ENCRYPT_EXTENSION, PATH);
        return new String(encryptedData, StandardCharsets.UTF_8);
    }

    @Override
    public String decryptMessage(String messageName, String keyName) throws Exception {
        byte[] key = ReadKeyFile.readKeyFile(PATH,keyName,KEY_EXTENSION);
        byte[] encryptedMessage = ReadMessageFile.readMessageFile(messageName, PATH,MESSAGE_ENCRYPT_EXTENSION);
        System.out.println(encryptedMessage.length);
        Cipher cipher = Cipher.getInstance("Blowfish");
        SecretKeySpec k = new SecretKeySpec(key, "Blowfish");
        cipher.init(Cipher.DECRYPT_MODE, k);
        byte[] DecryptedData = cipher.doFinal(encryptedMessage);
        String message = new String(DecryptedData, StandardCharsets.UTF_8);
        System.out.println("El mensaje era: ");
        System.out.println(message);
        return message;
    }

    private byte[] generatedSequenceOfBytes() throws Exception {
        StringBuilder randomkey = new StringBuilder();
        for (int i = 0; i < KEYSIZE; i++) {
            randomkey.append(Integer.parseInt(Double.toString((Math.random() + 0.1) * 1000).substring(0, 2)));
        }
        return randomkey.toString().getBytes("UTF-8");
    }
}
