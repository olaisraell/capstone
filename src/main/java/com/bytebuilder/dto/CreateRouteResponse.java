package com.bytebuilder.dto;


import lombok.Data;

@Data
public class CreateRouteResponse {

    private String start;
    private String end;
    private String vehicle;
    private String weather;
    private String time;
    private int crowd;
    private double startLong;
    private double startLat;
    private double endLong;
    private double endLat;
    private String price;
}
