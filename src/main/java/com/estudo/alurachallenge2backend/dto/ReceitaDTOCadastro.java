package com.estudo.alurachallenge2backend.dto;

import com.estudo.alurachallenge2backend.dominio.entidade.Receita;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class ReceitaDTOCadastro {
    @NotBlank
    private String descricao;
    @Min(value = 0)
    private BigDecimal valor;
    @NotNull
    private LocalDate data;

    public ReceitaDTOCadastro(Receita receita){
        this.descricao = receita.getDescricao();
        this.valor = receita.getValor();
        this.data = receita.getData();
    }

}
