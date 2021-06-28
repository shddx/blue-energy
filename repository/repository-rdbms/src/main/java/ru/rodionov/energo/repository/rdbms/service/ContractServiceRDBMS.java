package ru.rodionov.energo.repository.rdbms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rodionov.energo.repository.rdbms.converter.Converter;
import ru.rodionov.energo.repository.rdbms.domain.ContractDB;
import ru.rodionov.energo.repository.rdbms.repo.ContractRepo;
import ru.rodionov.energo.repository.api.exception.RepositoryException;
import ru.rodionov.energo.repository.api.model.Contract;
import ru.rodionov.energo.repository.api.service.ContractService;

@Service
@RequiredArgsConstructor
public class ContractServiceRDBMS implements ContractService {
    private final ContractRepo contractRepo;
    private final Converter<Contract, ContractDB> converter;

    @Override
    public Contract get(String id) throws RepositoryException {
        ContractDB contractDB = contractRepo.findById(id)
                .orElseThrow(() -> new RepositoryException("Не найден контракт с id = '" + id + "'"));
        return converter.fromDB(contractDB);
    }
}
