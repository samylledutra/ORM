package com.example.final_project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.final_project.model.Campanha;
import com.example.final_project.repository.CampanhaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CampanhaService {

    @Autowired
    private CampanhaRepository campanhaRepository;

    public List<Campanha> getAllCampanhas() {
        return campanhaRepository.findAll();
    }

    public Campanha getCampanhaById(Long id) {
        return campanhaRepository.findById(id).orElseThrow(() -> new RuntimeException("Campanha não encontrada"));
    }

    public Campanha createCampanha(Campanha campanha) {
        return campanhaRepository.save(campanha);
    }

    public Campanha updateCampanha(Long id, Campanha campanhaDetails) {
        Campanha campanha = getCampanhaById(id);
        campanha.setNome(campanhaDetails.getNome());
        campanha.setDescricao(campanhaDetails.getDescricao());
        campanha.setDataInicio(campanhaDetails.getDataInicio());
        campanha.setDataFim(campanhaDetails.getDataFim());
        return campanhaRepository.save(campanha);
    }

    public void deleteCampanha(Long id) {
        Campanha campanha = getCampanhaById(id);
        campanhaRepository.delete(campanha);
    }
}
