package com.bytebuilder.data.model;
import com.opencsv.bean.CsvBindByName;
import lombok.Data;

@Data
public class Route {

    private String start;
    private String end;
    private String vehicle;
    private String weather;
    private String time;
    private double startLong;
    private double startLat;
    private double endLong;
    private double endLat;
    private String price;
    private double fuel;


    @Override
    public String toString() {
        return "Trip{" +
                "start='" + start  +
                ", end='" + end +
                ", vehicle='" + vehicle +
                ", weather='" + weather +
                ", time='" + time +
                "start long =" + startLong +
                ", start lat =" + startLat +
                ", end long =" + endLong +
                ", end lat =" + endLat +
                ", price =" + price +

                '}';
    }
}
