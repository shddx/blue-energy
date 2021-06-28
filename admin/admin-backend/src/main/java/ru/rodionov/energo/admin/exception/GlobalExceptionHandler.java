package ru.rodionov.energo.admin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.rodionov.energo.repository.api.exception.RepositoryException;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RepositoryException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorInfo handleError(HttpServletRequest req, RepositoryException e) {
        return new ErrorInfo(req.getRequestURL(), ErrorType.DATA_NOT_FOUND, e.getMessage());
    }
}
