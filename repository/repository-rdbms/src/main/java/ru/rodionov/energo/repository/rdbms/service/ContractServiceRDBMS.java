package ru.rodionov.energo.repository.rdbms.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.rodionov.energo.repository.api.exception.RepositoryException;
import ru.rodionov.energo.repository.api.model.Contract;
import ru.rodionov.energo.repository.api.model.ContractSearchParams;
import ru.rodionov.energo.repository.api.service.ContractService;
import ru.rodionov.energo.repository.rdbms.converter.Converter;
import ru.rodionov.energo.repository.rdbms.converter.ResponseBuilder;
import ru.rodionov.energo.repository.rdbms.domain.ContractDB;
import ru.rodionov.energo.repository.rdbms.repo.ContractRepo;
import ru.rodionov.energo.repository.rdbms.search.ContractSpecification;

@Service
@RequiredArgsConstructor
public class ContractServiceRDBMS implements ContractService {
    private final ContractRepo contractRepo;
    private final Converter<Contract, ContractDB> converter;
    private final ResponseBuilder<Contract, ContractDB> responseBuilder;

    @Override
    public Page<Contract> filter(ContractSearchParams searchParams, Pageable pageable) {
        ContractSpecification filter = new ContractSpecification();
        BeanUtils.copyProperties(searchParams, filter);
        Page<ContractDB> page = contractRepo.findAll(filter, pageable);
        return responseBuilder.buildPageResponse(page);
    }

    @Override
    public Page<Contract> findPaginated(Pageable pageable) {
        Page<ContractDB> page = contractRepo.findAll(pageable);
        return responseBuilder.buildPageResponse(page);
    }

    @Override
    public Contract get(String id) {
        ContractDB contractDB = contractRepo.findById(id)
                .orElseThrow(() -> new RepositoryException("Не найден контракт с id = '" + id + "'"));
        return converter.fromDB(contractDB);
    }

    @Override
    @Transactional
    public void save(Contract contract, boolean updating) {
        contractRepo.save(converter.toDB(contract, updating));
    }

    @Override
    @Transactional
    public void delete(String id) {
        contractRepo.deleteById(id);
    }

}
