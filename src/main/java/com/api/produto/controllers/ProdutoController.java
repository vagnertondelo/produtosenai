package com.api.produto.controllers;

import com.api.produto.dtos.ProdutoDto;
import com.api.produto.models.ProdutoModel;
import com.api.produto.services.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
  private final ProdutoService produtoService;
  public ProdutoController(ProdutoService produtoService) {
      this.produtoService = produtoService;
  }
    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(
            @RequestBody @Valid ProdutoDto dto){
        ProdutoModel produto = new ProdutoModel();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        ProdutoModel salvo = produtoService.create(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

}
