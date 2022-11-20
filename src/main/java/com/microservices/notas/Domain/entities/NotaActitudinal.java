package com.microservices.notas.Domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "notasActitudinales")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NotaActitudinal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 8)
    private Integer idNotaAct;

    @Column(name = "nota_actitudinal",length = 2, nullable = false)
    @Size(min = 1, max = 2,message = "nota no valida")
    private String notaAct;


    @JoinColumn( name = "idEstudiante",
            foreignKey = @ForeignKey(name = "FK_NotaActitudinal_Estudiante"),
            nullable = false)
    private  Integer idEstudiante;

    @OneToOne
    @JoinColumn(name = "idBimestre",
            foreignKey = @ForeignKey(name = "FK_NotaActitudinal_Bimestre"),
            nullable = false)
    private  Bimestre idBimestre;
}
