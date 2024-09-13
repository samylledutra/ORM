package com.example.final_project.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.final_project.model.Lead;
import com.example.final_project.service.LeadService;

import java.util.List;

@RestController
@RequestMapping("/api/leads")
@Tag(name = "Lead", description = "Gerenciamento de leads captados pela landing page")
public class LeadController {

    @Autowired
    private LeadService leadService;

    @Operation(summary = "Listar todos os leads")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lista de leads retornada com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping
    public List<Lead> getAllLeads() {
        return leadService.getAllLeads();
    }

    @Operation(summary = "Obter um lead pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lead encontrado"),
        @ApiResponse(responseCode = "404", description = "Lead não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Lead> getLeadById(@PathVariable Long id) {
        Lead lead = leadService.getLeadById(id);
        return ResponseEntity.ok(lead);
    }

    @Operation(summary = "Criar um novo lead")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Lead criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PostMapping
    public Lead createLead(@RequestBody Lead lead) {
        return leadService.createLead(lead);
    }

    @Operation(summary = "Atualizar um lead existente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Lead atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Lead não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Lead> updateLead(@PathVariable Long id, @RequestBody Lead leadDetails) {
        Lead updatedLead = leadService.updateLead(id, leadDetails);
        return ResponseEntity.ok(updatedLead);
    }

    @Operation(summary = "Deletar um lead pelo ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Lead deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Lead não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLead(@PathVariable Long id) {
        leadService.deleteLead(id);
        return ResponseEntity.noContent().build();
    }
}
