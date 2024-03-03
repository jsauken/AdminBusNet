package com.example.adminbusnet.service;

import com.example.adminbusnet.DTO.RouteDTO;
import com.example.adminbusnet.exception.ResourceNotFoundException;
import com.example.adminbusnet.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<RouteDTO> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Optional<RouteDTO> getRouteById(Long id) {
        return routeRepository.findById(id);
    }

    public RouteDTO createRoute(RouteDTO route) {
        return routeRepository.save(route);
    }

    public RouteDTO updateRoute(Long id, RouteDTO routeDetails) {
        Optional<RouteDTO> optionalRoute = routeRepository.findById(id);
        if (optionalRoute.isPresent()) {
            RouteDTO existingRoute = optionalRoute.get();
            existingRoute.setOrigin(routeDetails.getOrigin());
            existingRoute.setDestination(routeDetails.getDestination());
            existingRoute.setDistance(routeDetails.getDistance());
            existingRoute.setStatus(routeDetails.getStatus());
            return routeRepository.save(existingRoute);
        } else {
            throw new ResourceNotFoundException("Route not found with id: " + id);
        }
    }

    public void deleteRoute(Long id) {
        if (routeRepository.existsById(id)) {
            routeRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Route not found with id: " + id);
        }
    }
}
