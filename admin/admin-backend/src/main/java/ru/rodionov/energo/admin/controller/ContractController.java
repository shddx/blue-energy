package ru.rodionov.energo.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ru.rodionov.energo.repository.api.model.Contract;
import ru.rodionov.energo.repository.api.service.ContractService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/contract")
@RequiredArgsConstructor
public class ContractController {
    private final ContractService contractService;

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping
    public Page<Contract> getAll(Pageable pageable) {
        return contractService.findPaginated(pageable);
    }

    @GetMapping("/{id}")
    public Contract get(@PathVariable String id) {
        return contractService.get(id);
    }

    @PostMapping
    public void create(@RequestBody Contract contract) {
        contractService.save(contract, false);
    }
}
