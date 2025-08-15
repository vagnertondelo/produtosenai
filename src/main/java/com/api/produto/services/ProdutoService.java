package com.api.produto.services;

import com.api.produto.models.ProdutoModel;
import com.api.produto.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoModel create(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

}
