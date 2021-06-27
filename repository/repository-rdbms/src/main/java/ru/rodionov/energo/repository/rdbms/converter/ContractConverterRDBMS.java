package ru.rodionov.energo.repository.rdbms.converter;

import ru.rodionov.energo.repository.rdbms.domain.ContractDB;
import ru.roidonov.energo.repository.api.model.Contract;

public class ContractConverterRDBMS implements Converter<Contract, ContractDB> {
    @Override
    public Contract fromDB(ContractDB contractDB) {
        Contract contract = new Contract();
        contract.setId(contractDB.getId());
        contract.setNumber(contractDB.getNumber());
        contract.setPrice(contractDB.getPrice());
        contract.setType(contractDB.getType());
        contract.setSignDate(contractDB.getSignDate());
        contract.setUpdated(contractDB.getUpdated());

        return contract;
    }

    @Override
    public ContractDB toDB(Contract entity) {
        return null;
    }
}
