package com.bytebuilder.controller;

import com.bytebuilder.data.model.User;
import com.bytebuilder.data.repository.UserRepository;
import com.bytebuilder.dto.LoginRequest;
import com.bytebuilder.dto.LoginResponse;
import com.bytebuilder.dto.SignUpRequest;
import com.bytebuilder.service.UserService;
//import com.bytebuilder.util.JwtService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

//    @Autowired
//    private JwtService jwtService;

    @PostMapping("/signUp")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest signUpRequest) {

        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(userService.register(signUpRequest));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
//
//        User user = userRepository.findByEmail(request.getEmail());
//
//        if (user != null && user.getPassword().equals(request.getPassword())) {
//            String token = jwtService.generateToken(request.getEmail());
//            return ResponseEntity.ok(new LoginResponse(token));
//        }
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
//    }

//    @GetMapping("/secure")
//    public ResponseEntity<?> secureEndpoint() {
//        return ResponseEntity.ok("You are authenticated!");
//    }
}


