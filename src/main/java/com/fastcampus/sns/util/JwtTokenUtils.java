package com.fastcampus.sns.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.MacAlgorithm;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtils {

    public static String generateToken(String userName, String key, long expiredTimeMs) {

        SecretKey secretKey = getKey(key); // 키 생성
        MacAlgorithm alg = Jwts.SIG.HS256;

        return Jwts.builder()
                .claims(createClaims(userName))
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiredTimeMs))
                .signWith(secretKey, alg)
                .compact();
    }

    public static String getUserName(String token, String key) {
        return extractClaims(token, key).get("userName", String.class);
    }

    public static boolean isExpired(String token, String key) {
        Date expiredDate = extractClaims(token, key).getExpiration();
        return expiredDate.before(new Date());
    }

    private static Map<String, Object> createClaims(String userName) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("userName", userName);
        return claims;
    }

    private static SecretKey getKey(String key) {
        byte[] keyBytes = key.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private static Claims extractClaims(String token, String key) {
        return Jwts.parser().verifyWith(getKey(key)).build().parseSignedClaims(token).getPayload();
    }

}
