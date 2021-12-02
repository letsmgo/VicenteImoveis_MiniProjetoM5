package com.br.zup.vicente_imoveis.config;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<ErroDeValidacao> tratarErrosDeValidacao (MethodArgumentNotValidException excecao){
        List<ErroDeValidacao> erros = new ArrayList<>();

        for (FieldError referencia : excecao.getFieldErrors()){
            ErroDeValidacao mensagem = new ErroDeValidacao(referencia.getField(),
                    referencia.getDefaultMessage());
            erros.add(mensagem);
        }

        return erros;
    }
}
