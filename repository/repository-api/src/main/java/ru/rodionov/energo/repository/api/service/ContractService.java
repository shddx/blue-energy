package ru.rodionov.energo.repository.api.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.rodionov.energo.repository.api.exception.RepositoryException;
import ru.rodionov.energo.repository.api.model.Contract;
import ru.rodionov.energo.repository.api.model.ContractSearchParams;

public interface ContractService {
    Contract get(String id) throws RepositoryException;

    void save(Contract contract, boolean updating);

    Page<Contract> findPaginated(Pageable pageable);

    void delete(String id);

    Page<Contract> filter(ContractSearchParams searchParams, Pageable pageable);
}
