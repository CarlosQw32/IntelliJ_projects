package org.example.contollers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.domain.DTOs.nascimento.DadosCadastroNascimento;
import org.example.domain.DTOs.nascimento.DadosListagemNascimento;
import org.example.domain.DTOs.obito.DadosCadastroObito;
import org.example.domain.DTOs.obito.DadosListagemObito;
import org.example.domain.DTOs.obito.RepositoryObito;
import org.example.domain.entities.nascimento;
import org.example.domain.entities.obito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/obito")
@Tag(name = "obito",description = "CRUD do obito.")
public class ObitoController {

    @Autowired
    private RepositoryObito repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de obito", description = "Endpoint do cadastro de novos obito.")
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroObito dados, UriComponentsBuilder uriBuilder) {
        var obito_crianca = new obito(dados);
        repository.save(obito_crianca);
        var uri = uriBuilder.path("/obito/{obito}").buildAndExpand(obito_crianca.getId_obito()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemObito(obito_crianca));
    }

    @GetMapping
    @Operation(summary = "Listagem de obito", description = "Endpoint da listagem de obito cadastrados.")
    public ResponseEntity<Page<DadosListagemObito>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemObito::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{obito}")
    @Operation(summary = "Exibir obito", description = "Endpoint da exibição de um único obito cadastrado.")
    public ResponseEntity exibir(@PathVariable Long obito) {
        var obito_crianca = repository.getReferenceById(obito);
        return ResponseEntity.ok(new DadosListagemObito(obito_crianca));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar obito", description = "Endpoint da atualização de um único obito cadastrado.")
    public ResponseEntity atualizar(@RequestBody @Valid DadosCadastroObito dados) {
        var obito_crianca = repository.getReferenceById(dados.id_obito());
        obito_crianca.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemObito(obito_crianca));
    }

    @DeleteMapping("/{obito}")
    @Transactional
    @Operation(summary = "Excluir obito", description = "Endpoint da exclusão de um único obito cadastrado.")
    public ResponseEntity excluir(@PathVariable Long obito) {
        repository.deleteById(obito);
        return ResponseEntity.ok().body("obito " + obito + " deletado.");
    }
}
