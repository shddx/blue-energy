package ru.rodionov.energo.repository.api.service;

import ru.rodionov.energo.repository.api.exception.RepositoryException;
import ru.rodionov.energo.repository.api.model.Contract;

import java.util.List;

public interface ContractService {
    Contract get(String id) throws RepositoryException;

    void save(Contract contract, boolean updating);

    List<Contract> getAll();
}
