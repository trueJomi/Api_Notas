package com.microservices.notas.Domain.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "notas_competencia")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class NotaCompetencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 8)
    private Integer idNotaComp;

    @Column(name = "nota_comp",length = 2)
    private String notaComp;


    @JoinColumn( name = "idEstudiante",
            foreignKey = @ForeignKey(name = "FK_NotaCompetencia_Estudiante"),
            nullable = false)
    private  Integer idEstudiante;


    @JoinColumn(name = "idCompetencia",
            foreignKey = @ForeignKey(name = "FK_NotaCompetencia_Competencia"),
            nullable = false)
    private Integer idCompetencia;

    @ManyToOne
    @JoinColumn(name = "idBimestre",
            foreignKey = @ForeignKey(name = "FK_NotaCompetencia_Bimestre"),
            nullable = false)
    private  Bimestre idBimestre;
}
