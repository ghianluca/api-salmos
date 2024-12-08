package br.com.ghianluca.SalmoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ghianluca.SalmoApp.model.Versiculo;

@Repository
public interface VersiculoRepository extends JpaRepository<Versiculo, Integer> {
}