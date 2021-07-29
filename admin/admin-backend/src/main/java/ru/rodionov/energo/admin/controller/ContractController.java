package ru.rodionov.energo.admin.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;
import ru.rodionov.energo.repository.api.model.Contract;
import ru.rodionov.energo.admin.model.PageResponse;
import ru.rodionov.energo.repository.api.service.ContractService;

import static ru.rodionov.energo.admin.controller.ContractController.URL_PATH;

@RestController
@RequestMapping(URL_PATH)
@RequiredArgsConstructor
public class ContractController {
    final static String URL_PATH = "/api/admin/contract";
    private final ContractService contractService;

    @GetMapping
    public PageResponse<Contract> getAll(@SortDefault(sort = "signDate",
            direction = Sort.Direction.DESC) Pageable pageable) {
        Page<Contract> page = contractService.findPaginated(pageable);
        return PageResponse.build(page, URL_PATH);
    }

    @GetMapping("/{id}")
    public Contract get(@PathVariable String id) {
        return contractService.get(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        contractService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Contract contract) {
        contractService.save(contract, true);
    }

    @PostMapping
    public void create(@RequestBody Contract contract) {
        contractService.save(contract, false);
    }
}
