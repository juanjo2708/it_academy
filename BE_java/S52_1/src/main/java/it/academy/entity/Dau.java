package it.academy.entity;

public class Dau {

// --- PROPIETATS ------------------------	
	private int valor;

// --- CONSTRUCTOR ---------------------	
	public Dau(int valor) {
		super();
		this.valor = valor;
	}

// --- JUGADA ALEATÒRIA -----------------
	public int tirada () {
		return (int)(Math.random()*7+1);
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
