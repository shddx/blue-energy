package ru.rodionov.energo.repository.api.service;

import ru.rodionov.energo.repository.api.exception.RepositoryException;
import ru.rodionov.energo.repository.api.model.Contract;

public interface ContractService {
    Contract get(String id) throws RepositoryException;
}
