package com.bytebuilder.service;

import com.bytebuilder.data.model.Route;
import com.bytebuilder.data.model.Trip;
import com.bytebuilder.data.repository.RouteRepository;
import com.opencsv.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

@SpringBootTest
public class Test {

//    @Autowired
//    private RouteRepository routeRepository;
//
//    @org.junit.jupiter.api.Test
//    public void tests(){
//        System.out.println(routeRepository.count());
//    }
//
//    @org.junit.jupiter.api.Test
//    public void test() {
//        try (FileReader reader = new FileReader("C:\\Users\\nzigw\\Downloads\\java_joints - Sheet1 (1).csv")) {
//            CsvToBean<Route> csvToBean = new CsvToBeanBuilder<Route>(reader)
//                    .withType(Route.class)
//                    .withIgnoreLeadingWhiteSpace(true)
//                    .build();
//
//            List<Route> trips = csvToBean.parse();
//
//            for (Route route : trips) {
//                System.out.println(route);
//                routeRepository.save(route);
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//    }

}


