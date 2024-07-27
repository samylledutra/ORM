package br.edu.iftm.leilao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.iftm.leilao.model.ItemDeLeilao;
import br.edu.iftm.leilao.model.Lance;
import br.edu.iftm.leilao.model.Participante;
import br.edu.iftm.leilao.repository.ItemDeLeilaoRepository;
import br.edu.iftm.leilao.repository.LanceRepository;
import br.edu.iftm.leilao.repository.ParticipanteRepository;

@SpringBootApplication
public class LeilaoApplication implements CommandLineRunner {

	@Autowired
	private ParticipanteRepository participante;

	@Autowired
	private ItemDeLeilaoRepository itemDeLeilaoRepository;

	@Autowired
	private LanceRepository lanceRepository;

	public static void main(String[] args) {
		SpringApplication.run(LeilaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ItemDeLeilao bicicleta = new ItemDeLeilao("Bicicleta", 100.0, true);
		Participante joao = new Participante("João", "12345");
		Lance lance = new Lance(100.0, joao);
		bicicleta.getLancesRecebidos().add(lance);

		participante.save(joao);
		lanceRepository.save(lance);
		itemDeLeilaoRepository.save(bicicleta);

		System.out.println(lance);
	}

}
