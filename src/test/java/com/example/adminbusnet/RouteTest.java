package com.example.adminbusnet;

import com.example.adminbusnet.DTO.RouteDTO;
import com.example.adminbusnet.repository.RouteRepository;
import com.example.adminbusnet.service.RouteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;

@DataJpaTest
public class RouteTest {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteService routeService;

    @Test
    public void SaveRoute(){
        // Create a route
        RouteDTO route = new RouteDTO();
        route.setOrigin("Origin");
        route.setDestination("Destination");
        route.setDistance(100.0);
        route.setStatus("Active");

        // Save the route
        RouteDTO savedRoute = routeService.createRoute(route);

        // Check if the route was saved successfully
        Assertions.assertNotNull(savedRoute.getId());
    }

    @Test
    public void GetRoute(){
        // Create a route
        RouteDTO route = new RouteDTO();
        route.setOrigin("Origin");
        route.setDestination("Destination");
        route.setDistance(100.0);
        route.setStatus("Active");

        // Save the route
        RouteDTO savedRoute = routeRepository.save(route);

        // Retrieve the route by ID
        RouteDTO retrievedRoute = routeService.getRouteById(savedRoute.getId()).orElse(null);

        // Check if the retrieved route matches the saved route
        Assertions.assertNotNull(retrievedRoute);
        Assertions.assertEquals(savedRoute.getId(), retrievedRoute.getId());
        Assertions.assertEquals(savedRoute.getOrigin(), retrievedRoute.getOrigin());
        Assertions.assertEquals(savedRoute.getDestination(), retrievedRoute.getDestination());
        Assertions.assertEquals(savedRoute.getDistance(), retrievedRoute.getDistance());
        Assertions.assertEquals(savedRoute.getStatus(), retrievedRoute.getStatus());
    }
    //Routes
    @Test
    public void GetRoutes() {
        // Create some routes
        RouteDTO route1 = new RouteDTO();
        route1.setOrigin("Origin1");
        route1.setDestination("Destination1");
        route1.setDistance(100.0);
        route1.setStatus("Active");

        RouteDTO route2 = new RouteDTO();
        route2.setOrigin("Origin2");
        route2.setDestination("Destination2");
        route2.setDistance(200.0);
        route2.setStatus("Active");

        routeRepository.save(route1);
        routeRepository.save(route2);

        // Retrieve all routes
        List<RouteDTO> routes = routeService.getAllRoutes();

        // Check if routes are retrieved successfully
        Assertions.assertEquals(2, routes.size());
    }

    @Test
    public void DeleteRoute() {
        // Create a route
        RouteDTO route = new RouteDTO();
        route.setOrigin("Origin");
        route.setDestination("Destination");
        route.setDistance(100.0);
        route.setStatus("Active");

        // Save the route
        RouteDTO savedRoute = routeRepository.save(route);

        // Delete the route
        routeService.deleteRoute(savedRoute.getId());

        // Check if the route is deleted successfully
        List<RouteDTO> routes = routeService.getAllRoutes();
        Assertions.assertEquals(0, routes.size());
    }
}
