package br.com.ghianluca.SalmoApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ghianluca.SalmoApp.model.Salmo;
import br.com.ghianluca.SalmoApp.model.Versiculo;
import br.com.ghianluca.SalmoApp.repository.SalmoRepository;
import br.com.ghianluca.SalmoApp.repository.VersiculoRepository;

@Service
public class SalmoService {

    @Autowired
    private SalmoRepository salmoRepository;

    @Autowired
    private VersiculoRepository versiculoRepository;

    public List<Salmo> getAllSalmos() {
        return salmoRepository.findAll();
    }

    public Salmo getSalmoById(Integer id) {
        return salmoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Salmo não encontrado"));
    }

    public Versiculo getVersiculoById(Integer versiculoId) {
        return versiculoRepository.findById(versiculoId)
                .orElseThrow(() -> new RuntimeException("Versículo não encontrado"));
    }

    public void importarSalmos(List<SalmoImportRequest.SalmoRequest> salmoRequests) {
        for (SalmoImportRequest.SalmoRequest salmoRequest : salmoRequests) {
            Salmo salmo = new Salmo();
            salmo.setTitulo(salmoRequest.getTitle());
            salmoRepository.save(salmo);

            for (SalmoImportRequest.SalmoRequest.VersiculoRequest versiculoRequest : salmoRequest.getVersiculos()) {
                Versiculo versiculo = new Versiculo();
                versiculo.setTitulo(versiculoRequest.getTitle());
                versiculo.setTexto(versiculoRequest.getText());
                versiculo.setSalmo(salmo);
                versiculoRepository.save(versiculo);
            }
        }
    }
}