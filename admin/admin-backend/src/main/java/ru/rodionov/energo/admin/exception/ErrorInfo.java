package ru.rodionov.energo.admin.exception;

import lombok.Data;

@Data
public class ErrorInfo {
    private final String url;
    private final ErrorType errorType;
    private final String details;

    public ErrorInfo(CharSequence url, ErrorType errorType, String details) {
        this.url = url.toString();
        this.errorType = errorType;
        this.details = details;
    }
}
