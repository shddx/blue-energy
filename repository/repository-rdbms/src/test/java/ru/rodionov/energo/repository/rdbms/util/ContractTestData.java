package ru.rodionov.energo.repository.rdbms.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import ru.rodionov.energo.repository.api.model.Contract;
import ru.rodionov.energo.repository.api.model.ContractType;
import ru.rodionov.energo.repository.api.model.Contract;

import java.time.LocalDate;
import java.util.List;

public class ContractTestData {
    public static final String CONTRACT_1_ID = "test_id_1";
    public static final LocalDate LOWER_SIGN_DATE = LocalDate.of(2020, 1, 1);
    public static final LocalDate INSIDE_SIGN_DATE = LocalDate.of(2020, 5, 1);
    public static final LocalDate UPPER_SIGN_DATE = LocalDate.of(2020, 12, 1);
    public static final Integer LOWER_PRICE = 1000;
    public static final Integer INSIDE_PRICE = 1234;
    public static final Integer UPPER_PRICE = 1500;

    public static final Contract CONTRACT_1 = new Contract(CONTRACT_1_ID, "ТО-ВДГО-123123", ContractType.VDGO, "Василий", 4234, UPPER_SIGN_DATE, LocalDate.of(2021, 11, 30), null);
    public static final Contract CONTRACT_2 = new Contract("test_id_2", "ТО-ВДГО-123132", ContractType.VDGO, "Петр", 777, LOWER_SIGN_DATE, LocalDate.of(2021, 1, 1), null);
    public static final Contract CONTRACT_3 = new Contract("test_id_3", "ТО-ВДГО-123ad132", ContractType.VDGO, "Антоний", 777, INSIDE_SIGN_DATE, LocalDate.of(2021, 1, 1), null);
    public static final List<Contract> CONTRACTS_IN_DATE_RANGE = List.of(CONTRACT_1, CONTRACT_2, CONTRACT_3);
    public static final Contract CONTRACT_4 = new Contract("test_id_4", "ТО-ВДГО-123sf132", ContractType.VDGO, "Рик", LOWER_PRICE, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_5 = new Contract("test_id_5", "ТО-ВДГО-1231drt32", ContractType.VDGO, "Морти", INSIDE_PRICE, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_6 = new Contract("test_id_6", "ТО-ВДГО-12drtafefef3132", ContractType.VDGO, "Силас", UPPER_PRICE, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final List<Contract> CONTRACTS = buildContractListOf10();
    public static final List<Contract> CONTRACTS_IN_PRICE_RANGE = List.of(CONTRACT_4, CONTRACT_5, CONTRACT_6);
    public static final Contract CONTRACT_7 = new Contract("test_id_7", "ТО-ВДГО-12drt3132", ContractType.VDGO, "Мэддисон", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_8 = new Contract("test_id_8", "ТО-ВДГО-123drt132", ContractType.VDGO, "Аники", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_9 = new Contract("test_id_9", "ТО-ВДГО-1231rtgd32", ContractType.VDGO, "Билли", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_10 = new Contract("test_id_10", "ТО-ВДГО-123rd132", ContractType.VDGO, "Фартикон", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_11 = new Contract("test_id_11", "ТО-ВДГО-1231ft32", ContractType.VDGO, "Гена", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_12 = new Contract("test_id_12", "ТО-ВДГО-123k132", ContractType.VDGO, "Катерина", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_13 = new Contract("test_id_13", "ТО-ВДГО-1231j32", ContractType.VDGO, "Карен", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_14 = new Contract("test_id_14", "ТО-ВДГО-12hj3132", ContractType.VDGO, "Маррта", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_15 = new Contract("test_id_15", "ТО-ВДГО-12th3132", ContractType.VDGO, "Ака", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_16 = new Contract("test_id_16", "ТО-ВДГО-123hgt132", ContractType.VDGO, "Петр", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_17 = new Contract("test_id_17", "ТО-ВДГО-12gr3132", ContractType.VDGO, "Петр", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_18 = new Contract("test_id_18", "ТО-ВДГО-1grg23adw132", ContractType.VDGO, "Петр", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_19 = new Contract("test_id_19", "ТО-ВДГО-12332132", ContractType.VDGO, "Петр", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_20 = new Contract("test_id_20", "ТО-ВДГО-12313dw2", ContractType.VDGO, "Петр", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_21 = new Contract("test_id_21", "ТО-ВДГО-123adw132", ContractType.VDGO, "Петр", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_22 = new Contract("test_id_22", "ТО-ВДГО-123asef132", ContractType.VDGO, "Петр", 777, LocalDate.of(2018, 12, 1), LocalDate.of(2019, 11, 30), null);
    public static final Contract CONTRACT_23 = new Contract("test_id_23", "ТО-ВДГО-124444sef43", ContractType.VDGO, "Алекс", 9999, LocalDate.of(2019, 12, 1), LocalDate.of(2020, 11, 30), null);

    public static Contract getNewContract() {
        Contract db = new Contract();
        db.setContractNumber("NEW_CONTRACT_NUMBER");
        db.setClient("NEW_CONTRACT_CLIENT");
        db.setSignDate(LocalDate.of(2021, 1, 1));
        db.setEndDate(LocalDate.of(2022, 1, 1));
        db.setPrice(1000);
        db.setType(ContractType.VDGO);

        return db;
    }

    public static List<Contract> buildContractListOf10() {
        return List.of(CONTRACT_1, CONTRACT_2, CONTRACT_3, CONTRACT_4, CONTRACT_5, CONTRACT_6, CONTRACT_7, CONTRACT_8, CONTRACT_9, CONTRACT_10);
    }
}
