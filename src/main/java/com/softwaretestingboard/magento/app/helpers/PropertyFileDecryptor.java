package com.softwaretestingboard.magento.app.helpers;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Properties;

public class PropertyFileDecryptor {

    public static Properties decryptPropertiesFile(String filePath, String password) throws Exception {
       // String password1 = "qwe123"; // Enter the password used for encryption

        // Read the encrypted file
        byte[] encryptedData = Files.readAllBytes(Paths.get(filePath));

        // Decrypt the file
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(password.getBytes(), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));

        // Load the decrypted properties
        Properties properties = new Properties();
        properties.load(new ByteArrayInputStream(decryptedData));

        // Access sensitive data
        String sensitiveData = properties.getProperty("password");
        System.out.println("Sensitive Data: " + sensitiveData);
        return properties;
    }
}
