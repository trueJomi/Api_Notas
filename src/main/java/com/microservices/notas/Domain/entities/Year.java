package com.microservices.notas.Domain.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "year")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 8)
    private Integer idYear;

    @Column(name = "year",length = 4,unique = true)
    private  Integer year;

    @OneToMany(mappedBy = "idBimestre",cascade = {CascadeType.ALL})
    List<Bimestre> bimestres;
}
