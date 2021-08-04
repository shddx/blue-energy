package ru.rodionov.energo.repository.rdbms.search;

import org.springframework.data.jpa.domain.Specification;
import ru.rodionov.energo.repository.rdbms.domain.ContractDB;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContractFilter implements Specification<ContractDB> {
    private String contractNumber;
    private LocalDate fromSignDate;
    private LocalDate toSignDate;
    private String client;
    private Integer priceLow;
    private Integer priceHigh;

    public static Specification<ContractDB> contractNumberContains(final String contractNumber) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("contractNumber"), contractNumber);
    }

    @Override
    public Predicate toPredicate(Root<ContractDB> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();
        if (contractNumber != null) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("contractNumber")), "%" + contractNumber.toUpperCase() + "%"));
        }
        if (client != null) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("client")), "%" + client.toUpperCase() + "%"));
        }
        if (priceLow != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), priceLow));
        }
        if (priceHigh != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("price"), priceHigh));
        }
        if (fromSignDate != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("signDate"), fromSignDate));
        }
        if (toSignDate != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("signDate"), toSignDate));
        }
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
