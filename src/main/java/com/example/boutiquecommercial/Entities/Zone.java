package com.example.boutiquecommercial.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Zone implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType. IDENTITY)
     int id;
    String ref ;
    float dimension;

    @ManyToOne()
    Parking parking;

    @OneToOne()
    Personnel personnelResponsable;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List <Personnel> personnelGardes;
}
