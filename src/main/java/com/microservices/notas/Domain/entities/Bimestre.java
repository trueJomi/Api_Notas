package com.microservices.notas.Domain.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "bimestres")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Bimestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 8)
    private Integer idBimestre;

    @Column(name = "bimestre",length = 1, nullable = false)
    private Integer bimestre;

    @ManyToOne
    @JoinColumn(name = "idYear",
            foreignKey = @ForeignKey(name = "FK_Bimestre_Year"),
            nullable = false)
    private  Year idYear;
}
