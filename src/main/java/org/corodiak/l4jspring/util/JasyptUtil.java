package org.corodiak.l4jspring.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.registry.AlgorithmRegistry;

import java.util.Scanner;

public class JasyptUtil {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(AlgorithmRegistry.getAllPBEAlgorithms());
        String key = sc.nextLine();
        String value = sc.nextLine();
        String algo = sc.nextLine();
        //PBEWithMD5AndTripleDES
        //PBEWithSHA256And128BitAES-CBC-BC


        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        encryptor.setProvider(new BouncyCastleProvider());
        encryptor.setPoolSize(2);
        encryptor.setPassword(key);
        encryptor.setAlgorithm(algo);

        String enc = encryptor.encrypt(value);
        System.out.println(enc);
        System.out.println(encryptor.decrypt(enc));
    }
}
