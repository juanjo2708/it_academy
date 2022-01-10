package academy.it.ApiRestMongo1.entity;




public class Producte {
	private String nomProducte;
	private int quantitat;
	private int preu;
	
	public Producte() {}

	public Producte(String nomProducte, int quantitat, int preu) {		
		this.nomProducte = nomProducte;
		this.quantitat = quantitat;
		this.preu = preu;
	}

	public String getNomProducte() {
		return nomProducte;
	}

	public void setNomProducte(String nomProducte) {
		this.nomProducte = nomProducte;
	}

	public int getQuantitat() {
		return quantitat;
	}

	public void setQuantitat(int quantitat) {
		this.quantitat = quantitat;
	}

	public int getPreu() {
		return preu;
	}

	public void setPreu(int preu) {
		this.preu = preu;
	}

	
	
}
	
	
