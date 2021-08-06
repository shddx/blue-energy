package ru.rodionov.energo.repository.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class ContractSearchParams {
    private String contractNumber;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fromSignDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate toSignDate;
    private String client;
    private Integer priceLow;
    private Integer priceHigh;
}
