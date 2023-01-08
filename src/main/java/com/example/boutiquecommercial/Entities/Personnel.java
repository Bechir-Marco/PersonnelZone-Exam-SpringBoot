package com.example.boutiquecommercial.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Personnel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
    int id;
    String nom;
    String prenom;
    int age;
    @Temporal(TemporalType.DATE)
    Date dateDeRec;
    String login;
    String password;
    @Enumerated(EnumType.STRING)
    Poste poste;

    @OneToOne(mappedBy = "personnelResponsable")
    Zone zone;
}
