package ru.rodionov.energo.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rodionov.energo.repository.api.model.Contract;
import ru.rodionov.energo.repository.api.service.ContractService;

@RestController
@RequestMapping("/api/admin/contract")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @GetMapping("/{id}")
    public Contract get(@PathVariable String id) {
        return contractService.get(id);
    }
}
