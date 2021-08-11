package ru.rodionov.energo.repository.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
