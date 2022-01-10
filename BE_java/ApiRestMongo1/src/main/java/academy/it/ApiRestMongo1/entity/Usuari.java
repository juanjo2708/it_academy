package academy.it.ApiRestMongo1.entity;

import java.io.Serializable;
import java.util.List;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection ="usuaris")
public class Usuari implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id   
	private int id;
	private String nom;
	private String genere;
	private List<Producte> productes;
	private Direccio direccio;
	
	public Usuari() {}
	
	public Usuari(int id, String nom, String genere) {
		this.genere = genere;
		this.nom = nom;
		this.id = id;
	}

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

	public String getGenere() {
		return genere;
	}

	public void setGenere(String genere) {
		this.genere = genere;
	}

	public List<Producte> getProductes() {
		return productes;
	}

	public void setProductes(List<Producte> productes) {
		this.productes = productes;
	}

	public Direccio getDireccio() {
		return direccio;
	}

	public void setDireccio(Direccio direccio) {
		this.direccio = direccio;
	}

	@Override
	public String toString() {
		return "Usuari [id=" + id + ", nom=" + nom + ", genere=" + genere + ", productes=" + productes + ", direccio="
				+ direccio + "]";
	}
	
	
	
}
