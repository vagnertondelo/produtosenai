package com.api.produto.repository;

import com.api.produto.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends
        JpaRepository<ProdutoModel, UUID> { }
