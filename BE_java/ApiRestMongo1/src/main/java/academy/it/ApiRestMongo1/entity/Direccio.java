package academy.it.ApiRestMongo1.entity;

public class Direccio {
	private String ciutat;
	private String provincia;
	private String codiPostal;
	
	public Direccio() {}
	
	public Direccio(String ciutat, String provincia, String codiPostal) {
		this.ciutat = ciutat;
		this.provincia = provincia;
		this.codiPostal = codiPostal;
	}

	public String getCiutat() {
		return ciutat;
	}

	public void setCiutat(String ciutat) {
		this.ciutat = ciutat;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodiPostal() {
		return codiPostal;
	}

	public void setCodiPostal(String codiPostal) {
		this.codiPostal = codiPostal;
	}
	
	
	
	
}
