package br.com.Crud.Crud.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RequestsException {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity threat404(){
        return ResponseEntity.badRequest().body("Dado não encontrado!");
    }
}
