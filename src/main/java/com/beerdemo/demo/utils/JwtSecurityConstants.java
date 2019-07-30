package com.beerdemo.demo.utils;

import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;

import static io.jsonwebtoken.security.Keys.secretKeyFor;

public final class JwtSecurityConstants {

    public static final SecretKey SECRET = secretKeyFor(SignatureAlgorithm.HS256);

//    static {
//        SECRET = secretKeyFor(SignatureAlgorithm.HS256);
//    }

    private JwtSecurityConstants() {
        throw new IllegalStateException("Cannot create instance of static util class");
    }
}
