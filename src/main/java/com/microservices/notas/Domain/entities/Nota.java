package com.microservices.notas.Domain.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "notas")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Nota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 8)
    private Integer idNotaAcad;

    @Column(name = "nota_academica",length = 2, nullable = false)
    private String notaAcad;


    @JoinColumn( name = "idEstudiante",
            foreignKey = @ForeignKey(name = "FK_Nota_Estudiante"),
            nullable = false)
    private  Integer idEstudiante;


    @JoinColumn(name = "idCurso",
            foreignKey = @ForeignKey(name = "FK_Nota_Curso"),
            nullable = false)
    private Integer idCurso;

    @ManyToOne
    @JoinColumn(name = "idBimestre",
            foreignKey = @ForeignKey(name = "FK_Nota_Bimestre")
            , nullable = false)
    private  Bimestre idBimestre;
}
