package com.estudo.alurachallenge2backend.controle;

import com.estudo.alurachallenge2backend.dominio.entidade.Receita;
import com.estudo.alurachallenge2backend.dominio.entidade.regras.ReceitaRepetidaNoMes;
import com.estudo.alurachallenge2backend.dto.ReceitaDTOCadastro;
import com.estudo.alurachallenge2backend.servico.ReceitaServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receita")
public class ReceitaControle {

    @Autowired
    private ReceitaServico servico;

    @Autowired
    ReceitaRepetidaNoMes receitaRepetidaNoMes;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody ReceitaDTOCadastro receita){
        receitaRepetidaNoMes.validar(receita);
        servico.salvar(new Receita(receita));
        return ResponseEntity.ok(receita);
    }

}
