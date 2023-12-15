package com.hehmdalolkek.spring.ordermanagerback.controller;


import com.hehmdalolkek.spring.ordermanagerback.security.LoginRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.crypto.SecretKey;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class SecurityRestController {

    private final static SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        if (loginRequest.getUsername().equals("admin") && loginRequest.getPassword().equals("admin")) {
            String token = Jwts.builder()
                    .setSubject(loginRequest.getUsername())
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
            return ResponseEntity.ok().body(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
