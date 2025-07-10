package com.bytebuilder.dto;

import lombok.Data;

@Data
public class NavigateRequest {
    private String startName;
    private double startLat;
    private double startLong;
    private String stopName;
    private double stopLat;
    private double stopLong;
//    private String email;
}
