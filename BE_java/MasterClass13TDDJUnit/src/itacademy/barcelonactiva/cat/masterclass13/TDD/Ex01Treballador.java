package itacademy.barcelonactiva.cat.masterclass13.TDD;

public class Ex01Treballador {
	
	
	public Ex01Treballador() {
		this("", "", 0, SALARI_BASIC);
	}

	public Ex01Treballador(String nom, String cognom) {
		this(nom, cognom, 0, SALARI_BASIC);
	}

	public Ex01Treballador(String nom, String cognom, int edat) {
		this(nom, cognom, edat, SALARI_BASIC);
	}

	public Ex01Treballador(String nom, String cognom, int edat, double salari) {
		this.nom = nom;
		this.cognom = cognom;
		this.edat = edat;
		this.salari = salari;
	}

	
	
	public final static double SALARI_BASIC = 600;

	public final static int MAJOR = 1;
	public final static int IGUAL = 0;
	public final static int MENOR = -1;

	private String nom;
	private String cognom;
	private int edat;
	private double salari;

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCognom() {
		return cognom;
	}

	public void setCognom(String cognom) {
		this.cognom = cognom;
	}

	public int getEdat() {
		return edat;
	}

	public void setEdat(int edat) {
		this.edat = edat;
	}

	public double getSalari() {
		return salari;
	}

	public void setSalari(double salari) {
		this.salari = salari;
	}

	public boolean plus(double sueldoPlus) {

		boolean aumento = false;
		if (edat > 40) {
			salari += sueldoPlus;
			aumento = true;
		}
		return aumento;
	}

	public boolean equals(Ex01Treballador a) {

		if (a.getNom().equals(nom) && a.getCognom().equals(cognom)) {
			return true;
		} else {
			return false;
		}
	}

	public int compareTo(Ex01Treballador a) {

		int estado = MENOR;
		if (this.edat == a.getEdat()) {
			// Los objetos son iguales
			estado = IGUAL;
		} else if (this.edat > a.getEdat()) {
			// El objeto 1 es MAJOR que la pasada por parametro
			estado = MAJOR;
		}
		return estado;

	}

	

}
