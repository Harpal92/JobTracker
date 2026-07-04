package com.jobtracker.jobtracker;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
  private final Key key=  Keys.secretKeyFor(SignatureAlgorithm.HS256);
  public String genearteToken(String email){
    return Jwts.builder()
    .setSubject(email)
    .setIssuedAt(new Date())
    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
    .signWith(key)
    .compact();

  }
  public  String extractEmail(String Token){
    return Jwts.parserBuilder()
          .setSigningKey(key)
          .build()
          .parseClaimsJws(Token)
          .getBody()
          .getSubject();
          
  }
  public boolean validateToken(String Token){
    try {
         extractEmail(Token);
            return true;
    } catch (Exception e) {
        return false;
    }
  }

}
