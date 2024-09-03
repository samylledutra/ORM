package br.edu.iftm.rastreamento.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.model.Rastreamento;
import br.edu.iftm.rastreamento.service.util.Converters;

@Service
public class RastreamentoService {
    
    @Autowired
    private PacoteService pacoteService;
   
    public List<Rastreamento> getRastreamentos(Long id) {
        Pacote pacote = pacoteService.getPacoteById(id);
        return pacote.getRastreamentos();
    }
}