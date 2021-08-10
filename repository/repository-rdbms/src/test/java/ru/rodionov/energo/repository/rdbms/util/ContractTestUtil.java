package ru.rodionov.energo.repository.rdbms.util;

import ru.rodionov.energo.repository.api.model.ContractType;
import ru.rodionov.energo.repository.rdbms.domain.ContractDB;

import java.time.LocalDate;

public class ContractTestUtil {
    public static final String CONTRACT_1_ID = "test_id_1";
    public static final ContractDB CONTRACT_1 = new ContractDB(
            CONTRACT_1_ID,
            "ТО-ВДГО-123123",
            ContractType.VDGO,
            "Василий",
            4234,
            LocalDate.of(2020, 12, 1),
            LocalDate.of(2021, 11, 30),
            null
    );

    public static ContractDB getNewContract() {
        ContractDB db = new ContractDB();
        db.setContractNumber("NEW_CONTRACT_NUMBER");
        db.setClient("NEW_CONTRACT_CLIENT");
        db.setSignDate(LocalDate.of(2021, 1, 1));
        db.setEndDate(LocalDate.of(2022, 1, 1));
        db.setPrice(1000);
        db.setType(ContractType.VDGO);

        return db;
    }
}
