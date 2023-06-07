package com.estudo.alurachallenge2backend.utilidade;

import com.estudo.alurachallenge2backend.dominio.entidade.excecao.ExcecaoDeValidacao;
import com.estudo.alurachallenge2backend.servico.excecao.RecursoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.List;

import static java.util.Arrays.stream;

@ControllerAdvice
public class TratadorDeExcecao{

    @ExceptionHandler(ExcecaoDeValidacao.class)
    public ResponseEntity resposta(ExcecaoDeValidacao erro){
        Resposta resposta = new Resposta("Não foi possivel cadastrar a receita", HttpStatus.BAD_REQUEST.value(),erro.getMessage());
        return ResponseEntity.badRequest().body(resposta);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity resposta(MethodArgumentNotValidException erros){
        List<FieldError> campos =  erros.getBindingResult().getFieldErrors();
        StringBuilder mensagem = new StringBuilder();
        String campo = "";
        String mensagemDeErro = "";

        for (FieldError campoErro : campos) {
            campo = campoErro.getField();
            mensagemDeErro = campoErro.getDefaultMessage();

            mensagem.append(campo + " " + mensagemDeErro);

            if (campos.size() > 1){
                mensagem.append(", ");
            }
        }

        Resposta resposta = new Resposta(
                "Não foi possivel cadastrar a receita",
                HttpStatus.BAD_REQUEST.value(),
                mensagem.toString()
        );

        return ResponseEntity.badRequest().body(resposta);
    }

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity resposta(DateTimeParseException erro){

        Resposta resposta = new Resposta(
                "Não foi possivel cadastrar a receita",
                HttpStatus.BAD_REQUEST.value(),
                "Data inválida!"
        );

        return ResponseEntity.badRequest().body(resposta);
    }

    @ExceptionHandler(RecursoNaoEncontrado.class)
    public ResponseEntity resposta(){
        return ResponseEntity.notFound().build();
    }

}
