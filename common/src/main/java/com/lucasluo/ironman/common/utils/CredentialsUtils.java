package com.lucasluo.ironman.common.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class CredentialsUtils {

    private static final RandomNumberGenerator randomNumberGenerator;
    private static final String algorithm = "md5";
    private static final int hashIteration = 2;

    static {
        randomNumberGenerator = new SecureRandomNumberGenerator();
    }

    public static String generateSalt() {
        return randomNumberGenerator.nextBytes().toHex();
    }

    public static String encryptPassword(String salt, String username, String password) {
        String encryptPassword = new SimpleHash(algorithm, password,
            ByteSource.Util.bytes(username + salt), hashIteration).toHex();
        return encryptPassword;
    }
}
