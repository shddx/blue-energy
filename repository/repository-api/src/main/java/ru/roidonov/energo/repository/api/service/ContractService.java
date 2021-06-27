package ru.roidonov.energo.repository.api.service;

import ru.roidonov.energo.repository.api.exception.RepositoryException;
import ru.roidonov.energo.repository.api.model.Contract;

public interface ContractService {
    Contract get(String id) throws RepositoryException;
}
