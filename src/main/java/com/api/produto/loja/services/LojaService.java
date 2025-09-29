package com.api.produto.loja.services;

import com.api.produto.loja.dtos.LojaDto;
import com.api.produto.loja.models.LojaModel;
import com.api.produto.loja.repository.LojaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LojaService {
    private LojaRepository lojaRepository;
    public LojaService(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    public LojaModel create(LojaDto dto) {
        LojaModel produto = new LojaModel();
        produto.setNome(dto.getNome());
        produto.setEndereco(dto.getEndereco());
        produto.setCnpj(dto.getCnpj());
        return lojaRepository.save(produto);
    }

    public List<LojaModel> listar() {
        return lojaRepository.findAll();
    }

    public LojaModel atualizar(LojaDto dto, UUID id){
        LojaModel existente = lojaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        existente.setNome(dto.getNome());
        existente.setEndereco(dto.getEndereco());
        existente.setCnpj(dto.getCnpj());
        return lojaRepository.save(existente);
    }
    public void deletar(UUID id) {
        LojaModel existente = lojaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        lojaRepository.deleteById(existente.getId());
    }
    public List<LojaModel> buscarPorNome(String nomeBusca) {
     return    lojaRepository.findByNomeContainingIgnoreCase(nomeBusca);
    }
}
