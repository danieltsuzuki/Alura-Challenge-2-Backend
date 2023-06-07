package com.estudo.alurachallenge2backend.dto;

import com.estudo.alurachallenge2backend.dominio.entidade.Receita;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ReceitaDTODetalhes {

    private String descricao;

    private BigDecimal valor;

    private LocalDate data;

    public ReceitaDTODetalhes(Receita receita){
        this.descricao = receita.getDescricao();
        this.valor = receita.getValor();
        this.data = receita.getData();
    }
}
