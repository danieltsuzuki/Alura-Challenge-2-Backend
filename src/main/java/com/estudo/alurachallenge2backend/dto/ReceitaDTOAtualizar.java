package com.estudo.alurachallenge2backend.dto;

import com.estudo.alurachallenge2backend.dominio.entidade.Receita;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class ReceitaDTOAtualizar {

    @NotBlank
    private String descricao;
    @Min(value = 0)
    private BigDecimal valor;
    @PastOrPresent
    private LocalDate data;

    public ReceitaDTOAtualizar(Receita receita){
        this.descricao = receita.getDescricao();
        this.valor = receita.getValor();
        this.data = receita.getData();
    }
}
