package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.domain.DTOs.fornecedor.DadosCadastroFornecedor;
import org.example.domain.DTOs.fornecedor.DadosListagemFornecedor;
import org.example.domain.DTOs.fornecedor.RepositoryFornecedor;
import org.example.domain.entities.CompraFornecedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/fornecedor")
@Tag(name = "fornecedor",description = "CRUD de fornecedor.")
public class FornecedorController {

    @Autowired
    private RepositoryFornecedor repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de fornecedor", description = "Endpoint do cadastro de novos fornecedores.")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroFornecedor dados, UriComponentsBuilder uriBuilder) {
        var fornecedor = new CompraFornecedor(dados);
        repository.save(fornecedor);
        var uri = uriBuilder.path("/fornecedor/{fornecedor}").buildAndExpand(fornecedor.getCnpjFornecedor()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemFornecedor(fornecedor));
    }

    @GetMapping
    @Operation(summary = "Listagem de fornecedores", description = "Endpoint da listagem de fornecedores cadastrados.")
    public ResponseEntity<Page<DadosListagemFornecedor>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemFornecedor::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{fornecedor}")
    @Operation(summary = "Exibir fornecedor", description = "Endpoint da exibição de um único fornecedor cadastrado.")
    public ResponseEntity exibir(@PathVariable Long CompraFornecedor) {
        var fornecedor = repository.getReferenceById(CompraFornecedor);
        return ResponseEntity.ok(new DadosListagemFornecedor(fornecedor));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar fornecedor", description = "Endpoint da atualização de um único fornecedor cadastrado.")
    public ResponseEntity atualizar(@RequestBody @Valid DadosCadastroFornecedor dados) {
        var fornecedor = repository.getReferenceById(dados.cnpjFornecedor());
        fornecedor.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemFornecedor(fornecedor));
    }

    @DeleteMapping("/{fornecedor}")
    @Transactional
    @Operation(summary = "Excluir fornecedor", description = "Endpoint da exclusão de um único fornecedor cadastrado.")
    public ResponseEntity excluir(@PathVariable Long CompraFornecedor) {
        repository.deleteById(CompraFornecedor);
        return ResponseEntity.ok().body("fornecedor " + CompraFornecedor + " deletado.");
    }
}
