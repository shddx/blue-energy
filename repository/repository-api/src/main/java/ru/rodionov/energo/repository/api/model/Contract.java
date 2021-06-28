package ru.rodionov.energo.repository.api.model;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Contract {
    private String id;
    private String number;
    private ContractType type;
    private Integer price;
    private LocalDate signDate;
    private LocalDateTime updated;
}
