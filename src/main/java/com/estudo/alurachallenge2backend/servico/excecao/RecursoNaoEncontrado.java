package com.estudo.alurachallenge2backend.servico.excecao;

public class RecursoNaoEncontrado extends RuntimeException{

    public RecursoNaoEncontrado(String mensagem){
        super(mensagem);
    }
}
