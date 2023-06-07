package com.estudo.alurachallenge2backend.servico;

import com.estudo.alurachallenge2backend.dominio.entidade.Receita;
import com.estudo.alurachallenge2backend.repositorio.ReceitaRepositorio;
import com.estudo.alurachallenge2backend.servico.excecao.RecursoNaoEncontrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
}
