package com.example.final_project.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.final_project.model.Campanha;
import com.example.final_project.service.CampanhaService;

import java.util.List;

@RestController
@RequestMapping("/api/campanhas")
@Tag(name = "Campanha", description = "Gerenciamento de campanhas de marketing")
public class CampanhaController {

    @Autowired
    private CampanhaService campanhaService;

    @Operation(summary = "Listar todas as campanhas")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de campanhas retornada com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping
    public List<Campanha> getAllCampanhas() {
        return campanhaService.getAllCampanhas();
    }

    @Operation(summary = "Obter uma campanha pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Campanha encontrada"),
        @ApiResponse(responseCode = "404", description = "Campanha não encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Campanha> getCampanhaById(@PathVariable Long id) {
        Campanha campanha = campanhaService.getCampanhaById(id);
        return ResponseEntity.ok(campanha);
    }

    @Operation(summary = "Criar uma nova campanha")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Campanha criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    public Campanha createCampanha(@RequestBody Campanha campanha) {
        return campanhaService.createCampanha(campanha);
    }

    @Operation(summary = "Atualizar uma campanha existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Campanha atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Campanha não encontrada"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Campanha> updateCampanha(@PathVariable Long id, @RequestBody Campanha campanhaDetails) {
        Campanha updatedCampanha = campanhaService.updateCampanha(id, campanhaDetails);
        return ResponseEntity.ok(updatedCampanha);
    }

    @Operation(summary = "Deletar uma campanha pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Campanha deletada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Campanha não encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCampanha(@PathVariable Long id) {
        campanhaService.deleteCampanha(id);
        return ResponseEntity.noContent().build();
    }
}
