package com.example.adminbusnet.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
/*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bus_station_id")
    private BusStation busStation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "start_point_id")
    private BusStation startPoint;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "end_point_id")
    private BusStation endPoint;

    @ManyToOne
    @JoinColumn(name = "bus_station_id")
    private BusStation busStation;
*/
    private double startLatitude; // latitude of start point
    private double startLongitude; // longitude of start point

    private double endLatitude; // latitude of end point
    private double endLongitude; // longitude of end point
}
