package com.bytebuilder.data.model;

import lombok.Data;

@Data
public class Trip {
    private String startName;
    private String stopName;
    private double startLat;
    private double startLong;
    private double stopLat;
    private double stopLong;
    private String email;

}


