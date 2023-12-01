package org.example.contollers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.domain.DTOs.carteira_vacinacao.DadosCadastroCarteiraVacinacao;
import org.example.domain.DTOs.carteira_vacinacao.DadosListagemCarteiraVacinacao;
import org.example.domain.DTOs.carteira_vacinacao.RepositoryCarteiraVacinacao;
import org.example.domain.DTOs.nascimento.DadosCadastroNascimento;
import org.example.domain.DTOs.nascimento.DadosListagemNascimento;
import org.example.domain.entities.carteira_vacinacao;
import org.example.domain.entities.nascimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/carteira_vacinacao")
@Tag(name = "carteira vacinacao",description = "CRUD de carteira vacinacao.")
public class CarteiraVacinacaoController {

    @Autowired
    private RepositoryCarteiraVacinacao repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de carteira vacinacao", description = "Endpoint do cadastro de novas carteira vacinacao.")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroCarteiraVacinacao dados, UriComponentsBuilder uriBuilder) {
        var carteiraVacinacao = new carteira_vacinacao(dados);
        repository.save(carteiraVacinacao);
        var uri = uriBuilder.path("/carteira_vacinacao/{carteira_vacinacao}").buildAndExpand(carteiraVacinacao.getId_carteira_vacina()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemCarteiraVacinacao(carteiraVacinacao));
    }

    @GetMapping
    @Operation(summary = "Listagem de carteira vacinacao", description = "Endpoint da listagem de carteiras vacinacao.")
    public ResponseEntity<Page<DadosListagemCarteiraVacinacao>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemCarteiraVacinacao::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{carteira_vacinacao}")
    @Operation(summary = "Exibir carteira vacinacao", description = "Endpoint da exibição de uma única carteira vacinacao cadastrada.")
    public ResponseEntity exibir(@PathVariable Long carteira_vacinacao) {
        var carteiraVacinacao = repository.getReferenceById(carteira_vacinacao);
        return ResponseEntity.ok(new DadosListagemCarteiraVacinacao(carteiraVacinacao));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar carteira vacinacao", description = "Endpoint da atualização de uma única carteira vacinacao cadastrada.")
    public ResponseEntity atualizar(@RequestBody @Valid DadosCadastroCarteiraVacinacao dados) {
        var carteiraVacinacao = repository.getReferenceById(dados.id_carteira_vacinacao());
        carteiraVacinacao.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemCarteiraVacinacao(carteiraVacinacao));
    }

    @DeleteMapping("/{carteira_vacinacao}")
    @Transactional
    @Operation(summary = "Excluir carteira vacinacao", description = "Endpoint da exclusão de uma única carteira vacinacao cadastrada.")
    public ResponseEntity excluir(@PathVariable Long carteira_vacinacao) {
        repository.deleteById(carteira_vacinacao);
        return ResponseEntity.ok().body("carteira_vacinacao " + carteira_vacinacao + " deletada.");
    }
}
