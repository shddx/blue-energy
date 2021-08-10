package ru.rodionov.energo.repository.rdbms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.rodionov.energo.repository.rdbms.DbBaseTest;
import ru.rodionov.energo.repository.rdbms.util.ContractTestUtil;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("rdbms")
public class ContractServiceRDBMSTest extends DbBaseTest {

    @Autowired
    private ContractServiceRDBMS contractServiceRDBMS;

    @org.junit.jupiter.api.Test
    void filter() {
    }

    @org.junit.jupiter.api.Test
    void findPaginated() {
    }

    @org.junit.jupiter.api.Test
    void get() {
        assertThat(contractServiceRDBMS.get(ContractTestUtil.CONTRACT_1_ID))
                .usingRecursiveComparison()
                .ignoringFields("updated")
                .isEqualTo(ContractTestUtil.CONTRACT_1);
    }

    @org.junit.jupiter.api.Test
    void save() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }
}
