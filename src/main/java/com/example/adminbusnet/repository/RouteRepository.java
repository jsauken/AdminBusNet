package com.example.adminbusnet.repository;

import com.example.adminbusnet.DTO.RouteDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<RouteDTO, Long> {
}