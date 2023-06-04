package com.estudo.alurachallenge2backend.dominio.entidade.regras;

import com.estudo.alurachallenge2backend.dominio.entidade.excecao.ExcecaoDeValidacao;
import com.estudo.alurachallenge2backend.dto.ReceitaDTOCadastro;
import com.estudo.alurachallenge2backend.servico.ReceitaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReceitaRepetidaNoMes {

    @Autowired
    private ReceitaServico servico;

    public void validar(ReceitaDTOCadastro receita){
        boolean existeReceitaNoMes = servico.buscaReceitaPorDescricaoEMes(
                receita.getDescricao(), receita.getData().getYear(), receita.getData().getMonth().getValue()
        );

        if (existeReceitaNoMes) {
            throw new ExcecaoDeValidacao(receita.getDescricao() + " já foi cadastrado este mês!");
        }
    }


}
