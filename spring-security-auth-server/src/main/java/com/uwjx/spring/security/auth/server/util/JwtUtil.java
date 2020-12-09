package com.uwjx.spring.security.auth.server.util;

import com.alibaba.fastjson.JSON;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Slf4j
public class JwtUtil {

    public static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String createAccesstoken(UserDetails userDetails){
        long now = System.currentTimeMillis();
        return Jwts.builder()
                .setId("sjw")
                .claim("authorities" , userDetails.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(toList()))
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(now + 1000 * 60 * 10))
                .signWith(key , SignatureAlgorithm.HS256)
                .compact();

    }

//    public String createAccesstoken(){
//        long now = System.currentTimeMillis();
//        return Jwts.builder()
//                .setId("idididi")
//                .claim("clm" , "claimsssss")
//                .setSubject("subject")
//                .setIssuedAt(new Date())
//                .setExpiration(new Date(now + 1000 * 60 * 10))
//                .signWith(key , SignatureAlgorithm.HS256)
//                .compact();
//
//    }

    public static void main(String[] args) {
        JwtUtil jwtUtil = new JwtUtil();

        String username = "wanghuan";
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("worker"));
        authorities.add(new SimpleGrantedAuthority("user"));
        authorities.add(new SimpleGrantedAuthority("delete"));
        User user = new User(username , "" , authorities);

        String accesstoken = jwtUtil.createAccesstoken(user);
        log.warn("accesstoken -> {}" , accesstoken);

        Claims claims = Jwts.parserBuilder().setSigningKey(JwtUtil.key).build()
                .parseClaimsJws(accesstoken)
                .getBody();
        log.info("claims -> {}" , JSON.toJSONString(claims));

    }
}
