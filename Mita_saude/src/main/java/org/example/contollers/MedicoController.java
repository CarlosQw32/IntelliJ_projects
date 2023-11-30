package org.example.contollers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.example.domain.DTOs.usuario_medico.DadosAtualizacaoMedico;
import org.example.domain.DTOs.usuario_medico.DadosCadastroMedico;
import org.example.domain.DTOs.usuario_medico.DadosListagemMedico;
import org.example.domain.DTOs.usuario_medico.RepositoryUsuarioMedico;
import org.example.domain.entities.usuario_medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/Medicos")
@Tag(name = "Medicos",description = "CRUD dos Medicos.")
public class MedicoController {

    @Autowired
    private RepositoryUsuarioMedico repository;

    @PostMapping
    @Transactional
    @Operation(summary = "Cadastro de médicos", description = "Endpoint de cadastro de novos médicos")
    public ResponseEntity cadastrar (@RequestBody @Valid DadosCadastroMedico dados, UriComponentsBuilder uriBuilder){
        var medico = new usuario_medico(dados);
        repository.save(medico);
        var uri = uriBuilder.path("/medicos/{usuario_medico}").buildAndExpand(medico.getCrm_medico()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemMedico(medico));
    }

    @GetMapping
    @Operation(summary = "Listagem de médicos", description = "Endpoint da listagem de médicos cadastradas.")
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10) Pageable paginacao) {
        var page = repository.findAll(paginacao).map((DadosListagemMedico::new));
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{usuario_medico}")
    @Operation(summary = "Exibir médicos", description = "Endpoint da exibição de um único médico cadastrado.")
    public ResponseEntity exibir(@PathVariable Long usuario_medico) {
        var medico = repository.getReferenceById(usuario_medico);
        return ResponseEntity.ok(new DadosListagemMedico(medico));
    }

    @PutMapping
    @Transactional
    @Operation(summary = "Atualizar médicos", description = "Endpoint da atualização de um único médico cadastrado.")
    public ResponseEntity atualizar(@org.springframework.web.bind.annotation.RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.crm_medico());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosListagemMedico(medico));
    }

    @DeleteMapping("/{usuario_medico}")
    @Transactional
    @Operation(summary = "Excluir médicos", description = "Endpoint da exclusão de um único médico cadastrado.")
    public ResponseEntity excluir(@PathVariable Long usuario_medico) {
        repository.deleteById(usuario_medico);
        return ResponseEntity.ok().body("Médico " + usuario_medico + " deletada.");
    }
}
