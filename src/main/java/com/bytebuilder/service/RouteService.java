package com.bytebuilder.service;

import com.bytebuilder.dto.CreateRouteResponse;
import com.bytebuilder.dto.NavigateRequest;

import java.util.List;

public interface RouteService {

    List<CreateRouteResponse> navigate(NavigateRequest request);
}
