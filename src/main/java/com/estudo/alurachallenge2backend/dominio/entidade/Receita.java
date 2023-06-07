package com.estudo.alurachallenge2backend.dominio.entidade;

import com.estudo.alurachallenge2backend.dto.ReceitaDTOAtualizar;
import com.estudo.alurachallenge2backend.dto.ReceitaDTOCadastro;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "receitas")
@Getter
@Setter
@NoArgsConstructor
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private BigDecimal valor;

    private LocalDate data;

    public Receita(ReceitaDTOCadastro receita){
        this.descricao = receita.getDescricao();
        this.valor = receita.getValor();
        this.data = receita.getData();
    }

}
