package com.cinema.crvg.config;

import com.cinema.crvg.entities.*;
import com.cinema.crvg.entities.enums.FranquiaEnum;
import com.cinema.crvg.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import java.time.LocalDateTime;

@Configuration
public class CargaInicialConfig implements CommandLineRunner {

    private final CadeiraRepository cadeiraRepository;
    private final CidadeRepository cidadeRepository;
    private final CinemaRepository cinemaRepository;
    private final DiretorRepository diretorRepository;
    private final EstadoRepository estadoRepository;
    private final FilmeRepository filmeRepository;
    private final IngressoRepository ingressoRepository;
    private final RecursoRepository recursoRepository;
    private final SalaRepository salaRepository;
    private final SessaoRepository sessaoRepository;

    public CargaInicialConfig(CadeiraRepository cadeiraRepository, CidadeRepository cidadeRepository,
                              CinemaRepository cinemaRepository, DiretorRepository diretorRepository,
                              EstadoRepository estadoRepository, FilmeRepository filmeRepository,
                              IngressoRepository ingressoRepository, RecursoRepository recursoRepository,
                              SalaRepository salaRepository, SessaoRepository sessaoRepository) {
        this.cadeiraRepository = cadeiraRepository;
        this.cidadeRepository = cidadeRepository;
        this.cinemaRepository = cinemaRepository;
        this.diretorRepository = diretorRepository;
        this.estadoRepository = estadoRepository;
        this.filmeRepository = filmeRepository;
        this.ingressoRepository = ingressoRepository;
        this.recursoRepository = recursoRepository;
        this.salaRepository = salaRepository;
        this.sessaoRepository = sessaoRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Estado sergipe = new Estado();
        sergipe.setSigla("SE");
        sergipe.setNome("Sergipe");
        estadoRepository.save(sergipe);

        Estado alagoas = new Estado();
        alagoas.setSigla("AL");
        alagoas.setNome("Alagoas");
        estadoRepository.save(alagoas);

        Estado bahia = new Estado();
        bahia.setSigla("BA");
        bahia.setNome("Bahia");
        estadoRepository.save(bahia);

        Cidade aracaju = new Cidade();
        aracaju.setNome("Aracaju");
        aracaju.setEstado(sergipe);
        cidadeRepository.save(aracaju);

        Cidade maceio = new Cidade();
        maceio.setNome("Maceió");
        maceio.setEstado(alagoas);
        cidadeRepository.save(maceio);

        Cidade salvador = new Cidade();
        salvador.setNome("Salvador");
        salvador.setEstado(bahia);
        cidadeRepository.save(salvador);

        Cidade socorro = new Cidade();
        socorro.setNome("Socorro");
        socorro.setEstado(sergipe);
        cidadeRepository.save(socorro);

        Recurso r1 = new Recurso();
        r1.setNome("Sala IMAX");
        recursoRepository.save(r1);

        Recurso r2 = new Recurso();
        r2.setNome("Acessibilidade para Cadeirantes");
        recursoRepository.save(r2);

        Recurso r3 = new Recurso();
        r3.setNome("Tecnologia 4DX");
        recursoRepository.save(r3);

        Cinema cinemarkRiomar = new Cinema();
        cinemarkRiomar.setNome("Cinemark Shopping Riomar");
        cinemarkRiomar.setEndereco("Av. Delmiro Gouveia, 400 - Coroa do Meio, Aracaju - SE, 49035-500");
        cinemarkRiomar.setCidade(aracaju);
        cinemarkRiomar.setFranquia(FranquiaEnum.CINEMARK);
        cinemarkRiomar.getRecursos().add(r1);
        cinemarkRiomar.getRecursos().add(r2);
        cinemaRepository.save(cinemarkRiomar);

        Cinema centerplexCentro = new Cinema();
        centerplexCentro.setNome("Centerplex Parque Shopping");
        centerplexCentro.setEndereco("Av. João Rodrigues, 42 - Industrial, Aracaju - SE, 49065-450");
        centerplexCentro.setCidade(aracaju);
        centerplexCentro.setFranquia(FranquiaEnum.CENTERPLEX);
        centerplexCentro.getRecursos().add(r3);
        cinemaRepository.save(centerplexCentro);

        Cinema cineserclaSocorro = new Cinema();
        cineserclaSocorro.setNome("Cinesercla Shopping Prêmio");
        cineserclaSocorro.setEndereco("Av. Coletora A, s/n, Marcos Freire I, Nossa Senhora do Socorro, Sergipe, Brasil");
        cineserclaSocorro.setCidade(socorro);
        cineserclaSocorro.setFranquia(FranquiaEnum.CINESERCLA);
        cineserclaSocorro.getRecursos().add(r2);
        cinemaRepository.save(cineserclaSocorro);

        Sala sala1 = new Sala();
        sala1.setNumero(1);
        sala1.setCapacidade(40);
        sala1.setCinema(cineserclaSocorro);
        salaRepository.save(sala1);

        Cadeira a1 = new Cadeira();
        a1.setFila('A');
        a1.setNumero(1);
        a1.setTipo("Normal");
        a1.setSala(sala1);
        a1.setStatus(true);
        cadeiraRepository.save(a1);

        Diretor tarantino = new Diretor();
        tarantino.setNome("Quentin Tarantino");
        diretorRepository.save(tarantino);

        Filme pulpFiction = new Filme();
        pulpFiction.setTitulo("Pulp Fiction: Tempo de Violência");
        pulpFiction.setSinopse("Assassino que trabalha para a máfia se apaixona pela esposa de seu chefe " +
                "quando é convidado a acompanhá-la, um boxeador descumpre sua promessa de perder uma luta e um " +
                "casal tenta um assalto que rapidamente sai do controle.");
        pulpFiction.setGenero("Crime");
        pulpFiction.setDuracao("2h34min");
        pulpFiction.setFaixaEtaria(18);
        pulpFiction.getDiretores().add(tarantino);
        tarantino.getFilmes().add(pulpFiction);
        filmeRepository.save(pulpFiction);

        Sessao sessao1 = new Sessao();
        sessao1.setDataInicioExibicao(LocalDateTime.of(2026, 5, 20, 19, 0));
        sessao1.setDataFimExibicao(LocalDateTime.of(2026, 5, 20, 21, 30));
        sessao1.setHoraDataSessao(LocalDateTime.of(2026, 5, 20, 19, 0));
        sessao1.setPreco(35.00);
        sessao1.setFilme(pulpFiction);
        sessao1.setSala(sala1);
        sessaoRepository.save(sessao1);

        Ingresso ingresso1 = new Ingresso();
        ingresso1.setSessao(sessao1);
        ingresso1.setCadeira(a1);
        ingresso1.setValorPago(30.00);
        ingresso1.setStatus("PAGO");
        ingressoRepository.save(ingresso1);

        System.out.println("Carga inicial de dados executada com sucesso!");
    }
}
