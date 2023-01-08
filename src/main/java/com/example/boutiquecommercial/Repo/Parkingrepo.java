package com.example.boutiquecommercial.Repo;

import com.example.boutiquecommercial.Entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Parkingrepo extends JpaRepository <Parking, Integer> {

}
