package ru.rodionov.energo.repository.rdbms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import ru.rodionov.energo.repository.api.model.ContractType;

import javax.persistence.*;
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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    @Column(unique = true)
    private String number;
    @Enumerated(EnumType.STRING)
    private ContractType type;
    private String client;
    private Integer price;
    @Column(columnDefinition = "DATE")
    private LocalDate signDate;
    @Column(columnDefinition = "DATE")
    private LocalDate endDate;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updated;
}
