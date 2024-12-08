package br.com.ghianluca.SalmoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ghianluca.SalmoApp.model.Salmo;

public interface SalmoRepository extends JpaRepository<Salmo, Integer> {

}