package com.example.adminbusnet;

import com.example.adminbusnet.DTO.RouteDTO;
import com.example.adminbusnet.repository.RouteRepository;
import com.example.adminbusnet.service.RouteService;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@DataJpaTest
@ComponentScan("com.example.adminbusnet.service")
public class RouteTest {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private RouteService routeService;

    @Test
    public void SaveRoute(){
        // Create a route
        RouteDTO route = new RouteDTO(1L,"Almaty","Astana",1000.0,"Active");

        // Save the route
        RouteDTO savedRoute = routeService.createRoute(route);

        // Check if the route was saved successfully
        Assertions.assertNotNull(savedRoute.getId());
    }

    @Test
    public void GetRoute(){
        // Create a route
        RouteDTO route = new RouteDTO(1L,"Almaty","Astana",1000.0,"Active");

        // Save the route
        RouteDTO savedRoute = routeRepository.save(route);

        // Retrieve the route by ID
        RouteDTO retrievedRoute = routeService.getRouteById(savedRoute.getId()).orElse(null);

        // Check if the retrieved route matches the saved route
        Assertions.assertNotNull(retrievedRoute);
        Assertions.assertEquals(savedRoute, retrievedRoute);
    }
    //Routes
    @Test
    public void GetRoutes() {
        // Create some routes
        RouteDTO route1 = new RouteDTO(1L,"Almaty","Astana",1000.0,"Active");


        RouteDTO route2 = new RouteDTO(2L,"Almaty","Shymkent",2000.0,"Active");

        routeRepository.save(route1);
        routeRepository.save(route2);

        // Retrieve all routes
        List<RouteDTO> routes = routeService.getAllRoutes();

        // Check if routes are retrieved successfully
        Assert.assertNotNull(routeRepository.findAll());
    }

    @Test
    public void DeleteRoute() {
        // Create a route
        RouteDTO route = new RouteDTO(1L,"Almaty","Astana",1000.0,"Active");

        // Save the route
        RouteDTO savedRoute = routeRepository.save(route);

        // Delete the route
        routeService.deleteRoute(savedRoute.getId());

        // Check if the route is deleted successfully
        List<RouteDTO> routes = routeService.getAllRoutes();
        Assertions.assertEquals(0, routes.size());
    }
}
