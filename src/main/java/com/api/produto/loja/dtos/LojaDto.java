package com.api.produto.loja.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

@Data
public class LojaDto {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    private String endereco;
    @CNPJ
    private String cnpj;
}
