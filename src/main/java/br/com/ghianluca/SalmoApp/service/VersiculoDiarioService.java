package br.com.ghianluca.SalmoApp.service;

import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class VersiculoDiarioService {

    private final List<Integer> idsDisponiveis = new LinkedList<>();
    private final Random random = new Random();
    private int idAtual = 1;
    private final LocalTime horarioAtualizacao = LocalTime.of(6, 0);
    private LocalTime ultimaAtualizacao;

    public VersiculoDiarioService() {
        inicializarIds();
    }

    private void inicializarIds() {
        idsDisponiveis.clear();
        for (int i = 1; i <= 73; i++) {
            idsDisponiveis.add(i);
        }
        Collections.shuffle(idsDisponiveis, random);
    }

    @Scheduled(cron = "0 0 6 * * *")
    public void atualizarVersiculoDiario() {
        if (idsDisponiveis.isEmpty()) {
            inicializarIds();
        }
        idAtual = idsDisponiveis.remove(0);
        ultimaAtualizacao = LocalTime.now();
        System.out.println("Versículo diário atualizado. Novo ID: " + idAtual);
    }

    public int getVersiculoDiario() {
        verificarAtualizacao();
        return idAtual;
    }

    private void verificarAtualizacao() {
        LocalTime agora = LocalTime.now();
        if (ultimaAtualizacao == null || 
           (ultimaAtualizacao.isBefore(horarioAtualizacao) && agora.isAfter(horarioAtualizacao))) {
            atualizarVersiculoDiario();
        }
    }

    @PostConstruct
    public void inicializar() {
        System.out.println("Serviço de Versículo Diário iniciado.");
        verificarAtualizacao();
    }
}