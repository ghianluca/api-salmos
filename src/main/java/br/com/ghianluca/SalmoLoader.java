package br.com.ghianluca;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.ghianluca.SalmoApp.model.Salmo;
import br.com.ghianluca.SalmoApp.model.Versiculo;
import br.com.ghianluca.SalmoApp.repository.SalmoRepository;
import jakarta.annotation.PostConstruct;

@Component
public class SalmoLoader {

    private final SalmoRepository salmoRepository;

    public SalmoLoader(SalmoRepository salmoRepository) {
        this.salmoRepository = salmoRepository;
    }

    @PostConstruct
    public void loadSalmos() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/salmos.json");

            if (inputStream == null) {
                System.err.println("Arquivo 'salmos.json' não encontrado.");
                return;
            }

            List<Salmo> salmos = mapper.readValue(inputStream, new TypeReference<>() {});
            for (Salmo salmo : salmos) {
                if (salmo.getVersiculos() != null) {
                    for (Versiculo versiculo : salmo.getVersiculos()) {
                        versiculo.setSalmo(salmo);
                    }
                }
                salmoRepository.save(salmo);
            }

            System.out.println("Salmos carregados com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao carregar os salmos: " + e.getMessage());
        }
    }
}