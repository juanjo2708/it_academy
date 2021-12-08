package it.academy.entity;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jugadors")
public class Jugador {
	
// --- PROPIETATS ----------------------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	private String nom;
	private LocalDate dataRegistre;
    
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "jugador_id", cascade = CascadeType.ALL)
	private ArrayList <Jugada> jugades;

// --- CONSTRUCTORS -----------------------------------------------------	
	public Jugador(String nom) {
		this.nom = nom;
		this.dataRegistre = LocalDate.now();
		this.jugades = new ArrayList<Jugada>(); 
	}
		
	// --- GETTERS, SETTERS, TOSTRING ------------------------------
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public LocalDate getDataRegistre() {
		return dataRegistre;
	}
	public void setDataRegistre(LocalDate dataRegistre) {
		this.dataRegistre = dataRegistre;
	}
	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nom=" + nom + ", dataRegistre=" + dataRegistre + "]";
	}
}
