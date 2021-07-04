package ru.rodionov.energo.repository.rdbms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.rodionov.energo.repository.api.exception.RepositoryException;
import ru.rodionov.energo.repository.api.model.Contract;
import ru.rodionov.energo.repository.api.service.ContractService;
import ru.rodionov.energo.repository.rdbms.converter.Converter;
import ru.rodionov.energo.repository.rdbms.domain.ContractDB;
import ru.rodionov.energo.repository.rdbms.repo.ContractRepo;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractServiceRDBMS implements ContractService {
    private final ContractRepo contractRepo;
    private final Converter<Contract, ContractDB> converter;

    @Override
    public List<Contract> findPaginated(Pageable pageable) {
        return contractRepo.findAll(pageable).stream()
                .map(converter::fromDB)
                .collect(Collectors.toList());
    }

    @Override
    public Contract get(String id) {
        ContractDB contractDB = contractRepo.findById(id)
                .orElseThrow(() -> new RepositoryException("Не найден контракт с id = '" + id + "'"));
        return converter.fromDB(contractDB);
    }

    @Override
    public void save(Contract contract, boolean updating) {
        contractRepo.save(converter.toDB(contract, updating));
    }
}
