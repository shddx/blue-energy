package ru.rodionov.energo.admin.model;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageResponse<T> {
    private final List<T> content;
    private final int pages;
    private final long total;
    private final String nextPage;
    private final String previousPage;

    public static <T> PageResponse<T> build(Page<T> page, String urlPath) {
        int totalPages = page.getTotalPages();
        int pageNumber = page.getPageable().getPageNumber() + 1;
        String pageUrl = urlPath + "?page=";
        String previous = page.getPageable().hasPrevious() ? pageUrl + (pageNumber - 1) : null;
        String next = pageNumber == totalPages ? null : pageUrl + (pageNumber + 1);

        return new PageResponse<>(page.getContent(), totalPages, page.getTotalElements(), next, previous);
    }
}
