package ru.rodionov.energo.repository.rdbms.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;
import ru.rodionov.energo.repository.api.model.Contract;
import ru.rodionov.energo.repository.rdbms.domain.ContractDB;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class ContractResponseBuilder implements ResponseBuilder<Contract, ContractDB> {

    private final Converter<Contract, ContractDB> converter;

    @Override
    public Page<Contract> buildPageResponse(Page<ContractDB> entityPage) {
        List<Contract> contracts = entityPage.stream()
                .map(converter::fromDB)
                .collect(toList());
        return new PageImpl<>(contracts, entityPage.getPageable(), entityPage.getTotalElements());
    }
}
