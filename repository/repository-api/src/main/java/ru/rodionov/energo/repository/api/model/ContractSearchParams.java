package ru.rodionov.energo.repository.api.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ContractSearchParams {
    private String contractNumber;
    private LocalDate fromSignDate;
    private LocalDate toSignDate;
    private String client;
    private Integer priceLow;
    private Integer priceHigh;
}
