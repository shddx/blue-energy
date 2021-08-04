package ru.rodionov.energo.repository.rdbms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;
import ru.rodionov.energo.repository.rdbms.domain.ContractDB;

@Transactional(readOnly = true)
public interface ContractRepo extends JpaRepository<ContractDB, String>, JpaSpecificationExecutor<ContractDB> {
}
