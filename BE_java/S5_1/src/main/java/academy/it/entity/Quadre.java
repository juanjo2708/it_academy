package academy.it.entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "quadres")
public class Quadre {

	// --- PROPIETATS ---------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nom;
	private String autor;
	private Float preu;
	private LocalDate dataEntrada;
		
	// --- CONSTRUCTORS -------------------------------------
	public Quadre() {}
	
	public Quadre(String nom, Float preu) {
		this.nom = nom;
		this.preu = preu;
		this.dataEntrada = LocalDate.now();
	}
	
	public Quadre (String nom, String autor) {
		this.nom = nom;
		this.autor = autor;
		this.dataEntrada = LocalDate.now();
	}
	
	// --- GETTERS, SETTERS,  toString --------------------
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Float getPreu() {
		return preu;
	}

	public void setPreu(Float preu) {
		this.preu = preu;
	}

	public LocalDate getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(LocalDate dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	
	@Override
	public String toString() {
		return "Quadre [id=" + id + ", nom=" + nom + ", autor=" + autor + ", preu=" + preu + ", dataEntrada="
				+ dataEntrada +"]";
	}
}
