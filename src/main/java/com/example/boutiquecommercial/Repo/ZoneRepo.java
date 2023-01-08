package com.example.boutiquecommercial.Repo;

import com.example.boutiquecommercial.Entities.Parking;
import com.example.boutiquecommercial.Entities.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepo extends JpaRepository<Zone, Integer> {
    List<Zone> findZoneByParking(Parking parking);
   Zone findZoneByParkingAdresse(String adresse);
}
