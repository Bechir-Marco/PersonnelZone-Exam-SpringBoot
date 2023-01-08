package com.example.boutiquecommercial.Serv;

import com.example.boutiquecommercial.Entities.Parking;
import com.example.boutiquecommercial.Entities.Personnel;
import com.example.boutiquecommercial.Entities.Poste;
import com.example.boutiquecommercial.Entities.Zone;
import com.example.boutiquecommercial.Repo.Parkingrepo;
import com.example.boutiquecommercial.Repo.PersonnelRepo;
import com.example.boutiquecommercial.Repo.ZoneRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServImp  {

    @Autowired
    Parkingrepo parkingrepo;
    @Autowired
    PersonnelRepo personnelRepo;
    @Autowired
    ZoneRepo zoneRepo;

   public Personnel ajouterPersonnel(Personnel personnel) {
      return   personnelRepo.save(personnel);
    }

    public void affecterPersonnelZone (int idzone, int idGarde){
        Personnel personnel = personnelRepo.findById(idGarde).orElse(null);
        Zone zone =zoneRepo.findById(idzone).orElse(null);
        assert zone != null;
        zone.getPersonnelGardes().add(personnel);
        zoneRepo.save(zone);
        }

    public void ajoutParkingetZones(Parking parking){
       parkingrepo.save(parking);
    }
    public List<Personnel> getAllPersonnelByParking (Parking parking){
        List<Zone> zones = zoneRepo.findZoneByParking(parking);
        List <Personnel> newp = new ArrayList<>();
        List <Personnel> personnels = personnelRepo.findAll();
            for (Zone z: zones) {
                for (Personnel p : personnels
                ) {
                    newp.add(p);
                }
            }
        return newp;
    }
   public Integer nombreGardeJour (String adress) {
        Zone z = zoneRepo.findZoneByParkingAdresse(adress);
        int res =0;

            for (Personnel personnel: z.getPersonnelGardes()){
                if (personnel.getPoste().equals(Poste.GARDE_JOUR)) {
                    res+=1;
                }
            }

        return res;
    }
    public List <Personnel> getPersonaByDate (Date db, Date df){
       return personnelRepo.findPersonnelsByDateDeRecBetween(db, df);
    }
    @Scheduled(fixedRate = 2000)
    public void getNbrGardesbyZone () {
       List<Zone> zones = zoneRepo.findAll();
       int nb =0;
       for (Zone zone: zones){
           nb= 0;
           for (Personnel p: zone.getPersonnelGardes()){
               if (p.getPoste().equals(Poste.GARDE_JOUR)){
                nb++;

               }
           }
           log.info("nb " +nb);

       }
    }
}
