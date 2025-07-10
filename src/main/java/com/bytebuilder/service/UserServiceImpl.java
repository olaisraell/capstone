package com.bytebuilder.service;

import com.bytebuilder.data.model.User;
import com.bytebuilder.data.repository.UserRepository;
import com.bytebuilder.dto.SignUpRequest;
import com.bytebuilder.dto.SignUpResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public SignUpResponse register(SignUpRequest signUpRequest) {

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new IllegalArgumentException("Email address already in use");
        }

        User user = modelMapper.map(signUpRequest, User.class);
        userRepository.save(user);
        return modelMapper.map(user, SignUpResponse.class);
    }
}
