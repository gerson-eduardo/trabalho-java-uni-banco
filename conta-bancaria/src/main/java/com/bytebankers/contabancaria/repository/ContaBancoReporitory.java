package com.bytebankers.contabancaria.repository;

import com.bytebankers.contabancaria.model.ContaBanco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaBancoReporitory extends JpaRepository<ContaBanco, Integer> {
    ContaBanco save(ContaBanco conta);
    Optional<ContaBanco> findByNumconta(int id);
}
