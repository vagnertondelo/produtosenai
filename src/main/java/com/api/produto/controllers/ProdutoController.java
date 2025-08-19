package com.api.produto.controllers;

import com.api.produto.dtos.ProdutoDto;
import com.api.produto.models.ProdutoModel;
import com.api.produto.services.ProdutoService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("/salvar")
    public ResponseEntity<?> salvar(
            @RequestBody @Valid ProdutoDto dto) {
        ProdutoModel produtoSalvo = produtoService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                produtoSalvo);
    }

    @GetMapping("/listar")
    public List<ProdutoModel> listar() {
        return produtoService.listar();
    }

    @PostMapping("/editar/{id}")
    public ResponseEntity<?> editar(
            @RequestBody @Valid ProdutoDto dto,
            @PathVariable(value = "id") UUID id
    ) {
        try {
            ProdutoModel produtoEditado = produtoService.atualizar(dto, id);
            return ResponseEntity.status(HttpStatus.CREATED).
                    body(produtoEditado);
        } catch (Exception e) {
                //Retorna eror 500 com a mensagem de erro para o front
            return ResponseEntity.status(
                    HttpStatus.INTERNAL_SERVER_ERROR).body("Erro: "+ e.getMessage());
        }
    }

    @PostMapping("/apagar/{id}")
    public ResponseEntity<String> apagar(@PathVariable UUID id) {
        try {
            produtoService.deletar(id);
            return ResponseEntity.ok(
                    "Produto apagado com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    "Deu ruim: " +e.getMessage()
            );
        }
    }

}
