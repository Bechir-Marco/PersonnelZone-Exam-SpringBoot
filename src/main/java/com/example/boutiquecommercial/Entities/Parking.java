package com.example.boutiquecommercial.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Parking implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    Long id ;
    String designation;
    String adresse;
    int capacite;

    @OneToMany(mappedBy = "parking",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Zone> zoneList;

}
