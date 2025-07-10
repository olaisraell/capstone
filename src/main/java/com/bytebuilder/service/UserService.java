package com.bytebuilder.service;

import com.bytebuilder.dto.SignUpRequest;
import com.bytebuilder.dto.SignUpResponse;

public interface UserService {
    SignUpResponse register(SignUpRequest signUpRequest);
}
