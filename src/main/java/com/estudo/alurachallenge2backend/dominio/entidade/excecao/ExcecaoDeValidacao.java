package com.estudo.alurachallenge2backend.dominio.entidade.excecao;

public class ExcecaoDeValidacao extends RuntimeException{

    public ExcecaoDeValidacao(String mensagem){
        super(mensagem);
    }

}
