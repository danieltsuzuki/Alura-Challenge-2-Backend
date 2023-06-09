package com.estudo.alurachallenge2backend.dto;

import com.estudo.alurachallenge2backend.dominio.entidade.Receita;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class ReceitaDTOCadastro {
    @NotEmpty
    private String descricao;
    @Min(value = 0)
    @NotNull
    private BigDecimal valor;
    @NotNull
    @PastOrPresent
    private LocalDate data;

    public ReceitaDTOCadastro(Receita receita){
        this.descricao = receita.getDescricao();
        this.valor = receita.getValor();
        this.data = receita.getData();
    }

}
