package ru.rodionov.energo.repository.rdbms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rodionov.energo.repository.rdbms.domain.ContractDB;

import java.util.Optional;

public interface ContractRepo extends JpaRepository<ContractDB, String> {
    Optional<ContractDB> findById(String id);
}
