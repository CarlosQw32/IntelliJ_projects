package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.domain.DTOs.requisicao.DadosCadastroRequisicao;
import org.example.domain.DTOs.requisicao.DadosListagemRequisicao;
import org.example.domain.DTOs.requisicao.RepositoryRequisicao;
import org.example.domain.entities.CompraRequisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/requisicao")
@Tag(name = "requisicao",description = "CRUD de requisicao.")
public class RequisicaoController {

    @Autowired
    private RepositoryRequisicao repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de requisicao", description = "Endpoint do cadastro de novas requisicao.")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroRequisicao dados, UriComponentsBuilder uriBuilder) {
        var requisicao = new CompraRequisicao(dados);
        repository.save(requisicao);
        var uri = uriBuilder.path("/requisicao/{requisicao}").buildAndExpand(requisicao.getIdRequisicao()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemRequisicao(requisicao));
    }

    @GetMapping
    @Operation(summary = "Listagem de requisicao", description = "Endpoint da listagem de requisições cadastradas.")
    public ResponseEntity<Page<DadosListagemRequisicao>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemRequisicao::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{requisicao}")
    @Operation(summary = "Exibir requisicao", description = "Endpoint da exibição de uma única requisicao cadastrada.")
    public ResponseEntity exibir(@PathVariable Long CompraRequisicao) {
        var requisicao = repository.getReferenceById(CompraRequisicao);
        return ResponseEntity.ok(new DadosListagemRequisicao(requisicao));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar requisicao", description = "Endpoint da atualização de uma única requisicao cadastrada.")
    public ResponseEntity atualizar(@RequestBody @Valid DadosCadastroRequisicao dados) {
        var requisicao = repository.getReferenceById(dados.idRequisicao());
        requisicao.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemRequisicao(requisicao));
    }

    @DeleteMapping("/{requisicao}")
    @Transactional
    @Operation(summary = "Excluir requisicao", description = "Endpoint da exclusão de uma única requisicao cadastrada.")
    public ResponseEntity excluir(@PathVariable Long CompraRequisicao) {
        repository.deleteById(CompraRequisicao);
        return ResponseEntity.ok().body("nascimento " + CompraRequisicao + " deletado.");
    }
}
