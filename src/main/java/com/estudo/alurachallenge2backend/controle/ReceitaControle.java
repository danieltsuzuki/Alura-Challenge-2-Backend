package com.estudo.alurachallenge2backend.controle;

import com.estudo.alurachallenge2backend.dominio.entidade.Receita;
import com.estudo.alurachallenge2backend.dominio.entidade.regras.ReceitaRepetidaNoMes;
import com.estudo.alurachallenge2backend.dto.ReceitaDTOCadastro;
import com.estudo.alurachallenge2backend.dto.ReceitaDTODetalhes;
import com.estudo.alurachallenge2backend.dto.ReceitaDTOListagem;
import com.estudo.alurachallenge2backend.servico.ReceitaServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/receita")
public class ReceitaControle {

    @Autowired
    private ReceitaServico servico;

    @Autowired
    ReceitaRepetidaNoMes receitaRepetidaNoMes;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid ReceitaDTOCadastro receita){
        receitaRepetidaNoMes.validar(receita);
        servico.salvar(new Receita(receita));
        return ResponseEntity.ok(receita);
    }

    @GetMapping
    public ResponseEntity listar(){
        List<ReceitaDTOListagem> receitas = servico.buscarTodasReceitas().stream().map(receita -> new ReceitaDTOListagem(receita)).collect(Collectors.toList());
        return ResponseEntity.ok(receitas);
    }

    @GetMapping("/{id}")
    public ResponseEntity pesquisar(@PathVariable Long id){
        ReceitaDTODetalhes receita = new ReceitaDTODetalhes(servico.buscarPorId(id));
        return ResponseEntity.ok(receita);
    }

}
