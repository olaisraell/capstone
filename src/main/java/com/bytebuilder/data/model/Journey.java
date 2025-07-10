package com.bytebuilder.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Journey {
    private List<Route> route;
    private Trip trip;
}
