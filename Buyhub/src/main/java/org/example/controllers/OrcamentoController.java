package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.domain.DTOs.orcamento.DadosCadastroOrcamento;
import org.example.domain.DTOs.orcamento.DadosListagemOrcamento;
import org.example.domain.DTOs.orcamento.RepositoryOrcamento;
import org.example.domain.entities.CompraOrcamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/orcamento")
@Tag(name = "orcamento",description = "CRUD de orcamento.")
public class OrcamentoController {

    @Autowired
    private RepositoryOrcamento repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de orcamento", description = "Endpoint do cadastro de novos orcamentos.")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroOrcamento dados, UriComponentsBuilder uriBuilder) {
        var orcamento = new CompraOrcamento(dados);
        repository.save(orcamento);
        var uri = uriBuilder.path("/orcamento/{orcamento}").buildAndExpand(orcamento.getIdOrcamento()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemOrcamento(orcamento));
    }

    @GetMapping
    @Operation(summary = "Listagem de orcamento", description = "Endpoint da listagem de orcamentos cadastrados.")
    public ResponseEntity<Page<DadosListagemOrcamento>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemOrcamento::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{orcamento}")
    @Operation(summary = "Exibir orcamento", description = "Endpoint da exibição de um único orcamento cadastrado.")
    public ResponseEntity exibir(@PathVariable Long CompraOrcamento) {
        var orcamento = repository.getReferenceById(CompraOrcamento);
        return ResponseEntity.ok(new DadosListagemOrcamento(orcamento));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar orcamento", description = "Endpoint da atualização de um único orcamento cadastrado.")
    public ResponseEntity atualizar(@RequestBody @Valid DadosCadastroOrcamento dados) {
        var orcamento = repository.getReferenceById(dados.idOrcamento());
        orcamento.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemOrcamento(orcamento));
    }

    @DeleteMapping("/{orcamento}")
    @Transactional
    @Operation(summary = "Excluir orcamento", description = "Endpoint da exclusão de um único orcamento cadastrado.")
    public ResponseEntity excluir(@PathVariable Long CompraOrcamento) {
        repository.deleteById(CompraOrcamento);
        return ResponseEntity.ok().body("nascimento " + CompraOrcamento + " deletado.");
    }
}
