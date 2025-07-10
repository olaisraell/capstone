//package com.bytebuilder.util;
//
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//
//@Component
//public class JwtService {
//    private final String SECRET_KEY = "your-256-bit-secret-your-256-bit-secret"; // must be 256 bits (32+ characters)
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15)) // 15 mins
//                .signWith(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()), SignatureAlgorithm.HS256)
//                .compact();
//    }
//
//    public String extractUsername(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//    }
//
//    public boolean isTokenValid(String token, String expectedUsername) {
//        final String actualUsername = extractUsername(token);
//        Date expiration = Jwts.parserBuilder()
//                .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes()))
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getExpiration();
//        return actualUsername.equals(expectedUsername) && expiration.after(new Date());
//    }
//}
//
