package com.br.zup.vicente_imoveis.config;

import com.br.zup.vicente_imoveis.Custom_exception.*;
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
    public List<ErroDeValidacao> tratarErrosDeValidacao(MethodArgumentNotValidException excecao) {
        List<ErroDeValidacao> erros = new ArrayList<>();

        for (FieldError referencia : excecao.getFieldErrors()) {
            ErroDeValidacao mensagem = new ErroDeValidacao(referencia.getDefaultMessage());
            erros.add(mensagem);
        }

        return erros;
    }

    @ExceptionHandler(ClienteNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroDeValidacao tratarClienteNaoEncontradoException(
            ClienteNaoEncontradoException clienteNaoEncontradoException) {
        return new ErroDeValidacao(clienteNaoEncontradoException.getMessage());
    }

    @ExceptionHandler(ContratoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroDeValidacao tratarContratoNaoEncontradoException(
            ContratoNaoEncontradoException contratoNaoEncontradoException) {
        return new ErroDeValidacao(contratoNaoEncontradoException.getMessage());
    }

    @ExceptionHandler(ImovelNaoCadastradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroDeValidacao tratarImovelNaoCadastradoException(
            ImovelNaoCadastradoException imovelNaoCadastradoException) {
        return new ErroDeValidacao(imovelNaoCadastradoException.getMessage());
    }

    @ExceptionHandler(ImovelCadastradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroDeValidacao tratarImovelCadastradoExeception(
            ImovelCadastradoException imovelCadastradoException) {
        return new ErroDeValidacao(imovelCadastradoException.getMessage());
    }

    @ExceptionHandler(TipoDeContratoIndelevelException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroDeValidacao tratarTipoDeContratoIndelevelExeception(
            TipoDeContratoIndelevelException tipoDeContratoIndelevelExeception) {
        return new ErroDeValidacao(tipoDeContratoIndelevelExeception.getMessage());
    }

    @ExceptionHandler(CpfJaCadastradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroDeValidacao CpfJaCadastradoException(
            CpfJaCadastradoException cpfJaCadastradoException) {
        return new ErroDeValidacao(cpfJaCadastradoException.getMessage());
    }

}
