package com.lucasluo.ironman.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class JwtUtils {

    private static final long EXPIRE_TIME = 24 * 60 * 30 * 1000;

    public static boolean verify(String token, String username, String password) {
        boolean result = true;
        try {
            Algorithm algorithm = Algorithm.HMAC256(password);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("username", username).build();
            DecodedJWT jwt = verifier.verify(token);
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public static String getUserName(String token) {
        String result = null;
        try {
            DecodedJWT jwt = JWT.decode(token);
            result = jwt.getClaim("username").asString();
        } catch (Exception e) {

        }
        return result;
    }

    public static String sign(String username, String password) {
        String result = null;
        try {
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(password);
            result = JWT.create()
                .withClaim("username", username)
                .withExpiresAt(date)
                .sign(algorithm);
        } catch (UnsupportedEncodingException e) {

        }
        return result;
    }
}
