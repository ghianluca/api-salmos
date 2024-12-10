package br.com.ghianluca.SalmoApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ghianluca.SalmoApp.model.Salmo;
import br.com.ghianluca.SalmoApp.model.Versiculo;
import br.com.ghianluca.SalmoApp.service.SalmoImportRequest;
import br.com.ghianluca.SalmoApp.service.SalmoService;
import br.com.ghianluca.SalmoApp.service.VersiculoDiarioService;

@RestController
@RequestMapping("/salmos")
public class SalmoController {

    @Autowired
    private SalmoService salmoService;

    @Autowired
    private VersiculoDiarioService versiculoDiarioService;

    @GetMapping
    public List<Salmo> getAllSalmos() {
        return salmoService.getAllSalmos();
    }

    @GetMapping("/{id}")
    public Salmo getSalmoById(@PathVariable Integer id) {
        return salmoService.getSalmoById(id);
    }

    @GetMapping("/versiculos/{versiculoId}")
    public Versiculo getVersiculoById(@PathVariable Integer versiculoId) {
        return salmoService.getVersiculoById(versiculoId);
    }

    @GetMapping("/versiculo-diario")
    public Versiculo getVersiculoDiario() {
        int idAtual = versiculoDiarioService.getVersiculoDiario();
        return salmoService.getVersiculoById(idAtual);
    }

    @PostMapping("/importar")
    public String importarSalmos(@RequestBody SalmoImportRequest salmoImportRequest) {
        salmoService.importarSalmos(salmoImportRequest.getSalmos());
        return "Dados importados com sucesso!";
    }
}