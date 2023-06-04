package com.estudo.alurachallenge2backend.dto;

import com.estudo.alurachallenge2backend.dominio.entidade.Receita;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class ReceitaDTODetalhes {

    private String descricao;

    private BigDecimal valor;

    private LocalDate data;

    public ReceitaDTODetalhes(Receita receitas){
        this.descricao = receitas.getDescricao();
        this.valor = receitas.getValor();
        this.data = receitas.getData();
    }

}
