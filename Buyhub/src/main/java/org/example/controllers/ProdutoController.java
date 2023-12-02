package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.domain.DTOs.orcamento.RepositoryOrcamento;
import org.example.domain.DTOs.produto.DadosCadastroProduto;
import org.example.domain.DTOs.produto.DadosListagemProduto;
import org.example.domain.entities.CompraProduto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/produto")
@Tag(name = "produto",description = "CRUD de produto.")
public class ProdutoController {

    @Autowired
    private RepositoryOrcamento repository;


}
