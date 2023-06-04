package com.estudo.alurachallenge2backend.utilidade;

import com.estudo.alurachallenge2backend.dominio.entidade.excecao.ExcecaoDeValidacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TratadorDeExcecao{

    @ExceptionHandler(ExcecaoDeValidacao.class)
    public ResponseEntity resposta(ExcecaoDeValidacao erro){
        Resposta resposta = new Resposta("Não foi possivel cadastrar a receita", HttpStatus.BAD_REQUEST.value(),erro.getMessage());
        return ResponseEntity.badRequest().body(resposta);
    }

}
