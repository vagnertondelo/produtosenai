package com.api.produto.produto.repository;

import com.api.produto.produto.dtos.ProdutoResponseDto;
import com.api.produto.produto.models.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository extends
        JpaRepository<ProdutoModel, UUID> {

//        List<ProdutoModel> findByNome(String nome);
    List<ProdutoModel> findByNomeContainingIgnoreCase(String nome);

    @Query("""
       select new com.api.produto.produto.dtos.ProdutoResponseDto(
           p.id, p.nome, p.descricao, p.preco, p.lojaModel.id
       )
       from ProdutoModel p
       """)
    List<ProdutoResponseDto> listarProjetado();

}
