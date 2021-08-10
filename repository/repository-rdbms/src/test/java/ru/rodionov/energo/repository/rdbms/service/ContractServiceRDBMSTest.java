package ru.rodionov.energo.repository.rdbms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import ru.rodionov.energo.repository.rdbms.DbBaseTest;
import ru.rodionov.energo.repository.rdbms.repo.ContractRepo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@ActiveProfiles("rdbms")
public class ContractServiceRDBMSTest extends DbBaseTest {

    @Autowired
    private ContractRepo contractRepo;

    @org.junit.jupiter.api.Test
    void filter() {
    }

    @org.junit.jupiter.api.Test
    void findPaginated() {
    }

    @org.junit.jupiter.api.Test
    void get() {
    }

    @org.junit.jupiter.api.Test
    void save() {
    }

    @org.junit.jupiter.api.Test
    void delete() {
    }
}
