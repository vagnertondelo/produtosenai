package com.api.produto.repository;

import com.api.produto.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository extends
        JpaRepository<ProdutoModel, UUID> {

//        List<ProdutoModel> findByNome(String nome);
    List<ProdutoModel> findByNomeContainingIgnoreCase(String nome);
}
