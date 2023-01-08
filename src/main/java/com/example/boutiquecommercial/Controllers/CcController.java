package com.example.boutiquecommercial.Controllers;

import com.example.boutiquecommercial.Entities.Parking;
import com.example.boutiquecommercial.Entities.Personnel;
import com.example.boutiquecommercial.Serv.ServImp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Cc")
public class CcController  {
      private final ServImp serv;

        @PostMapping("/ajouterPersonnel")
      Personnel ajouterPersonnel(@RequestBody Personnel personnel) {
        return  serv.ajouterPersonnel(personnel);
    }
    @PostMapping("/ajoutParkingetZones")
    public void ajoutParkingetZones(@RequestBody Parking parking){
             serv.ajoutParkingetZones(parking);
    }
    @GetMapping("/getAllPersonnelByParking")
    public List<Personnel> getAllPersonnelByParking (@RequestBody Parking parking){
          return   serv.getAllPersonnelByParking(parking);
    }
    @PutMapping("/affecterPersonnelZone")
    public void affecterPersonnelZone (@RequestParam int idzone, int idGarde){
            serv.affecterPersonnelZone(idzone, idGarde);
    }
    @GetMapping("/nombreGardeJour")
    public Integer nombreGardeJour (@RequestParam String adress) {
        return serv.nombreGardeJour(adress);
    }
    @GetMapping("/getPersonaByDate")
    public List <Personnel> getPersonaByDate (@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd")Date db, @DateTimeFormat(pattern = "yyyy-MM-dd") Date df){
            return serv.getPersonaByDate(db, df);
    }

}
