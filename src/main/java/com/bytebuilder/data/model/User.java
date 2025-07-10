package com.bytebuilder.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class User {

    private String name;
    private String email;
    private String password;
    private List<Journey> routesHistory = new ArrayList<Journey>();
}
