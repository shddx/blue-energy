package ru.rodionov.energo.repository.rdbms.domain;

import lombok.*;
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
    private String number;
    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private ContractType type;
    private Integer price;
    @Column(columnDefinition = "DATE")
    private LocalDate signDate;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime updated;
}
