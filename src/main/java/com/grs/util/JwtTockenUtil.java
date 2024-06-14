package com.grs.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.function.Function;

@Component
public class JwtTockenUtil {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    public String generateToken(UserDetails userDetails) {
      return  Jwts.builder().setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();

    }

    public Boolean validateToken(String token, UserDetails userDetails) {
       String username=getUserNameFromToken(token);

        return  (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    public String getUserNameFromToken(String token) {
        return getClaimFromTocken(token,Claims::getSubject);
    }

    public <T> T getClaimFromTocken(String token, Function<Claims,T> claimsRes) {
        Claims claims =getAllClaimsFromToken(token);
        return claimsRes.apply(claims);
    }

    public Claims getAllClaimsFromToken(String token) {
       return   Jwts.parser().setSigningKey(secret).parseClaimsJwt(token).getBody();
    }
    public Boolean isTokenExpired(String token){
        Date exp=getClaimFromTocken(token,Claims::getExpiration);
        return exp.before(new Date());

    }
}
