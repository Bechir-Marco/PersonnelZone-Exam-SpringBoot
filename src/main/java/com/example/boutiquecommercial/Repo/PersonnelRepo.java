package com.example.boutiquecommercial.Repo;


import com.example.boutiquecommercial.Entities.Personnel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonnelRepo extends JpaRepository<Personnel, Integer> {
    List<Personnel> findPersonnelsByDateDeRecBetween(Date db, Date df);
}
