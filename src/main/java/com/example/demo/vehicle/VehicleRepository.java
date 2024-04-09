package com.example.demo.vehicle;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

}
