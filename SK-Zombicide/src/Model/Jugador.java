package Model;

import java.util.ArrayList;

public class Jugador extends Humanoide{
	private String nombre;
	private int salud;
	private Arma arma;
	
	
	public Jugador(String nombre, int salud, Arma arma) {
		super(nombre, salud);
		this.nombre = nombre;
		this.salud = salud;
		this.arma = arma;
	}
	@Override
	public String toString() {
		return "JUGADOR: " + this.nombre + " S: " + salud + "  " + arma.toString();
	}
	
	public String getNombrePj() {
		return this.nombre;
	}
	
	public Arma getArma() {
		return this.arma;
	}
	
	public void setArma(Arma a) {
		this.arma = a;
	}
	public void setSalud(int movimiento) {
		this.salud = this.salud - movimiento;
		
	}
	public int getSalud() {
		return this.salud;
	}
}
