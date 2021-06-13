package Model;

import java.util.ArrayList;

public class Humanoide {
	
	private String nombre;
	private int salud, saludMax;
	private boolean vivo;
	private ArrayList<Zombie> zombies;
	
	public Humanoide(String nombre, int salud) {
		 this.nombre = nombre;
	        this.saludMax = salud;
	        this.salud = salud;
	        this.vivo = true;
	}
	
	public boolean estadoVivo() {
		if (this.salud <= 0) {
			vivo = false;
			return vivo;
		} else {
			vivo = true;
			return vivo;
		}
	}
	
}
