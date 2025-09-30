package com.api.produto.loja.dtos;

import com.api.produto.produto.models.ProdutoModel;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.br.CNPJ;

import java.util.ArrayList;
import java.util.List;

@Data
public class LojaDto {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    private String endereco;
    @CNPJ
    private String cnpj;

    private List<ProdutoModel> produtos = new ArrayList<>();
}
