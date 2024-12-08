package br.com.ghianluca.SalmoApp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "salmos")
public class Salmo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("title")
    private String titulo;

    @OneToMany(mappedBy = "salmo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Versiculo> versiculos;

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

    public List<Versiculo> getVersiculos() {
        return versiculos;
    }

    public void setVersiculos(List<Versiculo> versiculos) {
        this.versiculos = versiculos;
        if (versiculos != null) {
            for (Versiculo versiculo : versiculos) {
                versiculo.setSalmo(this);
            }
        }
    }
}