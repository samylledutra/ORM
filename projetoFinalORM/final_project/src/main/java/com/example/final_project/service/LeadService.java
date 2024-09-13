package com.example.final_project.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.final_project.model.Lead;
import com.example.final_project.repository.LeadRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadRepository;

    public List<Lead> getAllLeads() {
        return leadRepository.findAll();
    }

    public Lead getLeadById(Long id) {
        return leadRepository.findById(id).orElseThrow(() -> new RuntimeException("Lead não encontrado"));
    }

    public Lead createLead(Lead lead) {
        return leadRepository.save(lead);
    }

    public Lead updateLead(Long id, Lead leadDetails) {
        Lead lead = getLeadById(id);
        lead.setNome(leadDetails.getNome());
        lead.setEmail(leadDetails.getEmail());
        lead.setTelefone(leadDetails.getTelefone());
        return leadRepository.save(lead);
    }

    public void deleteLead(Long id) {
        Lead lead = getLeadById(id);
        leadRepository.delete(lead);
    }
}
