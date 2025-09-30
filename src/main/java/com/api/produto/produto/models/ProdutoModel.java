package com.api.produto.produto.models;

import com.api.produto.loja.models.LojaModel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "tb_produto")
public class ProdutoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String descricao;
    private double preco;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loja_id")
    @JsonBackReference
    private LojaModel lojaModel;

}
