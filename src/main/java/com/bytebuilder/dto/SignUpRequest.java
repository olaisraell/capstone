package com.bytebuilder.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SignUpRequest {
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @Email
    private String email;
//    @NotNull
//    @Size(min = 6, max = 20)
//    private String password;
}
