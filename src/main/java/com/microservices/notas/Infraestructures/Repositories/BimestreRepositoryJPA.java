package com.microservices.notas.Infraestructures.Repositories;

import com.microservices.notas.Domain.entities.Bimestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BimestreRepositoryJPA extends JpaRepository<Bimestre,Integer> {
}
