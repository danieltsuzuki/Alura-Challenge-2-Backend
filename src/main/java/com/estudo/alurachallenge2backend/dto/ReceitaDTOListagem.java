package com.estudo.alurachallenge2backend.dto;

import com.estudo.alurachallenge2backend.dominio.entidade.Receita;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
public class ReceitaDTOListagem {

    private Long id;

    private String descricao;

    private BigDecimal valor;

    private LocalDate data;

    public ReceitaDTOListagem(Receita receitas){
        this.id = receitas.getId();
        this.descricao = receitas.getDescricao();
        this.valor = receitas.getValor();
        this.data = receitas.getData();
    }

}
