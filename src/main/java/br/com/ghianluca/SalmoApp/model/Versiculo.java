package br.com.ghianluca.SalmoApp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "versiculos")
public class Versiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("title")
    private String titulo;

    @JsonProperty("text")
    @Column(length = 5000)
    private String texto;

    @ManyToOne
    @JoinColumn(name = "salmo_id", nullable = false)
    @JsonBackReference
    private Salmo salmo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Salmo getSalmo() {
        return salmo;
    }

    public void setSalmo(Salmo salmo) {
        this.salmo = salmo;
    }
}