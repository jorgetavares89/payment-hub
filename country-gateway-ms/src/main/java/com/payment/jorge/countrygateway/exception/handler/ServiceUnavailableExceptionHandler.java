package com.payment.jorge.countrygateway.exception.handler;

import com.payment.jorge.countrygateway.exception.CustomExceptionHandler;
import com.payment.jorge.countrygateway.exception.ServiceUnavailableException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ServiceUnavailableExceptionHandler extends CustomExceptionHandler {
	
	@ExceptionHandler(value = {ServiceUnavailableException.class})
    protected ResponseEntity<Object> handleServiceUnavailable(ServiceUnavailableException ex, WebRequest request) {
        return handleExceptionInternal(ex,
                getErrorResponse(ex, HttpStatus.SERVICE_UNAVAILABLE),
                new HttpHeaders(),
                HttpStatus.SERVICE_UNAVAILABLE,
                request);
    }
}
