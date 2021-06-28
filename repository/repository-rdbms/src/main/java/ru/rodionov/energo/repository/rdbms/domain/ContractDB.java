package ru.rodionov.energo.repository.rdbms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rodionov.energo.repository.api.model.ContractType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contract")
public class ContractDB {
    @Id
    private String id;
    private String number;
    private ContractType type;
    private Integer price;
    private LocalDate signDate;
    private LocalDateTime updated;
}
