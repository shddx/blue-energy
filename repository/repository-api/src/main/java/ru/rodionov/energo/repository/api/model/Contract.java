package ru.rodionov.energo.repository.api.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Contract {
    private String id;
    private String contractNumber;
    private ContractType type;
    private String client;
    private Integer price;
    private LocalDate signDate;
    private LocalDate endDate;
    private LocalDateTime updated;
}
