package com.estudo.alurachallenge2backend.servico;

import com.estudo.alurachallenge2backend.dominio.entidade.Receita;
import com.estudo.alurachallenge2backend.dominio.entidade.excecao.ExcecaoDeValidacao;
import com.estudo.alurachallenge2backend.dto.ReceitaDTOAtualizar;
import com.estudo.alurachallenge2backend.repositorio.ReceitaRepositorio;
import com.estudo.alurachallenge2backend.servico.excecao.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceitaServico {

    @Autowired
    private ReceitaRepositorio repositorio;

    public Receita salvar(Receita receita){
        return repositorio.save(receita);
    }

    public boolean buscaReceitaPorDescricaoEMes(String descricao, int ano,int mes){
        return !repositorio.buscaReceitaPorDescricaoEMes(descricao, ano,mes).isEmpty();
    }

    public List<Receita> buscarTodasReceitas(){
        return repositorio.findAll();
    }

    public Receita buscarPorId(Long id){
        var receita = repositorio.findById(id);
        if (receita.isEmpty()){
            throw new RecursoNaoEncontrado("Receita de ID: " + id + "não encontrado");
        }
        return receita.get();
    }

    public Receita atualizar(Receita receitaAntiga, ReceitaDTOAtualizar dados){
        if (dados.getDescricao() == null && dados.getValor() == null && dados.getData() == null){
            throw new ExcecaoDeValidacao("Nenhum dado para alteração foi informado");
        }
        if (dados.getDescricao() != null){
            receitaAntiga.setDescricao(dados.getDescricao());
        }
        if (dados.getValor() != null){
            receitaAntiga.setValor(dados.getValor());
        }
        if (dados.getData() != null){
            receitaAntiga.setData(dados.getData());
        }
        return repositorio.save(receitaAntiga);
    }

    public void excluir(Long id){
        var receita = buscarPorId(id);
        repositorio.delete(receita);
    }

}
