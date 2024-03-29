package com.github.kop.bbs.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class JwtTokenUtil {

  public final long jwtTokenValidity;
  private final String secret;

  public JwtTokenUtil(long expireSec, String secret) {
    jwtTokenValidity = expireSec;
    this.secret = secret;
  }

  public String getUserId(String token) {
    return getClaimFromToken(token, Claims::getSubject);
  }

  public Date getExpirationDateFromToken(String token) {
    return getClaimFromToken(token, Claims::getExpiration);
  }

  public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
    final Claims claims = getAllClaimsFromToken(token);
    return claimsResolver.apply(claims);
  }

  private Claims getAllClaimsFromToken(String token) {
    JwtParser build =
        Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(secret.getBytes())).build();
    return build.parseClaimsJws(token).getBody();
  }

  private Boolean isTokenExpired(String token) {
    final Date expiration = getExpirationDateFromToken(token);
    return expiration.before(new Date());
  }

  // generate token for user
  public String generateToken(Long userId) {
    Map<String, Object> claims = new HashMap<>();
    return doGenerateToken(claims, userId.toString());
  }

  private String doGenerateToken(Map<String, Object> claims, String subject) {
    return Jwts.builder()
        .setClaims(claims)
        .setSubject(subject)
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + jwtTokenValidity * 1000))
        // 自定义的secret长度不够,暂时注释
        .signWith(Keys.hmacShaKeyFor(secret.getBytes()), SignatureAlgorithm.HS512)
        //            .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS512))
        .compact();
  }

  public Boolean validateToken(String token) {
    return !isTokenExpired(token);
  }
}
