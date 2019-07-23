package org.lucasluo.ironman.user.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.lucasluo.ironman.user.model.User;

public class UserUtils {

    private static final RandomNumberGenerator randomNumberGenerator;
    private static final String algorithm = "md5";
    private static final int hashIteration = 2;

    static {
        randomNumberGenerator = new SecureRandomNumberGenerator();
    }

    public static void signPassword(User user) {

        String salt = randomNumberGenerator.nextBytes().toHex();
        user.setSalt(salt);
        String newPassword = new SimpleHash(algorithm, user.getPassword(),
            ByteSource.Util.bytes(user.getCredentialsSalt()), 2).toHex();
        user.setPassword(newPassword);
    }

    public static String getSignedPassword(String username, String password, String salt) {
        return new SimpleHash(algorithm, password,
            ByteSource.Util.bytes(username + salt), 2).toHex();
    }
}
