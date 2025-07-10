package com.bytebuilder.controller;

import com.bytebuilder.dto.NavigateRequest;
import com.bytebuilder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/navigate")
@CrossOrigin("*")
public class RouteController {

    @Autowired
    RouteService routeService;

    @PostMapping("/route")
    public ResponseEntity<?> navigate(@RequestBody NavigateRequest request) {
        try{
            return ResponseEntity.ok().body(routeService.navigate(request));
        }
        catch(Exception e){
            return ResponseEntity.ok().body(List.of(1,2,3));
        }
    }
}
