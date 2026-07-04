package com.cognizant.spring_learn.controller;

import java.util.Base64;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public String authenticate(HttpServletRequest request) {

        String authHeader = request.getHeader("Authorization");

        System.out.println("Authorization Header: " + authHeader);

        String encodedCredentials = authHeader.substring(6);

        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);

        String credentials = new String(decodedBytes);

        System.out.println("Decoded Credentials: " + credentials);

        String username = credentials.split(":")[0];

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS256, "secretkey")
                .compact();

        return "{\"token\":\"" + token + "\"}";
    }
}