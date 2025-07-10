package com.bytebuilder.service;

import com.bytebuilder.data.model.Journey;
import com.bytebuilder.data.model.Route;
import com.bytebuilder.data.model.Trip;
import com.bytebuilder.data.model.User;
import com.bytebuilder.data.repository.RouteRepository;
import com.bytebuilder.data.repository.UserRepository;
import com.bytebuilder.dto.CreateRouteResponse;
import com.bytebuilder.dto.NavigateRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<CreateRouteResponse> navigate(NavigateRequest request) {

        System.out.println("900");
        Route startRoute = getRouteClosestTo(request.getStartLat(),request.getStartLong());
       Route stopRoute = getRouteEndingTo(request.getStopLat(),request.getStopLong());

        List<Route> cheapestPath = findShortestPathBySteps(startRoute.getStart(),stopRoute.getEnd());
//        User user = userRepository.findByEmail(request.getEmail());
//        Trip trip = modelMapper.map(request, Trip.class);
//        Journey journey = new Journey(cheapestPath,trip);
//        List<Journey> history = user.getRoutesHistory();
//        history.add(journey);
//        user.setRoutesHistory(history);
//        userRepository.save(user);
//        if(cheapestPath.size()>3)return new ArrayList<>();
        return map(cheapestPath);

    }

    private List<CreateRouteResponse> map(List<Route> cheapestPath) {

        List<CreateRouteResponse> routeResponses = new ArrayList<>();
        for (Route route : cheapestPath) {

            routeResponses.add(modelMapper.map(route, CreateRouteResponse.class));
        }

        return routeResponses;
    }

    public List<Route> findShortestPathBySteps(String start, String end) {
        List<Route> allRoutes = routeRepository.findAll();

        Map<String, List<Route>> graph = new HashMap<>();
        for (Route route : allRoutes) {
            graph.computeIfAbsent(route.getStart(), k -> new ArrayList<>()).add(route);
        }

        Queue<String> queue = new LinkedList<>();
        Map<String, Route> cameFrom = new HashMap<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            if (current.equals(end)) {
                break;
            }

            List<Route> neighbors = graph.getOrDefault(current, new ArrayList<>());
            for (Route route : neighbors) {
                String next = route.getEnd();
                if (!visited.contains(next)) {
                    visited.add(next);
                    cameFrom.put(next, route);
                    queue.add(next);
                }
            }
        }

        List<Route> path = new LinkedList<>();
        String step = end;
        while (cameFrom.containsKey(step)) {
            Route route = cameFrom.get(step);
            path.add(0, route);
            step = route.getStart();
        }

        if (!step.equals(start)) {
            return Collections.emptyList();
        }

        return path;
    }





    private Route getRouteEndingTo(double startLat, double startLong) {

        ArrayList<Double> distances = new ArrayList<>();
        routeRepository.findAll().forEach(route -> {
            distances.add(calculateDistance(startLat,startLong,route.getEndLat(),route.getEndLong()));
        });
        double min = distances.stream().min(Double::compareTo).orElseThrow();
        int indexRoute = distances.indexOf(min);
        return (Route) routeRepository.findAll().toArray()[indexRoute];
    }

    private Route getRouteClosestTo(double startLat, double startLong) {

        ArrayList<Double> distances = new ArrayList<>();
        routeRepository.findAll().forEach(route -> {
            distances.add(calculateDistance(startLat,startLong,route.getStartLat(),route.getStartLong()));
        });
        double min = distances.stream().min(Double::compareTo).orElseThrow();
        int indexRoute = distances.indexOf(min);
        return (Route) routeRepository.findAll().toArray()[indexRoute];
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {

        double EARTH_RADIUS_KM = 6371;

        double lat1Rad = Math.toRadians(lat1);
        double lat2Rad = Math.toRadians(lat2);
        double deltaLat = Math.toRadians(lat2 - lat1);
        double deltaLon = Math.toRadians(lon2 - lon1);


        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS_KM * c;
    }

    static class RouteNode {
        String name;
        double cost;

        RouteNode(String name, double cost) {
            this.name = name;
            this.cost = cost;
        }
    }
}

