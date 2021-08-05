package ru.rodionov.energo.repository.rdbms.converter;

import org.springframework.data.domain.Page;

public interface ResponseBuilder<API, DB> {
    Page<API> buildPageResponse(Page<DB> entityPage);
}
