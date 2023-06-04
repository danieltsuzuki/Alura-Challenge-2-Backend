package com.estudo.alurachallenge2backend.utilidade;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Resposta {

    private String mensagem;
    private int status;
    private String erro;

}
