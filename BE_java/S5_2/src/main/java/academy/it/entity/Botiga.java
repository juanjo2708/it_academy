package academy.it.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.lang.NonNull;


@Entity
@Table(name="botigues")
public class Botiga {
			
	// --- PROPIETATS --------------------------------
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NonNull
	private String nom;
	
	@NonNull	
	private int capacitat;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="botiga_id")
	private Set<Quadre> quadres;
	
	// --- CONSTRUCTORS --------------------------------
	public Botiga() {}
	
	public Botiga (String nom, int capacitat) {
		this.nom = nom;
		this.capacitat = capacitat;
	}

	// --- AFEGIR, ESBORRAR QUADRES -----------------------------------
	public void afegirQuadre(Quadre quadre) {
		quadres.add(quadre);
	}
	
	public void esborrarQuadre(Quadre quadre) {
		quadres.remove(quadre);
	}
	
	// --- GETTERS, SETTERS, toString --------------------------------
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
	
	public Set<Quadre> getQuadres() {
		return quadres;
	}

	public void setQuadres(Set<Quadre> quadres) {
		this.quadres = quadres;
	}
		
	public int getCapacitat() {
		return capacitat;
	}

	public void setCapacitat(int capacitat) {
		this.capacitat = capacitat;
	}

	@Override
	public String toString() {
		return "Botiga [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
	
	

}
