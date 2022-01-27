package cat.academy.it.S52_F2_2.entity;

public class Dau {

// --- PROPIETATS ------------------------	
	private int valor;

// --- CONSTRUCTORS ---------------------	
	
	public Dau () {}
	
	public Dau(int valor) {	
		this.valor = valor;
	}

// --- JUGADA ALEATÒRIA -----------------
	public void tirada () {
		this.valor= (int)(Math.random()*7+1);
	}
	
// --- GETTERS, SETTERS, TOSTRING	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Dau [valor=" + valor + "]";
	}
    
	
	
}
