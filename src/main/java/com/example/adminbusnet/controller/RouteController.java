package com.example.adminbusnet.controller;
import com.example.adminbusnet.DTO.RouteDTO;
import com.example.adminbusnet.exception.ResourceNotFoundException;
import com.example.adminbusnet.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteRepository routeRepository;

    @GetMapping
    public List<RouteDTO> getAllRoutes() {
        return routeRepository.findAll();
    }

    @PostMapping
    public RouteDTO createRoute(@RequestBody RouteDTO route) {
        return routeRepository.save(route);
    }

    @GetMapping("/{id}")
    public RouteDTO getRouteById(@PathVariable Long id) {
        return routeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + id));
    }

    @PutMapping("/{id}")
    public RouteDTO updateRoute(@PathVariable Long id, @RequestBody RouteDTO routeDetails) {
        RouteDTO route = routeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + id));

        route.setOrigin(routeDetails.getOrigin());
        route.setDestination(routeDetails.getDestination());
        route.setDistance(routeDetails.getDistance());
        route.setStatus(routeDetails.getStatus());

        return routeRepository.save(route);
    }

    @DeleteMapping("/{id}")
    public void deleteRoute(@PathVariable Long id) {
        RouteDTO route = routeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + id));

        routeRepository.delete(route);
    }
}
