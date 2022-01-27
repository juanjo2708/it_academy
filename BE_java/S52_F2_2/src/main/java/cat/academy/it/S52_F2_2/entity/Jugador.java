package cat.academy.it.S52_F2_2.entity;

import java.io.Serializable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;


import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Document("jugador")
public class Jugador implements Serializable {
	private static final long serialVersionUID = 1L;

	// --- PROPIETATS ----------------------------------------------
	//@Transient
   // public static final String SEQUENCE_NAME = "jugadors_sequence";

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	private String nom;
	private LocalDate dataRegistre;
	
		
	//@OneToMany(mappedBy = "jugador",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	//@JoinColumn(name = "jugador")	
	private List <Jugada>jugades = new ArrayList<Jugada>() ;
	 
// --- CONSTRUCTORS -----------------------------------------------------	
	public Jugador() {}
	
	public Jugador(String nom) {
		this.nom = nom;
		this.dataRegistre = LocalDate.now();
		this.jugades = new ArrayList<Jugada>() ;
	}
	
	//--- AFEGIR NOVA JUGADA ---------------------------------------
	public void afegirJugada(Jugada novaJugada) {
		this.jugades.add(novaJugada);
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
	
	public List<Jugada> getJugades() {
		return jugades;
	}

	public void setJugades(List<Jugada> jugades) {
		this.jugades = jugades;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nom=" + nom + ", dataRegistre=" + dataRegistre + ", jugades=" + jugades + "]";
	}	
	
}