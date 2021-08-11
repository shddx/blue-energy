package ru.rodionov.energo.repository.rdbms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import ru.rodionov.energo.repository.api.model.Contract;
import ru.rodionov.energo.repository.api.model.ContractSearchParams;
import ru.rodionov.energo.repository.rdbms.DbBaseTest;
import ru.rodionov.energo.repository.rdbms.ContractTestData;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("rdbms")
@Sql(scripts = "classpath:populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class ContractServiceRDBMSTest extends DbBaseTest {

    @Autowired
    private ContractServiceRDBMS contractServiceRDBMS;

    @org.junit.jupiter.api.Test
    void filter_shouldReturnContractsInDateRange() {
        PageRequest pageable = PageRequest.of(0, 10);
        ContractSearchParams searchParams = new ContractSearchParams();
        searchParams.setFromSignDate(ContractTestData.LOWER_SIGN_DATE);
        searchParams.setToSignDate(ContractTestData.UPPER_SIGN_DATE);

        assertThat(contractServiceRDBMS.filter(searchParams, pageable).getContent())
                .usingRecursiveComparison()
                .ignoringFields("updated")
                .isEqualTo(ContractTestData.CONTRACTS_IN_DATE_RANGE);
    }

    @org.junit.jupiter.api.Test
    void filter_shouldReturnContractInPriceRange() {
        PageRequest pageable = PageRequest.of(0, 10);
        ContractSearchParams searchParams = new ContractSearchParams();
        searchParams.setPriceLow(ContractTestData.LOWER_PRICE);
        searchParams.setPriceHigh(ContractTestData.UPPER_PRICE);

        assertThat(contractServiceRDBMS.filter(searchParams, pageable).getContent())
                .usingRecursiveComparison()
                .ignoringFields("updated")
                .isEqualTo(ContractTestData.CONTRACTS_IN_PRICE_RANGE);
    }

    @org.junit.jupiter.api.Test
    void filter_shouldReturnContractWithClientName() {
        PageRequest pageable = PageRequest.of(0, 10);
        ContractSearchParams searchParams = new ContractSearchParams();
        searchParams.setClient("Катерина");

        assertThat(contractServiceRDBMS.filter(searchParams, pageable).getContent())
                .usingRecursiveComparison()
                .ignoringFields("updated")
                .isEqualTo(Collections.singletonList(ContractTestData.CONTRACT_12));

    }

    @org.junit.jupiter.api.Test
    void filter_shouldReturnContractWithContractNumber() {
        PageRequest pageable = PageRequest.of(0, 10);
        ContractSearchParams searchParams = new ContractSearchParams();
        searchParams.setContractNumber("1grg23adw132");

        assertThat(contractServiceRDBMS.filter(searchParams, pageable).getContent())
                .usingRecursiveComparison()
                .ignoringFields("updated")
                .isEqualTo(Collections.singletonList(ContractTestData.CONTRACT_18));
    }

    @org.junit.jupiter.api.Test
    void findPaginated_shouldReturnListOf10Contracts() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Contract> paginated = contractServiceRDBMS.findPaginated(pageable);
        assertThat(paginated.getContent())
                .usingRecursiveComparison()
                .ignoringFields("updated")
                .isEqualTo(ContractTestData.CONTRACTS);
    }

    @org.junit.jupiter.api.Test
    void get_shouldGetOneContract() {
        assertThat(contractServiceRDBMS.get(ContractTestData.CONTRACT_1_ID))
                .usingRecursiveComparison()
                .ignoringFields("updated")
                .isEqualTo(ContractTestData.CONTRACT_1);
    }
}
