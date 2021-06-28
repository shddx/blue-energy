package ru.rodionov.energo.admin.exception;

public class ErrorInfo {
    private String url;
    private ErrorType errorType;
    private String details;

    public ErrorInfo(CharSequence url, ErrorType errorType, String details) {
        this.url = url.toString();
        this.errorType = errorType;
        this.details = details;
    }
}
