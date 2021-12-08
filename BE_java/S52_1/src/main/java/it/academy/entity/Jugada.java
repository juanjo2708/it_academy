package it.academy.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name ="jugades")
public class Jugada {
	
// --- PROPIETATS ----------------------------------------------------------------	
	private int valorDau1;
	private int valorDau2;
	private Boolean guanyada;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinColumn(name ="jugador_id", referencedColumnName = "jugador_id")
	private Jugador jugador;
	
// --- CONSTRUCTORS ----------------------------------------------------------------	
	public Jugada() {}
	
	public Jugada(int valorDau1, int valorDau2, Boolean guanyada) {		
		this.valorDau1 = valorDau1;
		this.valorDau2 = valorDau2;
		this.guanyada = guanyada;
	}
	
	public Jugada(int valorDau1, int valorDau2) {		
		this.valorDau1 = valorDau1;
		this.valorDau2 = valorDau2;
		
		if(valorDau1+valorDau2 == 7) {
			this.guanyada = true;
		}
		
	}
	
// --- GETTERS, SETTERS, TOSTRING
	public int getValorDau1() {
		return valorDau1;
	}

	public void setValorDau1(int valorDau1) {
		this.valorDau1 = valorDau1;
	}

	public int getValorDau2() {
		return valorDau2;
	}

	public void setValorDau2(int valorDau2) {
		this.valorDau2 = valorDau2;
	}

	public Boolean getGuanyada() {
		return guanyada;
	}

	public void setGuanyada(Boolean guanyada) {
		this.guanyada = guanyada;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	@Override
	public String toString() {
		return "Jugada [valorDau1=" + valorDau1 + ", valorDau2=" + valorDau2 + ", guanyada=" + guanyada + ", jugador="
				+ jugador + "]";
	}
}
