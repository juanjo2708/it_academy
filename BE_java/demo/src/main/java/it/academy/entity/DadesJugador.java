package it.academy.entity;

public class DadesJugador  implements Comparable<DadesJugador>{

// --- PROPIETATS ------------------	
	private Long id_jugador;
	private String nomJugador;
	private int jugades;
	private int encertades;
	private int percentatgeEncert;

// --- CONSTRUCTORS -----------------------------------------------------------------------------	
	public DadesJugador(Long id_jugador,String nomJugador, int jugades, int encertades, int percentatgeEncert) {
		this.id_jugador = id_jugador;
		this.nomJugador = nomJugador;
		this.jugades = jugades;
		this.encertades = encertades;
		this.percentatgeEncert = percentatgeEncert;
	}

// --- GETTERS, SETTERS, TOSTRING -------------------------	
	public Long getId_jugador() {
		return id_jugador;
	}

	public void setId_jugador(Long id_jugador) {
		this.id_jugador = id_jugador;
	}
	
	public String getNomJugador() {
		return nomJugador;
	}

	public void setNomJugador(String nomJugador) {
		this.nomJugador = nomJugador;
	}

	public int getJugades() {
		return jugades;
	}

	public void setJugades(int jugades) {
		this.jugades = jugades;
	}

	public int getEncertades() {
		return encertades;
	}

	public void setEncertades(int encertades) {
		this.encertades = encertades;
	}

	public int getPercentatgeEncert() {
		return percentatgeEncert;
	}

	public void setPercentatgeEncert(int percentatgeEncert) {
		this.percentatgeEncert = percentatgeEncert;
	}

	@Override
	public String toString() {
		return "DadesJugador [nomJugador=" + nomJugador + ", jugades=" + jugades + ", encertades=" + encertades
				+ ", percentatgeEncert=" + percentatgeEncert + "]";
	}

	@Override
	public int compareTo(DadesJugador o) {
		if (o.getPercentatgeEncert()>percentatgeEncert) {
			return -1;
		}else if (o.getPercentatgeEncert()==percentatgeEncert) {
			return 0;
		}else {
			return 1;
		}
	}
	
	
		
}
