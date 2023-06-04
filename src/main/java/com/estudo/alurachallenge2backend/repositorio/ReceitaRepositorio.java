package com.estudo.alurachallenge2backend.repositorio;

import com.estudo.alurachallenge2backend.dominio.entidade.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReceitaRepositorio extends JpaRepository<Receita, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM receitas WHERE descricao = :descricao and YEAR(data) = :ano AND MONTH(data) = :mes")
    List<Receita> buscaReceitaPorDescricaoEMes(@Param("descricao") String descricao,@Param("ano") int ano, @Param("mes") int mes);

}
