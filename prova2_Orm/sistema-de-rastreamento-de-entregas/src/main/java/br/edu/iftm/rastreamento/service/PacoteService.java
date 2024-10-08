package br.edu.iftm.rastreamento.service;

import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.model.Rastreamento;
import br.edu.iftm.rastreamento.repository.PacoteRepository;
import br.edu.iftm.rastreamento.repository.RastreamentoRepository;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;
   
    @Autowired
    private RastreamentoRepository rastreamentoRepository;


    public List<Pacote> getAllPacotes() {
        Iterable<Pacote> pacotesIterable = pacoteRepository.findAll();
        List<Pacote> pacotesList = new ArrayList<>();
        pacotesIterable.forEach(pacotesList::add);
        return pacotesList;
    }

    public Pacote getPacoteById(Long id) {
        return pacoteRepository.findById(id).get();
    }

    public Pacote createPacote(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    public Pacote updatePacote(Long id, Pacote pacoteDetails) {
        Pacote pacote = pacoteRepository.findById(id).get();
        pacote.setId(id);
        pacote.atualizarStatus(pacoteDetails.getStatus(), Date.from(Instant.now()), "sem localização");
        
        Rastreamento ultiRastreamento = pacote.getRastreamentos().get(pacote.getRastreamentos().size() - 1);
        rastreamentoRepository.save(ultiRastreamento);
        return pacoteRepository.save(pacote);
    }

    public void deletePacote(Long id) {
        Pacote pacote = pacoteRepository.findById(id).get();
        pacoteRepository.delete(pacote);
    }

    public List<Pacote> getPacotePorStatus(String status) {

        Iterable<Pacote> pacotesStatusIterable = pacoteRepository.findByStatus(status);

        List<Pacote> pacotesStatusList = new ArrayList<>();
        pacotesStatusIterable.forEach(pacotesStatusList::add);

        return pacotesStatusList;
    }

    public List<Pacote> getPacotePorDestinatario(String destinatario) {

        Iterable<Pacote> pacotesDestinatarioIterable = pacoteRepository.findByDestinatario(destinatario);

        List<Pacote> pacotesDestinatarioList = new ArrayList<>();
        pacotesDestinatarioIterable.forEach(pacotesDestinatarioList::add);

        return pacotesDestinatarioList;
    }
}